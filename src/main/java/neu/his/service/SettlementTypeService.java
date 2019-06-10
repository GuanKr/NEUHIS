package neu.his.service;

import neu.his.bean.SettlementType;

import java.util.List;

public interface SettlementTypeService {
    //列出所有
    List<SettlementType> findAll();

    //删除
    void deleteByID(int id);

    //查询  attribute_name为属性名 ， attribute为属性内容
    List<SettlementType> findByAttribute_name(String attribute_name, String attribute);

    //新增
    void insertSettlementType(SettlementType settlementType);

    //修改
    void updateSettlementType(SettlementType settlementType);
}
