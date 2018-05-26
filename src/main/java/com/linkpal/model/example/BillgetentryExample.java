package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.List;

public class BillgetentryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillgetentryExample() {
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

        public Criteria andFmaterialidIsNull() {
            addCriterion("fmaterialid is null");
            return (Criteria) this;
        }

        public Criteria andFmaterialidIsNotNull() {
            addCriterion("fmaterialid is not null");
            return (Criteria) this;
        }

        public Criteria andFmaterialidEqualTo(Integer value) {
            addCriterion("fmaterialid =", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidNotEqualTo(Integer value) {
            addCriterion("fmaterialid <>", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidGreaterThan(Integer value) {
            addCriterion("fmaterialid >", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fmaterialid >=", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidLessThan(Integer value) {
            addCriterion("fmaterialid <", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidLessThanOrEqualTo(Integer value) {
            addCriterion("fmaterialid <=", value, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidIn(List<Integer> values) {
            addCriterion("fmaterialid in", values, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidNotIn(List<Integer> values) {
            addCriterion("fmaterialid not in", values, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidBetween(Integer value1, Integer value2) {
            addCriterion("fmaterialid between", value1, value2, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFmaterialidNotBetween(Integer value1, Integer value2) {
            addCriterion("fmaterialid not between", value1, value2, "fmaterialid");
            return (Criteria) this;
        }

        public Criteria andFlotIsNull() {
            addCriterion("flot is null");
            return (Criteria) this;
        }

        public Criteria andFlotIsNotNull() {
            addCriterion("flot is not null");
            return (Criteria) this;
        }

        public Criteria andFlotEqualTo(String value) {
            addCriterion("flot =", value, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotNotEqualTo(String value) {
            addCriterion("flot <>", value, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotGreaterThan(String value) {
            addCriterion("flot >", value, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotGreaterThanOrEqualTo(String value) {
            addCriterion("flot >=", value, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotLessThan(String value) {
            addCriterion("flot <", value, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotLessThanOrEqualTo(String value) {
            addCriterion("flot <=", value, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotIn(List<String> values) {
            addCriterion("flot in", values, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotNotIn(List<String> values) {
            addCriterion("flot not in", values, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotBetween(String value1, String value2) {
            addCriterion("flot between", value1, value2, "flot");
            return (Criteria) this;
        }

        public Criteria andFlotNotBetween(Integer value1, Integer value2) {
            addCriterion("flot not between", value1, value2, "flot");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyIsNull() {
            addCriterion("fapplyqty is null");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyIsNotNull() {
            addCriterion("fapplyqty is not null");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyEqualTo(Double value) {
            addCriterion("fapplyqty =", value, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyNotEqualTo(Double value) {
            addCriterion("fapplyqty <>", value, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyGreaterThan(Double value) {
            addCriterion("fapplyqty >", value, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("fapplyqty >=", value, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyLessThan(Double value) {
            addCriterion("fapplyqty <", value, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyLessThanOrEqualTo(Double value) {
            addCriterion("fapplyqty <=", value, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyIn(List<Double> values) {
            addCriterion("fapplyqty in", values, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyNotIn(List<Double> values) {
            addCriterion("fapplyqty not in", values, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyBetween(Double value1, Double value2) {
            addCriterion("fapplyqty between", value1, value2, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFapplyqtyNotBetween(Double value1, Double value2) {
            addCriterion("fapplyqty not between", value1, value2, "fapplyqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyIsNull() {
            addCriterion("frealqty is null");
            return (Criteria) this;
        }

        public Criteria andFrealqtyIsNotNull() {
            addCriterion("frealqty is not null");
            return (Criteria) this;
        }

        public Criteria andFrealqtyEqualTo(Double value) {
            addCriterion("frealqty =", value, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyNotEqualTo(Double value) {
            addCriterion("frealqty <>", value, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyGreaterThan(Double value) {
            addCriterion("frealqty >", value, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("frealqty >=", value, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyLessThan(Double value) {
            addCriterion("frealqty <", value, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyLessThanOrEqualTo(Double value) {
            addCriterion("frealqty <=", value, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyIn(List<Double> values) {
            addCriterion("frealqty in", values, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyNotIn(List<Double> values) {
            addCriterion("frealqty not in", values, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyBetween(Double value1, Double value2) {
            addCriterion("frealqty between", value1, value2, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFrealqtyNotBetween(Double value1, Double value2) {
            addCriterion("frealqty not between", value1, value2, "frealqty");
            return (Criteria) this;
        }

        public Criteria andFinventoryIsNull() {
            addCriterion("finventory is null");
            return (Criteria) this;
        }

        public Criteria andFinventoryIsNotNull() {
            addCriterion("finventory is not null");
            return (Criteria) this;
        }

        public Criteria andFinventoryEqualTo(Double value) {
            addCriterion("finventory =", value, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryNotEqualTo(Double value) {
            addCriterion("finventory <>", value, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryGreaterThan(Double value) {
            addCriterion("finventory >", value, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryGreaterThanOrEqualTo(Double value) {
            addCriterion("finventory >=", value, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryLessThan(Double value) {
            addCriterion("finventory <", value, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryLessThanOrEqualTo(Double value) {
            addCriterion("finventory <=", value, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryIn(List<Double> values) {
            addCriterion("finventory in", values, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryNotIn(List<Double> values) {
            addCriterion("finventory not in", values, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryBetween(Double value1, Double value2) {
            addCriterion("finventory between", value1, value2, "finventory");
            return (Criteria) this;
        }

        public Criteria andFinventoryNotBetween(Double value1, Double value2) {
            addCriterion("finventory not between", value1, value2, "finventory");
            return (Criteria) this;
        }

        public Criteria andFsendstockidIsNull() {
            addCriterion("fsendstockid is null");
            return (Criteria) this;
        }

        public Criteria andFsendstockidIsNotNull() {
            addCriterion("fsendstockid is not null");
            return (Criteria) this;
        }

        public Criteria andFsendstockidEqualTo(Integer value) {
            addCriterion("fsendstockid =", value, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidNotEqualTo(Integer value) {
            addCriterion("fsendstockid <>", value, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidGreaterThan(Integer value) {
            addCriterion("fsendstockid >", value, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsendstockid >=", value, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidLessThan(Integer value) {
            addCriterion("fsendstockid <", value, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidLessThanOrEqualTo(Integer value) {
            addCriterion("fsendstockid <=", value, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidIn(List<Integer> values) {
            addCriterion("fsendstockid in", values, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidNotIn(List<Integer> values) {
            addCriterion("fsendstockid not in", values, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidBetween(Integer value1, Integer value2) {
            addCriterion("fsendstockid between", value1, value2, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFsendstockidNotBetween(Integer value1, Integer value2) {
            addCriterion("fsendstockid not between", value1, value2, "fsendstockid");
            return (Criteria) this;
        }

        public Criteria andFnoteIsNull() {
            addCriterion("fnote is null");
            return (Criteria) this;
        }

        public Criteria andFnoteIsNotNull() {
            addCriterion("fnote is not null");
            return (Criteria) this;
        }

        public Criteria andFnoteEqualTo(String value) {
            addCriterion("fnote =", value, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteNotEqualTo(String value) {
            addCriterion("fnote <>", value, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteGreaterThan(String value) {
            addCriterion("fnote >", value, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteGreaterThanOrEqualTo(String value) {
            addCriterion("fnote >=", value, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteLessThan(String value) {
            addCriterion("fnote <", value, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteLessThanOrEqualTo(String value) {
            addCriterion("fnote <=", value, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteLike(String value) {
            addCriterion("fnote like", value, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteNotLike(String value) {
            addCriterion("fnote not like", value, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteIn(List<String> values) {
            addCriterion("fnote in", values, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteNotIn(List<String> values) {
            addCriterion("fnote not in", values, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteBetween(String value1, String value2) {
            addCriterion("fnote between", value1, value2, "fnote");
            return (Criteria) this;
        }

        public Criteria andFnoteNotBetween(String value1, String value2) {
            addCriterion("fnote not between", value1, value2, "fnote");
            return (Criteria) this;
        }

        public Criteria andFoidIsNull() {
            addCriterion("foid is null");
            return (Criteria) this;
        }

        public Criteria andFoidIsNotNull() {
            addCriterion("foid is not null");
            return (Criteria) this;
        }

        public Criteria andFoidEqualTo(Integer value) {
            addCriterion("foid =", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotEqualTo(Integer value) {
            addCriterion("foid <>", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidGreaterThan(Integer value) {
            addCriterion("foid >", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("foid >=", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidLessThan(Integer value) {
            addCriterion("foid <", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidLessThanOrEqualTo(Integer value) {
            addCriterion("foid <=", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidIn(List<Integer> values) {
            addCriterion("foid in", values, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotIn(List<Integer> values) {
            addCriterion("foid not in", values, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidBetween(Integer value1, Integer value2) {
            addCriterion("foid between", value1, value2, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotBetween(Integer value1, Integer value2) {
            addCriterion("foid not between", value1, value2, "foid");
            return (Criteria) this;
        }

        public Criteria andFentryidIsNull() {
            addCriterion("fentryid is null");
            return (Criteria) this;
        }

        public Criteria andFentryidIsNotNull() {
            addCriterion("fentryid is not null");
            return (Criteria) this;
        }

        public Criteria andFentryidEqualTo(Integer value) {
            addCriterion("fentryid =", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotEqualTo(Integer value) {
            addCriterion("fentryid <>", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidGreaterThan(Integer value) {
            addCriterion("fentryid >", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fentryid >=", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidLessThan(Integer value) {
            addCriterion("fentryid <", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidLessThanOrEqualTo(Integer value) {
            addCriterion("fentryid <=", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidIn(List<Integer> values) {
            addCriterion("fentryid in", values, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotIn(List<Integer> values) {
            addCriterion("fentryid not in", values, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidBetween(Integer value1, Integer value2) {
            addCriterion("fentryid between", value1, value2, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotBetween(Integer value1, Integer value2) {
            addCriterion("fentryid not between", value1, value2, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFbillidIsNull() {
            addCriterion("fbillid is null");
            return (Criteria) this;
        }

        public Criteria andFbillidIsNotNull() {
            addCriterion("fbillid is not null");
            return (Criteria) this;
        }

        public Criteria andFbillidEqualTo(Integer value) {
            addCriterion("fbillid =", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidNotEqualTo(Integer value) {
            addCriterion("fbillid <>", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidGreaterThan(Integer value) {
            addCriterion("fbillid >", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fbillid >=", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidLessThan(Integer value) {
            addCriterion("fbillid <", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidLessThanOrEqualTo(Integer value) {
            addCriterion("fbillid <=", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidIn(List<Integer> values) {
            addCriterion("fbillid in", values, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidNotIn(List<Integer> values) {
            addCriterion("fbillid not in", values, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidBetween(Integer value1, Integer value2) {
            addCriterion("fbillid between", value1, value2, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidNotBetween(Integer value1, Integer value2) {
            addCriterion("fbillid not between", value1, value2, "fbillid");
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