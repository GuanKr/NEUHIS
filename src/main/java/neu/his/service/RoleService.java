package neu.his.service;

import neu.his.bean.Role;

import java.util.List;
/**
 * 处理角色信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface RoleService {
    /**
     * 列出所有角色信息
     * @return 角色信息列表
     */
    List<Role> findAll();

}
