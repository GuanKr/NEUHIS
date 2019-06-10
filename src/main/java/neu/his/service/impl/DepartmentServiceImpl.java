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
            default:
                return null;
        }
    }

    @Override
    public String de_translate(String type_name) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return dao.selectByExample(new DepartmentExample());
    }
}
