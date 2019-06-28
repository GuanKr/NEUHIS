package neu.his.temp;

import neu.his.bean.Disease;
import neu.his.bean.RegistrationInfo;
import neu.his.service.DiseaseService;
import neu.his.service.RegistrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("retest")
public class retest {
    @Autowired
    RegistrationInfoService registrationInfoService;

    @RequestMapping("list")
    public void m1() {
        List<RegistrationInfo> list = registrationInfoService.findAll();
        for (RegistrationInfo registrationInfo : list) {
            System.out.println(registrationInfo);
        }
    }

    @RequestMapping("cal")
    public void m2() {
        System.out.println(registrationInfoService.calculateCost("普通门诊","需要"));
    }

    @RequestMapping("cre")
    public void m3() {
        System.out.println(registrationInfoService.createSerialNumber());
    }

    @RequestMapping("miss")
    public void m5() {
        List<RegistrationInfo> list = registrationInfoService.queryMissedByDoctorId(2);
        for (RegistrationInfo registrationInfo : list) {
            System.out.println(registrationInfo);
        }
    }

    @RequestMapping("are")
    public void m6() {
        List<RegistrationInfo> list = registrationInfoService.queryAlreadyByDoctorId(2);
        for (RegistrationInfo registrationInfo : list) {
            System.out.println(registrationInfo);
        }
    }

    @RequestMapping("re")
    public void m7() {
        RegistrationInfo registrationInfo = new RegistrationInfo();
        registrationInfo.setDoctorName("钱二");
        registrationInfo.setSeeDoctorDate(new Date());
        registrationInfo.setRegistrationResource("医院挂号");
        registrationInfo.setPatientSex("男");
        registrationInfo.setIsNeedMedicalrecordbook("需要");
        registrationInfoService.registration(registrationInfo);
    }
    @RequestMapping("comp")
    public void m8() {
        RegistrationInfo registrationInfo = new RegistrationInfo();
        registrationInfo.setId(1);
        registrationInfoService.completeRegistration(registrationInfo);
    }



}
