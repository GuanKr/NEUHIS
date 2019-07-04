package neu.his.service;


import neu.his.bean.Workload;

import java.util.Date;
import java.util.List;

/**
 * 工作量统计
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface WorkloadService {
    /**
     * 统计门诊医生个人工作量
     * @param startTime 开始时间
     * @param endTime 截止时间
     * @param doctorName 医生id
     * @return 工作量统计信息
     */
    List<Workload> personalWorkload(Date startTime, Date endTime, String doctorName);

    /**
     * 统计执行科室工作量
     * @param startTime 开始时间
     * @param endTime 截止时间
     * @return 工作量统计信息
     */
    List<Workload> executiveDepartmentWorkload(Date startTime, Date endTime);

    /**
     * 统计开立科室工作量
     * @param startTime 开始时间
     * @param endTime 截止时间
     * @return 工作量统计信息
     */
    List<Workload> drawBillDepartmentWorkload(Date startTime, Date endTime);

    /**
     * 统计所有医生个人工作量
     * @param startTime 开始时间
     * @param endTime 截止时间
     * @return 工作量统计信息
     */
    List<Workload> allPersonWorkload(Date startTime, Date endTime);

}
