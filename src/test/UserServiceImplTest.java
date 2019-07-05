
import neu.his.bean.User;
import neu.his.service.UserService;
import neu.his.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resources")
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void findAll() {
        List<User> list = userService.findAll();
        for(User user : list){
            System.out.println(user);
        }
    }
    @Test
    public void deletebyID() {
        userService.deletebyID(1);
    }

    @Test
    public void findbyattribute_name() {
        List<User> list = userService.findbyattribute_name("name","三");
        for(User user : list){
            System.out.println(user);
        }
    }

    @Test
    public void insertuser() {
        User user = new User();
        user.setLoginName("");
        System.out.println(userService.insertuser(user));
    }

    @Test
    public void updateuser() {
        List<User> list = userService.findAll();
        User user = list.get(0);
        user.setPassword("1234567");
        userService.updateuser(user);
    }
}