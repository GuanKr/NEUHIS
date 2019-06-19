package neu.his.service;

import neu.his.bean.Drug;
import neu.his.bean.Inspection;

import java.util.List;

/**
 * 处理药品信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface DrugService {
    /**
     * 查找所有药品信息
     * @return
     */
    List<Drug> findAll();

    /**
     * 增加药品
     * @param drug 药品对象
     */
    void addDrug(Drug drug);

    /**
     * 修改药品信息
     * @param drug 药品信息
     */
    void updateDrug(Drug drug);

    /**
     * 删除药品信息
     * @param id 药品id
     */
    void deleteDrug(Integer id);

    /**
     * 查找药品
     * @param drug 封装的查找信息(可查编码，名称，类型，助记码)
     * @return 药品列表
     */
    List<Drug> query(Drug drug);
}
