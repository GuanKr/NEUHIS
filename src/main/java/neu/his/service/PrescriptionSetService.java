package neu.his.service;

import neu.his.bean.DrugPrescription;
import neu.his.bean.PrescriptionSet;
import neu.his.bean.PrescriptionSetDetail;

import java.util.List;

/**
 * 处理处方组套信息
 * @author lsy
 * @since 1.8
 * @version 1.0
 */
public interface PrescriptionSetService {
    /**
     * 查找所有处方组套
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<PrescriptionSet> findAllSet(Integer doctorId);

    /**
     * 查找某组套下所有项目
     * @param setId 组套id
     * @return 项目列表
     */
    List<PrescriptionSetDetail> findDetailBySet(Integer setId );

    /**
     * 存为组套
     * @param prescriptionSet 组套信息
     * @param list 项目列表
     */
    void saveAsSet(PrescriptionSet prescriptionSet, List<DrugPrescription> list);

    /**
     * 删除组套
     * @param id 组套id
     * @param doctorId 操作的医生id
     * @return "成功"/"您没有权限"
     */
    String deleteSet(Integer id,Integer doctorId);

    /**
     * 更新组套信息(不包括药品)
     * @param prescriptionSet 组套信息
     * @param doctorId 操作的医生id
     * @return "成功"/"您没有权限"
     */
    String updateSet(PrescriptionSet prescriptionSet,Integer doctorId);

    /**
     * 删除药品信息
     * @param doctorId 操作的医生id
     * @param id 非药品id
     * @return "成功"/"您没有权限"
     */
    String deleteSetDetail(Integer id ,Integer doctorId);

    /**
     * 增加药品信息
     * @param doctorId 操作的医生id
     * @param prescriptionSetDetail 非药品信息
     * @return "成功"/"您没有权限"
     */
    String insertSetDetail(PrescriptionSetDetail prescriptionSetDetail, Integer doctorId);


    /**
     * 查找符合条件的组套
     * @param attribute_name 属性名称
     * @param attribute 属性内容
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<PrescriptionSet> query(String attribute_name, String attribute, Integer doctorId);
}
