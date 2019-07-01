package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.converter.DateConverter;
import neu.his.dao.*;
import neu.his.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    InspectionMapper inspectionMapper;

    @Autowired
    RegistrationInfoMapper registrationInfoMapper;

    @Autowired
    DrugPrescriptionMapper drugPrescriptionMapper;

    @Autowired
    NonDrugListMapper nonDrugListMapper;

    @Autowired
    DrugMapper drugMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    SettlementTypeMapper settlementTypeMapper;

    @Autowired
    UserMapper userMapper;

    public String translate(String type) {
        if (type.equals("1")) {
            return "挂号";
        }else if(type.equals("2")){
            return "检查";
        }else if(type.equals("3")){
            return "检验";
        }else if(type.equals("4")){
            return "处方";
        }else if(type.equals("5")){
            return "处置";
        }else if (type.equals("挂号")) {
            return "1";
        }else if (type.equals("检查")) {
            return "2";
        }else if (type.equals("检验")) {
            return "3";
        }else if(type.equals("处方")){
            return "4";
        }else if(type.equals("处置")){
            return "5";
        }else
            return  null;
    }

    public String createSerialNumber() {
        String lastSerNumber =invoiceMapper.serNumber();
        String frontSerNumber = new DateConverter().serNumber();
        String serNumber;
        if(lastSerNumber == null || lastSerNumber.isEmpty()){
            return frontSerNumber + "00001";
        }
        String behindSerNumber = lastSerNumber.substring(8,13);
        if(lastSerNumber.substring(0,8).equals(frontSerNumber)) {
            int number = Integer.parseInt(behindSerNumber);
            number++;
            behindSerNumber = String.format("%05d",number);
            serNumber = frontSerNumber + behindSerNumber;
        }else {
            serNumber = frontSerNumber + "00001";
        }
        return serNumber;
    }
    @Override
    public List<Item> findUnpaidItem(String medicalNo) {
        List<User> users = userMapper.selectWithName();
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        //查找未缴费挂号信息
        RegistrationInfoExample registrationInfoExample = new RegistrationInfoExample();
        registrationInfoExample.or().andMedicalRecordNoEqualTo(medicalNo);
        List<RegistrationInfo> registrationInfos = registrationInfoMapper.selectByExample(registrationInfoExample);
        if(!registrationInfos.isEmpty()){
            RegistrationInfo registrationInfo = registrationInfos.get(0);
            if(registrationInfo.getPaymentState().equals("0")&&registrationInfo.getRegistrationState().equals("1")){
                for(User user : users){
                    if(user.getId() == registrationInfo.getDoctorId()){
                        item.setDoctorName(user.getName());
                        item.setDepartmentName(user.getDepartmentname());
                        item.setDrawBillDepartmentName(user.getDepartmentname());
                    }
                }
                item.setUnitPrice(registrationInfo.getExpense());
                item.setItemName("挂号费");
                item.setQuantity(1);
                item.setCost(registrationInfo.getExpense());
                item.setCategory("挂号");
                item.setCategoryId(registrationInfo.getId());
                items.add(item);
            }
        }
        item = new Item();
        //查找未缴费检查/检验/处置信息
        InspectionExample inspectionExample = new InspectionExample();
        InspectionExample.Criteria criteria = inspectionExample.createCriteria();
        criteria.andValidityEqualTo("1");
        criteria.andMedicalRecordNoEqualTo(medicalNo);
        criteria.andIsCommonEqualTo("0");
        criteria.andPayStateEqualTo("0");
        inspectionExample.or(criteria);
        List<Inspection> inspections = inspectionMapper.selectByExample(inspectionExample);
        if(!inspections.isEmpty()){
            for(Inspection inspection : inspections){
                NonDrugList nonDrugList = nonDrugListMapper.selectByPrimaryKey(inspection.getNonDrugListId());
                Department department = departmentMapper.selectByPrimaryKey(nonDrugList.getExecutivedepartmentId());
                for(User user : users){
                    if(user.getId() == inspection.getDoctorId()){
                        item.setDoctorName(user.getName());
                        item.setDrawBillDepartmentName(user.getDepartmentname());
                        item.setDepartmentName(user.getDepartmentname());
                    }
                }
                item.setItemName(nonDrugList.getItemName());
                item.setUnitPrice(nonDrugList.getPrice());
                item.setQuantity(1);
                item.setCost(nonDrugList.getPrice());
                item.setFormat(nonDrugList.getFormat());
                item.setDepartmentName(department.getDepartmentName());
                item.setCategoryId(inspection.getId());
                item.setCategory(new NonDrugListServiceImpl().translate(nonDrugList.getItemType()));
                items.add(item);
                item = new Item();
            }
        }
        //查找未缴费处方信息
        DrugPrescriptionExample drugPrescriptionExample = new DrugPrescriptionExample();
        DrugPrescriptionExample.Criteria criteria1 = drugPrescriptionExample.createCriteria();
        criteria1.andMedicalRecordNoEqualTo(medicalNo);
        criteria1.andPaymentStateEqualTo("0");
        criteria1.andStatusEqualTo("1");
        drugPrescriptionExample.or(criteria1);
        List<DrugPrescription> drugPrescriptions = drugPrescriptionMapper.selectByExample(drugPrescriptionExample);
        if(!drugPrescriptions.isEmpty()){
            for(DrugPrescription drugPrescription : drugPrescriptions){
                Drug drug = drugMapper.selectByPrimaryKey(drugPrescription.getDrugId());
                for(User user : users){
                    if(user.getId() == drugPrescription.getDoctorId()){
                        item.setDoctorName(user.getName());
                        item.setDrawBillDepartmentName(user.getDepartmentname());
                        item.setDepartmentName(user.getDepartmentname());
                    }
                }
                item.setItemName(drug.getDrugName());
                item.setUnitPrice(drugPrescription.getDrugPrice());
                item.setQuantity(drugPrescription.getQuantity());
                item.setCost(drugPrescription.getCost());
                item.setFormat(drugPrescription.getDrugFormat());
                item.setCategoryId(drugPrescription.getId());
                item.setCategory("处方");
                items.add(item);
                item = new Item();
            }
        }
        return items;
    }

    @Override
    public Double calCost(List<Item> list) {
        BigDecimal costAll = new BigDecimal("0");
        for(Item item : list){
            costAll = costAll.add(item.getCost());
        }
        return costAll.doubleValue();
    }

    @Override
    public void charge(List<Item> list,String settlementType,Integer tollCollectorId,String patientName,String medicalNo) {
        Invoice invoice = new Invoice();
        Date now = new Date();
        for(Item item : list){
            SettlementTypeExample settlementTypeExample = new SettlementTypeExample();
            settlementTypeExample.or().andSettlementTypeNameEqualTo(settlementType);
            SettlementType settlementType1 = settlementTypeMapper.selectByExample(settlementTypeExample).get(0);
            invoice.setInvoiceNo(createSerialNumber());
            invoice.setCost(item.getCost());
            invoice.setCostType(translate(item.getCategory()));
            invoice.setCostTypeId(item.getCategoryId());
            invoice.setInvoiceTime(now);
            invoice.setTollCollectorId(tollCollectorId);
            invoice.setSettlementTypeId(settlementType1.getId());
            invoice.setStatus("1");
            invoice.setPatientName(patientName);
            invoice.setItemName(item.getItemName());
            invoice.setMedicalRecordNo(medicalNo);
            invoice.setDoctorName(item.getDoctorName());
            invoice.setExecutiveDepartmentName(item.getDepartmentName());
            invoice.setDrawBillDepartmentName(item.getDrawBillDepartmentName());
            invoiceMapper.insertSelective(invoice);
            //修改标志
            if(item.getCategory().equals("挂号")){
                RegistrationInfo registrationInfo = registrationInfoMapper.selectByPrimaryKey(item.getCategoryId());
                registrationInfo.setPaymentTime(now);
                registrationInfo.setPaymentState("1");
                registrationInfoMapper.updateByPrimaryKeySelective(registrationInfo);
            }else if(item.getCategory().equals("处方")){
                DrugPrescription drugPrescription = drugPrescriptionMapper.selectByPrimaryKey(item.getCategoryId());
                drugPrescription.setPaymentState("1");
                drugPrescription.setPaymentTime(now);
                drugPrescriptionMapper.updateByPrimaryKeySelective(drugPrescription);
            }else{
                Inspection inspection = inspectionMapper.selectByPrimaryKey(item.getCategoryId());
                inspection.setPayState("1");
                inspection.setPayTime(now);
                inspectionMapper.updateByPrimaryKeySelective(inspection);
            }
        }
    }

    @Override
    public String returnReg(String medicalNo) {

        RegistrationInfoExample registrationInfoExample = new RegistrationInfoExample();
        registrationInfoExample.or().andMedicalRecordNoEqualTo(medicalNo);
        RegistrationInfo registrationInfo = registrationInfoMapper.selectByExample(registrationInfoExample).get(0);
        if(registrationInfo.getPaymentState().equals("0")){
            return "未缴费";
        } else if (registrationInfo.getIsSeenDoctor().equals("1")) {
            return "已看诊，无法退号";
        }else {
            registrationInfo.setRegistrationState("0");
            registrationInfoMapper.updateByPrimaryKeySelective(registrationInfo);
            //增加冲红发票
            InvoiceExample invoiceExample = new InvoiceExample();
            InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
            criteria.andCostTypeEqualTo("1");
            criteria.andCostTypeIdEqualTo(registrationInfo.getId());
            invoiceExample.or(criteria);
            Invoice invoice = invoiceMapper.selectByExample(invoiceExample).get(0);
            invoice.setStatus("0");
            invoiceMapper.updateByPrimaryKeySelective(invoice);
            invoice.setInvoiceNo(createSerialNumber());
            invoice.setCost(invoice.getCost().negate());
            invoice.setInvoiceTime(new Date());
            invoice.setId(null);
            invoiceMapper.insertSelective(invoice);
            return "成功,退款" + invoice.getCost() + "元";
        }

    }

    @Override
    public List<Invoice> findByMedNo(String medicalNo) {
        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andMedicalRecordNoEqualTo(medicalNo);
        criteria.andStatusEqualTo("1");
        invoiceExample.or(criteria);
        List<Invoice> list = invoiceMapper.selectByExample(invoiceExample);
        for(Invoice invoice: list){
            invoice.setCostType(translate(invoice.getCostType()));
        }
        return list;
    }

    @Override
    public String returnCost(Invoice invoice) {
        if(invoice.getCostType().equals("挂号")){
            return "不可退挂号费";
        }else if(invoice.getCostType().equals("处方")){
            DrugPrescription drugPrescription = drugPrescriptionMapper.selectByPrimaryKey(invoice.getCostTypeId());
            if((drugPrescription.getCost() == invoice.getCost())){
                return "请先退药";
            }else {
                invoice.setStatus("0");
                invoiceMapper.updateByPrimaryKeySelective(invoice);
                invoice.setCost((invoice.getCost().add(drugPrescription.getCost().negate())).negate());
                invoice.setInvoiceNo(createSerialNumber());
                invoice.setId(null);
                invoice.setInvoiceTime(new Date());
                invoiceMapper.insertSelective(invoice);
                return "成功,退款" + invoice.getCost().add(drugPrescription.getCost().negate()) + "元";
            }
        }else {
            Inspection inspection = inspectionMapper.selectByPrimaryKey(invoice.getCostTypeId());
            if (inspection.getRegisterState().equals("1")) {
                return "已登记，不可退费";
            }else {
                inspection.setPayState("0");
                inspectionMapper.updateByPrimaryKeySelective(inspection);
                invoice.setStatus("0");
                invoiceMapper.updateByPrimaryKeySelective(invoice);
                invoice.setCost(invoice.getCost().negate());
                invoice.setInvoiceNo(createSerialNumber());
                invoice.setInvoiceTime(new Date());
                invoice.setId(null);
                invoiceMapper.insertSelective(invoice);
                return "成功,退款" + invoice.getCost() + "元";
            }
        }
    }

    @Override
    public List<Invoice> query(String medicalNo, Date startTime, Date endTime) {
        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andMedicalRecordNoEqualTo(medicalNo);
        if(startTime != null&&endTime != null){
            criteria.andInvoiceTimeBetween(startTime,endTime);
        }else if(startTime != null&endTime == null){
            criteria.andInvoiceTimeGreaterThanOrEqualTo(startTime);
        }else if(startTime == null&endTime != null){
            criteria.andInvoiceTimeLessThanOrEqualTo(endTime);
        }
        invoiceExample.or(criteria);
        List<Invoice> list = invoiceMapper.selectByExample(invoiceExample);
        for(Invoice invoice: list){
            invoice.setCostType(translate(invoice.getCostType()));
        }
        return list;
    }
}
