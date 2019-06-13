package neu.his.service.impl;

import neu.his.bean.ScheduleRule;
import neu.his.dao.ScheduleRuleMapper;
import neu.his.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRuleMapper scheduleRuleMapper;

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
}
