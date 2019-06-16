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
    /**
     *@Author: dell on 2019/6/14 16:44
     *@param: []
     *@return: java.lang.String
     *@Description: toManagement
     */
    DepartmentService departmentService;
    @RequestMapping("management")
    public String toManagement(){
        return "department/management";
    }
    /**
     *@Author: dell on 2019/6/14 16:44
     *@param: []
     *@return: java.util.List
     *@Description: departmentList
     */
    @RequestMapping("list")
    public @ResponseBody
    List departmentList() {
        List<Department> departmentlist = departmentService.findAll();
        return departmentlist;
    }
    /**
     *@Author: dell on 2019/6/14 16:45
     *@param: [departments]
     *@return: void
     *@Description: updatedepartments
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
     *@Author: dell on 2019/6/14 16:45
     *@param: [pageNum, pageSize]
     *@return: com.github.pagehelper.PageInfo
     *@Description: listDepartmentWithPageHelper
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
     *@Author: dell on 2019/6/14 16:46
     *@param: [attribute_name, attribute, pageNum, pageSize]
     *@return: com.github.pagehelper.PageInfo
     *@Description: find DepartmentByAttributeWithPageHelper
     */

    @RequestMapping("findByAttributeWithPageHelper")
    public @ResponseBody
    PageInfo findByAttributeWithPageHelper(String attribute_name, String attribute,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Department> departmentlist = departmentService.findByAttribute_name(attribute_name,attribute);
        PageInfo pageInfo = new PageInfo(departmentlist);
//        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
//        PageInfo.setList(departmentService.)
        return pageInfo;
    }
//    @RequestMapping("findByAttribute")
//    public @ResponseBody
//    List


    /**
     *@Author: dell on 2019/6/14 16:46
     *@param: []
     *@return: java.util.List<java.lang.String>
     *@Description: departmentCategory
     */
    @RequestMapping("departmentCategory")
    public @ResponseBody
    List<String> departmentCategory(){
        List<String> categorylist = departmentService.findCategory();
        return categorylist;
    }
    /**
     *@Author: dell on 2019/6/14 18:38
     *@param: [department]
     *@return: void
     *@Description: insertDepartment
     */
    @RequestMapping("insertDepartment")
    public @ResponseBody
    void insertDepartment(Department department){
        departmentService.insertDepartment(department);
    }

    /**
     *
     * finddepartmentListByAttribute
     * @param attribute_name
     * @param attribute
     * @return List
     */
    @RequestMapping("findByAttribute")
    public @ResponseBody List findByAttribute(String attribute_name, String attribute){
        List departmentList = departmentService.findByAttribute_name(attribute_name,attribute);
        return departmentList;
    }
}
