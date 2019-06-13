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
     * 类型代码转换为类型名称
     * @param type 类型代码
     * @return 类型名称
     */
    String translate(String type);

    /**
     * 类型名称转换为类型代码
     * @param type_name 类型名称
     * @return 类型代码
     */
    String de_translate(String type_name);

    /**
     * 列出所有诊断目录信息
     * @return 诊断目录信息列表
     */
    List<DiagnoseDirectory> findAll();

    /**
     * 根据输入内容进行查询
     * @param attribute 疾病分类名称查询内容
     * @return 诊断目录信息列表
     */
    List<DiagnoseDirectory> findByAttribute_name(String attribute);
}
