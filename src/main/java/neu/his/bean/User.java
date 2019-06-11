package neu.his.bean;
/**
 * 存储用户信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public class User {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    private Integer departmentId;

    private String name;

    private String loginName;

    private String password;

    private Integer titleId;

    private Integer registrationLevelId;

    public String rolename;

    public String departmentname;

    public String titlename;

    public String registrationLevelname;

    /**
     * 构造方法1
     * @param id 主键id
     * @param roleId 角色id
     * @param departmentId
     * @param name
     * @param loginName
     * @param password
     * @param titleId
     * @param registrationLevelId
     */
    public User(Integer id, Integer roleId, Integer departmentId, String name, String loginName, String password, Integer titleId, Integer registrationLevelId) {
        this.id = id;
        this.roleId = roleId;
        this.departmentId = departmentId;
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.titleId = titleId;
        this.registrationLevelId = registrationLevelId;
    }

    /**
     * 构造方法2
     * @param name 姓名
     * @param loginName
     * @param password
     * @param registrationLevelname
     * @param rolename
     * @param departmentname
     * @param titlename
     */
    public User(String name, String loginName, String password, String registrationLevelname, String rolename, String departmentname, String titlename) {
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.registrationLevelname = registrationLevelname;
        this.rolename = rolename;
        this.departmentname = departmentname;
        this.titlename = titlename;
    }

    /**
     * 构造方法3
     * @param id 主键id
     * @param name
     * @param loginName
     * @param password
     * @param rolename
     * @param departmentname
     * @param titlename
     * @param registrationLevelname
     */
    public User(Integer id, String name, String loginName, String password, String rolename, String departmentname, String titlename, String registrationLevelname) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.rolename = rolename;
        this.departmentname = departmentname;
        this.titlename = titlename;
        this.registrationLevelname = registrationLevelname;

    }

    public String getRegistrationLevelname() {
        return registrationLevelname;
    }

    public void setRegistrationLevelname(String registrationLevelname) {
        this.registrationLevelname = registrationLevelname;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getRegistrationLevelId() {
        return registrationLevelId;
    }

    public void setRegistrationLevelId(Integer registrationLevelId) {
        this.registrationLevelId = registrationLevelId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", titleId=" + titleId +
                ", registrationLevelId=" + registrationLevelId +
                ", rolename='" + rolename + '\'' +
                ", departmentname='" + departmentname + '\'' +
                ", titlename='" + titlename + '\'' +
                ", registrationLevelname='" + registrationLevelname + '\'' +
                '}';
    }
}