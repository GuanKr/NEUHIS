package neu.his.temp;

import neu.his.bean.NonDrugList;
import neu.his.service.NonDrugListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("notest")
public class notest {

    @Autowired
    NonDrugListService nonDrugListService;

    @RequestMapping("list")
    public void m1() {
        List<NonDrugList> list = nonDrugListService.findAll();
        for (NonDrugList nonDrugList : list) {
            System.out.println(nonDrugList);
        }
    }

    @RequestMapping("insert")
    public void m2() {
        NonDrugList nonDrugList = new NonDrugList();
        nonDrugList.setItemTypeName("检查");
        nonDrugList.setExecutivedepartmentName("心血管内科");
        nonDrugList.setExpenseClassName("挂号费");
        nonDrugListService.insertNonDrugList(nonDrugList);
    }

    @RequestMapping("query")
    public void m4() {
            List<NonDrugList> list = nonDrugListService.findByAttribute_name("department_name","检验");
            for(NonDrugList nonDrugList : list){
                System.out.println(nonDrugList.toString());
            }
    }


    @RequestMapping("update")
    public void m3() {
        NonDrugList nonDrugList = new NonDrugList();
        nonDrugList.setId(57);
        nonDrugList.setItemTypeName("检查");
        nonDrugList.setExecutivedepartmentName("神经内科");
        nonDrugList.setExpenseClassName("挂号费");;
        nonDrugListService.insertNonDrugList(nonDrugList);
    }
}
