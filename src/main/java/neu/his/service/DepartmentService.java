package neu.his.service;

import neu.his.bean.Department;

import java.util.List;

public interface DepartmentService {
    //转换char，String.自用
    String translate(String type);
    String de_translate(String type_name);


    //列出所有
    List<Department> findAll();


}
