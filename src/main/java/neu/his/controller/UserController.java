package neu.his.controller;

import neu.his.bean.User;
import neu.his.dto.UserDTO;
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
    public @ResponseBody
    void deletebyID(int id) {
        userService.deletebyID(id);
    }
    @RequestMapping("insertuser")
    public @ResponseBody
    void insertUser(User user){
        userService.insertuser(user);
    }
    @RequestMapping("updateusers")
    public @ResponseBody void updateUsers(UserDTO users){
        List<User> users1 = users.getUsers();
        for (User user : users1){
            userService.updateuser(user);
        }
    }
    @RequestMapping("updatetuser")
    public @ResponseBody
    void updateUser(User user){
        userService.updateuser(user);
    }
    @RequestMapping("findbyattribute")
    public  @ResponseBody List findByAttribute(String attribute_name,String attribute){
        List<User> list=userService.findbyattribute_name(attribute_name,attribute);
        return list;
    }
}
