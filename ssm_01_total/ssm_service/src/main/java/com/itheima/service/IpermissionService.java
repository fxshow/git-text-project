package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface IpermissionService {

    public List<Permission> findAll();

    void save(Permission permission);

    Permission findById(String permissionId);

    void UpdatePermission(Permission permission);

    void deletePermission(String id);
}
