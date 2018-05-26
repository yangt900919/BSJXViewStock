package com.linkpal.service.impl;

import com.linkpal.dao.IRoleDao;
import com.linkpal.model.Role;
import com.linkpal.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Qualifier("roleDaoImpl")
    @Autowired
    IRoleDao roleDao;

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
}
