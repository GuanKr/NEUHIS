package neu.his.controller;


import neu.his.bean.User;
import neu.his.service.UserService;
import neu.his.service.impl.UserServiceImpl;
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
        userService.deletebyID(13);
    }

    @RequestMapping("insert")
    public void m3() {
        User user = new User("1","1","1","普通门诊","离职","心血管内科","主任医师");
        userService.insertuser(user);
    }

    @RequestMapping("query1")
    public void m4() {
        List<User> list = userService.findbyattribute_name("role_name","门诊医生");

        for (User user : list) {
            System.out.println(user.toString());
        }

    }
    @RequestMapping("query2")
    public void m5() {
        List<User> list = userService.findbyattribute_name("name","1");

        for (User user : list) {
            System.out.println(user.toString());
        }

    }
    @RequestMapping("query3")
    public void m6() {
        List<User> list = userService.findbyattribute_name("login_name","哈哈哈");

        for (User user : list) {
            System.out.println(user.toString());
        }
    }

    @RequestMapping("query4")
    public void m7() {
        List<User> list = userService.findbyattribute_name("department_name","外科");
        for (User user : list) {
            System.out.println(user.toString());
        }
    }

    @RequestMapping("query5")
    public void m8() {
        List<User> list = userService.findbyattribute_name("title_name","主任");

        for (User user : list) {
            System.out.println(user.toString());
        }
    }

    @RequestMapping("query6")
    public void m9() {
        List<User> list = userService.findbyattribute_name("level_name","诊");

        for (User user : list) {
            System.out.println(user.toString());
        }

    }


    @RequestMapping("update")
    public void m10() {
        List<User> list = userService.findAll();
        list = new UserServiceImpl().effectiveness(list);
        for(User user: list){
            userService.updateuser(user);
        }
        System.out.println(list);

    }

}
