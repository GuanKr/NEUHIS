package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.DepartmentMapper;
import neu.his.dao.ExpenseClassMapper;
import neu.his.dao.NonDrugListMapper;
import neu.his.dao.TranslateMapper;
import neu.his.service.NonDrugListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NonDrugListServiceImpl implements NonDrugListService {
    @Autowired
    NonDrugListMapper nonDrugListMapper;

    @Autowired
    TranslateMapper translateMapper;

    @Autowired
    ExpenseClassMapper expenseClassMapper;

    @Autowired
    DepartmentMapper departmentMapper;
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
        list = nonDrugListMapper.selectByExample(new NonDrugListExample());

        for(NonDrugList nonDrugList : list){
            nonDrugList.setExecutivedepartmentName(translateMapper.translate_department(nonDrugList.getExecutivedepartmentId()));
            nonDrugList.setExpenseClassName(translateMapper.translate_expense_class(nonDrugList.getExpenseClassId()));
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
        List<Department> departments;
        List<ExpenseClass> expenseClasses;
        List<NonDrugList> nonDrugLists;
        List<NonDrugList> list;

        nonDrugLists = findAll();
        expenseClasses = expenseClassMapper.selectByExample(new ExpenseClassExample());
        departments = departmentMapper.selectByExample(new DepartmentExample());

        NonDrugListExample nonDrugListExample = new NonDrugListExample();
        if (attribute_name.equals("item_name")) {
            for (NonDrugList nonDrugList : nonDrugLists) {
                String name = nonDrugList.getItemName();
                if (name.contains(attribute)) {
                    nonDrugListExample.or().andItemNameEqualTo(attribute);
                }
            }
        } else if (attribute_name.equals("expense_class_id")) {
            for (ExpenseClass expenseClass : expenseClasses) {
                String name = expenseClass.getExpenseName();
                if (name.contains(attribute)) {
                    nonDrugListExample.or().andExpenseClassIdEqualTo(expenseClass.getId());
                }
            }
        }else if(attribute_name.equals("executivedepartment_id")) {
            for (Department department : departments) {
                String name = department.getDepartmentName();
                if (name.contains(attribute)) {
                    nonDrugListExample.or().andExecutivedepartmentIdEqualTo(department.getId());
                }
            }
        }else
            return null;
        list = nonDrugListMapper.selectByExample(nonDrugListExample);
        return list;
    }

    @Override
    public void insertNonDrugList(NonDrugList nonDrugList) {
        nonDrugList.setItemType(de_translate(nonDrugList.getItemTypeName()));
        nonDrugList.setExecutivedepartmentId(translateMapper.de_translate_department(nonDrugList.getExecutivedepartmentName()));
        nonDrugList.setExpenseClassId(translateMapper.de_translate_expense_class(nonDrugList.getExpenseClassName()));
        nonDrugListMapper.insertSelective(nonDrugList);
    }

    @Override
    public void updateNonDrugList(NonDrugList nonDrugList) {
        nonDrugList.setItemType(de_translate(nonDrugList.getItemTypeName()));
        nonDrugList.setExecutivedepartmentId(translateMapper.de_translate_department(nonDrugList.getExecutivedepartmentName()));
        nonDrugList.setExpenseClassId(translateMapper.de_translate_expense_class(nonDrugList.getExpenseClassName()));
        nonDrugListMapper.updateByPrimaryKey(nonDrugList);
    }
}
