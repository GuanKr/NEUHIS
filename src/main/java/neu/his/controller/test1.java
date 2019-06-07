package neu.his.controller;


import neu.his.bean.User;
import neu.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("usertest")
public class test1 {
    @Autowired
    UserService userService;

    @RequestMapping("list")
    public void m1() {
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
    }

    @RequestMapping("delete")
    public void m2() {
        userService.deletebyID(7);
    }

    @RequestMapping("insert")
    public void m3() {
        User user = new User("1","1","1","普通门诊","门诊医生","心血管内科","主任医师");
        userService.insertuser(user);
    }

    @RequestMapping("query")
    public void m4() {
        userService.findbyattribute_name("role_name","门诊医生");
    }


}
