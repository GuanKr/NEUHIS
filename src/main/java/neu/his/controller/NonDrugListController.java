package neu.his.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import neu.his.bean.NonDrugList;
import neu.his.dto.NonDrugListDTO;
import neu.his.service.NonDrugListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("nonDrugList")
public class NonDrugListController {
    @Autowired
    NonDrugListService nonDrugListService;
    /**
     *@Author: dell on 2019/6/14 13:52
     *@param: []
     *@return: java.lang.String
     *@Description: toNonDrugListManagement
     */
    @RequestMapping("nonDrugListManagement")
    public String toNonDrugListManagement(){
        return "nonDrugList/nonDrugListManagement";
    }
    /**
     *@Author: dell on 2019/6/14 13:58
     *@param: [pageNum, pageSize]
     *@return: com.github.pagehelper.PageInfo
     *@Description:  listWithPageHelper
     */
    @RequestMapping("listWithPageHelper")
    public @ResponseBody
    PageInfo listWithPageInfo(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageNum);
        List<NonDrugList>  nonDrugLists = nonDrugListService.findAll();
        PageInfo pageInfo = new PageInfo(nonDrugLists);
        return pageInfo;
    }
    /**
     *@Author: dell on 2019/6/14 14:00
     *@param: [nonDrugList]
     *@return: void
     *@Description: addNonDrugList
     */
    @RequestMapping("addNonDrugList")
    public  @ResponseBody
    void addNonDrugList(NonDrugList nonDrugList){
        nonDrugListService.insertNonDrugList(nonDrugList);
    }
    /**
     *@Author: dell on 2019/6/14 14:08
     *@param: [idString]
     *@return: void
     *@Description: deleteNonDrugListsByID
     */
    @RequestMapping("deleteNonDrugListsByID")
    public @ResponseBody
    void deleteNonDrugListsByID(String idString){
        String[] IDs =idString.split(",");
        for (String id : IDs) {
            nonDrugListService.deleteByID(Integer.parseInt(id));
        }
    }
    /**
     *@Author: dell on 2019/6/14 14:13
     *@param: [nonDrugLists]
     *@return: void
     *@Description: updateNonDrugLists
     */
    @RequestMapping("updateNonDrugLists")
    public @ResponseBody
    void updateNonDrugLists(NonDrugListDTO nonDrugLists){
        List<NonDrugList> nonDrugLists1 =nonDrugLists.getNonDrugLists();
        for(NonDrugList nonDrugList:nonDrugLists1){
            nonDrugListService.updateNonDrugList(nonDrugList);
        }
    }



}
