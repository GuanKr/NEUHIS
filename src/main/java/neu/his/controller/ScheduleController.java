package neu.his.controller;
/**
 * 排班规则及信息管理
 */

import neu.his.bean.ScheduleInfo;
import neu.his.bean.ScheduleRule;
import neu.his.dto.ScheduleRuleDTO;
import neu.his.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    /**
     *@Author: dell on 2019/6/14 15:33
     *@param: []
     *@return: java.lang.String
     *@Description: toScheduleManagement
     */
    @RequestMapping("scheduleManagement")
    public String toScheduleManagement(){
        return "schedule/scheduleManagement";
    }
    /**
     *@Author: dell on 2019/6/14 15:37
     *@param: []
     *@return: java.util.List
     *@Description: scheduleRulesList
     */
    @RequestMapping("scheduleRulesList")
    public @ResponseBody
    List scheduleRulesList(){
        List<ScheduleRule> scheduleRuleList = scheduleService.findAll();
        return scheduleRuleList;
    }


    /**
     * scheduleInfosList
     * @return: List
     */
    @RequestMapping("scheduleInfosList")
    public @ResponseBody List scheduleInfosList(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<ScheduleInfo> scheduleInfoList = scheduleService.findAllInfo();
        for (ScheduleInfo scheduleInfo : scheduleInfoList) {
            scheduleInfo.setScheduleDateString(simpleDateFormat.format(scheduleInfo.getScheduleDate()));
        }
        return scheduleInfoList;
    }


    /**
     *@Author: dell on 2019/6/14 15:47
     *@param: [idString]
     *@return: void
     *@Description: deleteScheduleRulesByID
     */
    @RequestMapping("deleteScheduleRulesByID")
    public @ResponseBody
    void deleteScheduleRuleByID(String idString){
        String[] IDs =idString.split(",");
        for(String id:IDs){
            scheduleService.deleteByID(Integer.parseInt(id));
        }
    }
    /**
     *@Author: dell on 2019/6/14 15:53
     *@param: [scheduleRules]
     *@return: void
     *@Description: updateScheduleRules
     */
    @RequestMapping("updateScheduleRules")
    public @ResponseBody
    void updateScheduleRules(ScheduleRuleDTO scheduleRules){
        List<ScheduleRule> scheduleRules1 =scheduleRules.getScheduleRules();
        for(ScheduleRule scheduleRule: scheduleRules1){
            scheduleService.updateScheduleRule(scheduleRule);
        }
    }
}
