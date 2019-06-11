package neu.his.service;

import neu.his.bean.RegistrationLevel;
import neu.his.bean.Role;

import java.util.List;
/**
 * 处理挂号级别信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface RegistrationLevelService {

    /**
     * 列出所有挂号级别
     * @return 挂号级别列表
     */
    List<RegistrationLevel> findAll();

    /**
     * 删除挂号级别信息
     * @param id 主键id
     */
    void deleteByID(int id);

    /**
     * 根据属性名称及内容来查找
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     * @return 挂号级别列表
     */
    List<RegistrationLevel> findByAttribute_name(String attribute_name, String attribute);

    /**
     * 插入挂号级别信息
     * @param registrationLevel 新的挂号级别
     */
    void insertRegistrationLevel(RegistrationLevel registrationLevel);

    /**
     * 更新挂号级别信息
     * @param registrationLevel 内容更新过的挂号级别
     */
    void updateRegistrationLevel(RegistrationLevel registrationLevel);
}
