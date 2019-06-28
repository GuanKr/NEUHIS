package neu.his.temp;

import neu.his.bean.Workload;
import neu.his.converter.DateConverter;
import neu.his.service.WorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("wtest")
public class wtest {
    @Autowired
    WorkloadService workloadService;

    @RequestMapping("p")
    public void m1() {
        DateConverter dateConverter = new DateConverter();
        List<Workload> list = workloadService.allPersonWorkload(dateConverter.convert("2019-01-01"),dateConverter.convert("2019-12-12"));
        for(Workload workload : list){
            System.out.println(workload.toString());
        }
    }
}
