package com.baizhi.service;

import com.baizhi.dao.DeptDao;
import com.baizhi.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
