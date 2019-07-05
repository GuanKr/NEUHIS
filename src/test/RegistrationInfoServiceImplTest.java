import neu.his.bean.RegistrationInfo;
import neu.his.service.RegistrationInfoService;
import neu.his.service.impl.RegistrationInfoServiceImpl;
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
public class RegistrationInfoServiceImplTest {

    @Autowired
    RegistrationInfoServiceImpl registrationInfoService;

    @Test
    public void findAll() {
        List<RegistrationInfo> list = registrationInfoService.findAll();
        for(RegistrationInfo registrationInfo : list){
            System.out.println(registrationInfo);
        }
    }

    @Test
    public void calculateCost() {
        System.out.println(registrationInfoService.calculateCost("急诊","需要"));
    }

    @Test
    public void age() {
        System.out.println(registrationInfoService.age("1998-01-01"));
    }

    @Test
    public void createSerialNumber() {
        System.out.println(registrationInfoService.createSerialNumber());
    }

    @Test
    public void registration() {
        RegistrationInfo registrationInfo = new RegistrationInfo();
        registrationInfo.setAddress("创新路");
        registrationInfo.setDoctorName("钱二");
        registrationInfoService.registration(registrationInfo);
    }

    @Test
    public void queryMissedByDoctorId() {
        List<RegistrationInfo> list = registrationInfoService.queryMissedByDoctorId(2);
        for(RegistrationInfo registrationInfo : list){
            System.out.println(registrationInfo);
        }
    }

    @Test
    public void queryAlreadyByDoctorId() {
        List<RegistrationInfo> list = registrationInfoService.queryAlreadyByDoctorId(2);
        for(RegistrationInfo registrationInfo : list){
            System.out.println(registrationInfo);
        }
    }

    @Test
    public void query2() {
        List<RegistrationInfo> list = registrationInfoService.query2("medical_record_no","2019062000001");
        for(RegistrationInfo registrationInfo : list){
            System.out.println(registrationInfo);
        }
    }

    @Test
    public void query() {
        List<RegistrationInfo> list = registrationInfoService.query("medical_record_no","2019062000001");
        for(RegistrationInfo registrationInfo : list){
            System.out.println(registrationInfo);
        }
    }

    @Test
    public void completeRegistration() {
        List<RegistrationInfo> list = registrationInfoService.query2("medical_record_no","2019062000001");
        registrationInfoService.completeRegistration(list.get(0));
    }
}