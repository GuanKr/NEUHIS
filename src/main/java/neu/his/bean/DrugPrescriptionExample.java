package neu.his.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrugPrescriptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugPrescriptionExample() {
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

        public Criteria andDrugIdIsNull() {
            addCriterion("drug_id is null");
            return (Criteria) this;
        }

        public Criteria andDrugIdIsNotNull() {
            addCriterion("drug_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIdEqualTo(Integer value) {
            addCriterion("drug_id =", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotEqualTo(Integer value) {
            addCriterion("drug_id <>", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThan(Integer value) {
            addCriterion("drug_id >", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("drug_id >=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThan(Integer value) {
            addCriterion("drug_id <", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThanOrEqualTo(Integer value) {
            addCriterion("drug_id <=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdIn(List<Integer> values) {
            addCriterion("drug_id in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotIn(List<Integer> values) {
            addCriterion("drug_id not in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdBetween(Integer value1, Integer value2) {
            addCriterion("drug_id between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotBetween(Integer value1, Integer value2) {
            addCriterion("drug_id not between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugUsageIsNull() {
            addCriterion("drug_usage is null");
            return (Criteria) this;
        }

        public Criteria andDrugUsageIsNotNull() {
            addCriterion("drug_usage is not null");
            return (Criteria) this;
        }

        public Criteria andDrugUsageEqualTo(String value) {
            addCriterion("drug_usage =", value, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageNotEqualTo(String value) {
            addCriterion("drug_usage <>", value, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageGreaterThan(String value) {
            addCriterion("drug_usage >", value, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageGreaterThanOrEqualTo(String value) {
            addCriterion("drug_usage >=", value, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageLessThan(String value) {
            addCriterion("drug_usage <", value, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageLessThanOrEqualTo(String value) {
            addCriterion("drug_usage <=", value, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageLike(String value) {
            addCriterion("drug_usage like", value, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageNotLike(String value) {
            addCriterion("drug_usage not like", value, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageIn(List<String> values) {
            addCriterion("drug_usage in", values, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageNotIn(List<String> values) {
            addCriterion("drug_usage not in", values, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageBetween(String value1, String value2) {
            addCriterion("drug_usage between", value1, value2, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugUsageNotBetween(String value1, String value2) {
            addCriterion("drug_usage not between", value1, value2, "drugUsage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageIsNull() {
            addCriterion("drug_dosage is null");
            return (Criteria) this;
        }

        public Criteria andDrugDosageIsNotNull() {
            addCriterion("drug_dosage is not null");
            return (Criteria) this;
        }

        public Criteria andDrugDosageEqualTo(BigDecimal value) {
            addCriterion("drug_dosage =", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageNotEqualTo(BigDecimal value) {
            addCriterion("drug_dosage <>", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageGreaterThan(BigDecimal value) {
            addCriterion("drug_dosage >", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("drug_dosage >=", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageLessThan(BigDecimal value) {
            addCriterion("drug_dosage <", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("drug_dosage <=", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageIn(List<BigDecimal> values) {
            addCriterion("drug_dosage in", values, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageNotIn(List<BigDecimal> values) {
            addCriterion("drug_dosage not in", values, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drug_dosage between", value1, value2, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drug_dosage not between", value1, value2, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(String value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(String value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(String value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(String value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(String value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLike(String value) {
            addCriterion("frequency like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotLike(String value) {
            addCriterion("frequency not like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<String> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<String> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(String value1, String value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(String value1, String value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andDayNumberIsNull() {
            addCriterion("day_number is null");
            return (Criteria) this;
        }

        public Criteria andDayNumberIsNotNull() {
            addCriterion("day_number is not null");
            return (Criteria) this;
        }

        public Criteria andDayNumberEqualTo(BigDecimal value) {
            addCriterion("day_number =", value, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberNotEqualTo(BigDecimal value) {
            addCriterion("day_number <>", value, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberGreaterThan(BigDecimal value) {
            addCriterion("day_number >", value, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("day_number >=", value, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberLessThan(BigDecimal value) {
            addCriterion("day_number <", value, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("day_number <=", value, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberIn(List<BigDecimal> values) {
            addCriterion("day_number in", values, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberNotIn(List<BigDecimal> values) {
            addCriterion("day_number not in", values, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_number between", value1, value2, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andDayNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_number not between", value1, value2, "dayNumber");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceIsNull() {
            addCriterion("doctor_advice is null");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceIsNotNull() {
            addCriterion("doctor_advice is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceEqualTo(String value) {
            addCriterion("doctor_advice =", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceNotEqualTo(String value) {
            addCriterion("doctor_advice <>", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceGreaterThan(String value) {
            addCriterion("doctor_advice >", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_advice >=", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceLessThan(String value) {
            addCriterion("doctor_advice <", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceLessThanOrEqualTo(String value) {
            addCriterion("doctor_advice <=", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceLike(String value) {
            addCriterion("doctor_advice like", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceNotLike(String value) {
            addCriterion("doctor_advice not like", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceIn(List<String> values) {
            addCriterion("doctor_advice in", values, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceNotIn(List<String> values) {
            addCriterion("doctor_advice not in", values, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceBetween(String value1, String value2) {
            addCriterion("doctor_advice between", value1, value2, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceNotBetween(String value1, String value2) {
            addCriterion("doctor_advice not between", value1, value2, "doctorAdvice");
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

        public Criteria andTakeMedicineStateIsNull() {
            addCriterion("take_medicine_state is null");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateIsNotNull() {
            addCriterion("take_medicine_state is not null");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateEqualTo(String value) {
            addCriterion("take_medicine_state =", value, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateNotEqualTo(String value) {
            addCriterion("take_medicine_state <>", value, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateGreaterThan(String value) {
            addCriterion("take_medicine_state >", value, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateGreaterThanOrEqualTo(String value) {
            addCriterion("take_medicine_state >=", value, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateLessThan(String value) {
            addCriterion("take_medicine_state <", value, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateLessThanOrEqualTo(String value) {
            addCriterion("take_medicine_state <=", value, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateLike(String value) {
            addCriterion("take_medicine_state like", value, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateNotLike(String value) {
            addCriterion("take_medicine_state not like", value, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateIn(List<String> values) {
            addCriterion("take_medicine_state in", values, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateNotIn(List<String> values) {
            addCriterion("take_medicine_state not in", values, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateBetween(String value1, String value2) {
            addCriterion("take_medicine_state between", value1, value2, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andTakeMedicineStateNotBetween(String value1, String value2) {
            addCriterion("take_medicine_state not between", value1, value2, "takeMedicineState");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDrugTypeIsNull() {
            addCriterion("drug_type is null");
            return (Criteria) this;
        }

        public Criteria andDrugTypeIsNotNull() {
            addCriterion("drug_type is not null");
            return (Criteria) this;
        }

        public Criteria andDrugTypeEqualTo(String value) {
            addCriterion("drug_type =", value, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeNotEqualTo(String value) {
            addCriterion("drug_type <>", value, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeGreaterThan(String value) {
            addCriterion("drug_type >", value, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeGreaterThanOrEqualTo(String value) {
            addCriterion("drug_type >=", value, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeLessThan(String value) {
            addCriterion("drug_type <", value, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeLessThanOrEqualTo(String value) {
            addCriterion("drug_type <=", value, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeLike(String value) {
            addCriterion("drug_type like", value, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeNotLike(String value) {
            addCriterion("drug_type not like", value, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeIn(List<String> values) {
            addCriterion("drug_type in", values, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeNotIn(List<String> values) {
            addCriterion("drug_type not in", values, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeBetween(String value1, String value2) {
            addCriterion("drug_type between", value1, value2, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugTypeNotBetween(String value1, String value2) {
            addCriterion("drug_type not between", value1, value2, "drugType");
            return (Criteria) this;
        }

        public Criteria andDrugFormatIsNull() {
            addCriterion("drug_format is null");
            return (Criteria) this;
        }

        public Criteria andDrugFormatIsNotNull() {
            addCriterion("drug_format is not null");
            return (Criteria) this;
        }

        public Criteria andDrugFormatEqualTo(String value) {
            addCriterion("drug_format =", value, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatNotEqualTo(String value) {
            addCriterion("drug_format <>", value, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatGreaterThan(String value) {
            addCriterion("drug_format >", value, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatGreaterThanOrEqualTo(String value) {
            addCriterion("drug_format >=", value, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatLessThan(String value) {
            addCriterion("drug_format <", value, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatLessThanOrEqualTo(String value) {
            addCriterion("drug_format <=", value, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatLike(String value) {
            addCriterion("drug_format like", value, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatNotLike(String value) {
            addCriterion("drug_format not like", value, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatIn(List<String> values) {
            addCriterion("drug_format in", values, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatNotIn(List<String> values) {
            addCriterion("drug_format not in", values, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatBetween(String value1, String value2) {
            addCriterion("drug_format between", value1, value2, "drugFormat");
            return (Criteria) this;
        }

        public Criteria andDrugFormatNotBetween(String value1, String value2) {
            addCriterion("drug_format not between", value1, value2, "drugFormat");
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

        public Criteria andDrugPriceIsNull() {
            addCriterion("drug_price is null");
            return (Criteria) this;
        }

        public Criteria andDrugPriceIsNotNull() {
            addCriterion("drug_price is not null");
            return (Criteria) this;
        }

        public Criteria andDrugPriceEqualTo(BigDecimal value) {
            addCriterion("drug_price =", value, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceNotEqualTo(BigDecimal value) {
            addCriterion("drug_price <>", value, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceGreaterThan(BigDecimal value) {
            addCriterion("drug_price >", value, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("drug_price >=", value, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceLessThan(BigDecimal value) {
            addCriterion("drug_price <", value, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("drug_price <=", value, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceIn(List<BigDecimal> values) {
            addCriterion("drug_price in", values, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceNotIn(List<BigDecimal> values) {
            addCriterion("drug_price not in", values, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drug_price between", value1, value2, "drugPrice");
            return (Criteria) this;
        }

        public Criteria andDrugPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drug_price not between", value1, value2, "drugPrice");
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