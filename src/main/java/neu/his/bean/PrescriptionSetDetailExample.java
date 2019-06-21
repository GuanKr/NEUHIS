package neu.his.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionSetDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionSetDetailExample() {
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

        public Criteria andPrescriptionSetIdIsNull() {
            addCriterion("prescription_set_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdIsNotNull() {
            addCriterion("prescription_set_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdEqualTo(Integer value) {
            addCriterion("prescription_set_id =", value, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdNotEqualTo(Integer value) {
            addCriterion("prescription_set_id <>", value, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdGreaterThan(Integer value) {
            addCriterion("prescription_set_id >", value, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prescription_set_id >=", value, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdLessThan(Integer value) {
            addCriterion("prescription_set_id <", value, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdLessThanOrEqualTo(Integer value) {
            addCriterion("prescription_set_id <=", value, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdIn(List<Integer> values) {
            addCriterion("prescription_set_id in", values, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdNotIn(List<Integer> values) {
            addCriterion("prescription_set_id not in", values, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdBetween(Integer value1, Integer value2) {
            addCriterion("prescription_set_id between", value1, value2, "prescriptionSetId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prescription_set_id not between", value1, value2, "prescriptionSetId");
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