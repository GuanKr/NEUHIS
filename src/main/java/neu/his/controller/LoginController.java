package neu.his.controller;



import neu.his.bean.User;
import neu.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    /**
     * 向用户登录页面跳转
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }
    /**
     * 用户登录
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        //获取用户名和密码
        String username = user.getLoginName();
        String password = user.getPassword();
        //些处横板从数据库中获取对用户名和密码后进行判断
        List<User> list = userService.findAll();
        for(User user1 : list){
            if (user1.getRoleId()!=0&&username != null && username.equals(user1.getLoginName()) && password != null && password.equals(user1.getPassword())) {
                //将用户对象添加到Session中
                session.setAttribute("USER_SESSION", user1);
                //重定向到主页面的跳转方法
                switch (user1.getRoleId()){
                    case 1:
                        return "registration/registrationInfo";
                    case 2:
                        return "medicalRecord/medicalRecord";
                    case 3:
                        return "inspection/inspectionManagement";
                    case 4:
                        return "药房操作员";
                    case 5:
                        return "财务管理员";
                    case 6:
                        return "department/management";
                }
                /*return "redirect:main";*/
            }
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

    @RequestMapping(value = "/main")
    public String toMain() {
        return "main";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login";
    }
}

