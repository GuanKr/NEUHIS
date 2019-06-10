package neu.his.service.impl;

import neu.his.bean.Department;
import neu.his.bean.DepartmentExample;
import neu.his.dao.DepartmentMapper;
import neu.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper dao;

    @Override
    public String translate(String type) {
        switch (type) {
            case "1":
                return "临床科室";
            case "2":
                return "医技科室";
            case "3" :
                return "财务科室";
            case "4" :
                return "行政科室";
            case "5" :
                return "其他科室";
            default:
                return null;
        }
    }

    @Override
    public String de_translate(String type_name) {
        switch (type_name) {
            case "临床科室":
                return "1";
            case "医技科室":
                return "2";
            case "财务科室" :
                return "3";
            case "行政科室" :
                return "4";
            case "其他科室" :
                return "5";
            default:
                return null;
        }
    }

    @Override
    public List<Department> findAll() {
        List<Department> list;
        list =  dao.selectByExample(new DepartmentExample());
        for(Department department : list){
            department.setDepartmentTypeName(translate(department.getDepartmentType()));
        }
        return list;
    }

    @Override
    public void deleteByID(int id) {

    }

    @Override
    public List<Department> findByAttribute_name(String attribute_name, String attribute) {
        List<Department> list;
        DepartmentExample departmentExample = new DepartmentExample();
        if(attribute_name.equals("department_code")){
            departmentExample.or().andDepartmentCodeEqualTo(attribute);
        }else if(attribute_name.equals("department_name")){
            departmentExample.or().andDepartmentNameEqualTo(attribute);
        }else if(attribute_name.equals("department_type")){
            departmentExample.or().andDepartmentTypeEqualTo(de_translate(attribute));
        }else if(attribute_name.equals("department_category")){
            departmentExample.or().andDepartmentCategoryEqualTo(attribute);
        }else {
            return null;
        }
        list =  dao.selectByExample(departmentExample);
        for(Department department : list){
            department.setDepartmentTypeName(translate(department.getDepartmentType()));
        }
        return list;
    }

    @Override
    public void insertDepartment(Department department) {
        department.setDepartmentType(de_translate(department.getDepartmentTypeName()));
        dao.insertSelective(department);
    }

    @Override
    public void updateDepartment(Department department) {
        department.setDepartmentType(de_translate(department.getDepartmentTypeName()));
        dao.updateByPrimaryKey(department);
    }
}
