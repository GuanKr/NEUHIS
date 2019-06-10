package neu.his.service;

import neu.his.bean.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    //有效化  自用
    List<User> effectiveness(List<User> list);
    User effectiveness(User user);

    //列出所有
    List<User> findAll();

    //删除
    void deletebyID(int id);

    //查询  attribute_name为属性名 ， attribute为属性内容
    //强制转化  错误处理
    List<User> findbyattribute_name(String attribute_name,String attribute);

    //新增
    void insertuser(User user);

    //修改
    void updateuser(User user);

}
