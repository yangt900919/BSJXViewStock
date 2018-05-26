package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.List;

public class OrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrganizationExample() {
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

        public Criteria andOrganizationnumberIsNull() {
            addCriterion("organizationNumber is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberIsNotNull() {
            addCriterion("organizationNumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberEqualTo(String value) {
            addCriterion("organizationNumber =", value, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberNotEqualTo(String value) {
            addCriterion("organizationNumber <>", value, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberGreaterThan(String value) {
            addCriterion("organizationNumber >", value, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberGreaterThanOrEqualTo(String value) {
            addCriterion("organizationNumber >=", value, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberLessThan(String value) {
            addCriterion("organizationNumber <", value, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberLessThanOrEqualTo(String value) {
            addCriterion("organizationNumber <=", value, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberLike(String value) {
            addCriterion("organizationNumber like", value, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberNotLike(String value) {
            addCriterion("organizationNumber not like", value, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberIn(List<String> values) {
            addCriterion("organizationNumber in", values, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberNotIn(List<String> values) {
            addCriterion("organizationNumber not in", values, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberBetween(String value1, String value2) {
            addCriterion("organizationNumber between", value1, value2, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnumberNotBetween(String value1, String value2) {
            addCriterion("organizationNumber not between", value1, value2, "organizationnumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIsNull() {
            addCriterion("organizationName is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIsNotNull() {
            addCriterion("organizationName is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameEqualTo(String value) {
            addCriterion("organizationName =", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotEqualTo(String value) {
            addCriterion("organizationName <>", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameGreaterThan(String value) {
            addCriterion("organizationName >", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameGreaterThanOrEqualTo(String value) {
            addCriterion("organizationName >=", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLessThan(String value) {
            addCriterion("organizationName <", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLessThanOrEqualTo(String value) {
            addCriterion("organizationName <=", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameLike(String value) {
            addCriterion("organizationName like", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotLike(String value) {
            addCriterion("organizationName not like", value, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameIn(List<String> values) {
            addCriterion("organizationName in", values, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotIn(List<String> values) {
            addCriterion("organizationName not in", values, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameBetween(String value1, String value2) {
            addCriterion("organizationName between", value1, value2, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationnameNotBetween(String value1, String value2) {
            addCriterion("organizationName not between", value1, value2, "organizationname");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressIsNull() {
            addCriterion("organizationAddress is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressIsNotNull() {
            addCriterion("organizationAddress is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressEqualTo(String value) {
            addCriterion("organizationAddress =", value, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressNotEqualTo(String value) {
            addCriterion("organizationAddress <>", value, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressGreaterThan(String value) {
            addCriterion("organizationAddress >", value, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressGreaterThanOrEqualTo(String value) {
            addCriterion("organizationAddress >=", value, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressLessThan(String value) {
            addCriterion("organizationAddress <", value, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressLessThanOrEqualTo(String value) {
            addCriterion("organizationAddress <=", value, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressLike(String value) {
            addCriterion("organizationAddress like", value, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressNotLike(String value) {
            addCriterion("organizationAddress not like", value, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressIn(List<String> values) {
            addCriterion("organizationAddress in", values, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressNotIn(List<String> values) {
            addCriterion("organizationAddress not in", values, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressBetween(String value1, String value2) {
            addCriterion("organizationAddress between", value1, value2, "organizationaddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationaddressNotBetween(String value1, String value2) {
            addCriterion("organizationAddress not between", value1, value2, "organizationaddress");
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