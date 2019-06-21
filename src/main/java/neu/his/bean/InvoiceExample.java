package neu.his.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoiceExample() {
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

        public Criteria andInvoiceNoIsNull() {
            addCriterion("invoice_no is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNotNull() {
            addCriterion("invoice_no is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoEqualTo(String value) {
            addCriterion("invoice_no =", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotEqualTo(String value) {
            addCriterion("invoice_no <>", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThan(String value) {
            addCriterion("invoice_no >", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_no >=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThan(String value) {
            addCriterion("invoice_no <", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThanOrEqualTo(String value) {
            addCriterion("invoice_no <=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLike(String value) {
            addCriterion("invoice_no like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotLike(String value) {
            addCriterion("invoice_no not like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIn(List<String> values) {
            addCriterion("invoice_no in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotIn(List<String> values) {
            addCriterion("invoice_no not in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoBetween(String value1, String value2) {
            addCriterion("invoice_no between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotBetween(String value1, String value2) {
            addCriterion("invoice_no not between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNull() {
            addCriterion("cost_type is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNotNull() {
            addCriterion("cost_type is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeEqualTo(String value) {
            addCriterion("cost_type =", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotEqualTo(String value) {
            addCriterion("cost_type <>", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThan(String value) {
            addCriterion("cost_type >", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cost_type >=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThan(String value) {
            addCriterion("cost_type <", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThanOrEqualTo(String value) {
            addCriterion("cost_type <=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLike(String value) {
            addCriterion("cost_type like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotLike(String value) {
            addCriterion("cost_type not like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeIn(List<String> values) {
            addCriterion("cost_type in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotIn(List<String> values) {
            addCriterion("cost_type not in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeBetween(String value1, String value2) {
            addCriterion("cost_type between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotBetween(String value1, String value2) {
            addCriterion("cost_type not between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdIsNull() {
            addCriterion("cost_type_id is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdIsNotNull() {
            addCriterion("cost_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdEqualTo(Integer value) {
            addCriterion("cost_type_id =", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdNotEqualTo(Integer value) {
            addCriterion("cost_type_id <>", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdGreaterThan(Integer value) {
            addCriterion("cost_type_id >", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost_type_id >=", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdLessThan(Integer value) {
            addCriterion("cost_type_id <", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("cost_type_id <=", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdIn(List<Integer> values) {
            addCriterion("cost_type_id in", values, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdNotIn(List<Integer> values) {
            addCriterion("cost_type_id not in", values, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("cost_type_id between", value1, value2, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cost_type_id not between", value1, value2, "costTypeId");
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

        public Criteria andReceivableIsNull() {
            addCriterion("receivable is null");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNotNull() {
            addCriterion("receivable is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableEqualTo(BigDecimal value) {
            addCriterion("receivable =", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotEqualTo(BigDecimal value) {
            addCriterion("receivable <>", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThan(BigDecimal value) {
            addCriterion("receivable >", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable >=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThan(BigDecimal value) {
            addCriterion("receivable <", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable <=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableIn(List<BigDecimal> values) {
            addCriterion("receivable in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotIn(List<BigDecimal> values) {
            addCriterion("receivable not in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable not between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andNetReceiptIsNull() {
            addCriterion("\"net receipt\" is null");
            return (Criteria) this;
        }

        public Criteria andNetReceiptIsNotNull() {
            addCriterion("\"net receipt\" is not null");
            return (Criteria) this;
        }

        public Criteria andNetReceiptEqualTo(BigDecimal value) {
            addCriterion("\"net receipt\" =", value, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptNotEqualTo(BigDecimal value) {
            addCriterion("\"net receipt\" <>", value, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptGreaterThan(BigDecimal value) {
            addCriterion("\"net receipt\" >", value, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("\"net receipt\" >=", value, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptLessThan(BigDecimal value) {
            addCriterion("\"net receipt\" <", value, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptLessThanOrEqualTo(BigDecimal value) {
            addCriterion("\"net receipt\" <=", value, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptIn(List<BigDecimal> values) {
            addCriterion("\"net receipt\" in", values, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptNotIn(List<BigDecimal> values) {
            addCriterion("\"net receipt\" not in", values, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("\"net receipt\" between", value1, value2, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andNetReceiptNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("\"net receipt\" not between", value1, value2, "netReceipt");
            return (Criteria) this;
        }

        public Criteria andChngeIsNull() {
            addCriterion("chnge is null");
            return (Criteria) this;
        }

        public Criteria andChngeIsNotNull() {
            addCriterion("chnge is not null");
            return (Criteria) this;
        }

        public Criteria andChngeEqualTo(BigDecimal value) {
            addCriterion("chnge =", value, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeNotEqualTo(BigDecimal value) {
            addCriterion("chnge <>", value, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeGreaterThan(BigDecimal value) {
            addCriterion("chnge >", value, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("chnge >=", value, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeLessThan(BigDecimal value) {
            addCriterion("chnge <", value, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("chnge <=", value, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeIn(List<BigDecimal> values) {
            addCriterion("chnge in", values, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeNotIn(List<BigDecimal> values) {
            addCriterion("chnge not in", values, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("chnge between", value1, value2, "chnge");
            return (Criteria) this;
        }

        public Criteria andChngeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("chnge not between", value1, value2, "chnge");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeIsNull() {
            addCriterion("invoice_time is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeIsNotNull() {
            addCriterion("invoice_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeEqualTo(Date value) {
            addCriterion("invoice_time =", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeNotEqualTo(Date value) {
            addCriterion("invoice_time <>", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeGreaterThan(Date value) {
            addCriterion("invoice_time >", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invoice_time >=", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeLessThan(Date value) {
            addCriterion("invoice_time <", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeLessThanOrEqualTo(Date value) {
            addCriterion("invoice_time <=", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeIn(List<Date> values) {
            addCriterion("invoice_time in", values, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeNotIn(List<Date> values) {
            addCriterion("invoice_time not in", values, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeBetween(Date value1, Date value2) {
            addCriterion("invoice_time between", value1, value2, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeNotBetween(Date value1, Date value2) {
            addCriterion("invoice_time not between", value1, value2, "invoiceTime");
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