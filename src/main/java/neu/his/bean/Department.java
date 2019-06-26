package neu.his.bean;
/**
 * 存储科室
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class Department {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 部门编码
     */
    private String departmentCode;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门分类
     */
    private String departmentCategory;
    /**
     * 部门类型
     */
    private String departmentType;
    /**
     * 部门类型名称
     */
    private String departmentTypeName;

    /**
     *构造方法1
     *@param id 主键id
     *@param departmentCode 部门编码
     *@param departmentName 部门名称
     *@param departmentCategory 部门分类
     *@param departmentType 部门类型
     */
    public Department(Integer id, String departmentCode, String departmentName, String departmentCategory, String departmentType) {
        this.id = id;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentCategory = departmentCategory;
        this.departmentType = departmentType;
    }

    /**
     *构造方法2
     *@param departmentCode 部门编码
     *@param id 主键id
     *@param departmentName 部门名称
     *@param departmentCategory 部门分类
     *@param departmentTypeName 部门类型名称
     */
    public Department( String departmentCode, Integer id, String departmentName, String departmentCategory,String departmentTypeName) {
        this.id = id;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentCategory = departmentCategory;
        this.departmentTypeName = departmentTypeName;
    }

    /**
     *构造方法3
     *@param departmentCode 部门编码
     *@param departmentName 部门名称
     *@param departmentCategory 部门分类
     *@param departmentTypeName 部门类型名称
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
