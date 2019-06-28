package neu.his.temp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import neu.his.bean.Department;
import neu.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("detest")
public class detest {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("list")
    public void m1(){
        List<String> list = departmentService.findCategory();
        for(String category : list){
            System.out.println(category);
        }
    }

    @RequestMapping("query")
    public void m2(){

        List<Department> departmentlist = departmentService.findByAttribute_name("department_category","内科");
        for(Department department : departmentlist){
            System.out.println(department);
        }
    }


}
