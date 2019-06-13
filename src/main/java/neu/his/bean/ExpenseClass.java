package neu.his.bean;

public class ExpenseClass {
    private Integer id;

    private String expenseCode;

    private String expenseName;

    /**
     *@Author:
     *@param: [id, expenseCode, expenseName]
     *主键id，费用科目编码，费用科目名称
     *@return:
     *@Description: 构造方法1
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