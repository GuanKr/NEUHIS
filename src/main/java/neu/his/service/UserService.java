package neu.his.service;

import neu.his.bean.User;

import java.util.List;

public interface UserService {
    //列出所有
    List<User> findAll();

    //删除
    void deletebyID(int id);

    //查询
    List<User> findbyID(int id);

    //新增
    void insertuser(User user);

    //修改
    void updateuser(User user);

}
