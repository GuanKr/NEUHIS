package neu.his.controller;

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
}
