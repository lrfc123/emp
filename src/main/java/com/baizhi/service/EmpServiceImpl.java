package com.baizhi.service;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> queryAll() {
        return empDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll(Integer page,Integer rows) {
        Integer begin = (page-1)*rows;
        return empDao.findAll(begin,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer count() {
        return empDao.count();
    }

    @Override
    public void save(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.save(emp);
    }

    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public void delete(String id) {
        empDao.delete(id);
    }

    @Override
    public List<Emp> findAllSearch(Integer page, Integer rows, String searchField, String searchOper, String searchString) {
        Integer start = (page-1)*rows;
        return empDao.findAllSearch(start,rows,searchField,searchOper,searchString);
    }

    @Override
    public Integer findSerachTotalCounts(String searchField, String searchOper, String searchString) {
        return empDao.findSearchTotalCounts(searchField,searchOper,searchString);
    }


}
