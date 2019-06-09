package neu.his.controller;

import neu.his.bean.Department;
import neu.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("department")
public class departmentcontroller {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("list")
    public List list() {
        List<Department> list = departmentService.findAll();
        return list;
    }
}
