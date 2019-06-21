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

    /**
     * 增加费用科目
     * @param expenseclass 费用科目对象
     */
    void addExpenseClass(ExpenseClass expenseclass);

    /**
     * 修改费用科目信息
     * @param expenseclass 费用科目信息
     */
    void updateExpenseClass(ExpenseClass expenseclass);

    /**
     * 删除费用科目信息
     * @param id 费用科目id
     */
    void deleteExpenseClass(Integer id);

    /**
     * 查找费用科目
     * @param expenseclass 封装的查找信息(编码，名称)
     * @return 费用科目列表
     */
    List<ExpenseClass> query(ExpenseClass expenseclass);
}
