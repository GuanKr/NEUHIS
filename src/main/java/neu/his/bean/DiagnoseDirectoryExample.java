package neu.his.bean;

import java.util.ArrayList;
import java.util.List;

public class DiagnoseDirectoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiagnoseDirectoryExample() {
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

        public Criteria andDiseaseCategoryCodeIsNull() {
            addCriterion("disease_category_code is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeIsNotNull() {
            addCriterion("disease_category_code is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeEqualTo(String value) {
            addCriterion("disease_category_code =", value, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeNotEqualTo(String value) {
            addCriterion("disease_category_code <>", value, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeGreaterThan(String value) {
            addCriterion("disease_category_code >", value, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("disease_category_code >=", value, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeLessThan(String value) {
            addCriterion("disease_category_code <", value, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("disease_category_code <=", value, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeLike(String value) {
            addCriterion("disease_category_code like", value, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeNotLike(String value) {
            addCriterion("disease_category_code not like", value, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeIn(List<String> values) {
            addCriterion("disease_category_code in", values, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeNotIn(List<String> values) {
            addCriterion("disease_category_code not in", values, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeBetween(String value1, String value2) {
            addCriterion("disease_category_code between", value1, value2, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("disease_category_code not between", value1, value2, "diseaseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameIsNull() {
            addCriterion("disease_category_name is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameIsNotNull() {
            addCriterion("disease_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameEqualTo(String value) {
            addCriterion("disease_category_name =", value, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameNotEqualTo(String value) {
            addCriterion("disease_category_name <>", value, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameGreaterThan(String value) {
            addCriterion("disease_category_name >", value, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("disease_category_name >=", value, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameLessThan(String value) {
            addCriterion("disease_category_name <", value, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("disease_category_name <=", value, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameLike(String value) {
            addCriterion("disease_category_name like", value, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameNotLike(String value) {
            addCriterion("disease_category_name not like", value, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameIn(List<String> values) {
            addCriterion("disease_category_name in", values, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameNotIn(List<String> values) {
            addCriterion("disease_category_name not in", values, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameBetween(String value1, String value2) {
            addCriterion("disease_category_name between", value1, value2, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andDiseaseCategoryNameNotBetween(String value1, String value2) {
            addCriterion("disease_category_name not between", value1, value2, "diseaseCategoryName");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIsNull() {
            addCriterion("sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIsNotNull() {
            addCriterion("sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceNoEqualTo(Integer value) {
            addCriterion("sequence_no =", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotEqualTo(Integer value) {
            addCriterion("sequence_no <>", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoGreaterThan(Integer value) {
            addCriterion("sequence_no >", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence_no >=", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoLessThan(Integer value) {
            addCriterion("sequence_no <", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("sequence_no <=", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIn(List<Integer> values) {
            addCriterion("sequence_no in", values, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotIn(List<Integer> values) {
            addCriterion("sequence_no not in", values, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("sequence_no between", value1, value2, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence_no not between", value1, value2, "sequenceNo");
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