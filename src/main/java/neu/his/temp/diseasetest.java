package neu.his.temp;

import neu.his.bean.DiagnoseDirectory;
import neu.his.bean.Disease;
import neu.his.service.DiagnoseDirectoryService;
import neu.his.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("ditest")
public class diseasetest {
    @Autowired
    DiseaseService diseaseService;

    @Autowired
    DiagnoseDirectoryService diagnoseDirectoryService;
    @RequestMapping("list")
    public void m1() {
        List<Disease> list = diseaseService.findByDirectory("阿米巴病");
        for (Disease disease : list) {
            System.out.println(disease);
        }
    }

    @RequestMapping("insert")
    public void m2() {
       Disease disease = new Disease("AAA","HHH","XXX","阿米巴病");
       diseaseService.insertDisease(disease);
    }
    @RequestMapping("query")
    public void m4() {
        List<Disease> list = diseaseService.findByAttribute_name("阿米巴病","disease_name","阿米巴病");
        for(Disease disease : list){
            System.out.println(disease.toString());
        }
    }

    @RequestMapping("query1")
    public void m6() {
        List<DiagnoseDirectory> list = diagnoseDirectoryService.findByAttribute_name("阿");
        for(DiagnoseDirectory disease : list){
            System.out.println(disease.toString());
        }
    }


    @RequestMapping("update")
    public void m3(){
        Disease disease = new Disease(29396,"BBB","HHH","XXX","阿米巴病");
        diseaseService.updateDisease(disease);
    }
}