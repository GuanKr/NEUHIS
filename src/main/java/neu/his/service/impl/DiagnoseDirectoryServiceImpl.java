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
    public List<DiagnoseDirectory> findAll() {
        return diagnoseDirectoryMapper.selectByExample(new DiagnoseDirectoryExample());
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
        return list;

    }
}
