package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {

    public List<Emp> queryAll();

    //分页
    public List<Emp> findAll(Integer page,Integer rows);

    //总条数
    public Integer count();

    //添加
    public void save(Emp emp);

    //修改
    public void update(Emp emp);

    //删除
    public void delete(String id);

    //搜索条件查询分页
    public List<Emp> findAllSearch(Integer page,Integer rows,String searchField,String searchOper,String searchString);

    //条件查询总条数
    public Integer findSerachTotalCounts(String searchField,String searchOper,String searchString);
}
