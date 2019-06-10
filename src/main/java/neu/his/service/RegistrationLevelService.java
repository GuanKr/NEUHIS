package neu.his.service;

import neu.his.bean.RegistrationLevel;
import neu.his.bean.Role;

import java.util.List;

public interface RegistrationLevelService {
    //列出所有
    List<RegistrationLevel> findAll();

    //删除
    void deleteByID(int id);

    //查询  attribute_name为属性名 ， attribute为属性内容
    List<RegistrationLevel> findByAttribute_name(String attribute_name,String attribute);

    //新增
    void insertRegistrationLevel(RegistrationLevel user);

    //修改
    void updateRegistrationLevel(RegistrationLevel user);
}
