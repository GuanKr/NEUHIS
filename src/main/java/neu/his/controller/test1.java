package neu.his.controller;


import com.github.pagehelper.PageHelper;
import neu.his.bean.User;
import neu.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("user")
public class test1 {
    @Autowired
    UserService userService;

    @RequestMapping("list")
    public void m1() {
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

}
