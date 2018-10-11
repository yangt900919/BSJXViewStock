package com.linkpal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventryExample() {
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

        public Criteria andFparentidIsNull() {
            addCriterion("FParentID is null");
            return (Criteria) this;
        }

        public Criteria andFparentidIsNotNull() {
            addCriterion("FParentID is not null");
            return (Criteria) this;
        }

        public Criteria andFparentidEqualTo(Integer value) {
            addCriterion("FParentID =", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidNotEqualTo(Integer value) {
            addCriterion("FParentID <>", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidGreaterThan(Integer value) {
            addCriterion("FParentID >", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FParentID >=", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidLessThan(Integer value) {
            addCriterion("FParentID <", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidLessThanOrEqualTo(Integer value) {
            addCriterion("FParentID <=", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidIn(List<Integer> values) {
            addCriterion("FParentID in", values, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidNotIn(List<Integer> values) {
            addCriterion("FParentID not in", values, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidBetween(Integer value1, Integer value2) {
            addCriterion("FParentID between", value1, value2, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidNotBetween(Integer value1, Integer value2) {
            addCriterion("FParentID not between", value1, value2, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidIsNull() {
            addCriterion("FMaterialID is null");
            return (Criteria) this;
        }

        public Criteria andFmaterialidIsNotNull() {
            addCriterion("FMaterialID is not null");
            return (Criteria) this;
        }

        public Criteria andFmaterialidEqualTo(Integer value) {
            addCriterion("FMaterialID =", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidNotEqualTo(Integer value) {
            addCriterion("FMaterialID <>", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidGreaterThan(Integer value) {
            addCriterion("FMaterialID >", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FMaterialID >=", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidLessThan(Integer value) {
            addCriterion("FMaterialID <", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidLessThanOrEqualTo(Integer value) {
            addCriterion("FMaterialID <=", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidIn(List<Integer> values) {
            addCriterion("FMaterialID in", values, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidNotIn(List<Integer> values) {
            addCriterion("FMaterialID not in", values, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidBetween(Integer value1, Integer value2) {
            addCriterion("FMaterialID between", value1, value2, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidNotBetween(Integer value1, Integer value2) {
            addCriterion("FMaterialID not between", value1, value2, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidIsNull() {
            addCriterion("FGoodseatID is null");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidIsNotNull() {
            addCriterion("FGoodseatID is not null");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidEqualTo(Integer value) {
            addCriterion("FGoodseatID =", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidNotEqualTo(Integer value) {
            addCriterion("FGoodseatID <>", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidGreaterThan(Integer value) {
            addCriterion("FGoodseatID >", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FGoodseatID >=", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidLessThan(Integer value) {
            addCriterion("FGoodseatID <", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidLessThanOrEqualTo(Integer value) {
            addCriterion("FGoodseatID <=", value, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidIn(List<Integer> values) {
            addCriterion("FGoodseatID in", values, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidNotIn(List<Integer> values) {
            addCriterion("FGoodseatID not in", values, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidBetween(Integer value1, Integer value2) {
            addCriterion("FGoodseatID between", value1, value2, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFgoodseatidNotBetween(Integer value1, Integer value2) {
            addCriterion("FGoodseatID not between", value1, value2, "fgoodseatid");
            return (Criteria) this;
        }

        public Criteria andFqtyIsNull() {
            addCriterion("FQty is null");
            return (Criteria) this;
        }

        public Criteria andFqtyIsNotNull() {
            addCriterion("FQty is not null");
            return (Criteria) this;
        }

        public Criteria andFqtyEqualTo(Double value) {
            addCriterion("FQty =", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyNotEqualTo(Double value) {
            addCriterion("FQty <>", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyGreaterThan(Double value) {
            addCriterion("FQty >", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("FQty >=", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyLessThan(Double value) {
            addCriterion("FQty <", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyLessThanOrEqualTo(Double value) {
            addCriterion("FQty <=", value, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyIn(List<Double> values) {
            addCriterion("FQty in", values, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyNotIn(List<Double> values) {
            addCriterion("FQty not in", values, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyBetween(Double value1, Double value2) {
            addCriterion("FQty between", value1, value2, "fqty");
            return (Criteria) this;
        }

        public Criteria andFqtyNotBetween(Double value1, Double value2) {
            addCriterion("FQty not between", value1, value2, "fqty");
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