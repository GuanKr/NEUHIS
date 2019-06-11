package neu.his.service;

import neu.his.bean.Title;

import java.util.List;
/**
 * 处理职称信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface TitleService {
    /**
     * 列出所有职称信息
     * @return 职称信息列表
     */
    List<Title> findAll();
;}
