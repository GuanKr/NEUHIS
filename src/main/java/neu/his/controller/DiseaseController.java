package neu.his.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import neu.his.bean.DiagnoseDirectory;
import neu.his.bean.Disease;
import neu.his.dto.DiseaseDTO;
import neu.his.service.DiagnoseDirectoryService;
import neu.his.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("disease")
public class DiseaseController {
    @Autowired
    DiseaseService diseaseService;
    @Autowired
    DiagnoseDirectoryService diagnoseDirectoryService;

    @RequestMapping("listFindByDirectory")
    public @ResponseBody
    List listFindByDirectory(String directory){
        List<Disease>  diseases = diseaseService.findByDirectory(directory);
        return diseases;
    }

    @RequestMapping("updateDiseases")
    public @ResponseBody
    void updateDiseases(DiseaseDTO diseases){
        List<Disease> diseases1 = diseases.getDiseases();
        for(Disease disease:diseases1){
            diseaseService.updateDisease(disease);
        }
    }

    /**
     *
     * @param idString
     */
    @RequestMapping("deleteDiseaseByID")
    public @ResponseBody
    void deleteDiseaseByID(String idString){
        String[] IDs =idString.split(",");
        for(String id:IDs){
            diseaseService.deleteByID(Integer.parseInt(id));
        }
    }

    /**
     *
     * @param disease
     */
    @RequestMapping("addDisease")
    public @ResponseBody
    void addDisease(Disease disease){
        diseaseService.insertDisease(disease);
    }

    /**
     *
     * @param directory_name
     * @param attribute_name
     * @param attribute
     * @return
     */
    @RequestMapping("findByAttribute")
    public @ResponseBody
    List findByAttribute(String directory_name ,String attribute_name, String attribute){
        List<Disease> diseaseList;
        diseaseList=diseaseService.findByAttribute_name(directory_name,attribute_name,attribute);
        return diseaseList;
    }

    /**
     *
     * @param attribute
     * @return
     */
    @RequestMapping("directoryFindByAttribute")
    public @ResponseBody
    List directoryFindByAttribute(String attribute){
        List<DiagnoseDirectory> diagnoseDirectoryList;
        diagnoseDirectoryList = diagnoseDirectoryService.findByAttribute_name(attribute);
        return diagnoseDirectoryList;
    }
    @RequestMapping("findByAttributeWithTwoParametersWithoutPageHelper")
    public @ResponseBody List findByAttributeWithTwoParametersWithoutPageHelper(String attribute_name, String attribute){
        List<Disease> diseaseList;
        diseaseList = diseaseService.findAllByAttribute_name(attribute_name,attribute);
        return diseaseList;
    }

    @RequestMapping("findByAttributeWithTwoParameters")
    public @ResponseBody List findByAttributeWithTwoParameters(String attribute_name, String attribute){
        PageHelper.startPage(1,30);
        List<Disease> diseaseList = diseaseService.findAllByAttribute_name(attribute_name,attribute);
        PageInfo<Disease> pageInfo = new PageInfo(diseaseList);
        diseaseList = pageInfo.getList();
        return diseaseList;
    }

    @RequestMapping("findWithType")
    public @ResponseBody List<Disease> findWithType(String attribute_name, String attribute){
        return diseaseService.findWithType(attribute_name,attribute);
    }

}
