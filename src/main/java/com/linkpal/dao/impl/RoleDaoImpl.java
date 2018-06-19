package com.linkpal.dao.impl;

import com.linkpal.dao.IRoleDao;
import com.linkpal.map.RoleMapper;
import com.linkpal.map.RolerpermissionMapper;
import com.linkpal.model.Permission;
import com.linkpal.model.Role;
import com.linkpal.model.Role;
import com.linkpal.model.Rolerpermission;
import com.linkpal.model.example.RoleExample;
import com.linkpal.model.example.RoleExample;
import com.linkpal.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class RoleDaoImpl implements IRoleDao {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolerpermissionMapper rolerpermissionMapper;

    @Override
    public List<Role> getRoles() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public void rolepermissionBind(Map map) {
        roleMapper.rolepermissionBind(map);
    }

    @Override
    public void deleteRolePermission(int id) {
        roleMapper.deleteRolePermission(id);
    }

    @Override
    public boolean create(Role role) throws Exception {

       /* roleMapper.deleteRolePermission(role.getFid());

      List<Permission> permissions=role.getPermissions();

        saveRolePermission( role,  permissions);*/

        return roleMapper.insert(role)>0;
    }

    private void saveRolePermission(Role role, List<Permission> permissions)
    {
        for(Permission p:permissions)
        {
            Rolerpermission rp=new Rolerpermission();
            rp.setFroleid(role.getFid());
            rp.setFpermissionid(p.getFid());
            rp.setFcreatetime(new Date());
            rolerpermissionMapper.insert(rp);
        }
    }

    @Override
    public boolean update(Role role) throws Exception {
   /*     roleMapper.deleteRolePermission(role.getFid());

        List<Permission> permissions=role.getPermissions();
        saveRolePermission( role,  permissions);*/
        return roleMapper.updateByPrimaryKey(role)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return roleMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Role> getList() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public Role getDetail(String fnumber) {
        RoleExample example=new RoleExample();
        example.createCriteria().andRolenameEqualTo(fnumber);
        List<Role> list=roleMapper.selectByExample(example);
        if(list.size()>0)return list.get(0);
        else return null;
    }

    @Override
    public Role getDetail(int fid) {
        return roleMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Role> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Role> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Role> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Role role) {
        return roleMapper.getTotalNum(role);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return roleMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Role> getList(int pageIndex, int pageSize, Role role) {
        return roleMapper.getList(pageIndex,pageSize,role);
    }
}
