package neu.his.service;

import neu.his.bean.Department;

import java.util.List;

public interface DepartmentService {
    //转换char，String.自用
    String translate(String type);
    String de_translate(String type_name);


    //列出所有
    List<Department> findAll();

    //删除
    void deleteByID(int id);

    //查询  attribute_name为属性名 ， attribute为属性内容
    List<Department> findByAttribute_name(String attribute_name,String attribute);

    //新增
    void insertDepartment(Department user);

    //修改
    void updateDepartment(Department user);


}
