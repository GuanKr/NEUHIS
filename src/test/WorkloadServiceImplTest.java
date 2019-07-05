import neu.his.bean.Workload;
import neu.his.converter.DateConverter;
import neu.his.service.impl.WorkloadServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resources")
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class WorkloadServiceImplTest {

    @Autowired
    WorkloadServiceImpl workloadService;
    @Test
    public void personalWorkload() {
        DateConverter dateConverter = new DateConverter();
        List<Workload> list = workloadService.personalWorkload(dateConverter.convert("2019-01-01"),dateConverter.convert("2019-12-12"),"钱二");
        for(Workload workload : list){
            System.out.println(workload.toString());
        }

    }

    @Test
    public void executiveDepartmentWorkload() {
        DateConverter dateConverter = new DateConverter();
        List<Workload> list = workloadService.executiveDepartmentWorkload(dateConverter.convert("2019-01-01"),dateConverter.convert("2019-12-12"));
        for(Workload workload : list){
            System.out.println(workload.toString());
        }
    }

    @Test
    public void drawBillDepartmentWorkload() {
        DateConverter dateConverter = new DateConverter();
        List<Workload> list = workloadService.drawBillDepartmentWorkload(dateConverter.convert("2019-01-01"),dateConverter.convert("2019-12-12"));
        for(Workload workload : list){
            System.out.println(workload.toString());
        }
    }

    @Test
    public void allPersonWorkload() {
        DateConverter dateConverter = new DateConverter();
        List<Workload> list = workloadService.allPersonWorkload(dateConverter.convert("2019-01-01"),dateConverter.convert("2019-12-12"));
        for(Workload workload : list){
            System.out.println(workload.toString());
        }
    }
}