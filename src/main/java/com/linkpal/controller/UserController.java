package com.linkpal.controller;

import com.linkpal.model.Page;
import com.linkpal.model.Role;
import com.linkpal.model.User;
import com.linkpal.service.IRoleService;
import com.linkpal.service.IUserService;
import com.linkpal.util.CheckOnlyContext;
import com.linkpal.util.GlobalVarContext;
import com.linkpal.util.MD5Util;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    IUserService userService;
    
    @Autowired
    IRoleService roleService;

    @RequestMapping(value = "/user/index")
    @RequiresPermissions("user:view")
    public ModelAndView getList(HttpServletRequest request,User user)
    {

        Map map=userService.getPageList(request, user);
        ModelAndView mav=new ModelAndView("web/user/index");
        mav.addObject("userList", (List<User>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
//    	mav.addObject("url", "/User/index");
        mav.addObject("url", "user/index");
        mav.addObject("model",(User) map.get("model"));
        return mav;
    }

    @RequestMapping(value = "/user/create")
    @RequiresPermissions("user:create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/user/edit");
        User user=new User();
        mav.addObject("user",user);
        mav.addObject("roleList", roleService.getList());
        //mav.addObject("roleList", roleService.getAllList());
        return mav;
    }

    @RequestMapping(value = "/user/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,User user) throws Exception {
        if(user.getFid()==0)
        {
            userService.create(user);
            //service.userpermissionBind(BuildMapUtil.getMap(request));
        }
        else
        {
            userService.update(user);
        }

        return  getList(request,(User) request.getSession().getAttribute("User")) ;
    }

    @RequestMapping(value = "/user/edit")
    @RequiresPermissions("user:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/user/edit");
        User user=userService.getDetail(ID);
        mav.addObject("user",user);
        mav.addObject("roleList", roleService.getList());
        //mav.addObject("roleList", roleService.getAllList());
        return mav;
    }

    @RequestMapping(value = "/user/delete")
    @RequiresPermissions("user:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        userService.delete(ID);
        return getList(request,(User)request.getSession().getAttribute("User"));
    }

    @RequestMapping(value = "/user/deleteBatch")
    @RequiresPermissions("user:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        userService.deleteBatch(ids);
        return getList(request,(User)request.getSession().getAttribute("User"));
    }

    @RequestMapping(value = "/user/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CheckOnlyContext coc=new CheckOnlyContext();
        User model=null;
        if(ID==0)model=new User();
        else model=userService.getDetail(ID);
        out.println( coc.CheckOnly(model.getUsername(), userService, param, ID));
    }

    @RequestMapping(value = "/bindrole")
    public ModelAndView BindRole(int ID)
    {

        ModelAndView mav=new ModelAndView("web/user/role");
       User user=userService.getDetail(ID);
        mav.addObject("user",user);
        mav.addObject("roleList", roleService.getList());
        return mav;
    }

    @RequestMapping(value = "/user/bind")
    public ModelAndView Bind(HttpServletRequest request,int ID,Integer[] rids)
    {
        userService.RoleUserBind(ID, rids);
        return getList(request,(User) request.getSession().getAttribute("User"));
    }

    @RequestMapping(value = "/user/updatepsw")
    public void updatepsw(HttpServletRequest request,HttpServletResponse response) throws Exception {
       User user= GlobalVarContext.user;
       String url="";
       if(!user.getUserpassword().equals(MD5Util.getResult(request.getParameter("opsw"))))
       {
           request.getSession().setAttribute("pswmsg","旧密码输入不正确，请重新输入!");
         request.getRequestDispatcher("web/user/updatepsw.jsp").forward(request,response);
       }
       else
       {
           user.setUserpassword(MD5Util.getResult(request.getParameter("userpassword")));
           userService.update(user);
           request.getSession().invalidate();
           PrintWriter out=response.getWriter();
           out.println("<html>");
           out.println("<script>");
           out.println("parent.location.href='../login.jsp'");
           out.println("</script>");
           out.println("</html>");
       }
      //return url;
    }


    @RequestMapping(value = "/initpsw")
    public ModelAndView initpsw(HttpServletRequest request,int ID) throws Exception {
       User user=userService.getDetail(ID);
       user.setUserpassword(MD5Util.getResult("111111"));
        userService.update(user);
        return getList(request,(User) request.getSession().getAttribute("User"));
    }

}
