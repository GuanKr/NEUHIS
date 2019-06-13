package neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ScheduleInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScheduleInfoExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIsNull() {
            addCriterion("schedule_date is null");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIsNotNull() {
            addCriterion("schedule_date is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleDateEqualTo(Date value) {
            addCriterionForJDBCDate("schedule_date =", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("schedule_date <>", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateGreaterThan(Date value) {
            addCriterionForJDBCDate("schedule_date >", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("schedule_date >=", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateLessThan(Date value) {
            addCriterionForJDBCDate("schedule_date <", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("schedule_date <=", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIn(List<Date> values) {
            addCriterionForJDBCDate("schedule_date in", values, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("schedule_date not in", values, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("schedule_date between", value1, value2, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("schedule_date not between", value1, value2, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationIsNull() {
            addCriterion("bisessional_operation is null");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationIsNotNull() {
            addCriterion("bisessional_operation is not null");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationEqualTo(String value) {
            addCriterion("bisessional_operation =", value, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationNotEqualTo(String value) {
            addCriterion("bisessional_operation <>", value, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationGreaterThan(String value) {
            addCriterion("bisessional_operation >", value, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationGreaterThanOrEqualTo(String value) {
            addCriterion("bisessional_operation >=", value, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationLessThan(String value) {
            addCriterion("bisessional_operation <", value, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationLessThanOrEqualTo(String value) {
            addCriterion("bisessional_operation <=", value, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationLike(String value) {
            addCriterion("bisessional_operation like", value, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationNotLike(String value) {
            addCriterion("bisessional_operation not like", value, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationIn(List<String> values) {
            addCriterion("bisessional_operation in", values, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationNotIn(List<String> values) {
            addCriterion("bisessional_operation not in", values, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationBetween(String value1, String value2) {
            addCriterion("bisessional_operation between", value1, value2, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andBisessionalOperationNotBetween(String value1, String value2) {
            addCriterion("bisessional_operation not between", value1, value2, "bisessionalOperation");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaIsNull() {
            addCriterion("surplus_quota is null");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaIsNotNull() {
            addCriterion("surplus_quota is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaEqualTo(Integer value) {
            addCriterion("surplus_quota =", value, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaNotEqualTo(Integer value) {
            addCriterion("surplus_quota <>", value, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaGreaterThan(Integer value) {
            addCriterion("surplus_quota >", value, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("surplus_quota >=", value, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaLessThan(Integer value) {
            addCriterion("surplus_quota <", value, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("surplus_quota <=", value, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaIn(List<Integer> values) {
            addCriterion("surplus_quota in", values, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaNotIn(List<Integer> values) {
            addCriterion("surplus_quota not in", values, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaBetween(Integer value1, Integer value2) {
            addCriterion("surplus_quota between", value1, value2, "surplusQuota");
            return (Criteria) this;
        }

        public Criteria andSurplusQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("surplus_quota not between", value1, value2, "surplusQuota");
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

        public Criteria andScheduleQuotaIsNull() {
            addCriterion("schedule_quota is null");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaIsNotNull() {
            addCriterion("schedule_quota is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaEqualTo(Integer value) {
            addCriterion("schedule_quota =", value, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaNotEqualTo(Integer value) {
            addCriterion("schedule_quota <>", value, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaGreaterThan(Integer value) {
            addCriterion("schedule_quota >", value, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule_quota >=", value, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaLessThan(Integer value) {
            addCriterion("schedule_quota <", value, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("schedule_quota <=", value, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaIn(List<Integer> values) {
            addCriterion("schedule_quota in", values, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaNotIn(List<Integer> values) {
            addCriterion("schedule_quota not in", values, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaBetween(Integer value1, Integer value2) {
            addCriterion("schedule_quota between", value1, value2, "scheduleQuota");
            return (Criteria) this;
        }

        public Criteria andScheduleQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule_quota not between", value1, value2, "scheduleQuota");
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