import com.baizhi.EmpApplication;
import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.service.DeptService;
import com.baizhi.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = EmpApplication.class)
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    @Test
    public void test(){
        List<Emp> emps = empService.queryAll();
        System.out.println(emps);
    }
    @Test
    public void test2(){
        List<Emp> all = empService.findAll(1,3);
        System.out.println(all);
    }

    @Test
    public void test3(){
        String s1 = "hello";
        System.out.println(s1 == new String("he") + new String("llo"));

    }

    @Test
    public void test4(){
        List<Dept> all = deptService.findAll();
        System.out.println(all);
    }

    @Test
    public void test5(){
        List<Emp> allSearch = empService.findAllSearch(1, 4, "name", "eq", "小黑");
        System.out.println(allSearch);
    
}
    @Test
    public void test16(){
        int i = 100;
        int j = 99;
    }

}
