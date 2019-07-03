package neu.his.controller;
/**
 * 费用类型
 */

import neu.his.bean.ExpenseClass;
import neu.his.dto.ExpenseClassDTO;
import neu.his.service.ExpenseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("expenseClass")
public class ExpenseClassController {
    @Autowired
    ExpenseClassService expenseClassService;
    @RequestMapping("list")
    public @ResponseBody
    List expenseClassList(){
        return expenseClassService.findAll();
    }

    /**
     * 增加费用科目
     * @param expenseClass 费用科目
     */
    @RequestMapping("addExpenseClass")
    public @ResponseBody
    void addExpenseClass(ExpenseClass expenseClass){
        expenseClassService.addExpenseClass(expenseClass);
    }

    /**
     *
     * @param idString 待删除的id字符串，用","分割
     */
    @RequestMapping("deleteById")
    public @ResponseBody
    void deleteById(String idString){
        String[] ids = idString.split(",");
        for(String id:ids){
            expenseClassService.deleteExpenseClass(Integer.parseInt(id));
        }
    }

    /**
     *
     * @param expenseClasses 费用科目列表
     */
    @RequestMapping("update")
    public @ResponseBody
    void update(ExpenseClassDTO expenseClasses){
            List<ExpenseClass> expenseClassList=expenseClasses.getExpenseClasses();
            for(ExpenseClass expenseClass: expenseClassList) {
                expenseClassService.updateExpenseClass(expenseClass);
            }
    }

}
