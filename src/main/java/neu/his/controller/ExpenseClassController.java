package neu.his.controller;
/**
 * 费用类型
 */

import neu.his.bean.ExpenseClass;
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

}
