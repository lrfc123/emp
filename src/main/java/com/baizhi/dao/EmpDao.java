package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {

    public List<Emp> queryAll();

    //分页
    public List<Emp> findAll(@Param("begin") Integer begin, @Param("end") Integer end);
    //总条数
    public Integer count();

    //保存员工信息
    public void save(Emp emp);

    //修改员工信息
    public void update(Emp emp);

    //根据id删除员工信息
    public void delete(String id);

    //搜索分页查询
    List<Emp> findAllSearch(@Param("start")Integer start,@Param("rows")Integer rows,@Param("searchField")String searchField,@Param("searchOper")String searchOper,@Param("searchString")String searchString);

    //搜索分页总数
    Integer findSearchTotalCounts(@Param("searchField")String searchField,@Param("searchOper")String searchOper,@Param("searchString")String searchString);

}
