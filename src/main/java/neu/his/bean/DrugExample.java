package neu.his.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugExample() {
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

        public Criteria andDrugCodeIsNull() {
            addCriterion("drug_code is null");
            return (Criteria) this;
        }

        public Criteria andDrugCodeIsNotNull() {
            addCriterion("drug_code is not null");
            return (Criteria) this;
        }

        public Criteria andDrugCodeEqualTo(String value) {
            addCriterion("drug_code =", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeNotEqualTo(String value) {
            addCriterion("drug_code <>", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeGreaterThan(String value) {
            addCriterion("drug_code >", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeGreaterThanOrEqualTo(String value) {
            addCriterion("drug_code >=", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeLessThan(String value) {
            addCriterion("drug_code <", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeLessThanOrEqualTo(String value) {
            addCriterion("drug_code <=", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeLike(String value) {
            addCriterion("drug_code like", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeNotLike(String value) {
            addCriterion("drug_code not like", value, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeIn(List<String> values) {
            addCriterion("drug_code in", values, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeNotIn(List<String> values) {
            addCriterion("drug_code not in", values, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeBetween(String value1, String value2) {
            addCriterion("drug_code between", value1, value2, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugCodeNotBetween(String value1, String value2) {
            addCriterion("drug_code not between", value1, value2, "drugCode");
            return (Criteria) this;
        }

        public Criteria andDrugNameIsNull() {
            addCriterion("drug_name is null");
            return (Criteria) this;
        }

        public Criteria andDrugNameIsNotNull() {
            addCriterion("drug_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrugNameEqualTo(String value) {
            addCriterion("drug_name =", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotEqualTo(String value) {
            addCriterion("drug_name <>", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThan(String value) {
            addCriterion("drug_name >", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThanOrEqualTo(String value) {
            addCriterion("drug_name >=", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThan(String value) {
            addCriterion("drug_name <", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThanOrEqualTo(String value) {
            addCriterion("drug_name <=", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLike(String value) {
            addCriterion("drug_name like", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotLike(String value) {
            addCriterion("drug_name not like", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameIn(List<String> values) {
            addCriterion("drug_name in", values, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotIn(List<String> values) {
            addCriterion("drug_name not in", values, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameBetween(String value1, String value2) {
            addCriterion("drug_name between", value1, value2, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotBetween(String value1, String value2) {
            addCriterion("drug_name not between", value1, value2, "drugName");
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

        public Criteria andDrugUnitIsNull() {
            addCriterion("drug_unit is null");
            return (Criteria) this;
        }

        public Criteria andDrugUnitIsNotNull() {
            addCriterion("drug_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDrugUnitEqualTo(String value) {
            addCriterion("drug_unit =", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitNotEqualTo(String value) {
            addCriterion("drug_unit <>", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitGreaterThan(String value) {
            addCriterion("drug_unit >", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitGreaterThanOrEqualTo(String value) {
            addCriterion("drug_unit >=", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitLessThan(String value) {
            addCriterion("drug_unit <", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitLessThanOrEqualTo(String value) {
            addCriterion("drug_unit <=", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitLike(String value) {
            addCriterion("drug_unit like", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitNotLike(String value) {
            addCriterion("drug_unit not like", value, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitIn(List<String> values) {
            addCriterion("drug_unit in", values, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitNotIn(List<String> values) {
            addCriterion("drug_unit not in", values, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitBetween(String value1, String value2) {
            addCriterion("drug_unit between", value1, value2, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andDrugUnitNotBetween(String value1, String value2) {
            addCriterion("drug_unit not between", value1, value2, "drugUnit");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
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

        public Criteria andDrugDosageEqualTo(String value) {
            addCriterion("drug_dosage =", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageNotEqualTo(String value) {
            addCriterion("drug_dosage <>", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageGreaterThan(String value) {
            addCriterion("drug_dosage >", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageGreaterThanOrEqualTo(String value) {
            addCriterion("drug_dosage >=", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageLessThan(String value) {
            addCriterion("drug_dosage <", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageLessThanOrEqualTo(String value) {
            addCriterion("drug_dosage <=", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageLike(String value) {
            addCriterion("drug_dosage like", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageNotLike(String value) {
            addCriterion("drug_dosage not like", value, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageIn(List<String> values) {
            addCriterion("drug_dosage in", values, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageNotIn(List<String> values) {
            addCriterion("drug_dosage not in", values, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageBetween(String value1, String value2) {
            addCriterion("drug_dosage between", value1, value2, "drugDosage");
            return (Criteria) this;
        }

        public Criteria andDrugDosageNotBetween(String value1, String value2) {
            addCriterion("drug_dosage not between", value1, value2, "drugDosage");
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

        public Criteria andMnemonicCodeIsNull() {
            addCriterion("mnemonic_code is null");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeIsNotNull() {
            addCriterion("mnemonic_code is not null");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeEqualTo(String value) {
            addCriterion("mnemonic_code =", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeNotEqualTo(String value) {
            addCriterion("mnemonic_code <>", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeGreaterThan(String value) {
            addCriterion("mnemonic_code >", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("mnemonic_code >=", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeLessThan(String value) {
            addCriterion("mnemonic_code <", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeLessThanOrEqualTo(String value) {
            addCriterion("mnemonic_code <=", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeLike(String value) {
            addCriterion("mnemonic_code like", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeNotLike(String value) {
            addCriterion("mnemonic_code not like", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeIn(List<String> values) {
            addCriterion("mnemonic_code in", values, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeNotIn(List<String> values) {
            addCriterion("mnemonic_code not in", values, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeBetween(String value1, String value2) {
            addCriterion("mnemonic_code between", value1, value2, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeNotBetween(String value1, String value2) {
            addCriterion("mnemonic_code not between", value1, value2, "mnemonicCode");
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