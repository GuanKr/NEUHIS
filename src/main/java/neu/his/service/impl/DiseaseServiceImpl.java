package neu.his.service.impl;

import neu.his.bean.*;
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
    DiseaseMapper diseaseMapper;

    @Override
    public List<Disease> findByDirectory(String directory_name) {
        List<Disease> list;
        list = diseaseMapper.selectWithName(directory_name);
        return list;
    }

    @Override
    public void deleteByID(int id) {
        diseaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Disease> findByAttribute_name(String directory_name, String attribute_name, String attribute) {
        List<Disease> list;
        list = diseaseMapper.query(new DiseaseQuery(directory_name,attribute_name,attribute));
        return list;
    }

    @Override
    public List<Disease> findAllByAttribute_name(String attribute_name, String attribute) {
        List<Disease> list;
        list = diseaseMapper.queryAll(new Query(attribute_name,attribute));
        return list;
    }

    @Override
    public void insertDisease(Disease disease) {
        diseaseMapper.insertDisease(disease);
    }

    @Override
    public void updateDisease(Disease disease) {
        diseaseMapper.updateDisease(disease);
    }

}
