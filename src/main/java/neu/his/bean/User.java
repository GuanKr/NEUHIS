package neu.his.bean;

public class User {
    private Integer id;

    private Integer roleId;

    private Integer departmentId;

    private String name;

    private String loginName;

    private String password;

    public User(Integer id, Integer roleId, Integer departmentId, String name, String loginName, String password) {
        this.id = id;
        this.roleId = roleId;
        this.departmentId = departmentId;
        this.name = name;
        this.loginName = loginName;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}