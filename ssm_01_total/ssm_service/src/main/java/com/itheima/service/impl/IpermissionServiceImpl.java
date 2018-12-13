package com.itheima.service.impl;

import com.itheima.dao.IpermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.IpermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IpermissionServiceImpl implements IpermissionService {
    @Autowired
    private IpermissionDao ipermissionDao;

    @Override
    public List<Permission> findAll() {
        return ipermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        ipermissionDao.save(permission);
    }

    @Override
    public Permission findById(String permissionId) {
        return ipermissionDao.findById(permissionId);
    }

    @Override
    public void UpdatePermission(Permission permission) {
        ipermissionDao.UpdatePermission(permission);
    }

    @Override
    public void deletePermission(String id) {
        ipermissionDao.deletePermission(id);
    }
}
