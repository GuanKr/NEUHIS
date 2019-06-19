package neu.his.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InspectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InspectionExample() {
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

        public Criteria andNonDrugListIdIsNull() {
            addCriterion("non_drug_list_id is null");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdIsNotNull() {
            addCriterion("non_drug_list_id is not null");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdEqualTo(Integer value) {
            addCriterion("non_drug_list_id =", value, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdNotEqualTo(Integer value) {
            addCriterion("non_drug_list_id <>", value, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdGreaterThan(Integer value) {
            addCriterion("non_drug_list_id >", value, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("non_drug_list_id >=", value, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdLessThan(Integer value) {
            addCriterion("non_drug_list_id <", value, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdLessThanOrEqualTo(Integer value) {
            addCriterion("non_drug_list_id <=", value, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdIn(List<Integer> values) {
            addCriterion("non_drug_list_id in", values, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdNotIn(List<Integer> values) {
            addCriterion("non_drug_list_id not in", values, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdBetween(Integer value1, Integer value2) {
            addCriterion("non_drug_list_id between", value1, value2, "nonDrugListId");
            return (Criteria) this;
        }

        public Criteria andNonDrugListIdNotBetween(Integer value1, Integer value2) {
            addCriterion("non_drug_list_id not between", value1, value2, "nonDrugListId");
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

        public Criteria andInspectionResultAnalysisIsNull() {
            addCriterion("inspection_result_analysis is null");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisIsNotNull() {
            addCriterion("inspection_result_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisEqualTo(String value) {
            addCriterion("inspection_result_analysis =", value, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisNotEqualTo(String value) {
            addCriterion("inspection_result_analysis <>", value, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisGreaterThan(String value) {
            addCriterion("inspection_result_analysis >", value, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_result_analysis >=", value, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisLessThan(String value) {
            addCriterion("inspection_result_analysis <", value, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisLessThanOrEqualTo(String value) {
            addCriterion("inspection_result_analysis <=", value, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisLike(String value) {
            addCriterion("inspection_result_analysis like", value, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisNotLike(String value) {
            addCriterion("inspection_result_analysis not like", value, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisIn(List<String> values) {
            addCriterion("inspection_result_analysis in", values, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisNotIn(List<String> values) {
            addCriterion("inspection_result_analysis not in", values, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisBetween(String value1, String value2) {
            addCriterion("inspection_result_analysis between", value1, value2, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andInspectionResultAnalysisNotBetween(String value1, String value2) {
            addCriterion("inspection_result_analysis not between", value1, value2, "inspectionResultAnalysis");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(String value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(String value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(String value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(String value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(String value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(String value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLike(String value) {
            addCriterion("pay_state like", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotLike(String value) {
            addCriterion("pay_state not like", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<String> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<String> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(String value1, String value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(String value1, String value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andRegisterStateIsNull() {
            addCriterion("register_state is null");
            return (Criteria) this;
        }

        public Criteria andRegisterStateIsNotNull() {
            addCriterion("register_state is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterStateEqualTo(String value) {
            addCriterion("register_state =", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateNotEqualTo(String value) {
            addCriterion("register_state <>", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateGreaterThan(String value) {
            addCriterion("register_state >", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateGreaterThanOrEqualTo(String value) {
            addCriterion("register_state >=", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateLessThan(String value) {
            addCriterion("register_state <", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateLessThanOrEqualTo(String value) {
            addCriterion("register_state <=", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateLike(String value) {
            addCriterion("register_state like", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateNotLike(String value) {
            addCriterion("register_state not like", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateIn(List<String> values) {
            addCriterion("register_state in", values, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateNotIn(List<String> values) {
            addCriterion("register_state not in", values, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateBetween(String value1, String value2) {
            addCriterion("register_state between", value1, value2, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateNotBetween(String value1, String value2) {
            addCriterion("register_state not between", value1, value2, "registerState");
            return (Criteria) this;
        }

        public Criteria andValidityIsNull() {
            addCriterion("validity is null");
            return (Criteria) this;
        }

        public Criteria andValidityIsNotNull() {
            addCriterion("validity is not null");
            return (Criteria) this;
        }

        public Criteria andValidityEqualTo(String value) {
            addCriterion("validity =", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotEqualTo(String value) {
            addCriterion("validity <>", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityGreaterThan(String value) {
            addCriterion("validity >", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityGreaterThanOrEqualTo(String value) {
            addCriterion("validity >=", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityLessThan(String value) {
            addCriterion("validity <", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityLessThanOrEqualTo(String value) {
            addCriterion("validity <=", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityLike(String value) {
            addCriterion("validity like", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotLike(String value) {
            addCriterion("validity not like", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityIn(List<String> values) {
            addCriterion("validity in", values, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotIn(List<String> values) {
            addCriterion("validity not in", values, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityBetween(String value1, String value2) {
            addCriterion("validity between", value1, value2, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotBetween(String value1, String value2) {
            addCriterion("validity not between", value1, value2, "validity");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
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