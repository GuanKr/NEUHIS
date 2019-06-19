package neu.his.service;

import neu.his.bean.NonDrugList;

import java.util.List;
/**处理非药品目录信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface NonDrugListService {
    /**
     * 类型代码转换为类型名称
     * @param type 类型代码
     * @return 类型名称
     */
    String translate(String type);

    /**
     * 类型名称转换为类型代码
     * @param type_name 类型名称
     * @return 类型代码
     */
    String de_translate(String type_name);

    /**
     * 列出所有非药品项目
     * @return 非药品项目列表
     */
    List<NonDrugList> findAll();

    /**
     * 删除非药品项目信息
     * @param id 主键id
     */
    void deleteByID(int id);

    /**
     * 根据属性名称及内容来查找
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     * @return 非药品项目列表
     */
    List<NonDrugList> findByAttribute_name(String attribute_name, String attribute);

    /**
     * 插入非药品项目信息
     * @param nonDrugList 新的非药品项目
     */
    void insertNonDrugList(NonDrugList nonDrugList);

    /**
     * 更新非药品项目信息
     * @param nonDrugList 内容更新过的非药品项目
     */
    void updateNonDrugList(NonDrugList nonDrugList);

    /**
     * 根据类别属性名称及内容来查找
     * @param type 检查/检验/处置
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     * @return 非药品项目列表
     */
    List<NonDrugList> findByType(String type,String attribute_name, String attribute);
}
