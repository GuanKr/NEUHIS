package neu.his.service.impl;


import neu.his.bean.Title;
import neu.his.bean.TitleExample;
import neu.his.dao.TitleMapper;
import neu.his.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {
    @Autowired
    TitleMapper dao;

    @Override
    public List<Title> findAll() {
        return dao.selectByExample(new TitleExample());
    }
}
