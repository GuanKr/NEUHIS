package neu.his.controller;

import neu.his.bean.ExpenseClass;
import neu.his.dto.ExpenseClassDTO;
import neu.his.service.ExpenseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("financial")
public class FinancialController {
    @Autowired
    ExpenseClassService expenseClassService;

    /**
     *
     * @return
     */
    @RequestMapping("expenseClassManagement")
    public String toExpenseClassManagement(){
        return "financial/expenseClassManagement";
    }

    /**
     * 找到全部费用科目
     * @return 全部的费用科目列表
     */
    @RequestMapping("listAll")
    public @ResponseBody
    List listAll(){
        List<ExpenseClass> expenseClassList;
        expenseClassList=expenseClassService.findAll();
        return expenseClassList;
    }

    /**
     * 删除费用科目
     * @param idString 删除的id字符串用","分割
     */
    @RequestMapping("deleteById")
    public @ResponseBody
    void deleteById(String idString){
        String ids[] = idString.split(",");
        for(String id:ids){
            expenseClassService.deleteExpenseClass(Integer.parseInt(id));
        }
    }

    /**
     * 保存费用科目
     * @param expenseClasses 保存的费用科目List
     */
    @RequestMapping("update")
    public @ResponseBody
    void update(ExpenseClassDTO expenseClasses){
        List<ExpenseClass> expenseClasses1=expenseClasses.getExpenseClasses();
        for(ExpenseClass expenseClass:expenseClasses1){
            expenseClassService.updateExpenseClass(expenseClass);
        }
    }

    /**
     *
     * @param expenseClass 费用科目
     */
    @RequestMapping("addExpenseClass")
    public @ResponseBody
    void addSettlementType(ExpenseClass expenseClass){
        expenseClassService.addExpenseClass(expenseClass);
    }


}
