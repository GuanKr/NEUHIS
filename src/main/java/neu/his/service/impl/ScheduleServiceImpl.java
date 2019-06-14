package neu.his.service.impl;

import neu.his.bean.Query;
import neu.his.bean.ScheduleInfo;
import neu.his.bean.ScheduleRule;
import neu.his.converter.DateConverter;
import neu.his.dao.ScheduleInfoMapper;
import neu.his.dao.ScheduleRuleMapper;
import neu.his.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRuleMapper scheduleRuleMapper;

    @Autowired
    ScheduleInfoMapper scheduleInfoMapper;

    @Override
    public String translate(String type) {
        switch (type) {
            case "1":
                return "有效";
            case "0":
                return "无效";
            case "有效":
                return "1";
            case "无效":
                return "0";
            default:
                return null;
        }
    }

    @Override
    public List<ScheduleRule> findAll() {
        List<ScheduleRule> list = scheduleRuleMapper.selectWithName();
        for(ScheduleRule scheduleRule : list){
            scheduleRule.setStatusName(translate(scheduleRule.getStatus()));
        }
        return list;
    }

    @Override
    public void deleteByID(int id) {
        scheduleRuleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertScheduleRule(ScheduleRule scheduleRule) {
        scheduleRule.setStatus(translate(scheduleRule.getStatusName()));
        scheduleRuleMapper.insertScheduleRule(scheduleRule);
    }

    @Override
    public void updateScheduleRule(ScheduleRule scheduleRule) {
        scheduleRule.setStatus(translate(scheduleRule.getStatusName()));
        scheduleRuleMapper.updateByPrimaryKey(scheduleRule);
    }

    @Override
    public List<ScheduleInfo> findAllInfo() {
        List<ScheduleInfo> list = scheduleInfoMapper.selectWithName();
        for(ScheduleInfo scheduleInfo : list){
            scheduleInfo.setStatusName(translate(scheduleInfo.getStatus()));
        }
        return list;
    }

    @Override
    public void creatInfo(String start,String end) {
       List<ScheduleRule> scheduleRules = scheduleRuleMapper.selectWithName();
       List<ScheduleInfo> scheduleInfos = scheduleInfoMapper.selectWithName();
       ScheduleInfo scheduleInfo = new ScheduleInfo();

        DateConverter dateConverter = new DateConverter();
        Date startDate = dateConverter.convert(start);
        Date endDate = dateConverter.convert(end);

        for(Date date = startDate ; date.before(endDate);date = dateConverter.tomorrow(date)){
            for(ScheduleInfo scheduleInfo1 : scheduleInfos){
                if(scheduleInfo1.getScheduleDate().equals(date)){
                    deleteInfo(scheduleInfo1.getId());
                }
            }
        }


        for(Date date = startDate ; date.before(endDate);date = dateConverter.tomorrow(date)){
            for(ScheduleRule scheduleRule: scheduleRules){
                if(scheduleRule.getWeek().equals(dateConverter.getWeek(date))&&scheduleRule.getStatus().equals("1")){
                    scheduleInfo.setStatus(scheduleRule.getStatus());
                    scheduleInfo.setUserName(scheduleRule.getUserName());
                    scheduleInfo.setScheduleDate(date);
                    scheduleInfo.setBisessionalOperation(scheduleRule.getBisessionalOperation());
                    scheduleInfo.setScheduleQuota(scheduleRule.getSchedulQuota());
                    scheduleInfo.setSurplusQuota(scheduleRule.getSchedulQuota());
                    scheduleInfoMapper.insertScheduleInfo(scheduleInfo);
                }
            }
        }
    }

    @Override
    public void deleteInfo(int id) {
        scheduleInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateInfo(ScheduleInfo scheduleInfo) {
        scheduleInfo.setStatus(translate(scheduleInfo.getStatusName()));
        scheduleInfoMapper.updateByPrimaryKey(scheduleInfo);
    }

    @Override
    public List<ScheduleInfo> query(String attribute_name, String attribute) {
        List<ScheduleInfo> list = scheduleInfoMapper.query(new Query(attribute_name,attribute));
        for(ScheduleInfo scheduleInfo : list){
            scheduleInfo.setStatusName(translate(scheduleInfo.getStatus()));
        }
        return list;
    }
}
