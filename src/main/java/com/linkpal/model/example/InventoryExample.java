package com.linkpal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryExample() {
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

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFmaidIsNull() {
            addCriterion("fmaid is null");
            return (Criteria) this;
        }

        public Criteria andFmaidIsNotNull() {
            addCriterion("fmaid is not null");
            return (Criteria) this;
        }

        public Criteria andFmaidEqualTo(Integer value) {
            addCriterion("fmaid =", value, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidNotEqualTo(Integer value) {
            addCriterion("fmaid <>", value, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidGreaterThan(Integer value) {
            addCriterion("fmaid >", value, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fmaid >=", value, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidLessThan(Integer value) {
            addCriterion("fmaid <", value, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidLessThanOrEqualTo(Integer value) {
            addCriterion("fmaid <=", value, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidIn(List<Integer> values) {
            addCriterion("fmaid in", values, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidNotIn(List<Integer> values) {
            addCriterion("fmaid not in", values, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidBetween(Integer value1, Integer value2) {
            addCriterion("fmaid between", value1, value2, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFmaidNotBetween(Integer value1, Integer value2) {
            addCriterion("fmaid not between", value1, value2, "fmaid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidIsNull() {
            addCriterion("fgoodseatid is null");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidIsNotNull() {
            addCriterion("fgoodseatid is not null");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidEqualTo(Integer value) {
            addCriterion("fgoodseatid =", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidNotEqualTo(Integer value) {
            addCriterion("fgoodseatid <>", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidGreaterThan(Integer value) {
            addCriterion("fgoodseatid >", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fgoodseatid >=", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidLessThan(Integer value) {
            addCriterion("fgoodseatid <", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidLessThanOrEqualTo(Integer value) {
            addCriterion("fgoodseatid <=", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidIn(List<Integer> values) {
            addCriterion("fgoodseatid in", values, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidNotIn(List<Integer> values) {
            addCriterion("fgoodseatid not in", values, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidBetween(Integer value1, Integer value2) {
            addCriterion("fgoodseatid between", value1, value2, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidNotBetween(Integer value1, Integer value2) {
            addCriterion("fgoodseatid not between", value1, value2, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFstockidIsNull() {
            addCriterion("fstockid is null");
            return (Criteria) this;
        }

        public Criteria andFstockidIsNotNull() {
            addCriterion("fstockid is not null");
            return (Criteria) this;
        }

        public Criteria andFstockidEqualTo(Integer value) {
            addCriterion("fstockid =", value, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidNotEqualTo(Integer value) {
            addCriterion("fstockid <>", value, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidGreaterThan(Integer value) {
            addCriterion("fstockid >", value, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fstockid >=", value, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidLessThan(Integer value) {
            addCriterion("fstockid <", value, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidLessThanOrEqualTo(Integer value) {
            addCriterion("fstockid <=", value, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidIn(List<Integer> values) {
            addCriterion("fstockid in", values, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidNotIn(List<Integer> values) {
            addCriterion("fstockid not in", values, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidBetween(Integer value1, Integer value2) {
            addCriterion("fstockid between", value1, value2, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFstockidNotBetween(Integer value1, Integer value2) {
            addCriterion("fstockid not between", value1, value2, "fstockid");
            return (Criteria) this;
        }

        public Criteria andFqtyIsNull() {
            addCriterion("fqty is null");
            return (Criteria) this;
        }

        public Criteria andFqtyIsNotNull() {
            addCriterion("fqty is not null");
            return (Criteria) this;
        }

        public Criteria andFqtyEqualTo(Double value) {
            addCriterion("fqty =", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyNotEqualTo(Double value) {
            addCriterion("fqty <>", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyGreaterThan(Double value) {
            addCriterion("fqty >", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("fqty >=", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyLessThan(Double value) {
            addCriterion("fqty <", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyLessThanOrEqualTo(Double value) {
            addCriterion("fqty <=", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyIn(List<Double> values) {
            addCriterion("fqty in", values, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyNotIn(List<Double> values) {
            addCriterion("fqty not in", values, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyBetween(Double value1, Double value2) {
            addCriterion("fqty between", value1, value2, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyNotBetween(Double value1, Double value2) {
            addCriterion("fqty not between", value1, value2, "fqty");
            return (Criteria) this;
        }

        public Criteria andFdateIsNull() {
            addCriterion("fdate is null");
            return (Criteria) this;
        }

        public Criteria andFdateIsNotNull() {
            addCriterion("fdate is not null");
            return (Criteria) this;
        }

        public Criteria andFdateEqualTo(Date value) {
            addCriterion("fdate =", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotEqualTo(Date value) {
            addCriterion("fdate <>", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThan(Date value) {
            addCriterion("fdate >", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThanOrEqualTo(Date value) {
            addCriterion("fdate >=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThan(Date value) {
            addCriterion("fdate <", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThanOrEqualTo(Date value) {
            addCriterion("fdate <=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateIn(List<Date> values) {
            addCriterion("fdate in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotIn(List<Date> values) {
            addCriterion("fdate not in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateBetween(Date value1, Date value2) {
            addCriterion("fdate between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotBetween(Date value1, Date value2) {
            addCriterion("fdate not between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFmdateIsNull() {
            addCriterion("fmdate is null");
            return (Criteria) this;
        }

        public Criteria andFmdateIsNotNull() {
            addCriterion("fmdate is not null");
            return (Criteria) this;
        }

        public Criteria andFmdateEqualTo(Date value) {
            addCriterion("fmdate =", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateNotEqualTo(Date value) {
            addCriterion("fmdate <>", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateGreaterThan(Date value) {
            addCriterion("fmdate >", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateGreaterThanOrEqualTo(Date value) {
            addCriterion("fmdate >=", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateLessThan(Date value) {
            addCriterion("fmdate <", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateLessThanOrEqualTo(Date value) {
            addCriterion("fmdate <=", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateIn(List<Date> values) {
            addCriterion("fmdate in", values, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateNotIn(List<Date> values) {
            addCriterion("fmdate not in", values, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateBetween(Date value1, Date value2) {
            addCriterion("fmdate between", value1, value2, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateNotBetween(Date value1, Date value2) {
            addCriterion("fmdate not between", value1, value2, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFgperiodIsNull() {
            addCriterion("fgperiod is null");
            return (Criteria) this;
        }

        public Criteria andFgperiodIsNotNull() {
            addCriterion("fgperiod is not null");
            return (Criteria) this;
        }

        public Criteria andFgperiodEqualTo(Double value) {
            addCriterion("fgperiod =", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodNotEqualTo(Double value) {
            addCriterion("fgperiod <>", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodGreaterThan(Double value) {
            addCriterion("fgperiod >", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodGreaterThanOrEqualTo(Double value) {
            addCriterion("fgperiod >=", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodLessThan(Double value) {
            addCriterion("fgperiod <", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodLessThanOrEqualTo(Double value) {
            addCriterion("fgperiod <=", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodIn(List<Double> values) {
            addCriterion("fgperiod in", values, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodNotIn(List<Double> values) {
            addCriterion("fgperiod not in", values, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodBetween(Double value1, Double value2) {
            addCriterion("fgperiod between", value1, value2, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodNotBetween(Double value1, Double value2) {
            addCriterion("fgperiod not between", value1, value2, "fgperiod");
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