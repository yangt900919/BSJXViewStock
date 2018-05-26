package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.List;

public class MaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialExample() {
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

        public Criteria andMaterialnumberIsNull() {
            addCriterion("materialNumber is null");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberIsNotNull() {
            addCriterion("materialNumber is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberEqualTo(String value) {
            addCriterion("materialNumber =", value, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberNotEqualTo(String value) {
            addCriterion("materialNumber <>", value, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberGreaterThan(String value) {
            addCriterion("materialNumber >", value, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberGreaterThanOrEqualTo(String value) {
            addCriterion("materialNumber >=", value, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberLessThan(String value) {
            addCriterion("materialNumber <", value, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberLessThanOrEqualTo(String value) {
            addCriterion("materialNumber <=", value, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberLike(String value) {
            addCriterion("materialNumber like", value, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberNotLike(String value) {
            addCriterion("materialNumber not like", value, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberIn(List<String> values) {
            addCriterion("materialNumber in", values, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberNotIn(List<String> values) {
            addCriterion("materialNumber not in", values, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberBetween(String value1, String value2) {
            addCriterion("materialNumber between", value1, value2, "materialnumber");
            return (Criteria) this;
        }

        public Criteria andMaterialnumberNotBetween(String value1, String value2) {
            addCriterion("materialNumber not between", value1, value2, "materialnumber");
            return (Criteria) this;
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

        public Criteria andMaterialnameIsNull() {
            addCriterion("materialName is null");
            return (Criteria) this;
        }

        public Criteria andMaterialnameIsNotNull() {
            addCriterion("materialName is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialnameEqualTo(String value) {
            addCriterion("materialName =", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameNotEqualTo(String value) {
            addCriterion("materialName <>", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameGreaterThan(String value) {
            addCriterion("materialName >", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameGreaterThanOrEqualTo(String value) {
            addCriterion("materialName >=", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameLessThan(String value) {
            addCriterion("materialName <", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameLessThanOrEqualTo(String value) {
            addCriterion("materialName <=", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameLike(String value) {
            addCriterion("materialName like", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameNotLike(String value) {
            addCriterion("materialName not like", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameIn(List<String> values) {
            addCriterion("materialName in", values, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameNotIn(List<String> values) {
            addCriterion("materialName not in", values, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameBetween(String value1, String value2) {
            addCriterion("materialName between", value1, value2, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameNotBetween(String value1, String value2) {
            addCriterion("materialName not between", value1, value2, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelIsNull() {
            addCriterion("materialModel is null");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelIsNotNull() {
            addCriterion("materialModel is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelEqualTo(String value) {
            addCriterion("materialModel =", value, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelNotEqualTo(String value) {
            addCriterion("materialModel <>", value, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelGreaterThan(String value) {
            addCriterion("materialModel >", value, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelGreaterThanOrEqualTo(String value) {
            addCriterion("materialModel >=", value, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelLessThan(String value) {
            addCriterion("materialModel <", value, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelLessThanOrEqualTo(String value) {
            addCriterion("materialModel <=", value, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelLike(String value) {
            addCriterion("materialModel like", value, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelNotLike(String value) {
            addCriterion("materialModel not like", value, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelIn(List<String> values) {
            addCriterion("materialModel in", values, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelNotIn(List<String> values) {
            addCriterion("materialModel not in", values, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelBetween(String value1, String value2) {
            addCriterion("materialModel between", value1, value2, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialmodelNotBetween(String value1, String value2) {
            addCriterion("materialModel not between", value1, value2, "materialmodel");
            return (Criteria) this;
        }

        public Criteria andMaterialunitIsNull() {
            addCriterion("materialUnit is null");
            return (Criteria) this;
        }

        public Criteria andMaterialunitIsNotNull() {
            addCriterion("materialUnit is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialunitEqualTo(String value) {
            addCriterion("materialUnit =", value, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitNotEqualTo(String value) {
            addCriterion("materialUnit <>", value, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitGreaterThan(String value) {
            addCriterion("materialUnit >", value, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitGreaterThanOrEqualTo(String value) {
            addCriterion("materialUnit >=", value, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitLessThan(String value) {
            addCriterion("materialUnit <", value, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitLessThanOrEqualTo(String value) {
            addCriterion("materialUnit <=", value, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitLike(String value) {
            addCriterion("materialUnit like", value, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitNotLike(String value) {
            addCriterion("materialUnit not like", value, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitIn(List<String> values) {
            addCriterion("materialUnit in", values, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitNotIn(List<String> values) {
            addCriterion("materialUnit not in", values, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitBetween(String value1, String value2) {
            addCriterion("materialUnit between", value1, value2, "materialunit");
            return (Criteria) this;
        }

        public Criteria andMaterialunitNotBetween(String value1, String value2) {
            addCriterion("materialUnit not between", value1, value2, "materialunit");
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