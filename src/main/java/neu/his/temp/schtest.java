package neu.his.temp;

import neu.his.bean.RegistrationInfo;
import neu.his.bean.ScheduleInfo;
import neu.his.bean.ScheduleRule;
import neu.his.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("schtest")
public class schtest {


    @Autowired
    ScheduleService scheduleService;

    @RequestMapping("list")
    public void m1() {
        List<ScheduleRule> list = scheduleService.findAll();
        for (ScheduleRule scheduleServie : list) {
            System.out.println(scheduleServie);
        }
    }

    @RequestMapping("list1")
    public void m11() {
        List<ScheduleInfo> list = scheduleService.findAllInfo();
        for (ScheduleInfo schedule : list) {
            System.out.println(schedule);
        }
    }

    @RequestMapping("insert")
    public void m2() {
        scheduleService.creatInfo("2019-01-01","2019-01-31");
    }


    @RequestMapping("query")
    public void m3() {
        List<ScheduleInfo> list = scheduleService.query("schedule_date","2019-01-01");
        for (ScheduleInfo schedule : list) {
            System.out.println(schedule);
        }
    }

    @RequestMapping("select")
    public void m4() {
        RegistrationInfo registrationInfo = new RegistrationInfo();
        registrationInfo.setDepartmentName("风湿免疫内科");
        registrationInfo.setRegistrationLevelName("普通门诊");
        registrationInfo.setSeeDoctorDate(new Date());
        List<String> list = scheduleService.selectDoctor(registrationInfo);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
