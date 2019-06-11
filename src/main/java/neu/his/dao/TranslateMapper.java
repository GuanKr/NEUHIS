package neu.his.dao;

public interface TranslateMapper {
    String translate_title(Integer id);
    String translate_role(Integer id);
    String translate_department(Integer id);
    String translate_registration_level(Integer id);
    String translate_diagnose_directory(Integer id);
    String translate_expense_class(Integer id);

    Integer de_translate_title(String name);
    Integer de_translate_role(String name);
    Integer de_translate_department(String name);
    Integer de_translate_registration_level(String name);
    Integer de_translate_diagnose_directory(String name);
    Integer de_translate_expense_class(String name);
}
