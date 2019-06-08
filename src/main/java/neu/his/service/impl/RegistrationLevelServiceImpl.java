package neu.his.service.impl;

import neu.his.bean.RegistrationLevel;
import neu.his.bean.RegistrationLevelExample;
import neu.his.dao.RegistrationLevelMapper;
import neu.his.service.RegistrationLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegistrationLevelServiceImpl implements RegistrationLevelService {
    @Autowired
    RegistrationLevelMapper dao;

    @Override
    public List<RegistrationLevel> findAll() {
        return dao.selectByExample(new RegistrationLevelExample());
    }
}
