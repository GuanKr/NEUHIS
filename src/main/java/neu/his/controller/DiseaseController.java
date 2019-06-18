package neu.his.controller;

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
    /**
     *@Author: dell on 2019/6/14 13:39
     *@param: [directory]
     *@return: java.util.List
     *@Description: listFindByDirectory
     */
    @RequestMapping("listFindByDirectory")
    public @ResponseBody
    List listFindByDirectory(String directory){
        List<Disease>  diseases = diseaseService.findByDirectory(directory);
        return diseases;
    }
    /**
     *@Author: dell on 2019/6/14 13:40
     *@param: [diseases]
     *@return: void
     *@Description: updateDiseases
     */
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
    @RequestMapping("findByAttributeWithTwoParameters")
    public @ResponseBody
    List findByAttributeWithTwoParameters(String attribute_name, String attribute){
        List<Disease> diseaseList;
        diseaseList = diseaseService.findAllByAttribute_name(attribute_name,attribute);
        return diseaseList;
    }





}
