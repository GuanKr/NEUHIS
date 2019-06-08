package neu.his.service;

import neu.his.bean.RegistrationLevel;
import neu.his.bean.Role;

import java.util.List;

public interface RegistrationLevelService {
    //列出所有
    List<RegistrationLevel> findAll();
}
