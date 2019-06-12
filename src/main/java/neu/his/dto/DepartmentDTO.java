package neu.his.dto;

import neu.his.bean.Department;

import java.util.List;

public class DepartmentDTO {
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
