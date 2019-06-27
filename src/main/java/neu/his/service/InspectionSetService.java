package neu.his.service;

import neu.his.bean.Inspection;
import neu.his.bean.InspectionSet;
import neu.his.bean.InspectionSetDetail;


import java.util.List;

/**
 * 处理检查/检验/处置组套
 * @author lsy
 * @since 1.8
 * @version 1.0
 */
public interface InspectionSetService {

    /**
     * 查找所有检查/检验/处置组套
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> findAllSet(Integer doctorId);

    /**
     * 查找所有检查组套
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> findAllInsSet(Integer doctorId);

    /**
     * 查找所有检验组套
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> findAllCheckSet(Integer doctorId);

    /**
     * 查找所有处置组套
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> findAllHandleSet(Integer doctorId);

    /**
     * 查找某组套下所有项目
     * @param setId 组套id
     * @return 项目列表
     */
    List<InspectionSetDetail> findDetailBySet(Integer setId );

    /**
     * 存为组套
     * @param inspectionSet 组套信息
     * @param list 项目列表
     */
    void saveAsSet(InspectionSet inspectionSet, List<String> list);

    /**
     * 删除组套
     * @param id 组套id
     * @param doctorId 操作的医生id
     * @return "成功"/"您没有权限"
     */
    String deleteSet(Integer id,Integer doctorId);

    /**
     * 更新组套信息(不包括项目)
     * @param inspectionSet 组套信息
     * @param doctorId 操作的医生id
     * @return "成功"/"您没有权限"
     */
    String updateSet(InspectionSet inspectionSet,Integer doctorId);

    /**
     * 删除项目信息
     * @param doctorId 操作的医生id
     * @param id 非药品项目id
     * @return "成功"/"您没有权限"
     */
    String deleteSetDetail(Integer id ,Integer doctorId);

    /**
     * 增加项目信息
     * @param doctorId 操作的医生id
     * @param inspectionSetDetail 非药品项目信息
     * @return "成功"/"您没有权限"
     */
    String insertSetDetail(InspectionSetDetail inspectionSetDetail,Integer doctorId);


    /**
     * 查找符合条件的组套
     * @param attribute_name 属性名称
     * @param attribute 属性内容
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> query(String attribute_name,String attribute,Integer doctorId);
}
