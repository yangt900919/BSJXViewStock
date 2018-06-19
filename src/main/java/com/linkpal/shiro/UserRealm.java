package com.linkpal.shiro;

import com.linkpal.model.Permission;
import com.linkpal.model.Role;
import com.linkpal.model.User;
import com.linkpal.service.IPermissionService;
import com.linkpal.service.IRoleService;
import com.linkpal.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IPermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String key = "AUTHORIZATION_INFO";
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        SimpleAuthorizationInfo authorizationInfo = (SimpleAuthorizationInfo) session.getAttribute(key);
        if (!subject.isAuthenticated() || authorizationInfo == null) {
            String username = (String) principalCollection.getPrimaryPrincipal();
           User user=userService.getDetail(username);
            /*map = (HashMap)users.get(0);
            Object userId = map.get("id");
            map.put("userId", userId);
            map.put("isWork", "Y");*/
            List roles = user.getRoles();
            authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addRoles(roles);
            if(roles.size()>0){
                //根据当前用户ID获取其生效的菜单权限并给该用户授权
               List permissions=new ArrayList<>();
                //此处返回list<string>类型的权限
                for(int i=0;i<roles.size();i++)
                {
                    List<Permission> permissionList=roleService.getDetail(((Role)roles.get(i)).getRolename()).getPermissions();
                    for(Permission p:permissionList)
                    permissions.add(p.getFnumber());
                }
                //List permissions = permissionService.findPermissionByMap(map);
                authorizationInfo.addStringPermissions(permissions);
            }
            session.setAttribute(key, authorizationInfo);
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        User user=userService.getDetail(username);
        if(user==null){
            throw new UnknownAccountException();
        }else {

            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),
                    user.getUserpassword(),
                    getClass().getName());
            //第一种加密方式
            //系统设置固定的加密盐方式
//          info.setCredentialsSalt(ByteSource.Util.bytes(map.get("name")));
            //第二种方式:加密盐由系统随机生成,保存在数据库中,查询用户信息时需要将该随机盐一同查询出来
           // Object randomSalt = map.get("salt");//此处值由用户表获取
            info.setCredentialsSalt(ByteSource.Util.bytes(user.getUserpassword()));
            return info;
        }
    }
}
