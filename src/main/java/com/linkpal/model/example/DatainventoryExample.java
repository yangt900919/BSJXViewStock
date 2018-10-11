package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.List;

public class DatainventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatainventoryExample() {
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

        public Criteria andFdataidIsNull() {
            addCriterion("FdataID is null");
            return (Criteria) this;
        }

        public Criteria andFdataidIsNotNull() {
            addCriterion("FdataID is not null");
            return (Criteria) this;
        }

        public Criteria andFdataidEqualTo(Integer value) {
            addCriterion("FdataID =", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidNotEqualTo(Integer value) {
            addCriterion("FdataID <>", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidGreaterThan(Integer value) {
            addCriterion("FdataID >", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FdataID >=", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidLessThan(Integer value) {
            addCriterion("FdataID <", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidLessThanOrEqualTo(Integer value) {
            addCriterion("FdataID <=", value, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidIn(List<Integer> values) {
            addCriterion("FdataID in", values, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidNotIn(List<Integer> values) {
            addCriterion("FdataID not in", values, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidBetween(Integer value1, Integer value2) {
            addCriterion("FdataID between", value1, value2, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataidNotBetween(Integer value1, Integer value2) {
            addCriterion("FdataID not between", value1, value2, "fdataid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidIsNull() {
            addCriterion("fdataseatid is null");
            return (Criteria) this;
        }

        public Criteria andFdataseatidIsNotNull() {
            addCriterion("fdataseatid is not null");
            return (Criteria) this;
        }

        public Criteria andFdataseatidEqualTo(Integer value) {
            addCriterion("fdataseatid =", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidNotEqualTo(Integer value) {
            addCriterion("fdataseatid <>", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidGreaterThan(Integer value) {
            addCriterion("fdataseatid >", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fdataseatid >=", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidLessThan(Integer value) {
            addCriterion("fdataseatid <", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidLessThanOrEqualTo(Integer value) {
            addCriterion("fdataseatid <=", value, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidIn(List<Integer> values) {
            addCriterion("fdataseatid in", values, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidNotIn(List<Integer> values) {
            addCriterion("fdataseatid not in", values, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidBetween(Integer value1, Integer value2) {
            addCriterion("fdataseatid between", value1, value2, "fdataseatid");
            return (Criteria) this;
        }

        public Criteria andFdataseatidNotBetween(Integer value1, Integer value2) {
            addCriterion("fdataseatid not between", value1, value2, "fdataseatid");
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

        public Criteria andFdateEqualTo(String value) {
            addCriterion("fdate =", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotEqualTo(String value) {
            addCriterion("fdate <>", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThan(String value) {
            addCriterion("fdate >", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThanOrEqualTo(String value) {
            addCriterion("fdate >=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThan(String value) {
            addCriterion("fdate <", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThanOrEqualTo(String value) {
            addCriterion("fdate <=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLike(String value) {
            addCriterion("fdate like", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotLike(String value) {
            addCriterion("fdate not like", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateIn(List<String> values) {
            addCriterion("fdate in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotIn(List<String> values) {
            addCriterion("fdate not in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateBetween(String value1, String value2) {
            addCriterion("fdate between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotBetween(String value1, String value2) {
            addCriterion("fdate not between", value1, value2, "fdate");
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