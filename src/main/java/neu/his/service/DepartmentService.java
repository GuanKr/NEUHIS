package neu.his.service;

import neu.his.bean.Department;

import java.util.List;
/**
 * 处理科室信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface DepartmentService {
    /**
     * 将1，2等转化为String
     * @param type 类型
     * @return 类型名称
     */
    String translate(String type);

    /**
     * 将名称转化为1，2等存入数据库
     * @param type_name 类型名称
     * @return 类型
     */
    String de_translate(String type_name);


    /**
     * 列出所有科室
     * @return 科室列表
     */
    List<Department> findAll();

    /**
     * 删除科室信息
     * @param id 主键id
     */
    void deleteByID(int id);

    /**
     * 根据属性名称及内容来查找
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     * @return 科室列表
     */
    List<Department> findByAttribute_name(String attribute_name, String attribute);

    /**
     * 插入科室信息
     * @param department 新的科室信息
     */
    void insertDepartment(Department department);

    /**
     * 更新科室信息
     * @param department 内容更新过的科室信息
     */
    void updateDepartment(Department department);


}
