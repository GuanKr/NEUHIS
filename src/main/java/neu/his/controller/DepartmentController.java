package neu.his.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import neu.his.bean.Department;
import neu.his.service.DepartmentService;
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
    //@RequestMapping("updatedepartments")

    @RequestMapping("listWithPageHelper")
    public @ResponseBody
    PageInfo listWithPageHelper(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Department> departmentlist = departmentService.findAll();
        PageInfo pageInfo = new PageInfo(departmentlist);
        return pageInfo;
    }
}
