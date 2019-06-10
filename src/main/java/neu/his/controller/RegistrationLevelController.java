package neu.his.controller;
import neu.his.bean.RegistrationLevel;
import neu.his.service.RegistrationLevelService
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
    @RequestMapping("list")
    public @ResponseBody
    List registrationLevelList() {
        List<RegistrationLevel> registrationlevellist = registrationLevelService.findAll();
        return registrationlevellist;
    }
}


