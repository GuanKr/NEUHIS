package neu.his.bean;

public class Department {
    private Integer id;

    private String departmentCode;

    private String departmentName;

    private String departmentCategory;

    private String departmentType;

    private String departmentTypeName;

    /**
     *@Author:
     *@param: [id, departmentCode, departmentName, departmentCategory, departmentType]
     * 主键id，部门编码，部门名称，部门分类，部门类型
     *@return:
     *@Description: 构造方法1
     */
    public Department(Integer id, String departmentCode, String departmentName, String departmentCategory, String departmentType) {
        this.id = id;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentCategory = departmentCategory;
        this.departmentType = departmentType;
    }

    /**
     * @Author:
     * @param: [departmentCode, id, departmentName, departmentCategory, departmentTypeName]
     * 部门编码，主键id，部门名称，部门分类，部门分类名称
     *@return:
     *@Description: 构造方法2
     */
    public Department( String departmentCode, Integer id, String departmentName, String departmentCategory,String departmentTypeName) {
        this.id = id;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentCategory = departmentCategory;
        this.departmentTypeName = departmentTypeName;
    }

    /**
     *@Author:
     *@param: [departmentCode, departmentName, departmentCategory, departmentTypeName]
     * 部门编码，部门名称，部门分类，部门分类名称
     *@return:
     *@Description: 构造方法3
     */
    public Department(String departmentCode, String departmentName, String departmentCategory, String departmentTypeName){
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentCategory = departmentCategory;
        this.departmentTypeName = departmentTypeName;
    }

    public String getDepartmentTypeName() {
        return departmentTypeName;
    }

    public void setDepartmentTypeName(String departmentTypeName) {
        this.departmentTypeName = departmentTypeName;
    }

    public Department() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentCategory() {
        return departmentCategory;
    }

    public void setDepartmentCategory(String departmentCategory) {
        this.departmentCategory = departmentCategory == null ? null : departmentCategory.trim();
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType == null ? null : departmentType.trim();
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCategory='" + departmentCategory + '\'' +
                ", departmentType='" + departmentType + '\'' +
                ", departmentTypeName='" + departmentTypeName + '\'' +
                '}';
    }
}