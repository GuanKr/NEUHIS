package neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedicalRecordExample() {
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

        public Criteria andChiefComplaintIsNull() {
            addCriterion("chief_complaint is null");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintIsNotNull() {
            addCriterion("chief_complaint is not null");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintEqualTo(String value) {
            addCriterion("chief_complaint =", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotEqualTo(String value) {
            addCriterion("chief_complaint <>", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintGreaterThan(String value) {
            addCriterion("chief_complaint >", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintGreaterThanOrEqualTo(String value) {
            addCriterion("chief_complaint >=", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLessThan(String value) {
            addCriterion("chief_complaint <", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLessThanOrEqualTo(String value) {
            addCriterion("chief_complaint <=", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLike(String value) {
            addCriterion("chief_complaint like", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotLike(String value) {
            addCriterion("chief_complaint not like", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintIn(List<String> values) {
            addCriterion("chief_complaint in", values, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotIn(List<String> values) {
            addCriterion("chief_complaint not in", values, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintBetween(String value1, String value2) {
            addCriterion("chief_complaint between", value1, value2, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotBetween(String value1, String value2) {
            addCriterion("chief_complaint not between", value1, value2, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessIsNull() {
            addCriterion("history_of_present_illness is null");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessIsNotNull() {
            addCriterion("history_of_present_illness is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessEqualTo(String value) {
            addCriterion("history_of_present_illness =", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessNotEqualTo(String value) {
            addCriterion("history_of_present_illness <>", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessGreaterThan(String value) {
            addCriterion("history_of_present_illness >", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessGreaterThanOrEqualTo(String value) {
            addCriterion("history_of_present_illness >=", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessLessThan(String value) {
            addCriterion("history_of_present_illness <", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessLessThanOrEqualTo(String value) {
            addCriterion("history_of_present_illness <=", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessLike(String value) {
            addCriterion("history_of_present_illness like", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessNotLike(String value) {
            addCriterion("history_of_present_illness not like", value, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessIn(List<String> values) {
            addCriterion("history_of_present_illness in", values, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessNotIn(List<String> values) {
            addCriterion("history_of_present_illness not in", values, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessBetween(String value1, String value2) {
            addCriterion("history_of_present_illness between", value1, value2, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andHistoryOfPresentIllnessNotBetween(String value1, String value2) {
            addCriterion("history_of_present_illness not between", value1, value2, "historyOfPresentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessIsNull() {
            addCriterion("treatment_of_current_illness is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessIsNotNull() {
            addCriterion("treatment_of_current_illness is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessEqualTo(String value) {
            addCriterion("treatment_of_current_illness =", value, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessNotEqualTo(String value) {
            addCriterion("treatment_of_current_illness <>", value, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessGreaterThan(String value) {
            addCriterion("treatment_of_current_illness >", value, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessGreaterThanOrEqualTo(String value) {
            addCriterion("treatment_of_current_illness >=", value, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessLessThan(String value) {
            addCriterion("treatment_of_current_illness <", value, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessLessThanOrEqualTo(String value) {
            addCriterion("treatment_of_current_illness <=", value, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessLike(String value) {
            addCriterion("treatment_of_current_illness like", value, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessNotLike(String value) {
            addCriterion("treatment_of_current_illness not like", value, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessIn(List<String> values) {
            addCriterion("treatment_of_current_illness in", values, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessNotIn(List<String> values) {
            addCriterion("treatment_of_current_illness not in", values, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessBetween(String value1, String value2) {
            addCriterion("treatment_of_current_illness between", value1, value2, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andTreatmentOfCurrentIllnessNotBetween(String value1, String value2) {
            addCriterion("treatment_of_current_illness not between", value1, value2, "treatmentOfCurrentIllness");
            return (Criteria) this;
        }

        public Criteria andPastHistoryIsNull() {
            addCriterion("past_history is null");
            return (Criteria) this;
        }

        public Criteria andPastHistoryIsNotNull() {
            addCriterion("past_history is not null");
            return (Criteria) this;
        }

        public Criteria andPastHistoryEqualTo(String value) {
            addCriterion("past_history =", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryNotEqualTo(String value) {
            addCriterion("past_history <>", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryGreaterThan(String value) {
            addCriterion("past_history >", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("past_history >=", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryLessThan(String value) {
            addCriterion("past_history <", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryLessThanOrEqualTo(String value) {
            addCriterion("past_history <=", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryLike(String value) {
            addCriterion("past_history like", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryNotLike(String value) {
            addCriterion("past_history not like", value, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryIn(List<String> values) {
            addCriterion("past_history in", values, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryNotIn(List<String> values) {
            addCriterion("past_history not in", values, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryBetween(String value1, String value2) {
            addCriterion("past_history between", value1, value2, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andPastHistoryNotBetween(String value1, String value2) {
            addCriterion("past_history not between", value1, value2, "pastHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryIsNull() {
            addCriterion("allergy_history is null");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryIsNotNull() {
            addCriterion("allergy_history is not null");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryEqualTo(String value) {
            addCriterion("allergy_history =", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryNotEqualTo(String value) {
            addCriterion("allergy_history <>", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryGreaterThan(String value) {
            addCriterion("allergy_history >", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("allergy_history >=", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryLessThan(String value) {
            addCriterion("allergy_history <", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryLessThanOrEqualTo(String value) {
            addCriterion("allergy_history <=", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryLike(String value) {
            addCriterion("allergy_history like", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryNotLike(String value) {
            addCriterion("allergy_history not like", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryIn(List<String> values) {
            addCriterion("allergy_history in", values, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryNotIn(List<String> values) {
            addCriterion("allergy_history not in", values, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryBetween(String value1, String value2) {
            addCriterion("allergy_history between", value1, value2, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryNotBetween(String value1, String value2) {
            addCriterion("allergy_history not between", value1, value2, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationIsNull() {
            addCriterion("physical_examination is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationIsNotNull() {
            addCriterion("physical_examination is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationEqualTo(String value) {
            addCriterion("physical_examination =", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationNotEqualTo(String value) {
            addCriterion("physical_examination <>", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationGreaterThan(String value) {
            addCriterion("physical_examination >", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationGreaterThanOrEqualTo(String value) {
            addCriterion("physical_examination >=", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationLessThan(String value) {
            addCriterion("physical_examination <", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationLessThanOrEqualTo(String value) {
            addCriterion("physical_examination <=", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationLike(String value) {
            addCriterion("physical_examination like", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationNotLike(String value) {
            addCriterion("physical_examination not like", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationIn(List<String> values) {
            addCriterion("physical_examination in", values, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationNotIn(List<String> values) {
            addCriterion("physical_examination not in", values, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationBetween(String value1, String value2) {
            addCriterion("physical_examination between", value1, value2, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationNotBetween(String value1, String value2) {
            addCriterion("physical_examination not between", value1, value2, "physicalExamination");
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

        public Criteria andTemplateNameIsNull() {
            addCriterion("template_name is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("template_name is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("template_name =", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("template_name <>", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("template_name >", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("template_name >=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("template_name <", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("template_name <=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLike(String value) {
            addCriterion("template_name like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotLike(String value) {
            addCriterion("template_name not like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIn(List<String> values) {
            addCriterion("template_name in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            addCriterion("template_name not in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("template_name between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("template_name not between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andSeeTimeIsNull() {
            addCriterion("see_time is null");
            return (Criteria) this;
        }

        public Criteria andSeeTimeIsNotNull() {
            addCriterion("see_time is not null");
            return (Criteria) this;
        }

        public Criteria andSeeTimeEqualTo(Date value) {
            addCriterion("see_time =", value, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeNotEqualTo(Date value) {
            addCriterion("see_time <>", value, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeGreaterThan(Date value) {
            addCriterion("see_time >", value, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("see_time >=", value, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeLessThan(Date value) {
            addCriterion("see_time <", value, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeLessThanOrEqualTo(Date value) {
            addCriterion("see_time <=", value, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeIn(List<Date> values) {
            addCriterion("see_time in", values, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeNotIn(List<Date> values) {
            addCriterion("see_time not in", values, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeBetween(Date value1, Date value2) {
            addCriterion("see_time between", value1, value2, "seeTime");
            return (Criteria) this;
        }

        public Criteria andSeeTimeNotBetween(Date value1, Date value2) {
            addCriterion("see_time not between", value1, value2, "seeTime");
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