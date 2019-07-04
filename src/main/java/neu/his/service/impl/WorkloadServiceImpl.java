package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.DepartmentMapper;
import neu.his.dao.InvoiceMapper;
import neu.his.dao.MedicalRecordMapper;
import neu.his.dao.UserMapper;
import neu.his.service.WorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkloadServiceImpl implements WorkloadService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    MedicalRecordMapper medicalRecordMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    private List<Workload> deleteNull(List<Workload> workloads){
        List<Workload> list = new ArrayList<>();
        for(Workload workload: workloads){
            if(workload.getInvoiceQuantity() != null){
                list.add(workload);
            }
        }
        return list;
    }

    private List<Workload> deleteNullPersonal(List<Workload> workloads){
        List<Workload> list = new ArrayList<>();
        for(Workload workload: workloads){
            if(workload.getCost().equals(0)){
                list.add(workload);
            }
        }
        return list;
    }

    @Override
    public List<Workload> personalWorkload(Date startTime, Date endTime, String doctorName) {
        List<Workload> list = new ArrayList<>();
        BigDecimal regCost = new BigDecimal("0");
        BigDecimal drugCost = new BigDecimal("0");
        BigDecimal inspectionCost = new BigDecimal("0");
        BigDecimal checkoutCost = new BigDecimal("0");
        BigDecimal handleCost = new BigDecimal("0");
        //获得医生id
        Integer doctorId;
        UserExample userExample = new UserExample();
        userExample.or().andNameEqualTo(doctorName);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()){
            return null;
        }else{
            doctorId = users.get(0).getId();
        }
        //获得病历号
        MedicalRecordExample medicalRecordExample = new MedicalRecordExample();
        MedicalRecordExample.Criteria criteria = medicalRecordExample.createCriteria();
        criteria.andDoctorIdEqualTo(doctorId);
        criteria.andSeeTimeBetween(startTime,endTime);
        criteria.andIsCommonEqualTo("0");
        medicalRecordExample.or(criteria);
        List<MedicalRecord> medicalRecords = medicalRecordMapper.selectByExample(medicalRecordExample);
        if(medicalRecords.isEmpty()){
            return null;
        }else {
            for(MedicalRecord medicalRecord : medicalRecords) {
                Workload workload = new Workload();
                InvoiceExample invoiceExample = new InvoiceExample();
                invoiceExample.or().andMedicalRecordNoEqualTo(medicalRecord.getMedicalRecordNo());
                List<Invoice> invoices = invoiceMapper.selectByExample(invoiceExample);
                for(Invoice invoice : invoices){
                    workload.setPatientName(invoice.getPatientName());
                    switch (invoice.getCostType()){
                        case "1":
                            regCost = regCost.add(invoice.getCost());
                            break;
                        case "2":
                            inspectionCost = inspectionCost.add(invoice.getCost());
                            break;
                        case "3":
                            checkoutCost = checkoutCost.add(invoice.getCost());
                            break;
                        case "4":
                            drugCost = drugCost.add(invoice.getCost());
                            break;
                        case "5":
                            handleCost = handleCost.add(invoice.getCost());
                            break;
                    }
                }
                workload.setRegCost(regCost);
                workload.setCheckoutCost(checkoutCost);
                workload.setDrugCost(drugCost);
                workload.setHandleCost(handleCost);
                workload.setInspectionCost(inspectionCost);
                workload.setDoctorName(doctorName);
                workload.setCost(regCost.add(checkoutCost.add(drugCost.add(handleCost.add(inspectionCost)))));
                workload.setMedicalNo(medicalRecord.getMedicalRecordNo());
                workload.setInvoiceQuantity(medicalRecords.size());
                list.add(workload);
                workload = new Workload();
            }
        }
        return deleteNullPersonal(list);
    }

    @Override
    public List<Workload> executiveDepartmentWorkload(Date startTime, Date endTime) {
        BigDecimal regCost = new BigDecimal("0");
        BigDecimal drugCost = new BigDecimal("0");
        BigDecimal inspectionCost = new BigDecimal("0");
        BigDecimal checkoutCost = new BigDecimal("0");
        BigDecimal handleCost = new BigDecimal("0");
        List<Workload> workloads = new ArrayList<>();
        List<Department> departments = departmentMapper.selectByExample(new DepartmentExample());
        InvoiceExample invoiceExample1 = new InvoiceExample();
        invoiceExample1.or().andInvoiceTimeBetween(startTime,endTime);
        List<Invoice> invoices = invoiceMapper.selectByExample(invoiceExample1);
        for(Department department:departments){
            workloads.add(new Workload(department.getDepartmentName()));
        }
        for(Workload workload : workloads){
            regCost = new BigDecimal("0");
            drugCost = new BigDecimal("0");
            inspectionCost = new BigDecimal("0");
            checkoutCost = new BigDecimal("0");
            handleCost = new BigDecimal("0");
            for(Invoice invoice : invoices){
                if(workload.getDepartmentName().equals(invoice.getExecutiveDepartmentName())){
                    switch (invoice.getCostType()){
                        case "1":
                            regCost = regCost.add(invoice.getCost());
                            break;
                        case "2":
                            inspectionCost = inspectionCost.add(invoice.getCost());
                            break;
                        case "3":
                            checkoutCost = checkoutCost.add(invoice.getCost());
                            break;
                        case "4":
                            drugCost = drugCost.add(invoice.getCost());
                            break;
                        case "5":
                            handleCost = handleCost.add(invoice.getCost());
                            break;
                    }
                    //设置金额
                    workload.setRegCost(regCost);
                    workload.setCheckoutCost(checkoutCost);
                    workload.setDrugCost(drugCost);
                    workload.setHandleCost(handleCost);
                    workload.setInspectionCost(inspectionCost);
                    workload.setCost(regCost.add(checkoutCost.add(drugCost.add(handleCost.add(inspectionCost)))));
                    //设置发票数量
                    InvoiceExample invoiceExample = new InvoiceExample();
                    InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
                    criteria.andExecutiveDepartmentNameEqualTo(workload.getDepartmentName());
                    criteria.andInvoiceTimeBetween(startTime,endTime);
                    invoiceExample.or(criteria);
                    workload.setInvoiceQuantity(invoiceMapper.countByExample(invoiceExample));
                    //设置看诊人次
                    workload.setSeeQuantity(invoiceMapper.seeQuantity(new SeeQuantity(startTime,endTime,workload.getDepartmentName())));
                }
            }
        }
        return deleteNull(workloads);
    }

    @Override
    public List<Workload> drawBillDepartmentWorkload(Date startTime, Date endTime) {
        BigDecimal regCost = new BigDecimal("0");
        BigDecimal drugCost = new BigDecimal("0");
        BigDecimal checkoutCost = new BigDecimal("0");
        BigDecimal inspectionCost = new BigDecimal("0");
        BigDecimal handleCost = new BigDecimal("0");
        List<Workload> workloads = new ArrayList<>();
        List<Department> departments = departmentMapper.selectByExample(new DepartmentExample());
        InvoiceExample invoiceExample1 = new InvoiceExample();
        invoiceExample1.or().andInvoiceTimeBetween(startTime,endTime);
        List<Invoice> invoices = invoiceMapper.selectByExample(invoiceExample1);
        for(Department department:departments){
            workloads.add(new Workload(department.getDepartmentName()));
        }
        for(Workload workload : workloads){
            regCost = new BigDecimal("0");
            drugCost = new BigDecimal("0");
            inspectionCost = new BigDecimal("0");
            checkoutCost = new BigDecimal("0");
            handleCost = new BigDecimal("0");
            for(Invoice invoice : invoices){
                if(workload.getDepartmentName().equals(invoice.getDrawBillDepartmentName())){
                    switch (invoice.getCostType()){
                        case "1":
                            regCost = regCost.add(invoice.getCost());
                            break;
                        case "2":
                            inspectionCost = inspectionCost.add(invoice.getCost());
                            break;
                        case "3":
                            checkoutCost = checkoutCost.add(invoice.getCost());
                            break;
                        case "4":
                            drugCost = drugCost.add(invoice.getCost());
                            break;
                        case "5":
                            handleCost = handleCost.add(invoice.getCost());
                            break;
                    }
                    //设置金额

                    workload.setCheckoutCost(checkoutCost);
                    workload.setRegCost(regCost);
                    workload.setDrugCost(drugCost);
                    workload.setInspectionCost(inspectionCost);
                    workload.setHandleCost(handleCost);
                    workload.setCost(regCost.add(checkoutCost.add(drugCost.add(handleCost.add(inspectionCost)))));
                    //设置发票数量
                    InvoiceExample invoiceExample = new InvoiceExample();
                    InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
                    criteria.andInvoiceTimeBetween(startTime,endTime);
                    criteria.andDrawBillDepartmentNameEqualTo(workload.getDepartmentName());

                    invoiceExample.or(criteria);
                    workload.setInvoiceQuantity(invoiceMapper.countByExample(invoiceExample));
                    //设置看诊人次
                    workload.setSeeQuantity(invoiceMapper.seeQuantity2(new SeeQuantity(startTime,endTime,workload.getDepartmentName())));
                }
            }
        }
        return deleteNull(workloads);
    }

    @Override
    public List<Workload> allPersonWorkload(Date startTime, Date endTime) {
        BigDecimal regCost = new BigDecimal("0");
        BigDecimal drugCost = new BigDecimal("0");
        BigDecimal checkoutCost = new BigDecimal("0");
        BigDecimal inspectionCost = new BigDecimal("0");
        BigDecimal handleCost = new BigDecimal("0");
        List<Workload> workloads = new ArrayList<>();
        List<User> users = userMapper.selectByExample(new UserExample());
        InvoiceExample invoiceExample1 = new InvoiceExample();
        invoiceExample1.or().andInvoiceTimeBetween(startTime,endTime);
        List<Invoice> invoices = invoiceMapper.selectByExample(invoiceExample1);
        for(User user:users){
            workloads.add(new Workload(user.getName(),null));
        }
        for(Workload workload : workloads){
            regCost = new BigDecimal("0");
            drugCost = new BigDecimal("0");
            inspectionCost = new BigDecimal("0");
            checkoutCost = new BigDecimal("0");
            handleCost = new BigDecimal("0");
            for(Invoice invoice : invoices){
                if(workload.getDoctorName().equals(invoice.getDoctorName())){
                    switch (invoice.getCostType()){
                        case "1":
                            regCost = regCost.add(invoice.getCost());
                            break;
                        case "2":
                            inspectionCost = inspectionCost.add(invoice.getCost());
                            break;
                        case "3":
                            checkoutCost = checkoutCost.add(invoice.getCost());
                            break;
                        case "4":
                            drugCost = drugCost.add(invoice.getCost());
                            break;
                        case "5":
                            handleCost = handleCost.add(invoice.getCost());
                            break;
                    }
                    //设置金额
                    workload.setCheckoutCost(checkoutCost);
                    workload.setRegCost(regCost);
                    workload.setDrugCost(drugCost);
                    workload.setInspectionCost(inspectionCost);
                    workload.setHandleCost(handleCost);
                    workload.setCost(regCost.add(checkoutCost.add(drugCost.add(handleCost.add(inspectionCost)))));
                    //设置发票数量
                    InvoiceExample invoiceExample = new InvoiceExample();
                    InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
                    criteria.andInvoiceTimeBetween(startTime,endTime);
                    criteria.andDoctorNameEqualTo(workload.getDoctorName());
                    invoiceExample.or(criteria);
                    workload.setInvoiceQuantity(invoiceMapper.countByExample(invoiceExample));
                    //设置看诊人次
                    workload.setSeeQuantity(invoiceMapper.seeQuantity3(new SeeQuantity(startTime,endTime,workload.getDoctorName())));
                }
            }
        }
        return deleteNull(workloads);
    }
}
