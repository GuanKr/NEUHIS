package neu.his.dto;

import neu.his.bean.ExpenseClass;

import java.util.List;

public class ExpenseClassDTO {
    private List<ExpenseClass> expenseClasses;

    public List<ExpenseClass> getExpenseClasses() {
        return expenseClasses;
    }

    public void setExpenseClasses(List<ExpenseClass> expenseClasses) {
        this.expenseClasses = expenseClasses;
    }
}
