package neu.his.controller;

import neu.his.bean.Disease;
import neu.his.dto.DiseaseDTO;
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



}
