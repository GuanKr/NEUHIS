package neu.his.temp;

import neu.his.bean.CheckDay;
import neu.his.bean.CheckDayDetail;
import neu.his.bean.Drug;
import neu.his.bean.Invoice;
import neu.his.converter.DateConverter;
import neu.his.service.CheckDayService;
import neu.his.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("chtest")
public class chtest {
    @Autowired
    CheckDayService checkDayService;

    @Autowired
    DrugService drugService;


    @RequestMapping("q1")
    public void we1(){
        Drug drug = new Drug();
        drug.setMnemonicCode("Z");
        List<Drug> list = drugService.query(drug);
        for(Drug drug1 : list){
            System.out.println(drug1);
        }
    }
    @RequestMapping("check")
    public void m1(){
        /*checkDayService.checkDay(4,new Date());*/
        List<Invoice> invoices = checkDayService.findDetail(6);
        for(Invoice invoice :invoices){
            System.out.println(invoice);
        }
        List<CheckDay> checkDays = checkDayService.findCheckDay(4,new DateConverter().convert("2019-01-01"),new DateConverter().convert("2019-12-12"));
        for(CheckDay checkDay :checkDays){
            System.out.println(checkDay);
        }

        List<CheckDay> checkDays1 = checkDayService.findCheckDayById("李四");
        for(CheckDay checkDay :checkDays1){
            System.out.println(checkDay);
        }

        CheckDay checkDay = new CheckDay();
        checkDay.setId(1);
        checkDayService.check(checkDay);

    }
}
