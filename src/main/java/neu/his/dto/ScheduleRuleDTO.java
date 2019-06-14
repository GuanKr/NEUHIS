package neu.his.dto;

import neu.his.bean.ScheduleRule;

import java.util.List;

public class ScheduleRuleDTO {
    private List<ScheduleRule> scheduleRules;

    public List<ScheduleRule> getScheduleRules() {
        return scheduleRules;
    }

    public void setScheduleRules(List<ScheduleRule> scheduleRules) {
        this.scheduleRules = scheduleRules;
    }
}
