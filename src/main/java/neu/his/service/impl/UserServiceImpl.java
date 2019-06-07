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
            user.setRegistrationLevelname(dao1.translate_registration_level(user.getRegistrationLevelId()));
        }
        return list;
    }

    @Override
    public void deletebyID(int id) {
        dao.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> findbyattribute_name(String attribute_name, String attribute) {
        List<User> list;
        UserExample example = new UserExample();
        if(attribute_name.equals("role_name")){
            example.or().andRoleIdEqualTo(dao1.de_translate_role(attribute));
        }else if(attribute_name.equals("name")){
            example.or().andNameEqualTo(attribute);
        }else if(attribute_name.equals("login_name")){
            example.or().andLoginNameEqualTo(attribute);
        }else if(attribute_name.equals("department_name")){
            example.or().andDepartmentIdEqualTo(dao1.de_translate_department(attribute));
        }else if(attribute_name.equals("title_name")){
            example.or().andTitleIdEqualTo(dao1.de_translate_title(attribute));
        }else if(attribute_name.equals("level_name")){
            example.or().andRegistrationLevelIdEqualTo(dao1.de_translate_registration_level(attribute));
        }
        list = dao.selectByExample(example);

        for(User user : list){
            user.setDepartmentname(dao1.translate_department(user.getDepartmentId()));
            user.setRolename(dao1.translate_role(user.getRoleId()));
            user.setTitlename(dao1.translate_title(user.getTitleId()));
            user.setRegistrationLevelname(dao1.translate_registration_level(user.getRegistrationLevelId()));
        }

        return list;
    }

    @Override
    public void insertuser(User user) {
        user.setRoleId(dao1.de_translate_role(user.getRolename()));
        user.setDepartmentId(dao1.de_translate_department(user.getDepartmentname()));
        user.setTitleId(dao1.de_translate_title(user.getTitlename()));
        user.setRegistrationLevelId(dao1.de_translate_registration_level(user.getRegistrationLevelname()));
        System.out.println(user.toString());
        dao.insertSelective(user);
    }

    @Override
    public void updateuser(User user) {

        user.setRoleId(dao1.de_translate_role(user.getRolename()));
        user.setDepartmentId(dao1.de_translate_department(user.getDepartmentname()));
        user.setTitleId(dao1.de_translate_title(user.getTitlename()));
        user.setRegistrationLevelId(dao1.de_translate_registration_level(user.getRegistrationLevelname()));

        dao.updateByPrimaryKey(user);
    }
}
