package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.List;

public class BillstockentryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillstockentryExample() {
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

        public Criteria andFactqtyIsNull() {
            addCriterion("factqty is null");
            return (Criteria) this;
        }

        public Criteria andFactqtyIsNotNull() {
            addCriterion("factqty is not null");
            return (Criteria) this;
        }

        public Criteria andFactqtyEqualTo(Double value) {
            addCriterion("factqty =", value, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyNotEqualTo(Double value) {
            addCriterion("factqty <>", value, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyGreaterThan(Double value) {
            addCriterion("factqty >", value, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("factqty >=", value, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyLessThan(Double value) {
            addCriterion("factqty <", value, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyLessThanOrEqualTo(Double value) {
            addCriterion("factqty <=", value, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyIn(List<Double> values) {
            addCriterion("factqty in", values, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyNotIn(List<Double> values) {
            addCriterion("factqty not in", values, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyBetween(Double value1, Double value2) {
            addCriterion("factqty between", value1, value2, "factqty");
            return (Criteria) this;
        }

        public Criteria andFactqtyNotBetween(Double value1, Double value2) {
            addCriterion("factqty not between", value1, value2, "factqty");
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

        public Criteria andFbatchIsNull() {
            addCriterion("fbatch is null");
            return (Criteria) this;
        }

        public Criteria andFbatchIsNotNull() {
            addCriterion("fbatch is not null");
            return (Criteria) this;
        }

        public Criteria andFbatchEqualTo(String value) {
            addCriterion("fbatch =", value, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchNotEqualTo(String value) {
            addCriterion("fbatch <>", value, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchGreaterThan(String value) {
            addCriterion("fbatch >", value, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchGreaterThanOrEqualTo(String value) {
            addCriterion("fbatch >=", value, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchLessThan(String value) {
            addCriterion("fbatch <", value, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchLessThanOrEqualTo(String value) {
            addCriterion("fbatch <=", value, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchLike(String value) {
            addCriterion("fbatch like", value, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchNotLike(String value) {
            addCriterion("fbatch not like", value, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchIn(List<String> values) {
            addCriterion("fbatch in", values, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchNotIn(List<String> values) {
            addCriterion("fbatch not in", values, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchBetween(String value1, String value2) {
            addCriterion("fbatch between", value1, value2, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFbatchNotBetween(String value1, String value2) {
            addCriterion("fbatch not between", value1, value2, "fbatch");
            return (Criteria) this;
        }

        public Criteria andFobillidIsNull() {
            addCriterion("fobillid is null");
            return (Criteria) this;
        }

        public Criteria andFobillidIsNotNull() {
            addCriterion("fobillid is not null");
            return (Criteria) this;
        }

        public Criteria andFobillidEqualTo(Integer value) {
            addCriterion("fobillid =", value, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidNotEqualTo(Integer value) {
            addCriterion("fobillid <>", value, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidGreaterThan(Integer value) {
            addCriterion("fobillid >", value, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fobillid >=", value, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidLessThan(Integer value) {
            addCriterion("fobillid <", value, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidLessThanOrEqualTo(Integer value) {
            addCriterion("fobillid <=", value, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidIn(List<Integer> values) {
            addCriterion("fobillid in", values, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidNotIn(List<Integer> values) {
            addCriterion("fobillid not in", values, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidBetween(Integer value1, Integer value2) {
            addCriterion("fobillid between", value1, value2, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFobillidNotBetween(Integer value1, Integer value2) {
            addCriterion("fobillid not between", value1, value2, "fobillid");
            return (Criteria) this;
        }

        public Criteria andFonumberIsNull() {
            addCriterion("fonumber is null");
            return (Criteria) this;
        }

        public Criteria andFonumberIsNotNull() {
            addCriterion("fonumber is not null");
            return (Criteria) this;
        }

        public Criteria andFonumberEqualTo(String value) {
            addCriterion("fonumber =", value, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberNotEqualTo(String value) {
            addCriterion("fonumber <>", value, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberGreaterThan(String value) {
            addCriterion("fonumber >", value, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberGreaterThanOrEqualTo(String value) {
            addCriterion("fonumber >=", value, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberLessThan(String value) {
            addCriterion("fonumber <", value, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberLessThanOrEqualTo(String value) {
            addCriterion("fonumber <=", value, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberLike(String value) {
            addCriterion("fonumber like", value, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberNotLike(String value) {
            addCriterion("fonumber not like", value, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberIn(List<String> values) {
            addCriterion("fonumber in", values, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberNotIn(List<String> values) {
            addCriterion("fonumber not in", values, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberBetween(String value1, String value2) {
            addCriterion("fonumber between", value1, value2, "fonumber");
            return (Criteria) this;
        }

        public Criteria andFonumberNotBetween(String value1, String value2) {
            addCriterion("fonumber not between", value1, value2, "fonumber");
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