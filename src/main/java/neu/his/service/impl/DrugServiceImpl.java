package neu.his.service.impl;

import neu.his.bean.Drug;
import neu.his.bean.DrugExample;
import neu.his.dao.DrugMapper;
import neu.his.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    DrugMapper drugMapper;
    @Override
    public List<Drug> findAll() {
        return drugMapper.selectByExample(new DrugExample());
    }

    @Override
    public void addDrug(Drug drug) {
        drugMapper.insertSelective(drug);
    }

    @Override
    public void updateDrug(Drug drug) {
        drugMapper.updateByPrimaryKeySelective(drug);
    }

    @Override
    public void deleteDrug(Integer id) {
        drugMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Drug> query(Drug drug) {
        DrugExample drugExample = new DrugExample();
        DrugExample.Criteria criteria = drugExample.createCriteria();
        System.out.println(drug);
        if(!(drug.getDrugDosage() == null)){
            if(!drug.getDrugDosage().isEmpty()){
                criteria.andDrugDosageLike("%" + drug.getDrugDosage() + "%");
            }
        }

        if(!(drug.getDrugCode() == null)){
            if(!drug.getDrugCode().isEmpty()){
                criteria.andDrugCodeLike("%" +drug.getDrugCode()+ "%");
            }
        }

        if(!( drug.getDrugName() == null)){
            if(!drug.getDrugName().isEmpty()){
                criteria.andDrugNameLike("%" +drug.getDrugName()+ "%");
            }
        }

        if(!( drug.getMnemonicCode() == null)){
            if(!drug.getMnemonicCode().isEmpty()){
                criteria.andMnemonicCodeLike("%" +drug.getMnemonicCode()+ "%");
            }
        }

        drugExample.or(criteria);
        return drugMapper.selectByExample(drugExample);
    }
}
