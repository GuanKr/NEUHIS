package neu.his.service.impl;

import neu.his.bean.RegistrationInfo;
import neu.his.bean.RegistrationLevel;
import neu.his.bean.RegistrationLevelExample;
import neu.his.converter.DateConverter;
import neu.his.dao.RegistrationInfoMapper;
import neu.his.dao.RegistrationLevelMapper;
import neu.his.service.RegistrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RegistrationInfoServiceImpl implements RegistrationInfoService {

    @Autowired
    RegistrationInfoMapper registrationInfoMapper;

    @Autowired
    RegistrationLevelMapper registrationLevelMapper;

    @Override
    public String translateResource(String type) {
        switch (type) {
            case "1":
                return "医院挂号";
            case "2":
                return "预约挂号";
            case "医院挂号":
                return "1";
            case "预约挂号":
                return "2";
            default:
                return null;
        }
    }

    @Override
    public String translateMedicalrecordbook(String type) {
        switch (type) {
            case "1":
                return "需要";
            case "0":
                return "不需要";
            case "需要":
                return "1";
            case "不需要":
                return "0";
            default:
                return null;
        }
    }

    @Override
    public String translateIsSeen(String type) {
        switch (type) {
            case "1":
                return "已看诊";
            case "0":
                return "未看诊";
            case "已看诊":
                return "1";
            case "未看诊":
                return "0";
            default:
                return null;
        }
    }

    @Override
    public String translatePaymentState(String type) {
        switch (type) {
            case "1":
                return "已缴费";
            case "0":
                return "未缴费";
            case "已缴费":
                return "1";
            case "未缴费":
                return "0";
            default:
                return null;
        }
    }

    @Override
    public String translateRegistrationState(String type) {
        switch (type) {
            case "1":
                return "正常";
            case "0":
                return "退号";
            case "正常":
                return "1";
            case "退号":
                return "0";
            default:
                return null;
        }
    }

    @Override
    public String translateIsCompleted(String type) {
        switch (type) {
            case "1":
                return "已诊毕";
            case "0":
                return "未诊毕";
            case "已诊毕":
                return "1";
            case "未诊毕":
                return "0";
            default:
                return null;
        }
    }

    @Override
    public String translateSex(String type) {
        switch (type) {
            case "1":
                return "男";
            case "2":
                return "女";
            case "男":
                return "1";
            case "女":
                return "2";
            default:
                return null;
        }
    }

    public RegistrationInfo translate(RegistrationInfo registrationInfo){
        registrationInfo.setIsCompleted(translateIsCompleted(registrationInfo.getIsCompleted()));
        registrationInfo.setIsNeedMedicalrecordbook(translateMedicalrecordbook(registrationInfo.getIsNeedMedicalrecordbook()));
        registrationInfo.setIsSeenDoctor(translateIsSeen(registrationInfo.getIsSeenDoctor()));
        registrationInfo.setPaymentState(translatePaymentState(registrationInfo.getPaymentState()));
        registrationInfo.setRegistrationResource(translateResource(registrationInfo.getRegistrationResource()));
        registrationInfo.setRegistrationState(translateRegistrationState(registrationInfo.getRegistrationState()));
        registrationInfo.setPatientSex(translateSex(registrationInfo.getPatientSex()));
        return registrationInfo;
    }

    @Override
    public List<RegistrationInfo> findAll() {
        List<RegistrationInfo> list = registrationInfoMapper.selectWithName();
        for(RegistrationInfo registrationInfo : list){
            registrationInfo = translate(registrationInfo);
        }
        return list;
    }

    @Override
    public Double calculateCost(String level_name,String s) {
        BigDecimal rePrice = new BigDecimal(0);
        RegistrationLevelExample registrationLevelExample = new RegistrationLevelExample();
        registrationLevelExample.or().andLevelNameEqualTo(level_name);
        List<RegistrationLevel> registrationLevels = registrationLevelMapper.selectByExample(registrationLevelExample);
        for(RegistrationLevel registrationLevel : registrationLevels){
            rePrice = registrationLevel.getRegistrationPrice();
        }
        if(s.equals("需要")){
            rePrice = rePrice.add(new BigDecimal(1));
        }
        return rePrice.doubleValue();
    }

    @Override
    public int age(String birthday) {
        return Integer.parseInt(new DateConverter().nowYear()) - Integer.parseInt(birthday.substring(0,4));
    }

    @Override
    public String createSerialNumber() {
        String lastSerNumber = registrationInfoMapper.serNumber();
        String serNumber;
        String behindSerNumber = lastSerNumber.substring(8,13);
        String frontSerNumber = new DateConverter().serNumber();
        if(lastSerNumber.substring(0,8).equals(frontSerNumber)) {
            int number = Integer.parseInt(behindSerNumber);
            number++;
            behindSerNumber = String.format("%05d",number);
            serNumber = frontSerNumber + behindSerNumber;
        }else {
            serNumber = frontSerNumber + "00001";
        }
        return serNumber;
    }

    @Override
    public void registration(RegistrationInfo registrationInfo) {
        registrationInfo.setIsSeenDoctor("未看诊");
        registrationInfo.setPaymentState("未缴费");
        registrationInfo.setRegistrationState("正常");
        registrationInfo.setIsCompleted("未诊毕");
        registrationInfo = translate(registrationInfo);
        registrationInfoMapper.insertRegInfo(registrationInfo);
    }

}
