package neu.his.service;

import neu.his.bean.CheckDay;
import neu.his.bean.Invoice;

import java.util.Date;
import java.util.List;

/**
 * 处理日结信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface CheckDayService {
    /**
     * 日结
     * @param tollId 收费员id
     * @param endTime 截止时间
     */
    void checkDay(Integer tollId,Date endTime);
    /**
     * 查询日结
     * @param tollId 收费员id
     * @param startTime 开始时间
     * @param endTime 截止时间
     * @return 日结信息
     */
    List<CheckDay> findCheckDay(Integer tollId, Date startTime,Date endTime);

    /**
     * 查询日结详细信息
     * @param checkDayId 日结id
     * @return 发票列表
     */
    List<Invoice> findDetail(Integer checkDayId);

    /**
     * 核对用：查询日结
     * @param tollName 收费员姓名
     * @return 未核对列表
     */
    List<CheckDay> findCheckDayById(String tollName);

    /**
     * 日结核对
     * @param checkDay 核对完成的日结信息
     */
    void check(CheckDay checkDay);
}
