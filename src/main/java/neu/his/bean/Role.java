package neu.his.bean;
/**
 * 存储角色具体信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class Role {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 构造方法1
     * @param roleName 角色名称
     */
    public Role(String roleName) {  this.roleName = roleName; }

    /**
     * 构造方法2
     * @param id 主键id
     * @param roleName 角色名称
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