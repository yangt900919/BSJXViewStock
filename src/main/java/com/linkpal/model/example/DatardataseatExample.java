package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatardataseatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatardataseatExample() {
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
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFdataidIsNull() {
            addCriterion("FDataID is null");
            return (Criteria) this;
        }

        public Criteria andFdataidIsNotNull() {
            addCriterion("FDataID is not null");
            return (Criteria) this;
        }

        public Criteria andFdataidEqualTo(Integer value) {
            addCriterion("FDataID =", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidNotEqualTo(Integer value) {
            addCriterion("FDataID <>", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidGreaterThan(Integer value) {
            addCriterion("FDataID >", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FDataID >=", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidLessThan(Integer value) {
            addCriterion("FDataID <", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidLessThanOrEqualTo(Integer value) {
            addCriterion("FDataID <=", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidIn(List<Integer> values) {
            addCriterion("FDataID in", values, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidNotIn(List<Integer> values) {
            addCriterion("FDataID not in", values, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidBetween(Integer value1, Integer value2) {
            addCriterion("FDataID between", value1, value2, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidNotBetween(Integer value1, Integer value2) {
            addCriterion("FDataID not between", value1, value2, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidIsNull() {
            addCriterion("FDataSeatID is null");
            return (Criteria) this;
        }

        public Criteria andFdataseatidIsNotNull() {
            addCriterion("FDataSeatID is not null");
            return (Criteria) this;
        }

        public Criteria andFdataseatidEqualTo(Integer value) {
            addCriterion("FDataSeatID =", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidNotEqualTo(Integer value) {
            addCriterion("FDataSeatID <>", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidGreaterThan(Integer value) {
            addCriterion("FDataSeatID >", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FDataSeatID >=", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidLessThan(Integer value) {
            addCriterion("FDataSeatID <", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidLessThanOrEqualTo(Integer value) {
            addCriterion("FDataSeatID <=", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidIn(List<Integer> values) {
            addCriterion("FDataSeatID in", values, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidNotIn(List<Integer> values) {
            addCriterion("FDataSeatID not in", values, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidBetween(Integer value1, Integer value2) {
            addCriterion("FDataSeatID between", value1, value2, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidNotBetween(Integer value1, Integer value2) {
            addCriterion("FDataSeatID not between", value1, value2, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFremarkIsNull() {
            addCriterion("FRemark is null");
            return (Criteria) this;
        }

        public Criteria andFremarkIsNotNull() {
            addCriterion("FRemark is not null");
            return (Criteria) this;
        }

        public Criteria andFremarkEqualTo(String value) {
            addCriterion("FRemark =", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotEqualTo(String value) {
            addCriterion("FRemark <>", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkGreaterThan(String value) {
            addCriterion("FRemark >", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkGreaterThanOrEqualTo(String value) {
            addCriterion("FRemark >=", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLessThan(String value) {
            addCriterion("FRemark <", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLessThanOrEqualTo(String value) {
            addCriterion("FRemark <=", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLike(String value) {
            addCriterion("FRemark like", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotLike(String value) {
            addCriterion("FRemark not like", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkIn(List<String> values) {
            addCriterion("FRemark in", values, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotIn(List<String> values) {
            addCriterion("FRemark not in", values, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkBetween(String value1, String value2) {
            addCriterion("FRemark between", value1, value2, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotBetween(String value1, String value2) {
            addCriterion("FRemark not between", value1, value2, "fremark");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNull() {
            addCriterion("FCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNotNull() {
            addCriterion("FCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeEqualTo(Date value) {
            addCriterion("FCreateTime =", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotEqualTo(Date value) {
            addCriterion("FCreateTime <>", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThan(Date value) {
            addCriterion("FCreateTime >", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FCreateTime >=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThan(Date value) {
            addCriterion("FCreateTime <", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("FCreateTime <=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIn(List<Date> values) {
            addCriterion("FCreateTime in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotIn(List<Date> values) {
            addCriterion("FCreateTime not in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeBetween(Date value1, Date value2) {
            addCriterion("FCreateTime between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("FCreateTime not between", value1, value2, "fcreatetime");
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