package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.InspectionSetDetailMapper;
import neu.his.dao.InspectionSetMapper;
import neu.his.service.InspectionSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class InspectionSetServiceImpl implements InspectionSetService {
    @Autowired
    InspectionSetMapper inspectionSetMapper;

    @Autowired
    InspectionSetDetailMapper inspectionSetDetailMapper;

    public String translate(String type){
        switch (type){
            case "1":
                return "全院";
            case "2":
                return "科室";
            case "3":
                return "个人";
            case "全院":
                return "1";
            case "科室":
                return "2";
            case "个人":
                return "3";
            default:
                return null;
        }
    }

    @Override
    public List<InspectionSet> findAllSet(Integer doctorId) {
        List<InspectionSet> list = inspectionSetMapper.selectWithName(doctorId);
        for(InspectionSet inspectionSet : list){
            inspectionSet.setCategory(translate(inspectionSet.getCategory()));
        }
        return list;
    }

    @Override
    public List<InspectionSet> findAllInsSet(Integer doctorId) {
        List<InspectionSet> list = inspectionSetMapper.findAllInsSet(doctorId);
        for(InspectionSet inspectionSet : list){
            inspectionSet.setCategory(translate(inspectionSet.getCategory()));
        }
        return list;
    }

    @Override
    public List<InspectionSet> findAllCheckSet(Integer doctorId) {
        List<InspectionSet> list = inspectionSetMapper.findAllCheckSet(doctorId);
        for(InspectionSet inspectionSet : list){
            inspectionSet.setCategory(translate(inspectionSet.getCategory()));
        }
        return list;
    }

    @Override
    public List<InspectionSet> findAllHandleSet(Integer doctorId) {
        List<InspectionSet> list = inspectionSetMapper.findAllHandleSet(doctorId);
        for(InspectionSet inspectionSet : list){
            inspectionSet.setCategory(translate(inspectionSet.getCategory()));
        }
        return list;
    }

    @Override
    public List<InspectionSetDetail> findDetailBySet(Integer setId) {
        return inspectionSetDetailMapper.selectBySet(setId);
    }

    @Override
    public void saveAsSet(InspectionSet inspectionSet, List<String> list) {
        inspectionSet.setCategory(translate(inspectionSet.getCategory()));
        inspectionSet.setCreateTime(new Date());
        inspectionSetMapper.insertSelective(inspectionSet);
        Integer setId = inspectionSet.getId();
/*        InspectionSetExample inspectionSetExample = new InspectionSetExample();
        InspectionSetExample.Criteria criteria = inspectionSetExample.createCriteria();
        criteria.andDoctorIdEqualTo(inspectionSet.getDoctorId());
        criteria.andCreateTimeEqualTo(inspectionSet.getCreateTime());
        inspectionSetExample.or(criteria);
        Integer setId = null;
        for(InspectionSet inspectionSet1 : inspectionSetMapper.selectByExample(inspectionSetExample)){
            setId = inspectionSet1.getId();
        }*/
        InspectionSetDetail inspectionSetDetail = new InspectionSetDetail();
        for(String name : list){
            inspectionSetDetail.setItemName(name);
            inspectionSetDetail.setInspectionSetId(setId);
            inspectionSetDetailMapper.insertDetail(inspectionSetDetail);
        }
    }

    @Override
    public String deleteSet(Integer id, Integer doctorId) {
        InspectionSet inspectionSet = inspectionSetMapper.selectByPrimaryKey(id);
        if (inspectionSet.getDoctorId() == doctorId) {
            inspectionSetMapper.deleteByPrimaryKey(id);
            InspectionSetDetailExample inspectionSetDetailExample = new InspectionSetDetailExample();
            inspectionSetDetailExample.or().andInspectionSetIdEqualTo(id);
            inspectionSetDetailMapper.deleteByExample(inspectionSetDetailExample);
            return "成功";
        } else {
            return "您没有权限";
        }

    }

    @Override
    public String updateSet(InspectionSet inspectionSet, Integer doctorId) {
        if(inspectionSet.getDoctorId() == doctorId){
            inspectionSet.setCategory(translate(inspectionSet.getCategory()));
            inspectionSetMapper.updateByPrimaryKeySelective(inspectionSet);
            return "成功";
        }else{
            return "您没有权限";
        }
    }

    @Override
    public String deleteSetDetail(Integer id, Integer doctorId) {
        InspectionSetDetail inspectionSetDetail = inspectionSetDetailMapper.selectByPrimaryKey(id);
        InspectionSet inspectionSet = inspectionSetMapper.selectByPrimaryKey(inspectionSetDetail.getInspectionSetId());
        if(inspectionSet.getDoctorId() == doctorId){
            inspectionSetDetailMapper.deleteByPrimaryKey(id);
            return "成功";
        }else {
            return "您没有权限";
        }
    }


    @Override
    public String insertSetDetail(InspectionSetDetail inspectionSetDetail,Integer doctorId) {
        InspectionSet inspectionSet = inspectionSetMapper.selectByPrimaryKey(inspectionSetDetail.getInspectionSetId());
        if(inspectionSet.getDoctorId() == doctorId){
            inspectionSetDetailMapper.insertDetail(inspectionSetDetail);
            return "成功";
        }else {
            return "您没有权限";
        }
    }


    @Override
    public List<InspectionSet> query(String attribute_name, String attribute, Integer doctorId) {
        if(attribute_name.equals("category")){
            attribute = translate(attribute);
        }
        List<InspectionSet> list = inspectionSetMapper.query(new SetQuery(attribute_name,attribute,doctorId));
        for(InspectionSet inspectionSet : list){
            inspectionSet.setCategory(translate(inspectionSet.getCategory()));
        }
        return list;
    }
}
