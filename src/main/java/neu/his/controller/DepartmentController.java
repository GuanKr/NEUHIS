package neu.his.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import neu.his.bean.Department;
import neu.his.dto.DepartmentDTO;
import neu.his.service.DepartmentService;
//import neu.his.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("management")
    public String toManagement(){
        return "department/management";
    }

    /**
     * 返回所有科室列表
     * @return 科室列表
     */
    @RequestMapping("list")
    public @ResponseBody
    List departmentList() {
        List<Department> departmentlist = departmentService.findAll();
        return departmentlist;
    }

    /**
     * 更新科室信息
     * @param departments 需要更新的科室信息
     */
    @RequestMapping("updatedepartments")
    public @ResponseBody
    void updatedepartments(DepartmentDTO departments){
        List<Department> departments1=departments.getDepartments();
        for(Department department:departments1){
            departmentService.updateDepartment(department);
        }
    }

    /**
     * 带分页的科室信息
     * @param pageNum 页数
     * @param pageSize 每页数据条数
     * @return 分页的科室信息
     */
    @RequestMapping("listWithPageHelper")
    public @ResponseBody
    PageInfo listWithPageHelper(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Department> departmentlist = departmentService.findAll();
        PageInfo pageInfo = new PageInfo(departmentlist);
        return pageInfo;
    }

    /**
     * 通过属性查找带分页的科室信息
     * @param attribute_name 属性
     * @param attribute 属性值
     * @param pageNum 页数
     * @param pageSize 每页数据条数
     * @return 分页的查询结果
     */
    @RequestMapping("findByAttributeWithPageHelper")
    public @ResponseBody
    PageInfo findByAttributeWithPageHelper(String attribute_name, String attribute,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Department> departmentlist = departmentService.findByAttribute_name(attribute_name,attribute);
        PageInfo pageInfo = new PageInfo(departmentlist);
        return pageInfo;
    }


    /**
     * 获取科室分类列表
     * @return 科室分类列表
     */
    @RequestMapping("departmentCategory")
    public @ResponseBody
    List<String> departmentCategory(){
        List<String> categorylist = departmentService.findCategory();
        return categorylist;
    }

    /**
     * 添加科室
     * @param department 要添加的科室
     */
    @RequestMapping("insertDepartment")
    public @ResponseBody
    void insertDepartment(Department department){
        departmentService.insertDepartment(department);
    }

    /**
     * 查找所有科室
     * @param attribute_name 属性
     * @param attribute 属性值
     * @return 查找的结果
     */
    @RequestMapping("findByAttribute")
    public @ResponseBody List findByAttribute(String attribute_name, String attribute){
        List departmentList = departmentService.findByAttribute_name(attribute_name,attribute);
        return departmentList;
    }
}
