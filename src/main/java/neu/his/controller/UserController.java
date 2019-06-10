package neu.his.controller;

import neu.his.bean.User;
import neu.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("management")
         public String toManagement (){
         return  "user/management";
         }
    @RequestMapping("list")
    public @ResponseBody
    List userList() {
        List<User> userlist = userService.findAll();
        return userlist;
    }
    @RequestMapping("deletebyID")
    public void deletebyID(int id) {
        userService.deletebyID(id);
    }
    @RequestMapping("insertuser")
    public void insertUser(User user){
        userService.insertuser(user);
    }
    @RequestMapping("updateusers")
    public void updateUsers(List<User> users){
        for (User user : users) {
           userService.updateuser(user);
        }
    }
    @RequestMapping("updatetuser")
    public void updateUser(User user){
        userService.updateuser(user);
    }
    @RequestMapping("findbyattribute")
    public  List findByAttribute(String attribute_name,String attribute){
        List<User> list=userService.findbyattribute_name(attribute_name,attribute);
        return list;
    }
}
