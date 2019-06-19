package neu.his.service;

import neu.his.bean.Disease;

import java.util.List;
/**
 * 处理疾病信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface DiseaseService {

    /**
     * 根据诊断目录名称列举疾病信息
     * @param directory_name 诊断目录名称
     * @return 疾病信息列表
     */
    List<Disease> findByDirectory(String directory_name);

    /**
     * 删除疾病信息
     * @param id 主键id
     */
    void deleteByID(int id);

    /**
     * 根据诊断目录名称，属性名称及内容来查找
     * @param directory_name 诊断目录名称
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     * @return 疾病列表
     */
    List<Disease> findByAttribute_name(String directory_name,String attribute_name, String attribute);

    /**
     * 根据属性名称及内容来查找
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     * @return 疾病列表
     */
    List<Disease> findAllByAttribute_name(String attribute_name, String attribute);

    /**
     * 根据属性名称及内容来查找(包含中，西医标志)
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     * @return 疾病列表
     */
    List<Disease> findWithType(String attribute_name, String attribute);

    /**
     * 插入疾病信息
     * @param disease 新的疾病信息
     */
    void insertDisease(Disease disease);

    /**
     * 更新疾病信息
     * @param disease 内容更新过的疾病信息
     */
    void updateDisease(Disease disease);
}
