package neu.his.service.impl;

import neu.his.bean.Role;
import neu.his.bean.RoleExample;
import neu.his.dao.RoleMapper;
import neu.his.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper dao;

    @Override
    public List<Role> findAll() {
        return dao.selectByExample(new RoleExample());
    }
}
