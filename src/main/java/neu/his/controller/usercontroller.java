package neu.his.controller;

import neu.his.bean.User;
import neu.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
@Controller
@RequestMapping("user")
public class usercontroller {
    @Autowired
    UserService userService;
    @RequestMapping("management")
         public String tomanagement (){
         return  "user/usermanagement";
         }
    @RequestMapping("list")
    public List list() {
        List<User> list = userService.findAll();
        return list;
    }
    @RequestMapping("deletebyID")
    public void deletebyID(int id) {
        userService.deletebyID(id);
    }
    @RequestMapping("insertuser")
    public void insertuser(User user){
        userService.insertuser(user);
    }
    @RequestMapping("updateusers")
    public void updateusers(List<User> users){
        for (User user : users) {
           userService.updateuser(user);
        }
    }
    @RequestMapping("updatetuser")
    public void updateuser(User user){
        userService.updateuser(user);
    }
    @RequestMapping("findbyattribute")
    public  List findbyattribute(String attribute_name,String attribute){
        List<User> list=userService.findbyattribute_name(attribute_name,attribute);
        return list;
    }
}
