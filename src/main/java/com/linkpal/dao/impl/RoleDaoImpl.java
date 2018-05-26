package com.linkpal.dao.impl;

import com.linkpal.dao.IRoleDao;
import com.linkpal.map.RoleMapper;
import com.linkpal.model.Role;
import com.linkpal.model.example.RoleExample;
import com.linkpal.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleDaoImpl implements IRoleDao {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getRoles() {
        return roleMapper.selectByExample(new RoleExample());
    }
}
