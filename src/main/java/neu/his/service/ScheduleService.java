package neu.his.service;

import neu.his.bean.ScheduleInfo;
import neu.his.bean.ScheduleRule;

import java.util.Date;
import java.util.List;

/**
 * 处理排版信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface ScheduleService {
    /**
     * 0，1与无效有效转化
     * @param type 代码
     * @return 名称
     */
    String translate(String type);



    /**
     * 列出所有排版规则
     * @return 排版规则列表
     */
    List<ScheduleRule> findAll();

    /**
     * 删除排版规则信息
     * @param id 主键id
     */
    void deleteByID(int id);

    /**
     * 插入排版规则信息
     * @param scheduleRule 新的排版规则
     */
    void insertScheduleRule(ScheduleRule scheduleRule);

    /**
     * 更新排版规则信息
     * @param scheduleRule 内容更新过的排版规则
     */
    void updateScheduleRule(ScheduleRule scheduleRule);

    /**
     * 查询所有排班信息
     * @return 所有排班信息列表
     */
    List<ScheduleInfo> findAllInfo();

    /**
     * 生成排班计划
     */
    void creatInfo(String start, String end);

    /**
     * 删除排班信息
     * @param id 主键
     */
    void deleteInfo(int id);

    /**
     * 修改排班信息
     * @param scheduleInfo
     */
    void updateInfo(ScheduleInfo scheduleInfo);
}
