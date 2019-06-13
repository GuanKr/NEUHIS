package neu.his.bean;

public class Role {
    private Integer id;

    private String roleName;

    /**
     *@Author:
     *@param: [roleName]
     * 角色名称
     *@return:
     *@Description: 构造方法1
     */
    public Role(String roleName) {  this.roleName = roleName; }

    /**
     *@Author:
     *@param: [id, roleName]
     * 主键id，角色名称
     *@return:
     *@Description: 构造方法2
     */
    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}