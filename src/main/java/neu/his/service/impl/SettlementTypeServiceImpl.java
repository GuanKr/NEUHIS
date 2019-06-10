package neu.his.service.impl;

import neu.his.bean.SettlementType;
import neu.his.bean.SettlementTypeExample;
import neu.his.dao.SettlementTypeMapper;
import neu.his.service.SettlementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SettlementTypeServiceImpl implements SettlementTypeService {
    @Autowired
    SettlementTypeMapper settlementTypeMapper;

    @Override
    public List<SettlementType> findAll() {
        return settlementTypeMapper.selectByExample(new SettlementTypeExample());
    }

    @Override
    public void deleteByID(int id) {
        settlementTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SettlementType> findByAttribute_name(String attribute_name, String attribute) {
        return null;
    }

    @Override
    public void insertSettlementType(SettlementType settlementType) {
        settlementTypeMapper.insertSelective(settlementType);
    }

    @Override
    public void updateSettlementType(SettlementType settlementType) {
        settlementTypeMapper.updateByPrimaryKey(settlementType);
    }
}
