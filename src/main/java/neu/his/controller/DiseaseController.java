package neu.his.controller;

import neu.his.bean.DiagnoseDirectory;
import neu.his.bean.Disease;
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
    @RequestMapping("listFindByDirectory")
    public @ResponseBody
    List listFindByDirectory(String directory){
        List<Disease>  diseases = diseaseService.findByDirectory(directory);
        return diseases;
    }

}
