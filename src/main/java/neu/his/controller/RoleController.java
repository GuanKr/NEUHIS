package neu.his.controller;

import neu.his.bean.Role;
import neu.his.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("list")
    public @ResponseBody
    List roleList() {
        List<Role> rolelist = roleService.findAll();
        return rolelist;
    }
}
