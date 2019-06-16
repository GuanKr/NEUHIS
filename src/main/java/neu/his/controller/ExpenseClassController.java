package neu.his.controller;
/**
 * 费用类型
 */

import neu.his.service.ExpenseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("expenseClass")
public class ExpenseClassController {
    @Autowired
    ExpenseClassService expenseClassService;


}
