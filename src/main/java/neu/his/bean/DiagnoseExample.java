package neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DiagnoseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiagnoseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNull() {
            addCriterion("disease_id is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNotNull() {
            addCriterion("disease_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdEqualTo(Integer value) {
            addCriterion("disease_id =", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotEqualTo(Integer value) {
            addCriterion("disease_id <>", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThan(Integer value) {
            addCriterion("disease_id >", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disease_id >=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThan(Integer value) {
            addCriterion("disease_id <", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("disease_id <=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIn(List<Integer> values) {
            addCriterion("disease_id in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotIn(List<Integer> values) {
            addCriterion("disease_id not in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdBetween(Integer value1, Integer value2) {
            addCriterion("disease_id between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disease_id not between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoIsNull() {
            addCriterion("medical_record_no is null");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoIsNotNull() {
            addCriterion("medical_record_no is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoEqualTo(String value) {
            addCriterion("medical_record_no =", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotEqualTo(String value) {
            addCriterion("medical_record_no <>", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoGreaterThan(String value) {
            addCriterion("medical_record_no >", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("medical_record_no >=", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLessThan(String value) {
            addCriterion("medical_record_no <", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLessThanOrEqualTo(String value) {
            addCriterion("medical_record_no <=", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLike(String value) {
            addCriterion("medical_record_no like", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotLike(String value) {
            addCriterion("medical_record_no not like", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoIn(List<String> values) {
            addCriterion("medical_record_no in", values, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotIn(List<String> values) {
            addCriterion("medical_record_no not in", values, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoBetween(String value1, String value2) {
            addCriterion("medical_record_no between", value1, value2, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotBetween(String value1, String value2) {
            addCriterion("medical_record_no not between", value1, value2, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignIsNull() {
            addCriterion("major_diagnose_sign is null");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignIsNotNull() {
            addCriterion("major_diagnose_sign is not null");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignEqualTo(String value) {
            addCriterion("major_diagnose_sign =", value, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignNotEqualTo(String value) {
            addCriterion("major_diagnose_sign <>", value, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignGreaterThan(String value) {
            addCriterion("major_diagnose_sign >", value, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignGreaterThanOrEqualTo(String value) {
            addCriterion("major_diagnose_sign >=", value, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignLessThan(String value) {
            addCriterion("major_diagnose_sign <", value, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignLessThanOrEqualTo(String value) {
            addCriterion("major_diagnose_sign <=", value, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignLike(String value) {
            addCriterion("major_diagnose_sign like", value, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignNotLike(String value) {
            addCriterion("major_diagnose_sign not like", value, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignIn(List<String> values) {
            addCriterion("major_diagnose_sign in", values, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignNotIn(List<String> values) {
            addCriterion("major_diagnose_sign not in", values, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignBetween(String value1, String value2) {
            addCriterion("major_diagnose_sign between", value1, value2, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andMajorDiagnoseSignNotBetween(String value1, String value2) {
            addCriterion("major_diagnose_sign not between", value1, value2, "majorDiagnoseSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignIsNull() {
            addCriterion("suspected_sign is null");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignIsNotNull() {
            addCriterion("suspected_sign is not null");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignEqualTo(String value) {
            addCriterion("suspected_sign =", value, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignNotEqualTo(String value) {
            addCriterion("suspected_sign <>", value, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignGreaterThan(String value) {
            addCriterion("suspected_sign >", value, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignGreaterThanOrEqualTo(String value) {
            addCriterion("suspected_sign >=", value, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignLessThan(String value) {
            addCriterion("suspected_sign <", value, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignLessThanOrEqualTo(String value) {
            addCriterion("suspected_sign <=", value, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignLike(String value) {
            addCriterion("suspected_sign like", value, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignNotLike(String value) {
            addCriterion("suspected_sign not like", value, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignIn(List<String> values) {
            addCriterion("suspected_sign in", values, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignNotIn(List<String> values) {
            addCriterion("suspected_sign not in", values, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignBetween(String value1, String value2) {
            addCriterion("suspected_sign between", value1, value2, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andSuspectedSignNotBetween(String value1, String value2) {
            addCriterion("suspected_sign not between", value1, value2, "suspectedSign");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeIsNull() {
            addCriterion("disease_time is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeIsNotNull() {
            addCriterion("disease_time is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeEqualTo(Date value) {
            addCriterionForJDBCDate("disease_time =", value, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("disease_time <>", value, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("disease_time >", value, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("disease_time >=", value, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeLessThan(Date value) {
            addCriterionForJDBCDate("disease_time <", value, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("disease_time <=", value, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeIn(List<Date> values) {
            addCriterionForJDBCDate("disease_time in", values, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("disease_time not in", values, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("disease_time between", value1, value2, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("disease_time not between", value1, value2, "diseaseTime");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNull() {
            addCriterion("doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(Integer value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(Integer value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(Integer value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(Integer value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<Integer> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<Integer> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeIsNull() {
            addCriterion("disease_type is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeIsNotNull() {
            addCriterion("disease_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeEqualTo(String value) {
            addCriterion("disease_type =", value, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeNotEqualTo(String value) {
            addCriterion("disease_type <>", value, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeGreaterThan(String value) {
            addCriterion("disease_type >", value, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("disease_type >=", value, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeLessThan(String value) {
            addCriterion("disease_type <", value, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeLessThanOrEqualTo(String value) {
            addCriterion("disease_type <=", value, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeLike(String value) {
            addCriterion("disease_type like", value, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeNotLike(String value) {
            addCriterion("disease_type not like", value, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeIn(List<String> values) {
            addCriterion("disease_type in", values, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeNotIn(List<String> values) {
            addCriterion("disease_type not in", values, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeBetween(String value1, String value2) {
            addCriterion("disease_type between", value1, value2, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andDiseaseTypeNotBetween(String value1, String value2) {
            addCriterion("disease_type not between", value1, value2, "diseaseType");
            return (Criteria) this;
        }

        public Criteria andIsCommonIsNull() {
            addCriterion("is_common is null");
            return (Criteria) this;
        }

        public Criteria andIsCommonIsNotNull() {
            addCriterion("is_common is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommonEqualTo(String value) {
            addCriterion("is_common =", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonNotEqualTo(String value) {
            addCriterion("is_common <>", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonGreaterThan(String value) {
            addCriterion("is_common >", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonGreaterThanOrEqualTo(String value) {
            addCriterion("is_common >=", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonLessThan(String value) {
            addCriterion("is_common <", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonLessThanOrEqualTo(String value) {
            addCriterion("is_common <=", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonLike(String value) {
            addCriterion("is_common like", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonNotLike(String value) {
            addCriterion("is_common not like", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonIn(List<String> values) {
            addCriterion("is_common in", values, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonNotIn(List<String> values) {
            addCriterion("is_common not in", values, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonBetween(String value1, String value2) {
            addCriterion("is_common between", value1, value2, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonNotBetween(String value1, String value2) {
            addCriterion("is_common not between", value1, value2, "isCommon");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}