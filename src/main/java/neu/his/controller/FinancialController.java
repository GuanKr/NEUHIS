package neu.his.controller;

import neu.his.bean.ExpenseClass;
import neu.his.bean.Workload;
import neu.his.dto.ExpenseClassDTO;
import neu.his.service.ExpenseClassService;
import neu.his.service.WorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("financial")
public class FinancialController {
    @Autowired
    ExpenseClassService expenseClassService;
    @Autowired
    WorkloadService workloadService;

    /**
     *
     * @return
     */
    @RequestMapping("expenseClassManagement")
    public String toExpenseClassManagement(){
        return "financial/expenseClassManagement";
    }
    @RequestMapping("workload")
    public String toWorkload(){
        return "financial/workload";
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

    /**
     * 执行科室工作量统计
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 工作量List
     */
    @RequestMapping("executiveDepartmentWorkload")
    public @ResponseBody
    List executiveDepartmentWorkload(Date startTime,Date endTime){
        List<Workload> workloads = workloadService.executiveDepartmentWorkload(startTime,endTime);
        return workloads;
    }

    /**
     * 开立科室工作量统计
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 工作量List
     */
    @RequestMapping("drawBillDepartmentWorkload")
    public @ResponseBody
    List drawBillDepartmentWorkload(Date startTime,Date endTime){
        List<Workload> workloads = workloadService.drawBillDepartmentWorkload(startTime,endTime);
        return workloads;
    }

    /**
     * 所有医生个人工作量
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 工作量List
     */
    @RequestMapping("allPersonWorkload")
    public @ResponseBody
    List allPersonWorkload(Date startTime,Date endTime){
        List<Workload> workloads = workloadService.allPersonWorkload(startTime,endTime);
        return workloads;
    }

    /**
     * 门诊医生个人工作量
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param doctorId 医生Id
     * @return 工作量List
     */
    @RequestMapping("personalWorkload")
    public @ResponseBody
    List personalWorkload(Date startTime,Date endTime,String doctorId){
        List<Workload> workloads = workloadService.personalWorkload(startTime,endTime,doctorId);
        return workloads;
    }


}
