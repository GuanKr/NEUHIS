package neu.his.dao;

public interface TranslateMapper {
    String translate_title(Integer id);
    String translate_role(Integer id);
    String translate_department(Integer id);
    Integer de_translate_title(String name);
    Integer de_translate_role(String name);
    Integer de_translate_department(String name);
}
