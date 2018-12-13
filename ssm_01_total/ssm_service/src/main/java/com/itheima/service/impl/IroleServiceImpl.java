package com.itheima.service.impl;

import com.itheima.dao.IRoleDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.IroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IroleServiceImpl implements IroleService {

    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> findAll() {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) {
        iRoleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return iRoleDao.findById(id);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return iRoleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            System.out.println(permissionId+"111111111111111111111111111"+roleId);
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }

}
