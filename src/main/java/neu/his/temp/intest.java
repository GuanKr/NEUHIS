package neu.his.temp;

import neu.his.bean.Inspection;
import neu.his.bean.InspectionRegister;
import neu.his.bean.InspectionSet;
import neu.his.bean.InspectionSetDetail;
import neu.his.converter.DateConverter;
import neu.his.service.InspectionService;
import neu.his.service.InspectionSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("intest")
public class intest {

    @Autowired
    InspectionService inspectionService;

    @Autowired
    InspectionSetService inspectionSetService;


    @RequestMapping("list")
    public void m1() {
        List<Inspection> list = inspectionService.findByMedicalNo("001");
        for (Inspection nonDrugList : list) {
            System.out.println(nonDrugList);
        }
    }

    @RequestMapping("query")
    public void m2(){
        List<InspectionSet> list = inspectionSetService.query("category","个人",2);
        for(InspectionSet inspectionSet : list){
            System.out.println(inspectionSet.toString());
        }
         list = inspectionSetService.query("doctor_id","一",2);
        for(InspectionSet inspectionSet : list){
            System.out.println(inspectionSet.toString());
        }
    }

    @RequestMapping("findset")
    public void m3(){
        List<InspectionSet> list = inspectionSetService.findAllSet(2);
        for(InspectionSet inspectionSet : list){
            System.out.println(inspectionSet.toString());
        }
        list = inspectionSetService.findAllInsSet(2);
        for(InspectionSet inspectionSet : list){
            System.out.println(inspectionSet.toString());
        }
        list = inspectionSetService.findAllCheckSet(2);
        for(InspectionSet inspectionSet : list){
            System.out.println(inspectionSet.toString());
        }
        list = inspectionSetService.findAllHandleSet(2);
        for(InspectionSet inspectionSet : list){
            System.out.println(inspectionSet.toString());
        }
    }

    @RequestMapping("save")
    public void m4(){
        InspectionSet inspectionSet = new InspectionSet();
        inspectionSet.setDoctorId(2);
        inspectionSet.setCombinatorialName("hhh");
        inspectionSet.setCategory("个人");
        List<String> list = new ArrayList<>();
        list.add("大抢救");
        list.add("小抢救");
        inspectionSetService.saveAsSet(inspectionSet,list);
    }

    @RequestMapping("findn")
    public void m5(){
        List<Inspection> list = inspectionService.selectByNameOrMedNo("medical_record_no","2019062000001",1);
        for(Inspection inspection : list){
            System.out.println(inspection.toString());
        }
    }

    @RequestMapping("res")
    public void m6(){
       inspectionService.inputResult(1,"好！");
    }

    @RequestMapping("re")
    public void m8(){
        Inspection inspection = inspectionService.selectByNameOrMedNo("medical_record_no","2019062000001",1).get(0);
        System.out.println(inspectionService.register(inspection,2));
    }

    @RequestMapping("work")
    public void m7(){
        List<InspectionRegister> list = inspectionService.workloadStatistics(new DateConverter().convert("2019-06-19"),new DateConverter().convert("2019-06-23"),2);
        for(InspectionRegister inspection : list){
            System.out.println(inspection.toString());
        }
    }

}
