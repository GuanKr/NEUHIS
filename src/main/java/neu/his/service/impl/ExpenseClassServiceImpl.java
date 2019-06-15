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
}
