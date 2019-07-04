package neu.his.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import neu.his.bean.User;
import neu.his.dto.ResultDTO;
import neu.his.dto.UserDTO;
import neu.his.service.UserService;
import neu.his.service.impl.UserServiceImpl;
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
    @RequestMapping("listWithPageHelper")
    public @ResponseBody PageInfo listWithPageHelper(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> userlist = userService.findAll();
        PageInfo pageInfo = new PageInfo(userlist);
        return pageInfo;
    }
    @RequestMapping("deletebyID")
    public @ResponseBody
    void deletebyID(int id) {
        userService.deletebyID(id);
    }
    @RequestMapping("insertuser")
    public @ResponseBody ResultDTO insertUser(User user){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(userService.insertuser(user));
        return resultDTO;
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
        List<User> list = userService.findbyattribute_name(attribute_name,attribute);
        return list;
    }
    @RequestMapping("findbyattributeWithPageHelper")
    public  @ResponseBody PageInfo findByAttributeWithPageHelper(String attribute_name,String attribute,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userService.findbyattribute_name(attribute_name,attribute);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
