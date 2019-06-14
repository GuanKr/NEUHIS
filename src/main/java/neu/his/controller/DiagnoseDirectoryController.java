package neu.his.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import neu.his.bean.DiagnoseDirectory;
import neu.his.service.DiagnoseDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("diagnoseDirectory")
public class DiagnoseDirectoryController {
    @Autowired
    DiagnoseDirectoryService diagnoseDirectoryService;
    /**
     *@Author: dell on 2019/6/14 13:42
     *@param: []
     *@return: java.lang.String
     *@Description: toTiagnoseDirectoryManagement
     */
    @RequestMapping("diagnoseDirectoryManagement")
    public String toTiagnoseDirectoryManagement(){
        return"diagnoseDirectory/diagnoseDirectoryManagement";
    }
    /**
     *@Author: dell on 2019/6/14 13:42
     *@param: [pageNum, pageSize]
     *@return: com.github.pagehelper.PageInfo
     *@Description: listWithPageHelper
     */
    @RequestMapping("listWithPageHelper")
    public @ResponseBody
    PageInfo listWithPageHelper(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<DiagnoseDirectory> diagnoseDirectorieslist = diagnoseDirectoryService.findAll();
        PageInfo pageInfo = new PageInfo(diagnoseDirectorieslist);
        return pageInfo;
        
    }
}
