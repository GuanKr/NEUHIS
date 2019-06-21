package neu.his.service.impl;

import neu.his.bean.ExpenseClass;
import neu.his.bean.ExpenseClassExample;
import neu.his.dao.ExpenseClassMapper;
import neu.his.service.ExpenseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExpenseClassServiceImpl implements ExpenseClassService {

    @Autowired
    ExpenseClassMapper expenseClassMapper;

    @Override
    public List<ExpenseClass> findAll() {
        return expenseClassMapper.selectByExample(new ExpenseClassExample());
    }

    @Override
    public void addExpenseClass(ExpenseClass expenseclass) {
        expenseClassMapper.insertSelective(expenseclass);
    }

    @Override
    public void updateExpenseClass(ExpenseClass expenseclass) {
        expenseClassMapper.updateByPrimaryKeySelective(expenseclass);
    }

    @Override
    public void deleteExpenseClass(Integer id) {
        expenseClassMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ExpenseClass> query(ExpenseClass expenseclass) {
        ExpenseClassExample expenseClassExample = new ExpenseClassExample();
        ExpenseClassExample.Criteria criteria = expenseClassExample.createCriteria();
        if(!(expenseclass.getExpenseCode() == null||expenseclass.getExpenseCode().isEmpty())){
            criteria.andExpenseCodeLike(expenseclass.getExpenseCode());
        }else if(!(expenseclass.getExpenseName() == null || expenseclass.getExpenseName().isEmpty())){
            criteria.andExpenseNameLike(expenseclass.getExpenseName());
        }else {
            return null;
        }
        expenseClassExample.or(criteria);
        return expenseClassMapper.selectByExample(expenseClassExample);
    }
}
