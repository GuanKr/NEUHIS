package neu.his.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckDayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckDayExample() {
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

        public Criteria andTollCollectorIdIsNull() {
            addCriterion("toll_collector_id is null");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdIsNotNull() {
            addCriterion("toll_collector_id is not null");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdEqualTo(Integer value) {
            addCriterion("toll_collector_id =", value, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdNotEqualTo(Integer value) {
            addCriterion("toll_collector_id <>", value, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdGreaterThan(Integer value) {
            addCriterion("toll_collector_id >", value, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("toll_collector_id >=", value, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdLessThan(Integer value) {
            addCriterion("toll_collector_id <", value, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdLessThanOrEqualTo(Integer value) {
            addCriterion("toll_collector_id <=", value, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdIn(List<Integer> values) {
            addCriterion("toll_collector_id in", values, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdNotIn(List<Integer> values) {
            addCriterion("toll_collector_id not in", values, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdBetween(Integer value1, Integer value2) {
            addCriterion("toll_collector_id between", value1, value2, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andTollCollectorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("toll_collector_id not between", value1, value2, "tollCollectorId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andApproveIsNull() {
            addCriterion("approve is null");
            return (Criteria) this;
        }

        public Criteria andApproveIsNotNull() {
            addCriterion("approve is not null");
            return (Criteria) this;
        }

        public Criteria andApproveEqualTo(String value) {
            addCriterion("approve =", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotEqualTo(String value) {
            addCriterion("approve <>", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThan(String value) {
            addCriterion("approve >", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThanOrEqualTo(String value) {
            addCriterion("approve >=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThan(String value) {
            addCriterion("approve <", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThanOrEqualTo(String value) {
            addCriterion("approve <=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLike(String value) {
            addCriterion("approve like", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotLike(String value) {
            addCriterion("approve not like", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveIn(List<String> values) {
            addCriterion("approve in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotIn(List<String> values) {
            addCriterion("approve not in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveBetween(String value1, String value2) {
            addCriterion("approve between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotBetween(String value1, String value2) {
            addCriterion("approve not between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeIsNull() {
            addCriterion("check_day_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeIsNotNull() {
            addCriterion("check_day_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeEqualTo(Date value) {
            addCriterion("check_day_time =", value, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeNotEqualTo(Date value) {
            addCriterion("check_day_time <>", value, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeGreaterThan(Date value) {
            addCriterion("check_day_time >", value, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_day_time >=", value, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeLessThan(Date value) {
            addCriterion("check_day_time <", value, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_day_time <=", value, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeIn(List<Date> values) {
            addCriterion("check_day_time in", values, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeNotIn(List<Date> values) {
            addCriterion("check_day_time not in", values, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeBetween(Date value1, Date value2) {
            addCriterion("check_day_time between", value1, value2, "checkDayTime");
            return (Criteria) this;
        }

        public Criteria andCheckDayTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_day_time not between", value1, value2, "checkDayTime");
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