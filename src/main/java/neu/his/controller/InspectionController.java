package neu.his.controller;

import neu.his.bean.Inspection;
import neu.his.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("inspection")
public class InspectionController {
    @Autowired
    InspectionService inspectionService;
    @RequestMapping("inspectionManagement")
    public String toInspectionManagement(){
        return "inspection/inspectionManagement";
    }
    @RequestMapping("commonItems")
    public String toCommonItems(){
        return "inspection/commonItems";
    }
//  doctorid需要另外通过登录获取
    @RequestMapping("findByAttribute")
    public @ResponseBody
    List<Inspection> findByAttribute(String attribute_name,String attribute,String doctorId){
        return inspectionService.selectByNameOrMedNo(attribute_name,attribute,Integer.parseInt(doctorId));
    }
    @RequestMapping("register")
    public @ResponseBody
    String register(String medicalNoAndId,Integer doctorId){
        String str="";
        String mai[] = medicalNoAndId.split("%2C");
        List<Inspection> inspections = inspectionService.findByMedicalNo(mai[0]);
        for(Inspection inspection : inspections){
            if(inspection.getId().equals(mai[1])){
                str=inspectionService.register(inspection,doctorId);
            }
        }
        return str;
    }
//    @RequestMapping("findByAttribute")
//    public @ResponseBody
//    List<Inspection> findByAttribute(String medical_no){
//        List<Inspection> inspectionList;
//        inspectionList =  inspectionService.findByMedicalNo(medical_no);
//        return inspectionList;
//    }




}
