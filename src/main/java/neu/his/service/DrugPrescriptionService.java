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
     * @return 结果
     */
    String deletePrescription(Integer id);

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

    /**
     * 通过病历号查找及状态查找药品列表(查找患者在挂号表中)
     * @param medicalNo 病历号
     * @param state 状态(已发\未发\已退)
     * @return 处方列表
     */
    List<DrugPrescription> findByMedNo(String medicalNo,String state);

    /**
     * 通过病历号查找可发药的列表
     * @param medicalNo 病历号
     * @return 处方列表
     */
    List<DrugPrescription> findDispense(String medicalNo);

    /**
     * 发药
     * @param drugPrescription 发药的处方
     */
    void dispense(DrugPrescription drugPrescription);


    /**
     * 退药
     * @param drugPrescription 退药的处方信息
     * @param returnQuantity 退药数量
     * @return "成功"/"退药数量超过可退数量！"
     */
     String drugReturn(DrugPrescription drugPrescription,Integer returnQuantity);

    /**
     * 全退
     * @param list 退药处方列表
     * @return 所有列表可退最大数量
     */
     List<Integer> returnAll(List<DrugPrescription> list);


    /**
     * 通过病历号查找未作废所有处方列表
     * @param medicalNo 病历号
     * @return 处方列表
     */
    List<DrugPrescription> findPrescription(String medicalNo);

}
