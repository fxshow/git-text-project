package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IsyslogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.IsyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IsyslogServiceServiceImpl implements IsyslogService {
    @Autowired
    private IsyslogDao isyslogDao;

    @Override
    public List<SysLog> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return isyslogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) {
        isyslogDao.save(sysLog);
    }
}
