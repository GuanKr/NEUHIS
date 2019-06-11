package neu.his.service;

import neu.his.bean.DiagnoseDirectory;
import neu.his.bean.Disease;

import java.util.List;
/**
 * 处理诊断目录信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface DiagnoseDirectoryService {
    /**
     * 列出所有诊断目录信息
     * @return 诊断目录信息列表
     */
    List<DiagnoseDirectory> findAll();

    /**
     * 根据输入内容进行查询
     * @param attribute 查询内容
     * @return 诊断目录信息列表
     */
    List<DiagnoseDirectory> findByAttribute_name(String attribute);
}
