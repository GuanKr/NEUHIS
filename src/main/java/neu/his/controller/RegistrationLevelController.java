package neu.his.controller;
import neu.his.bean.RegistrationLevel;
import neu.his.dto.RegistrationLevelDTO;
import neu.his.service.RegistrationLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("registrationLevel")
public class RegistrationLevelController {
    @Autowired
    RegistrationLevelService registrationLevelService;
    @RequestMapping("registrationLevelManagement")
    public String toRegistrationLevelManagement(){
        return "registrationLevel/registrationLevelManagement";
    }

    @RequestMapping("list")
    public @ResponseBody
    List registrationLevelList() {
        List<RegistrationLevel> registrationlevellist = registrationLevelService.findAll();
        return registrationlevellist;
    }
    @RequestMapping("addRegistrationLevel")
    public @ResponseBody
    void addRegistrtionLevel(RegistrationLevel registrationLevel){
        registrationLevelService.insertRegistrationLevel(registrationLevel);

    }
    @RequestMapping("updateRegistrationLevels")
    public @ResponseBody
    void updateRegistrationLevels(RegistrationLevelDTO registrationlevels){
        List<RegistrationLevel>  registrationLevels1=registrationlevels.getRegistrationLevels();
        for(RegistrationLevel registrationLevel:registrationLevels1){
            registrationLevelService.updateRegistrationLevel(registrationLevel);
        }
    }
    @RequestMapping("deleteRegistrationLevelsByID")
    public @ResponseBody
    void deleteRegistrationLevelsByID(int[] ids){
        for(int id:ids){
            registrationLevelService.deleteByID(id);
        }
    }

}


