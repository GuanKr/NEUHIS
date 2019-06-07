package neu.his.service.impl;

import neu.his.bean.User;
import neu.his.bean.UserExample;
import neu.his.dao.TranslateMapper;
import neu.his.dao.UserMapper;
import neu.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper dao;

    @Autowired
    TranslateMapper dao1;

    @Override
    public List<User> findAll() {
        List<User> list;
        list = dao.selectByExample(new UserExample());
        for(User user : list){
            user.setDepartmentname(dao1.translate_department(user.getDepartmentId()));
            user.setRolename(dao1.translate_role(user.getRoleId()));
            user.setTitlename(dao1.translate_title(user.getTitleId()));
        }
        return list;
    }

    @Override
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
