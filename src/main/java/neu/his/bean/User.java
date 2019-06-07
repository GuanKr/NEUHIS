package neu.his.bean;

public class User {
    private Integer id;

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

    public User(String name, String loginName, String password, String registrationLevelname, String rolename, String departmentname, String titlename) {
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.registrationLevelname = registrationLevelname;
        this.rolename = rolename;
        this.departmentname = departmentname;
        this.titlename = titlename;
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