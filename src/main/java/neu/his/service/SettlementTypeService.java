package neu.his.service;

import neu.his.bean.SettlementType;

import java.util.List;
/**
 * 处理结算类别信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface SettlementTypeService {
    /**
     * 列出所有结算类别
     * @return 结算类别列表
     */
    List<SettlementType> findAll();

    /**
     * 删除结算类别信息
     * @param id 主键id
     */
    void deleteByID(int id);

    /**
     * 根据属性名称及内容来查找
     * @param attribute_name 属性名称
     * @param attribute 查找内容
     * @return 结算类别列表
     */
    List<SettlementType> findByAttribute_name(String attribute_name, String attribute);

    /**
     * 插入结算类别信息
     * @param settlementType 新的结算类别
     */
    void insertSettlementType(SettlementType settlementType);

    /**
     * 更新结算类别信息
     * @param settlementType 内容更新过的结算类别
     */
    void updateSettlementType(SettlementType settlementType);
}
