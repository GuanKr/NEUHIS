package neu.his.service.impl;

import neu.his.bean.User;
import neu.his.bean.UserExample;
import neu.his.dao.UserMapper;
import neu.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper dao;

    public List<User> findAll() {
        return dao.selectByExample(new UserExample());
    }


    public void deletebyID(int id) {
        dao.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> findbyattribute_name(String attribute_name, String attribute) {
        return null;
    }

    @Override
    public void insertuser(User user) {

    }

    @Override
    public void updateuser(User user) {

    }
}
