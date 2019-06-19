package neu.his.service.impl;

import neu.his.bean.DrugUsageDetail;
import neu.his.bean.DrugUsageDetailExample;
import neu.his.dao.DrugUsageDetailMapper;
import neu.his.service.DrugPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugPrescriptionServiceImpl implements DrugPrescriptionService {
    @Autowired
    DrugUsageDetailMapper drugUsageDetailMapper;

    @Override
    public List<DrugUsageDetail> findUsage() {
        return drugUsageDetailMapper.selectByExample(new DrugUsageDetailExample());
    }
}
