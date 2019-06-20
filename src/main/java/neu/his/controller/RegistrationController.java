package neu.his.controller;

import neu.his.bean.RegistrationInfo;
import neu.his.bean.User;
import neu.his.service.RegistrationInfoService;
import neu.his.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("registration")
public class RegistrationController {
    @Autowired
    RegistrationInfoService registrationInfoService;
    @Autowired
    ScheduleService scheduleService;

    /**
     *
     * @return
     */
    @RequestMapping("registrationInfo")
    public String toRegistrationInfo(){
        return "registration/registrationInfo";
    }

    /**
     * getMedicalRecordNo 获取病历号
     * @return 病例号/流水号
     */
    @RequestMapping("getMedicalRecordNo")
    public @ResponseBody
    String  getMedicalRecordNo(){
        String serialNumber;
        serialNumber=registrationInfoService.createSerialNumber();
        return serialNumber;
    }

    @RequestMapping("getDoctorList")
    public @ResponseBody
    List getDoctorList(RegistrationInfo registrationInfo) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date seeDoctorDate = dateFormat.parse(registrationInfo.getSeeDoctorDateString());
        registrationInfo.setSeeDoctorDate(seeDoctorDate);
        List<String> doctorName = null;
        List<User> doctorList = new ArrayList<User>();
        doctorName= scheduleService.selectDoctor(registrationInfo);
        for(String name :doctorName){
            User user = new User(name,"","","","","","");
            doctorList.add(user);
        }
        return  doctorList;
    }

    /**
     * 挂号
     * @param registrationInfo
     */
    @RequestMapping("addRegistrationInfo")
    public @ResponseBody
    void addRegistrationInfo(RegistrationInfo registrationInfo ) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date seeDoctorDate = dateFormat.parse(registrationInfo.getSeeDoctorDateString());
        registrationInfo.setSeeDoctorDate(seeDoctorDate);
        registrationInfoService.registration(registrationInfo);
    }

    /**
     *
     * @param registrationInfo
     * @return
     */
    @RequestMapping("getExpense")
    public @ResponseBody
    double getExpense(RegistrationInfo registrationInfo){
        String level_name = registrationInfo.getRegistrationLevelName();
        String isNeed = registrationInfo.getIsNeedMedicalrecordbook();
        double expense = registrationInfoService.calculateCost(level_name,isNeed);
        return expense;
    }

    /**
     * registrationInfoList
     * @return
     */
    @RequestMapping("registrationInfoList")
    public @ResponseBody
    List registrationInfoList(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<RegistrationInfo> registrationInfoList = registrationInfoService.findAll();
        for (RegistrationInfo reg : registrationInfoList) {
            if (reg.getSeeDoctorDate() != null)
                reg.setSeeDoctorDateString(dateFormat.format(reg.getSeeDoctorDate()));
            if (reg.getPatientBirthday() != null)
                reg.setPatientBirthdayString(dateFormat.format(reg.getPatientBirthday()));
        }
        return registrationInfoList;
    }

    /**
     * 返回退号成功或失败原因
     * @param id
     * @return 退号成功或失败原因
     */
    @RequestMapping("withdraw")
    public @ResponseBody
    String withdraw(int id){
//        TODO
        String state = "u未找到该病历";
        List<RegistrationInfo> registrationInfoList = registrationInfoService.findAll();
        for(RegistrationInfo registrationInfo :registrationInfoList){
            if(registrationInfo.getId()==id) {
                if (registrationInfo.getIsSeenDoctor().equals("0") || registrationInfo.getIsSeenDoctor().equals("未看诊")) {
                    state = "退号成功";
                } else if (registrationInfo.getIsSeenDoctor().equals("1") || registrationInfo.getIsSeenDoctor().equals("已看诊")) {
                    state = "退号失败：已看诊";
                }
            }
        }
        return state;
    }

    /**
     * 查找待诊病人
     * @param id
     * @return 病历列表
     */
    @RequestMapping("getWaitingDiagnosePatientsByID")
    public @ResponseBody
    List getWaitingDiagnosePatientsByID(int id){
        List<RegistrationInfo> registrationInfoList;
        registrationInfoList = registrationInfoService.queryMissedByDoctorId(id);
        return registrationInfoList;
    }

    /**
     * 查找已诊病人
     * @param id
     * @return 病历列表
     */
    @RequestMapping("getDiagnosedPatientsByID")
    public @ResponseBody
    List getDiagnosedPatientsByID(int id){
        List<RegistrationInfo> registrationInfoList;
        registrationInfoList = registrationInfoService.queryAlreadyByDoctorId(id);
        return registrationInfoList;
    }

    /**
     * 计算年龄
     * @param birthdayString 年龄字符串
     * @return 年龄
     */
    @RequestMapping("getPatientAge")
    public @ResponseBody int getPatientAge(String birthdayString){
        return registrationInfoService.age(birthdayString);
    }

}
