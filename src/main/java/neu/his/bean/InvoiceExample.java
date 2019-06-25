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

        public Criteria andPatientNameIsNull() {
            addCriterion("patient_name is null");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNotNull() {
            addCriterion("patient_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatientNameEqualTo(String value) {
            addCriterion("patient_name =", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotEqualTo(String value) {
            addCriterion("patient_name <>", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThan(String value) {
            addCriterion("patient_name >", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThanOrEqualTo(String value) {
            addCriterion("patient_name >=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThan(String value) {
            addCriterion("patient_name <", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThanOrEqualTo(String value) {
            addCriterion("patient_name <=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLike(String value) {
            addCriterion("patient_name like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotLike(String value) {
            addCriterion("patient_name not like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameIn(List<String> values) {
            addCriterion("patient_name in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotIn(List<String> values) {
            addCriterion("patient_name not in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameBetween(String value1, String value2) {
            addCriterion("patient_name between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotBetween(String value1, String value2) {
            addCriterion("patient_name not between", value1, value2, "patientName");
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

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
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

        public Criteria andDoctorNameIsNull() {
            addCriterion("doctor_name is null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNotNull() {
            addCriterion("doctor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameEqualTo(String value) {
            addCriterion("doctor_name =", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotEqualTo(String value) {
            addCriterion("doctor_name <>", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThan(String value) {
            addCriterion("doctor_name >", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_name >=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThan(String value) {
            addCriterion("doctor_name <", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanOrEqualTo(String value) {
            addCriterion("doctor_name <=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLike(String value) {
            addCriterion("doctor_name like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotLike(String value) {
            addCriterion("doctor_name not like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIn(List<String> values) {
            addCriterion("doctor_name in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotIn(List<String> values) {
            addCriterion("doctor_name not in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameBetween(String value1, String value2) {
            addCriterion("doctor_name between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotBetween(String value1, String value2) {
            addCriterion("doctor_name not between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameIsNull() {
            addCriterion("executive_department_name is null");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameIsNotNull() {
            addCriterion("executive_department_name is not null");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameEqualTo(String value) {
            addCriterion("executive_department_name =", value, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameNotEqualTo(String value) {
            addCriterion("executive_department_name <>", value, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameGreaterThan(String value) {
            addCriterion("executive_department_name >", value, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("executive_department_name >=", value, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameLessThan(String value) {
            addCriterion("executive_department_name <", value, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("executive_department_name <=", value, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameLike(String value) {
            addCriterion("executive_department_name like", value, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameNotLike(String value) {
            addCriterion("executive_department_name not like", value, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameIn(List<String> values) {
            addCriterion("executive_department_name in", values, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameNotIn(List<String> values) {
            addCriterion("executive_department_name not in", values, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameBetween(String value1, String value2) {
            addCriterion("executive_department_name between", value1, value2, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andExecutiveDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("executive_department_name not between", value1, value2, "executiveDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameIsNull() {
            addCriterion("draw_bill_department_name is null");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameIsNotNull() {
            addCriterion("draw_bill_department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameEqualTo(String value) {
            addCriterion("draw_bill_department_name =", value, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameNotEqualTo(String value) {
            addCriterion("draw_bill_department_name <>", value, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameGreaterThan(String value) {
            addCriterion("draw_bill_department_name >", value, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("draw_bill_department_name >=", value, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameLessThan(String value) {
            addCriterion("draw_bill_department_name <", value, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("draw_bill_department_name <=", value, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameLike(String value) {
            addCriterion("draw_bill_department_name like", value, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameNotLike(String value) {
            addCriterion("draw_bill_department_name not like", value, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameIn(List<String> values) {
            addCriterion("draw_bill_department_name in", values, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameNotIn(List<String> values) {
            addCriterion("draw_bill_department_name not in", values, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameBetween(String value1, String value2) {
            addCriterion("draw_bill_department_name between", value1, value2, "drawBillDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDrawBillDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("draw_bill_department_name not between", value1, value2, "drawBillDepartmentName");
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