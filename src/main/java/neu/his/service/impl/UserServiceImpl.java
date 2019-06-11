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

    @Autowired
    TranslateMapper translateMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    TitleMapper titleMapper;

    @Autowired
    RegistrationLevelMapper registrationLevelMapper;

/*    @Override
    public List<User> effectiveness(List<User> list) {
        int length = list.size();
        int flag = 0;
        List<User> sign = new ArrayList<>();
        for(int i = 0 ;i<length;i++){
            if(list.get(i).getRoleId() == 0){
                sign.add(list.get(i));
                flag++;
            }
        }
        for(int i = 0;i<flag;i++){
            list.remove(sign.get(i));
        }
        return list;
    }

    @Override
    public User effectiveness(User user) {
        if (user.getRoleId() != 0)
            return user;
        else
            return null;
    }*/

    @Override
    public List<User> findAll() {
        List<User> list;

        UserExample userExample = new UserExample();
        userExample.or().andRoleIdNotEqualTo(0);
        list = userMapper.selectByExample(userExample);

        for(User user : list){
            user.setDepartmentname(translateMapper.translate_department(user.getDepartmentId()));
            user.setRolename(translateMapper.translate_role(user.getRoleId()));
            user.setRegistrationLevelname(translateMapper.translate_registration_level(user.getRegistrationLevelId()));
            user.setTitlename(translateMapper.translate_title(user.getTitleId()));
        }
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
        List<Role> roles;
        List<Department> departments;
        List<Title> titles;
        List<RegistrationLevel> registrationLevels;
        List<User> listAll;

        UserExample example = new UserExample();

        listAll = userMapper.selectByExample(new UserExample());
        roles = roleMapper.selectByExample(new RoleExample());
        departments = departmentMapper.selectByExample(new DepartmentExample());
        titles = titleMapper.selectByExample(new TitleExample());
        registrationLevels =registrationLevelMapper.selectByExample(new RegistrationLevelExample());

        UserExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdNotEqualTo(0);

        if(attribute_name.equals("role_name")){
            for(int i = 0;i<roles.size();i++){
                if(roles.get(i).getRoleName().contains(attribute)){
                    example.or().andRoleIdEqualTo(roles.get(i).getId());
                }
            }

        }else if(attribute_name.equals("name")){
            for(int i = 0;i<listAll.size();i++){
                if(listAll.get(i).getName().contains(attribute)){
                    example.or().andNameEqualTo(listAll.get(i).getName());
                }
            }
        }else if(attribute_name.equals("login_name")){
            for(int i = 0;i<listAll.size();i++){
                if(listAll.get(i).getLoginName().contains(attribute)){
                    example.or().andLoginNameEqualTo(listAll.get(i).getLoginName());
                }
            }
        }else if(attribute_name.equals("department_name")){
            for(int i = 0;i<departments.size();i++){
                if(departments.get(i).getDepartmentName().contains(attribute)){
                    example.or().andDepartmentIdEqualTo(departments.get(i).getId());
                }
            }
        }else if(attribute_name.equals("title_name")){
            for(int i = 0;i<titles.size();i++){
                if(titles.get(i).getTitleName().contains(attribute)){
                    example.or().andTitleIdEqualTo(titles.get(i).getId());
                }
            }
        }else if(attribute_name.equals("level_name")){
            for(int i = 0;i<registrationLevels.size();i++){
                if(registrationLevels.get(i).getLevelName().contains(attribute)){
                    example.or().andRegistrationLevelIdEqualTo(registrationLevels.get(i).getId());
                }
            }
        }else {
            return null;
        }
        list = userMapper.selectByExample(example);

        for(User user : list){
            user.setDepartmentname(translateMapper.translate_department(user.getDepartmentId()));
            user.setRolename(translateMapper.translate_role(user.getRoleId()));
            user.setTitlename(translateMapper.translate_title(user.getTitleId()));
            user.setRegistrationLevelname(translateMapper.translate_registration_level(user.getRegistrationLevelId()));
        }

        return list;
    }

    @Override
    public void insertuser(User user) {
        user.setRoleId(translateMapper.de_translate_role(user.getRolename()));
        user.setDepartmentId(translateMapper.de_translate_department(user.getDepartmentname()));
        user.setTitleId(translateMapper.de_translate_title(user.getTitlename()));
        user.setRegistrationLevelId(translateMapper.de_translate_registration_level(user.getRegistrationLevelname()));
        userMapper.insertSelective(user);
    }

    @Override
    public void updateuser(User user) {
        user.setRoleId(translateMapper.de_translate_role(user.getRolename()));
        user.setDepartmentId(translateMapper.de_translate_department(user.getDepartmentname()));
        user.setTitleId(translateMapper.de_translate_title(user.getTitlename()));
        user.setRegistrationLevelId(translateMapper.de_translate_registration_level(user.getRegistrationLevelname()));
        userMapper.updateByPrimaryKey(user);
    }
}
