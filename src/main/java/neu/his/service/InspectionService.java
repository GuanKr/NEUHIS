package neu.his.service;

import neu.his.bean.Inspection;
import neu.his.bean.InspectionRegister;
import neu.his.bean.MedicalRecord;

import java.util.Date;
import java.util.List;

/**处理检查/检验/处置信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface InspectionService {

    /**
     * 查找检查/检验/处置信息
     * @param medicalNo 病历号
     * @return 检查/检验/处置列表
     */
    List<Inspection> findByMedicalNo(String medicalNo);

    /**
     * 开立检查/检验/处置项目
     * @param inspection 检查/检验
     */
    void addInspection(Inspection inspection);

    /**
     * 暂存检查/检验/处置项目
     * @param inspection 检查/检验 需医生id，病历号
     */
    void temporaryStorage(Inspection inspection);

    /**
     * 查找暂存信息
     * @param inspection 查找的信息封装 需病历号和医生id
     * @return 暂存信息列表
     */
    List<Inspection> findTemStorage(Inspection inspection);

    /**
     * 编辑暂存信息
     * @param inspection 暂存信息
     */
    void updateTemStorage(Inspection inspection);

    /**
     * 删除暂存信息
     * @param id 暂存信息id
     */
    void deleteTemStorage(Integer id);

    /**
     * 作废已开立检查/检验/处置项目
     * @param inspection 作废的检查/检验/处置
     * @return "已开立，无法作废"/"作废成功"
     */
    String deleteInspection(Inspection inspection);

    /**
     * 查找检查/检验结果
     * @param id 检查/检验id
     * @return 检查检验结果
     */
    String findResult(Integer id);

    /**
     * 设为常用诊断
     * @param inspection 诊断
     */
    void common(Inspection inspection);

    /**
     * 获得常用诊断
     * @param id 医生id
     * @return 常用诊断列表
     */
    List<Inspection> findCommon(Integer id);

    /**
     * 删除常用诊断
     * @param id 常用诊断id
     */
    void deleteCommon(Integer id);

    /**
     * 修改常用诊断
     * @param inspection 常用诊断
     */
    void updateCommon(Inspection inspection);

    /**
     * 检查/检验登记
     * @param inspection 检查/检验
     * @param doctorId 检查/检验登记的医生id
     * @return "成功"/"未缴费！"
     */
    String register(Inspection inspection,Integer doctorId);

    /**
     * 登记时通过病历号或姓名查看检查/检验信息列表
     * @param attribute_name medical_record_no或patient_name
     * @param attribute 内容
     * @param doctorId 操作的医生id
     * @return 检查/检验列表
     */
    List<Inspection> selectByNameOrMedNo(String attribute_name,String attribute,Integer doctorId);

    /**
     * 检查/检验结果录入
     * @param id 检查/检验id
     * @param result 结果
     */
    void inputResult(Integer id,String result);


    /**
     * 个人工作量统计
     * @param doctorId 操作的医生id
     * @param startTime 起始时间
     * @param endTime 截止时间
     * @return 检查/检验列表
     */
    List<InspectionRegister> workloadStatistics(Date startTime, Date endTime, Integer doctorId);

}
