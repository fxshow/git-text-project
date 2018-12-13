package com.itheima.service;

import com.itheima.domain.SysLog;

import java.util.List;

public interface IsyslogService {
    List<SysLog> findAll(int page,int size);

    void save(SysLog sysLog);
}
