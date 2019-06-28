package neu.his.temp;

import neu.his.bean.Item;
import neu.his.bean.RegistrationInfo;
import neu.his.service.InvoiceService;
import neu.his.service.RegistrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("invtest")
public class invtest {
    @Autowired
    InvoiceService invoiceService;

    @Autowired
    RegistrationInfoService registrationInfoService;
    @RequestMapping("f")
    public void m1() {
        List<Item> list = invoiceService.findUnpaidItem("2019062000001");
        for (Item item: list) {
            System.out.println(item);
        }
        /*System.out.println(invoiceService.calCost(list));
        invoiceService.charge(list,"医保",4,"abc","2019062000001");*/
    }
    }
