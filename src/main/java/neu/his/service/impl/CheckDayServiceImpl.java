package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.*;
import neu.his.service.CheckDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CheckDayServiceImpl implements CheckDayService {

    @Autowired
    CheckDayMapper checkDayMapper;

    @Autowired
    CheckDayDetailMapper checkDayDetailMapper;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    SettlementTypeMapper settlementTypeMapper;

    @Autowired
    UserMapper userMapper;

    public String translate(String type) {
        switch (type) {
            case "1":
                return "有效";
            case "0":
                return "红冲";
            case "有效" :
                return "0";
            case "红冲" :
                return "1";
            default:
                return null;
        }
    }

    @Override
    public void checkDay(Integer tollId, Date endTime) {
        CheckDayExample checkDayExample = new CheckDayExample();
        checkDayExample.or().andTollCollectorIdEqualTo(tollId);
        checkDayExample.setOrderByClause("end_time DESC");
        Date startTime = checkDayMapper.selectByExample(checkDayExample).get(0).getEndTime();

        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andInvoiceTimeBetween(startTime,endTime);
        criteria.andTollCollectorIdEqualTo(tollId);
        invoiceExample.or(criteria);
        List<Invoice> list = invoiceMapper.selectByExample(invoiceExample);
        //上传日结信息
        BigDecimal cost = new BigDecimal("0");
        CheckDay checkDay = new CheckDay();
        checkDay.setStartTime(startTime);
        checkDay.setEndTime(endTime);
        checkDay.setCheckDayTime(new Date());
        checkDay.setTollCollectorId(tollId);
        checkDay.setApprove("0");
        for(Invoice invoice : list){
            cost = cost.add(invoice.getCost());
        }
        checkDay.setCost(cost);
        checkDayMapper.insertSelective(checkDay);
        Integer checkId = checkDay.getId();
                //上传日结具体信息
        CheckDayDetail checkDayDetail = new CheckDayDetail();
        for(Invoice invoice : list){
          checkDayDetail.setCheckDayId(checkId);
          checkDayDetail.setInvoiceId(invoice.getId());
          checkDayDetailMapper.insertSelective(checkDayDetail);
        }

    }

    @Override
    public List<CheckDay> findCheckDay(Integer tollId, Date startTime, Date endTime) {
        CheckDayExample checkDayExample = new CheckDayExample();
        CheckDayExample.Criteria criteria = checkDayExample.createCriteria();
        criteria.andTollCollectorIdEqualTo(tollId);
        criteria.andCheckDayTimeBetween(startTime,endTime);
        checkDayExample.or(criteria);
        return checkDayMapper.selectByExample(checkDayExample);
    }

    @Override
    public List<Invoice> findDetail(Integer checkDayId) {
        List<Invoice> list = new ArrayList<>();
        CheckDayDetailExample checkDayDetailExample = new CheckDayDetailExample();
        checkDayDetailExample.or().andCheckDayIdEqualTo(checkDayId);
        List<CheckDayDetail> checkDayDetails = checkDayDetailMapper.selectByExample(checkDayDetailExample);
        for(CheckDayDetail checkDayDetail : checkDayDetails){
            list.add(invoiceMapper.selectByPrimaryKey(checkDayDetail.getInvoiceId()));
        }
        List<SettlementType> settlementTypes = settlementTypeMapper.selectByExample(new SettlementTypeExample());
        for(Invoice invoice: list){
            invoice.setCostType(new InvoiceServiceImpl().translate(invoice.getCostType()));
            invoice.setStatus(translate(invoice.getStatus()));
            for(SettlementType settlementType : settlementTypes){
                if(settlementType.getId() == invoice.getSettlementTypeId()){
                    invoice.setSettlementTypeName(settlementType.getSettlementTypeName());
                }
            }
        }
        return list;
    }

    @Override
    public List<CheckDay> findCheckDayById(String tollName) {
        Integer tollId = null;
        List<User> users = userMapper.selectWithName();
        for(User user : users){
            if(user.getName().equals(tollName)){
                tollId = user.getId();
            }
        }
        CheckDayExample checkDayExample = new CheckDayExample();
        CheckDayExample.Criteria criteria = checkDayExample.createCriteria();
        criteria.andTollCollectorIdEqualTo(tollId);
        criteria.andApproveEqualTo("0");
        checkDayExample.or(criteria);
        List<CheckDay> list = checkDayMapper.selectByExample(checkDayExample);
        return list;
    }

    @Override
    public void check(CheckDay checkDay) {
        checkDay.setApprove("1");
        checkDayMapper.updateByPrimaryKeySelective(checkDay);
    }
}
