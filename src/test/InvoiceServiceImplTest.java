import neu.his.bean.Invoice;
import neu.his.bean.InvoiceExample;
import neu.his.bean.Item;
import neu.his.converter.DateConverter;
import neu.his.service.InvoiceService;
import neu.his.service.impl.InvoiceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resources")
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class InvoiceServiceImplTest {

    @Autowired
    InvoiceServiceImpl invoiceServiceImpl;

    @Test
    public void translate() {
    }

    @Test
    public void createSerialNumber() {
        System.out.println(invoiceServiceImpl.createSerialNumber());
    }

    @Test
    public void findUnpaidItem() {
        List<Item> list = invoiceServiceImpl.findUnpaidItem("2019062000001");
        for (Item item: list) {
            System.out.println(item);
        }
    }

    @Test
    public void calCost() {
        List<Item> list = invoiceServiceImpl.findUnpaidItem("2019062000001");
        System.out.println(invoiceServiceImpl.calCost(list));
    }

    @Test
    public void charge() {
        List<Item> list = invoiceServiceImpl.findUnpaidItem("2019062000001");
        invoiceServiceImpl.charge(list,"医保",4,"abc","2019062000001");
    }

    @Test
    public void returnReg() {
        System.out.println(invoiceServiceImpl.returnReg("2019062000001"));
    }

    @Test
    public void findByMedNo() {
        List<Invoice> list =  invoiceServiceImpl.findByMedNo("2019062000001");
        for (Invoice invoice: list) {
            System.out.println(invoice);
        }

    }

    @Test
    public void returnCost() {
        List<Invoice> list =  invoiceServiceImpl.findByMedNo("2019062000001");
        invoiceServiceImpl.returnCost(list.get(2));
    }

    @Test
    public void query() {
        List<Invoice> list =  invoiceServiceImpl.query("2019062000001",new DateConverter().convert("2019-01-01"),new DateConverter().convert("2019-12-01"));
        for (Invoice invoice: list) {
            System.out.println(invoice);
        }
    }
}