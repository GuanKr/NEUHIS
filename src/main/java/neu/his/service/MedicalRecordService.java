package neu.his.service;

import neu.his.bean.Diagnose;
import neu.his.bean.MedicalRecord;

import java.util.List;

/**处理病历信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface MedicalRecordService {
    /**
     * 暂存病历信息
     * @param medicalRecord 暂存信息
     */
    void temporaryStorage(MedicalRecord medicalRecord);

    /**
     * 读取暂存信息
     * @param medical_record_no 病历号
     * @return 已存储的暂存信息
     */
    MedicalRecord readTemporaryStorage(String medical_record_no);

    /**
     * 存为模板
     * @param medicalRecord 模板内容(已有模板名称和模板类别，类别为1,2,3   1-全院   2-科室  3-个人)
     */
    void saveAsTemplate(MedicalRecord medicalRecord);

    /**
     * 引用全院病历模板
     * @return 病历模板
     */
    List<MedicalRecord> referenceTemplateAll();

    /**
     * 引用科室病历模板
     * @param id 医生id
     * @return 病历模板
     */
    List<MedicalRecord> referenceTemplateDep(Integer id);

    /**
     * 引用个人病历模板
     * @param id 医生id
     * @return 病历模板
     */
    List<MedicalRecord> referenceTemplateDoc(Integer id);

    /**
     * 查询该病人历史病历
     * @param idCard 身份证号
     * @return
     */
    List<MedicalRecord> historyMed(String idCard);

    /**
     * 提交病历首页
     * @param medicalRecord  病历首页信息
     * @param diagnoses 诊断信息列表
     * @return ‘请输入XXX’或‘成功’
     */
    String Submission(MedicalRecord medicalRecord, List<Diagnose> diagnoses);

    /**
     * 获得常用诊断
     * @param id 医生id
     * @return 常用诊断列表
     */
    List<Diagnose> findCommonDiagnose(Integer id);

    /**
     * 上传常用诊断
     * @param diagnose
     */
    void CommonDiagnose(Diagnose diagnose);

    /**
     * 删除常用诊断
     * @param id 常用诊断主键id
     */
    void deleteCommonDiagnose(Integer id);
}
