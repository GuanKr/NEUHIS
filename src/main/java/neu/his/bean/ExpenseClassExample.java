package neu.his.bean;

import java.util.ArrayList;
import java.util.List;

public class ExpenseClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenseClassExample() {
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

        public Criteria andExpenseCodeIsNull() {
            addCriterion("expense_code is null");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeIsNotNull() {
            addCriterion("expense_code is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeEqualTo(String value) {
            addCriterion("expense_code =", value, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeNotEqualTo(String value) {
            addCriterion("expense_code <>", value, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeGreaterThan(String value) {
            addCriterion("expense_code >", value, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("expense_code >=", value, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeLessThan(String value) {
            addCriterion("expense_code <", value, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeLessThanOrEqualTo(String value) {
            addCriterion("expense_code <=", value, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeLike(String value) {
            addCriterion("expense_code like", value, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeNotLike(String value) {
            addCriterion("expense_code not like", value, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeIn(List<String> values) {
            addCriterion("expense_code in", values, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeNotIn(List<String> values) {
            addCriterion("expense_code not in", values, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeBetween(String value1, String value2) {
            addCriterion("expense_code between", value1, value2, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCodeNotBetween(String value1, String value2) {
            addCriterion("expense_code not between", value1, value2, "expenseCode");
            return (Criteria) this;
        }

        public Criteria andExpenseNameIsNull() {
            addCriterion("expense_name is null");
            return (Criteria) this;
        }

        public Criteria andExpenseNameIsNotNull() {
            addCriterion("expense_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseNameEqualTo(String value) {
            addCriterion("expense_name =", value, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameNotEqualTo(String value) {
            addCriterion("expense_name <>", value, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameGreaterThan(String value) {
            addCriterion("expense_name >", value, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameGreaterThanOrEqualTo(String value) {
            addCriterion("expense_name >=", value, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameLessThan(String value) {
            addCriterion("expense_name <", value, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameLessThanOrEqualTo(String value) {
            addCriterion("expense_name <=", value, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameLike(String value) {
            addCriterion("expense_name like", value, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameNotLike(String value) {
            addCriterion("expense_name not like", value, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameIn(List<String> values) {
            addCriterion("expense_name in", values, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameNotIn(List<String> values) {
            addCriterion("expense_name not in", values, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameBetween(String value1, String value2) {
            addCriterion("expense_name between", value1, value2, "expenseName");
            return (Criteria) this;
        }

        public Criteria andExpenseNameNotBetween(String value1, String value2) {
            addCriterion("expense_name not between", value1, value2, "expenseName");
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