package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.DepartmentMapper;
import neu.his.dao.ExpenseClassMapper;
import neu.his.dao.NonDrugListMapper;
import neu.his.dao.TranslateMapper;
import neu.his.service.NonDrugListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NonDrugListServiceImpl implements NonDrugListService {
    @Autowired
    NonDrugListMapper nonDrugListMapper;

    @Override
    public String translate(String type) {
        if (type.equals("1")) {
            return "检查";
        }else if(type.equals("2")){
            return "检验";
        }else if(type.equals("3")){
            return "处置";
        }else
            return  null;
    }

    @Override
    public String de_translate(String type_name) {
        if (type_name.equals("检查")) {
            return "1";
        }else if(type_name.equals("检验")){
            return "2";
        }else if(type_name.equals("处置")){
            return "3";
        }else
            return  null;
    }

    @Override
    public List<NonDrugList> findAll() {
        List<NonDrugList> list;
        list = nonDrugListMapper.selectWithName();
        for(NonDrugList nonDrugList : list){
            nonDrugList.setItemTypeName(translate(nonDrugList.getItemType()));
        }
        return list;
    }

    @Override
    public void deleteByID(int id) {
        nonDrugListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<NonDrugList> findByAttribute_name(String attribute_name, String attribute) {
        List<NonDrugList> list;
        list =  nonDrugListMapper.query(new Query(attribute_name,attribute));
        for(NonDrugList nonDrugList : list){
            nonDrugList.setItemTypeName(translate(nonDrugList.getItemType()));
        }
        return list;
    }

    @Override
    public void insertNonDrugList(NonDrugList nonDrugList) {
        nonDrugList.setItemType(de_translate(nonDrugList.getItemTypeName()));
        nonDrugListMapper.insertNonDrugList(nonDrugList);
    }

    @Override
    public void updateNonDrugList(NonDrugList nonDrugList) {
        nonDrugList.setItemType(de_translate(nonDrugList.getItemTypeName()));
        nonDrugListMapper.updateNonDrugList(nonDrugList);
    }

    @Override
    public List<NonDrugList> findByType(String type, String attribute_name, String attribute) {
        List<NonDrugList> lista = findByAttribute_name(attribute_name,attribute);
        List<NonDrugList> list = new ArrayList<>();
        if(type.equals("检查")){
            for(NonDrugList nonDrugList : lista){
                if(nonDrugList.getItemType().equals("1")){
                    list.add(nonDrugList);
                }
            }
        }else if(type.equals("检验")) {
            for (NonDrugList nonDrugList : lista) {
                if (nonDrugList.getItemType().equals("2")) {
                    list.add(nonDrugList);
                }
            }
        }else{
            for (NonDrugList nonDrugList : lista) {
                if (nonDrugList.getItemType().equals("3")) {
                    list.add(nonDrugList);
                }
            }
        }
        return list;
    }

}
