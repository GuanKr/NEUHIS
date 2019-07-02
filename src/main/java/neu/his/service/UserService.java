package neu.his.service;

import neu.his.bean.User;

import java.util.List;


/**
 * 处理用户信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface UserService {

    /**
     * 列出所有用户
     * @return 所有用户的列表
     */
    List<User> findAll();

    /**
     * 删除某一用户
     * @param id 用户信息主键id
     */
    void deletebyID(int id);

    /**
     * 根据属性名称及内容来查找
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     */
    List<User> findbyattribute_name(String attribute_name,String attribute);

    /**
     * 插入一个新用户
     * @param user 新的用户信息
     * @return 处理结果
     */
    String insertuser(User user);

    /**
     * 更新用户表
     * @param user 内容更新过的用户信息
     */
    void updateuser(User user);

}
