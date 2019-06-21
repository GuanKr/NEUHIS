package neu.his.service;

import neu.his.bean.Drug;
import neu.his.bean.DrugCommon;
import neu.his.bean.DrugPrescription;
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
    /**
     * 暂存处方
     * @param drugPrescription 处方
     */
    void temporaryStorage(DrugPrescription drugPrescription);

    /**
     * 查找暂存信息
     * @param drugPrescription 查找的信息封装 需病历号和医生id
     * @return 暂存信息列表
     */
    List<DrugPrescription> findTemStorage(DrugPrescription drugPrescription);

    /**
     * 编辑暂存信息
     * @param drugPrescription 暂存信息
     */
    void updateTemStorage(DrugPrescription drugPrescription);

    /**
     * 删除暂存信息
     * @param id 暂存信息id
     */
    void deleteTemStorage(Integer id);

    /**
     * 发送处方
     * @param drugPrescription 处方
     */
    void sendPrescription(DrugPrescription drugPrescription);

    /**
     * 作废处方
     * @param id 处方id
     */
    void deletePrescription(Integer id);

    /**
     * 查找所有常用药
     * @param doctorId 医生id
     * @return 常用药列表
     */
    List<DrugCommon> findCommon(Integer doctorId);

    /**
     * 添加常用药
     * @param drug 药品信息
     */
    void insertCommon(Drug drug,Integer doctorId);

    /**
     * 删除常用药
     * @param id 常用药品id
     */
    void deleteCommon(Integer id);

    /**
     * 计算总金额
     * @param list 处方列表
     * @return 总额
     */
    Double costAll(List<DrugPrescription> list);
}
