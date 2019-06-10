package neu.his.service.impl;

import neu.his.bean.RegistrationLevel;
import neu.his.bean.RegistrationLevelExample;
import neu.his.dao.RegistrationLevelMapper;
import neu.his.service.RegistrationLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class RegistrationLevelServiceImpl implements RegistrationLevelService {
    @Autowired
    RegistrationLevelMapper registrationLevelMapper;

    @Override
    public List<RegistrationLevel> findAll() {
        return registrationLevelMapper.selectByExample(new RegistrationLevelExample());
    }

    @Override
    public void deleteByID(int id) {
        registrationLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<RegistrationLevel> findByAttribute_name(String attribute_name, String attribute) {
        List<RegistrationLevel> list;
        List<RegistrationLevel> listAll;

        listAll = findAll();

        RegistrationLevelExample registrationExample = new RegistrationLevelExample();
        if(attribute_name.equals("code")){
            for(int i = 0;i<listAll.size();i++){
                if(listAll.get(i).getCode().contains(attribute)){
                    registrationExample.or().andCodeEqualTo(listAll.get(i).getCode());
                }
            }
        }else if(attribute_name.equals("level_name")){
            for(int i = 0;i<listAll.size();i++){
                if(listAll.get(i).getLevelName().contains(attribute)){
                    registrationExample.or().andLevelNameEqualTo(listAll.get(i).getLevelName());
                }
            }
        }else if(attribute_name.equals("is_default")){
              registrationExample.or().andIsDefaultEqualTo(attribute);
        }else if(attribute_name.equals("registration_price")){
              registrationExample.or().andRegistrationPriceEqualTo(new BigDecimal(attribute));
        }else {
            return null;
        }
        return registrationLevelMapper.selectByExample(registrationExample);
    }

    @Override
    public void insertRegistrationLevel(RegistrationLevel registrationLevel) {
        registrationLevelMapper.insertSelective(registrationLevel);
    }

    @Override
    public void updateRegistrationLevel(RegistrationLevel registrationLevel) {
        registrationLevelMapper.updateByPrimaryKey(registrationLevel);
    }
}
