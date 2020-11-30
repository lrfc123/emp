package com.baizhi.controller;


import com.alibaba.druid.util.StringUtils;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("emp")
@Scope("prototype")
public class EmpController {

    private final Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empService;

    @RequestMapping("queryAll")
    @ResponseBody
    public List<Emp> queryAll(){
        List<Emp> emps = empService.queryAll();
        return emps;
    }

    //查所有
    @RequestMapping("findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page,Integer rows){
        List<Emp> all = empService.findAll(page, rows);
        Integer count = empService.count();
        Integer total = count%rows==0?count/rows:count/rows+1;
        HashMap<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("total",total);
        map.put("count",count);
        map.put("rows",all);
        return map;
    }

    //修改方法：String oper add：添加 edit：修改  del:删除

    @RequestMapping("edit")
    @ResponseBody
    public void edit(Emp emp,String oper){
        log.info("当前操作:{}",oper);

        //判断是什么操作
        if(StringUtils.equals("add",oper)){
            log.info("员工信息:{}","员工性别信息:{}","员工部门id:{}",emp.getName(),emp.getSex(),emp.getDept(),emp.getId());
            empService.save(emp);
        }
        if(StringUtils.equals("edit",oper)){
            log.info("员工信息:{}","员工性别信息:{}","员工部门id:{}",emp.getName(),emp.getSex(),emp.getDept(),emp.getId());
            empService.update(emp);
        }
        if(StringUtils.equals("del",oper)){
            log.info("删除的员工id:{}",emp.getId());
            empService.delete(emp.getId());
        }
    }


    //搜索条件查询
    @RequestMapping("findAll2")
    @ResponseBody
    public Map<String,Object> findAll2(Integer page,Integer rows,String searchField,String searchOper,String searchString){
        log.info("当前页：{}，每页显示记录数：{}",page,rows);
        HashMap<String,Object> result = new HashMap<>();
        List<Emp> emps;
        Integer totalCounts;
        if(StringUtils.isEmpty(searchField)){
            //分页查询的结果
            emps = empService.findAll(page,rows);
            //总条数
            totalCounts = empService.count();
        }else{
            emps = empService.findAllSearch(page,rows,searchField,searchOper,searchString);
            totalCounts = empService.findSerachTotalCounts(searchField,searchOper,searchString);
        }
        //总页数
        Integer totalPage = totalCounts%rows==0?totalCounts/rows:(totalCounts/rows)+1;
        result.put("page",page);
        result.put("total",totalPage);
        result.put("records",totalCounts);
        result.put("rows",emps);
        return result;
    }

    public String get(String searchOper){
        Map<String,String> map = new HashMap<>();
        map.put("eq","=");
        map.put("ne","!=");
        map.put("cn","containt");
        return map.get(searchOper);
    }

}
