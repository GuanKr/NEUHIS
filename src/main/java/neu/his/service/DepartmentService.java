package neu.his.service;

import neu.his.bean.Department;

import java.util.List;

public interface DepartmentService {
    //列出所有
    List<Department> findAll();
}
