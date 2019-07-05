import neu.his.bean.DrugPrescription;
import neu.his.bean.PrescriptionSet;
import neu.his.service.DrugPrescriptionService;
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
public class DrugPrescriptionServiceImplTest {

    @Autowired
    DrugPrescriptionService drugPrescriptionService;
    @Test
    public void translate() {
    }

    @Test
    public void findUsage() {
    }

    @Test
    public void temporaryStorage() {
    }

    @Test
    public void findTemStorage() {
    }

    @Test
    public void updateTemStorage() {
    }

    @Test
    public void deleteTemStorage() {
    }

    @Test
    public void sendPrescription() {
    }

    @Test
    public void deletePrescription() {
    }

    @Test
    public void findCommon() {
    }

    @Test
    public void insertCommon() {
    }

    @Test
    public void deleteCommon() {
    }

    @Test
    public void costAll() {
    }

    @Test
    public void findByMedNo() {
        System.out.println(drugPrescriptionService.findByMedNo("2019062000001","2"));
    }

    @Test
    public void findDispense() {
        System.out.println(drugPrescriptionService.findDispense("2019062000001"));
    }

    @Test
    public void dispense() {
    }

    @Test
    public void drugReturn() {
        List<DrugPrescription> list = drugPrescriptionService.findByMedNo("2019062000001","2");
        DrugPrescription drugPrescription = list.get(0);
        drugPrescriptionService.drugReturn(drugPrescription,2);
    }

    @Test
    public void returnAll() {

    }

    @Test
    public void findPrescription() {
    }
}