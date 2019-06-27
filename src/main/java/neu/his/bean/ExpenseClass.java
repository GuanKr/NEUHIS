package neu.his.bean;
/**
 * 存储费用科目
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class ExpenseClass {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 费用科目编码
     */
    private String expenseCode;
    /**
     * 费用科目名称
     */
    private String expenseName;

    /**
     * 构造方法
     * @param id 主键id
     * @param expenseCode 费用科目编码
     * @param expenseName 费用科目名称
     */
    public ExpenseClass(Integer id, String expenseCode, String expenseName) {
        this.id = id;
        this.expenseCode = expenseCode;
        this.expenseName = expenseName;
    }

    public ExpenseClass() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(String expenseCode) {
        this.expenseCode = expenseCode == null ? null : expenseCode.trim();
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName == null ? null : expenseName.trim();
    }
}