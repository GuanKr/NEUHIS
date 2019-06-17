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

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("nonDrugList")
public class NonDrugListController {
    @Autowired
    NonDrugListService nonDrugListService;

    /**
     *
     * @return
     */
    @RequestMapping("nonDrugListManagement")
    public String toNonDrugListManagement(){
        return "nonDrugList/nonDrugListManagement";
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("listWithPageHelper")
    public @ResponseBody
    PageInfo listWithPageInfo(int pageNum,int pageSize){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PageHelper.startPage(pageNum,pageSize);
        List<NonDrugList>  nonDrugLists = nonDrugListService.findAll();
        for(NonDrugList nonDrugList:nonDrugLists){
            nonDrugList.setCreationdateString(simpleDateFormat.format(nonDrugList.getCreationTime()));
        }
        PageInfo pageInfo = new PageInfo(nonDrugLists);
        return pageInfo;
    }

    /**
     *
     * @param nonDrugList
     */
    @RequestMapping("addNonDrugList")
    public  @ResponseBody
    void addNonDrugList(NonDrugList nonDrugList){
        nonDrugListService.insertNonDrugList(nonDrugList);
    }

    /**
     *
     * @param idString
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
     *
     * @param nonDrugLists
     */
    @RequestMapping("updateNonDrugLists")
    public @ResponseBody
    void updateNonDrugLists(NonDrugListDTO nonDrugLists){
        List<NonDrugList> nonDrugLists1 =nonDrugLists.getNonDrugLists();
        for(NonDrugList nonDrugList:nonDrugLists1){
            nonDrugListService.updateNonDrugList(nonDrugList);
        }
    }

    /**
     *
     * @param attribute_name
     * @param attribute
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findbyattributeWithPageHelper")
    public  @ResponseBody PageInfo findByAttributeWithPageHelper(String attribute_name,String attribute,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<NonDrugList> nonDrugList = nonDrugListService.findByAttribute_name(attribute_name,attribute);
        PageInfo pageInfo = new PageInfo(nonDrugList);
        return pageInfo;
    }



}
