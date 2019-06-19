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
        if(!(drug.getDrugDosage().isEmpty() || drug.getDrugDosage() == null)){
            criteria.andDrugDosageLike(drug.getDrugDosage());
        }else if(!(drug.getDrugCode().isEmpty() || drug.getDrugCode() == null)){
            criteria.andDrugCodeLike(drug.getDrugCode());
        }else  if(!(drug.getDrugName().isEmpty() || drug.getDrugName() == null)){
            criteria.andDrugNameLike(drug.getDrugName());
        }else if(!(drug.getMnemonicCode().isEmpty() || drug.getMnemonicCode() == null)){
            criteria.andMnemonicCodeLike(drug.getMnemonicCode());
        }else{
            return null;
        }
        drugExample.or(criteria);
        return drugMapper.selectByExample(drugExample);
    }
}
