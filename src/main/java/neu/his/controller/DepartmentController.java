package neu.his.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import neu.his.bean.Department;
import neu.his.dto.DepartmentDTO;
import neu.his.service.DepartmentService;
import neu.his.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("list")
    public @ResponseBody
    List departmentList() {
        List<Department> departmentlist = departmentService.findAll();
        return departmentlist;

    }
    @RequestMapping("updatedepartments")
    public @ResponseBody
    void updatedepartments(DepartmentDTO departments){
        List<Department> departments1=departments.getDepartments();
        for(Department department:departments1){
            departmentService.updateDepartment(department);
        }
    }

    @RequestMapping("listWithPageHelper")
    public @ResponseBody
    PageInfo listWithPageHelper(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Department> departmentlist = departmentService.findAll();
        PageInfo pageInfo = new PageInfo(departmentlist);
        return pageInfo;
    }
    @RequestMapping("findByAttributeWithPageHelper")
    public @ResponseBody
    PageInfo findByAttributeWithPageHelper(String attribute_name, String attribute,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Department> departmentlist = departmentService.findByAttribute_name(attribute_name,attribute);
        PageInfo pageInfo = new PageInfo(departmentlist);
//        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
//        PageInfo.setList(departmentService.)
        return pageInfo;
    }
    @RequestMapping("departmentCategory")
    public @ResponseBody
    List<String> departmentCategory(){
        List<String> categorylist = departmentService.findCategory();
        return categorylist;
    }
}
