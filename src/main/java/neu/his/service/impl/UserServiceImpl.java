package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.*;
import neu.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> list;
        list = userMapper.selectWithName();
        return list;
    }


    @Override
    public void deletebyID(int id) {
        User user;
        user = userMapper.selectByPrimaryKey(id);
        user.setRoleId(0);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<User> findbyattribute_name(String attribute_name, String attribute) {
        List<User> list;
        if (attribute_name.equals("title_name")) {
            list = userMapper.queryByTitle(attribute);
        } else if (attribute_name.equals("role_name")) {
            list = userMapper.queryByRole(attribute);
        } else if (attribute_name.equals("name")) {
            list = userMapper.queryByName(attribute);
        } else if (attribute_name.equals("login_name")) {
            list = userMapper.queryByLoginName(attribute);
        } else if (attribute_name.equals("department_name")) {
            list = userMapper.queryByDepartment(attribute);
        } else if (attribute_name.equals("level_name")) {
            list = userMapper.queryByReLevel(attribute);
        } else {
            return null;
        }
        return list;
    }

    @Override
    public String insertuser(User user) {
        if(user.getLoginName().isEmpty()||user.getPassword().isEmpty()||user.getName().isEmpty()){
            return "请输入必填项";
        }
        List<User> list = findAll();
        for(User user1 : list){
            if(user1.getLoginName().equals(user.getLoginName())){
                return "用户名已被占用";
            }
        }
        userMapper.insertUser(user);
        return "成功";
    }

    @Override
    public void updateuser(User user) {
        userMapper.updateUser(user);
    }
}
