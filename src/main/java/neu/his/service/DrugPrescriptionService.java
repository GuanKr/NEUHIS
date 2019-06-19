package neu.his.service;

import neu.his.bean.DrugUsageDetail;

import java.util.List;

/**
 * 处理处方信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface DrugPrescriptionService {
    /**
     * 找到所有药品用法
     * @return 药品用法列表
     */
    List<DrugUsageDetail> findUsage();
}
