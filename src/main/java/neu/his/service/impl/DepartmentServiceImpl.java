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
    public List<Department> findAll() {
        return dao.selectByExample(new DepartmentExample());
    }
}
