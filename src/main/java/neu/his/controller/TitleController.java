package neu.his.controller;

import neu.his.bean.Title;
import neu.his.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("title")
public class TitleController {
    @Autowired
    TitleService titleService;
    @RequestMapping("list")
    public @ResponseBody
    List titleList() {
        List<Title> titlelist = titleService.findAll();
        return titlelist;
    }
}
