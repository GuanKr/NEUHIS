package neu.his.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RegistrationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegistrationInfoExample() {
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

        public Criteria andRegistrationLevelIdIsNull() {
            addCriterion("registration_level_id is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdIsNotNull() {
            addCriterion("registration_level_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdEqualTo(Integer value) {
            addCriterion("registration_level_id =", value, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdNotEqualTo(Integer value) {
            addCriterion("registration_level_id <>", value, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdGreaterThan(Integer value) {
            addCriterion("registration_level_id >", value, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("registration_level_id >=", value, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdLessThan(Integer value) {
            addCriterion("registration_level_id <", value, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdLessThanOrEqualTo(Integer value) {
            addCriterion("registration_level_id <=", value, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdIn(List<Integer> values) {
            addCriterion("registration_level_id in", values, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdNotIn(List<Integer> values) {
            addCriterion("registration_level_id not in", values, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdBetween(Integer value1, Integer value2) {
            addCriterion("registration_level_id between", value1, value2, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andRegistrationLevelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("registration_level_id not between", value1, value2, "registrationLevelId");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateIsNull() {
            addCriterion("see_doctor_date is null");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateIsNotNull() {
            addCriterion("see_doctor_date is not null");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateEqualTo(Date value) {
            addCriterion("see_doctor_date =", value, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateNotEqualTo(Date value) {
            addCriterion("see_doctor_date <>", value, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateGreaterThan(Date value) {
            addCriterion("see_doctor_date >", value, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateGreaterThanOrEqualTo(Date value) {
            addCriterion("see_doctor_date >=", value, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateLessThan(Date value) {
            addCriterion("see_doctor_date <", value, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateLessThanOrEqualTo(Date value) {
            addCriterion("see_doctor_date <=", value, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateIn(List<Date> values) {
            addCriterion("see_doctor_date in", values, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateNotIn(List<Date> values) {
            addCriterion("see_doctor_date not in", values, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateBetween(Date value1, Date value2) {
            addCriterion("see_doctor_date between", value1, value2, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andSeeDoctorDateNotBetween(Date value1, Date value2) {
            addCriterion("see_doctor_date not between", value1, value2, "seeDoctorDate");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
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

        public Criteria andRegistrationResourceIsNull() {
            addCriterion("registration_resource is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceIsNotNull() {
            addCriterion("registration_resource is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceEqualTo(String value) {
            addCriterion("registration_resource =", value, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceNotEqualTo(String value) {
            addCriterion("registration_resource <>", value, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceGreaterThan(String value) {
            addCriterion("registration_resource >", value, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceGreaterThanOrEqualTo(String value) {
            addCriterion("registration_resource >=", value, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceLessThan(String value) {
            addCriterion("registration_resource <", value, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceLessThanOrEqualTo(String value) {
            addCriterion("registration_resource <=", value, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceLike(String value) {
            addCriterion("registration_resource like", value, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceNotLike(String value) {
            addCriterion("registration_resource not like", value, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceIn(List<String> values) {
            addCriterion("registration_resource in", values, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceNotIn(List<String> values) {
            addCriterion("registration_resource not in", values, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceBetween(String value1, String value2) {
            addCriterion("registration_resource between", value1, value2, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andRegistrationResourceNotBetween(String value1, String value2) {
            addCriterion("registration_resource not between", value1, value2, "registrationResource");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdIsNull() {
            addCriterion("settlement_type_id is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdIsNotNull() {
            addCriterion("settlement_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdEqualTo(Integer value) {
            addCriterion("settlement_type_id =", value, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdNotEqualTo(Integer value) {
            addCriterion("settlement_type_id <>", value, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdGreaterThan(Integer value) {
            addCriterion("settlement_type_id >", value, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("settlement_type_id >=", value, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdLessThan(Integer value) {
            addCriterion("settlement_type_id <", value, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("settlement_type_id <=", value, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdIn(List<Integer> values) {
            addCriterion("settlement_type_id in", values, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdNotIn(List<Integer> values) {
            addCriterion("settlement_type_id not in", values, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("settlement_type_id between", value1, value2, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("settlement_type_id not between", value1, value2, "settlementTypeId");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookIsNull() {
            addCriterion("is_need_medicalrecordbook is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookIsNotNull() {
            addCriterion("is_need_medicalrecordbook is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookEqualTo(String value) {
            addCriterion("is_need_medicalrecordbook =", value, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookNotEqualTo(String value) {
            addCriterion("is_need_medicalrecordbook <>", value, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookGreaterThan(String value) {
            addCriterion("is_need_medicalrecordbook >", value, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookGreaterThanOrEqualTo(String value) {
            addCriterion("is_need_medicalrecordbook >=", value, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookLessThan(String value) {
            addCriterion("is_need_medicalrecordbook <", value, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookLessThanOrEqualTo(String value) {
            addCriterion("is_need_medicalrecordbook <=", value, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookLike(String value) {
            addCriterion("is_need_medicalrecordbook like", value, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookNotLike(String value) {
            addCriterion("is_need_medicalrecordbook not like", value, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookIn(List<String> values) {
            addCriterion("is_need_medicalrecordbook in", values, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookNotIn(List<String> values) {
            addCriterion("is_need_medicalrecordbook not in", values, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookBetween(String value1, String value2) {
            addCriterion("is_need_medicalrecordbook between", value1, value2, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsNeedMedicalrecordbookNotBetween(String value1, String value2) {
            addCriterion("is_need_medicalrecordbook not between", value1, value2, "isNeedMedicalrecordbook");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorIsNull() {
            addCriterion("is_seen_doctor is null");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorIsNotNull() {
            addCriterion("is_seen_doctor is not null");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorEqualTo(String value) {
            addCriterion("is_seen_doctor =", value, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorNotEqualTo(String value) {
            addCriterion("is_seen_doctor <>", value, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorGreaterThan(String value) {
            addCriterion("is_seen_doctor >", value, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorGreaterThanOrEqualTo(String value) {
            addCriterion("is_seen_doctor >=", value, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorLessThan(String value) {
            addCriterion("is_seen_doctor <", value, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorLessThanOrEqualTo(String value) {
            addCriterion("is_seen_doctor <=", value, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorLike(String value) {
            addCriterion("is_seen_doctor like", value, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorNotLike(String value) {
            addCriterion("is_seen_doctor not like", value, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorIn(List<String> values) {
            addCriterion("is_seen_doctor in", values, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorNotIn(List<String> values) {
            addCriterion("is_seen_doctor not in", values, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorBetween(String value1, String value2) {
            addCriterion("is_seen_doctor between", value1, value2, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andIsSeenDoctorNotBetween(String value1, String value2) {
            addCriterion("is_seen_doctor not between", value1, value2, "isSeenDoctor");
            return (Criteria) this;
        }

        public Criteria andExpenseIsNull() {
            addCriterion("expense is null");
            return (Criteria) this;
        }

        public Criteria andExpenseIsNotNull() {
            addCriterion("expense is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseEqualTo(BigDecimal value) {
            addCriterion("expense =", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotEqualTo(BigDecimal value) {
            addCriterion("expense <>", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseGreaterThan(BigDecimal value) {
            addCriterion("expense >", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("expense >=", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseLessThan(BigDecimal value) {
            addCriterion("expense <", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("expense <=", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseIn(List<BigDecimal> values) {
            addCriterion("expense in", values, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotIn(List<BigDecimal> values) {
            addCriterion("expense not in", values, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expense between", value1, value2, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expense not between", value1, value2, "expense");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNull() {
            addCriterion("payment_state is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNotNull() {
            addCriterion("payment_state is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateEqualTo(String value) {
            addCriterion("payment_state =", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotEqualTo(String value) {
            addCriterion("payment_state <>", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThan(String value) {
            addCriterion("payment_state >", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThanOrEqualTo(String value) {
            addCriterion("payment_state >=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThan(String value) {
            addCriterion("payment_state <", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThanOrEqualTo(String value) {
            addCriterion("payment_state <=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLike(String value) {
            addCriterion("payment_state like", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotLike(String value) {
            addCriterion("payment_state not like", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIn(List<String> values) {
            addCriterion("payment_state in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotIn(List<String> values) {
            addCriterion("payment_state not in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateBetween(String value1, String value2) {
            addCriterion("payment_state between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotBetween(String value1, String value2) {
            addCriterion("payment_state not between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_time not between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateIsNull() {
            addCriterion("registration_state is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateIsNotNull() {
            addCriterion("registration_state is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateEqualTo(String value) {
            addCriterion("registration_state =", value, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateNotEqualTo(String value) {
            addCriterion("registration_state <>", value, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateGreaterThan(String value) {
            addCriterion("registration_state >", value, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateGreaterThanOrEqualTo(String value) {
            addCriterion("registration_state >=", value, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateLessThan(String value) {
            addCriterion("registration_state <", value, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateLessThanOrEqualTo(String value) {
            addCriterion("registration_state <=", value, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateLike(String value) {
            addCriterion("registration_state like", value, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateNotLike(String value) {
            addCriterion("registration_state not like", value, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateIn(List<String> values) {
            addCriterion("registration_state in", values, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateNotIn(List<String> values) {
            addCriterion("registration_state not in", values, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateBetween(String value1, String value2) {
            addCriterion("registration_state between", value1, value2, "registrationState");
            return (Criteria) this;
        }

        public Criteria andRegistrationStateNotBetween(String value1, String value2) {
            addCriterion("registration_state not between", value1, value2, "registrationState");
            return (Criteria) this;
        }

        public Criteria andIsCompletedIsNull() {
            addCriterion("is_completed is null");
            return (Criteria) this;
        }

        public Criteria andIsCompletedIsNotNull() {
            addCriterion("is_completed is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompletedEqualTo(String value) {
            addCriterion("is_completed =", value, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedNotEqualTo(String value) {
            addCriterion("is_completed <>", value, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedGreaterThan(String value) {
            addCriterion("is_completed >", value, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedGreaterThanOrEqualTo(String value) {
            addCriterion("is_completed >=", value, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedLessThan(String value) {
            addCriterion("is_completed <", value, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedLessThanOrEqualTo(String value) {
            addCriterion("is_completed <=", value, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedLike(String value) {
            addCriterion("is_completed like", value, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedNotLike(String value) {
            addCriterion("is_completed not like", value, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedIn(List<String> values) {
            addCriterion("is_completed in", values, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedNotIn(List<String> values) {
            addCriterion("is_completed not in", values, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedBetween(String value1, String value2) {
            addCriterion("is_completed between", value1, value2, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andIsCompletedNotBetween(String value1, String value2) {
            addCriterion("is_completed not between", value1, value2, "isCompleted");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNull() {
            addCriterion("patient_name is null");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNotNull() {
            addCriterion("patient_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatientNameEqualTo(String value) {
            addCriterion("patient_name =", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotEqualTo(String value) {
            addCriterion("patient_name <>", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThan(String value) {
            addCriterion("patient_name >", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThanOrEqualTo(String value) {
            addCriterion("patient_name >=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThan(String value) {
            addCriterion("patient_name <", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThanOrEqualTo(String value) {
            addCriterion("patient_name <=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLike(String value) {
            addCriterion("patient_name like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotLike(String value) {
            addCriterion("patient_name not like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameIn(List<String> values) {
            addCriterion("patient_name in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotIn(List<String> values) {
            addCriterion("patient_name not in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameBetween(String value1, String value2) {
            addCriterion("patient_name between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotBetween(String value1, String value2) {
            addCriterion("patient_name not between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberIsNull() {
            addCriterion("patient_identity_number is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberIsNotNull() {
            addCriterion("patient_identity_number is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberEqualTo(String value) {
            addCriterion("patient_identity_number =", value, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberNotEqualTo(String value) {
            addCriterion("patient_identity_number <>", value, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberGreaterThan(String value) {
            addCriterion("patient_identity_number >", value, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberGreaterThanOrEqualTo(String value) {
            addCriterion("patient_identity_number >=", value, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberLessThan(String value) {
            addCriterion("patient_identity_number <", value, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberLessThanOrEqualTo(String value) {
            addCriterion("patient_identity_number <=", value, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberLike(String value) {
            addCriterion("patient_identity_number like", value, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberNotLike(String value) {
            addCriterion("patient_identity_number not like", value, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberIn(List<String> values) {
            addCriterion("patient_identity_number in", values, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberNotIn(List<String> values) {
            addCriterion("patient_identity_number not in", values, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberBetween(String value1, String value2) {
            addCriterion("patient_identity_number between", value1, value2, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientIdentityNumberNotBetween(String value1, String value2) {
            addCriterion("patient_identity_number not between", value1, value2, "patientIdentityNumber");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIsNull() {
            addCriterion("patient_age is null");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIsNotNull() {
            addCriterion("patient_age is not null");
            return (Criteria) this;
        }

        public Criteria andPatientAgeEqualTo(Integer value) {
            addCriterion("patient_age =", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotEqualTo(Integer value) {
            addCriterion("patient_age <>", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeGreaterThan(Integer value) {
            addCriterion("patient_age >", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_age >=", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeLessThan(Integer value) {
            addCriterion("patient_age <", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeLessThanOrEqualTo(Integer value) {
            addCriterion("patient_age <=", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIn(List<Integer> values) {
            addCriterion("patient_age in", values, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotIn(List<Integer> values) {
            addCriterion("patient_age not in", values, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeBetween(Integer value1, Integer value2) {
            addCriterion("patient_age between", value1, value2, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_age not between", value1, value2, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientSexIsNull() {
            addCriterion("patient_sex is null");
            return (Criteria) this;
        }

        public Criteria andPatientSexIsNotNull() {
            addCriterion("patient_sex is not null");
            return (Criteria) this;
        }

        public Criteria andPatientSexEqualTo(String value) {
            addCriterion("patient_sex =", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexNotEqualTo(String value) {
            addCriterion("patient_sex <>", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexGreaterThan(String value) {
            addCriterion("patient_sex >", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexGreaterThanOrEqualTo(String value) {
            addCriterion("patient_sex >=", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexLessThan(String value) {
            addCriterion("patient_sex <", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexLessThanOrEqualTo(String value) {
            addCriterion("patient_sex <=", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexLike(String value) {
            addCriterion("patient_sex like", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexNotLike(String value) {
            addCriterion("patient_sex not like", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexIn(List<String> values) {
            addCriterion("patient_sex in", values, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexNotIn(List<String> values) {
            addCriterion("patient_sex not in", values, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexBetween(String value1, String value2) {
            addCriterion("patient_sex between", value1, value2, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexNotBetween(String value1, String value2) {
            addCriterion("patient_sex not between", value1, value2, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayIsNull() {
            addCriterion("patient_birthday is null");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayIsNotNull() {
            addCriterion("patient_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("patient_birthday =", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("patient_birthday <>", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("patient_birthday >", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("patient_birthday >=", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("patient_birthday <", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("patient_birthday <=", value, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("patient_birthday in", values, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("patient_birthday not in", values, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("patient_birthday between", value1, value2, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andPatientBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("patient_birthday not between", value1, value2, "patientBirthday");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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