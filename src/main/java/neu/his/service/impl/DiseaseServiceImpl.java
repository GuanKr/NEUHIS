package neu.his.service.impl;

import neu.his.bean.DiagnoseDirectory;
import neu.his.bean.Disease;
import neu.his.bean.DiseaseExample;
import neu.his.bean.DiseaseQuery;
import neu.his.dao.DiagnoseDirectoryMapper;
import neu.his.dao.DiseaseMapper;
import neu.his.dao.TranslateMapper;
import neu.his.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    DiagnoseDirectoryMapper diagnoseDirectoryMapper;

    @Autowired
    DiseaseMapper diseaseMapper;

    @Autowired
    TranslateMapper translateMapper;

    @Override
    public List<Disease> findByDirectory(String directory_name) {
        List<Disease> list;
        list = diseaseMapper.selectWithName(directory_name);
        return list;
    }

    @Override
    public void deleteByID(int id) {
        diagnoseDirectoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Disease> findByAttribute_name(String directory_name, String attribute_name, String attribute) {
        List<Disease> list;
        list = diseaseMapper.query(new DiseaseQuery(directory_name,attribute_name,attribute));
/*        List<Disease> listAll = findByDirectory(directory_name);
        List<Disease> list;
        DiseaseExample diseaseExample = new DiseaseExample();
        if (attribute_name.equals("disease_name")) {
            for (Disease disease : listAll) {
                String name = disease.getDiseaseName();
                if (name.contains(attribute)) {
                    diseaseExample.or().andDiseaseNameEqualTo(name);
                }
            }
        } else if (attribute_name.equals("international_icd_code")) {
            for (Disease disease : listAll) {
                String code = disease.getDiseaseMnemonicCode();
                if (code.contains(attribute)) {
                    diseaseExample.or().andDiseaseMnemonicCodeEqualTo(code);
                }
            }
        }else
            return null;
        list = diseaseMapper.selectByExample(diseaseExample);*/
        return list;
    }

    @Override
    public void insertDisease(Disease disease) {
        diseaseMapper.insertDisease(disease);
    }

    @Override
    public void updateDisease(Disease disease) {
/*        disease.setDiagnoseDirectoryId(translateMapper.de_translate_diagnose_directory(disease.getDiagnoseDirectoryName()));
        diseaseMapper.updateByPrimaryKey(disease);*/
        diseaseMapper.updateDisease(disease);
    }

}
