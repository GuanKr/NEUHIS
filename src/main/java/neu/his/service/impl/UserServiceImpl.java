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
    public void insertuser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateuser(User user) {
        userMapper.updateUser(user);
    }
}
