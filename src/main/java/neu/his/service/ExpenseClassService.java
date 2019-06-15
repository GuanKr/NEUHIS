package neu.his.service;

import neu.his.bean.ExpenseClass;

import java.util.List;

/**处理费用科目
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface ExpenseClassService {
    /**
     * 获得所有费用科目
     * @return 费用科目列表
     */
    List<ExpenseClass> findAll();
}
