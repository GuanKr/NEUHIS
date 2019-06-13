package neu.his.service.impl;

import neu.his.bean.DiagnoseDirectory;
import neu.his.bean.DiagnoseDirectoryExample;
import neu.his.dao.DiagnoseDirectoryMapper;
import neu.his.service.DiagnoseDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;

@Service
public class DiagnoseDirectoryServiceImpl implements DiagnoseDirectoryService {
    @Autowired
    DiagnoseDirectoryMapper diagnoseDirectoryMapper;

    @Override
    public String translate(String type) {
        if (type.equals("1")) {
            return "西医";
        }else if(type.equals("2")){
            return "中医";
        }else{
            return null;
        }
    }

    @Override
    public String de_translate(String type_name) {
        if (type_name.equals("西医")) {
            return "1";
        }else if(type_name.equals("中医")){
            return "2";
        }else{
            return null;
        }
    }

    @Override
    public List<DiagnoseDirectory> findAll() {
        List<DiagnoseDirectory> list;
        list = diagnoseDirectoryMapper.selectByExample(new DiagnoseDirectoryExample());
        for(DiagnoseDirectory diagnoseDirectory : list){
            diagnoseDirectory.setDeseaseTypeName(translate(diagnoseDirectory.getDiseaseType()));
        }
        return list;
    }

    @Override
    public List<DiagnoseDirectory> findByAttribute_name(String attribute) {
        List<DiagnoseDirectory> list;
        List<DiagnoseDirectory> listAll;

        DiagnoseDirectoryExample diagnoseDirectoryExample = new DiagnoseDirectoryExample();

        listAll = diagnoseDirectoryMapper.selectByExample(new DiagnoseDirectoryExample());

        for(DiagnoseDirectory diagnoseDirectory : listAll){
            String name = diagnoseDirectory.getDiseaseCategoryName();
            if(name.contains(attribute)){
                diagnoseDirectoryExample.or().andDiseaseCategoryNameEqualTo(name);
            }
        }

        list = diagnoseDirectoryMapper.selectByExample(diagnoseDirectoryExample);

        for(DiagnoseDirectory diagnoseDirectory : list){
            diagnoseDirectory.setDeseaseTypeName(translate(diagnoseDirectory.getDiseaseType()));
        }
        return list;

    }
}
