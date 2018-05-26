package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillcheckentryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillcheckentryExample() {
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

        public Criteria andFeligqtyIsNull() {
            addCriterion("feligqty is null");
            return (Criteria) this;
        }

        public Criteria andFeligqtyIsNotNull() {
            addCriterion("feligqty is not null");
            return (Criteria) this;
        }

        public Criteria andFeligqtyEqualTo(Double value) {
            addCriterion("feligqty =", value, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyNotEqualTo(Double value) {
            addCriterion("feligqty <>", value, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyGreaterThan(Double value) {
            addCriterion("feligqty >", value, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("feligqty >=", value, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyLessThan(Double value) {
            addCriterion("feligqty <", value, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyLessThanOrEqualTo(Integer value) {
            addCriterion("feligqty <=", value, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyIn(List<Double> values) {
            addCriterion("feligqty in", values, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyNotIn(List<Double> values) {
            addCriterion("feligqty not in", values, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyBetween(Double value1, Double value2) {
            addCriterion("feligqty between", value1, value2, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFeligqtyNotBetween(Double value1, Double value2) {
            addCriterion("feligqty not between", value1, value2, "feligqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyIsNull() {
            addCriterion("funqty is null");
            return (Criteria) this;
        }

        public Criteria andFunqtyIsNotNull() {
            addCriterion("funqty is not null");
            return (Criteria) this;
        }

        public Criteria andFunqtyEqualTo(Double value) {
            addCriterion("funqty =", value, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyNotEqualTo(Double value) {
            addCriterion("funqty <>", value, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyGreaterThan(Integer value) {
            addCriterion("funqty >", value, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("funqty >=", value, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyLessThan(Double value) {
            addCriterion("funqty <", value, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyLessThanOrEqualTo(Double value) {
            addCriterion("funqty <=", value, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyIn(List<Double> values) {
            addCriterion("funqty in", values, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyNotIn(List<Double> values) {
            addCriterion("funqty not in", values, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyBetween(Double value1, Double value2) {
            addCriterion("funqty between", value1, value2, "funqty");
            return (Criteria) this;
        }

        public Criteria andFunqtyNotBetween(Double value1, Double value2) {
            addCriterion("funqty not between", value1, value2, "funqty");
            return (Criteria) this;
        }

        public Criteria andFreasonIsNull() {
            addCriterion("freason is null");
            return (Criteria) this;
        }

        public Criteria andFreasonIsNotNull() {
            addCriterion("freason is not null");
            return (Criteria) this;
        }

        public Criteria andFreasonEqualTo(String value) {
            addCriterion("freason =", value, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonNotEqualTo(String value) {
            addCriterion("freason <>", value, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonGreaterThan(String value) {
            addCriterion("freason >", value, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonGreaterThanOrEqualTo(String value) {
            addCriterion("freason >=", value, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonLessThan(String value) {
            addCriterion("freason <", value, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonLessThanOrEqualTo(String value) {
            addCriterion("freason <=", value, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonLike(String value) {
            addCriterion("freason like", value, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonNotLike(String value) {
            addCriterion("freason not like", value, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonIn(List<String> values) {
            addCriterion("freason in", values, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonNotIn(List<String> values) {
            addCriterion("freason not in", values, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonBetween(String value1, String value2) {
            addCriterion("freason between", value1, value2, "freason");
            return (Criteria) this;
        }

        public Criteria andFreasonNotBetween(String value1, String value2) {
            addCriterion("freason not between", value1, value2, "freason");
            return (Criteria) this;
        }

        public Criteria andFresultIsNull() {
            addCriterion("fresult is null");
            return (Criteria) this;
        }

        public Criteria andFresultIsNotNull() {
            addCriterion("fresult is not null");
            return (Criteria) this;
        }

        public Criteria andFresultEqualTo(String value) {
            addCriterion("fresult =", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultNotEqualTo(String value) {
            addCriterion("fresult <>", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultGreaterThan(String value) {
            addCriterion("fresult >", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultGreaterThanOrEqualTo(String value) {
            addCriterion("fresult >=", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultLessThan(String value) {
            addCriterion("fresult <", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultLessThanOrEqualTo(String value) {
            addCriterion("fresult <=", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultLike(String value) {
            addCriterion("fresult like", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultNotLike(String value) {
            addCriterion("fresult not like", value, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultIn(List<String> values) {
            addCriterion("fresult in", values, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultNotIn(List<String> values) {
            addCriterion("fresult not in", values, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultBetween(String value1, String value2) {
            addCriterion("fresult between", value1, value2, "fresult");
            return (Criteria) this;
        }

        public Criteria andFresultNotBetween(String value1, String value2) {
            addCriterion("fresult not between", value1, value2, "fresult");
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

        public Criteria andFguartimeIsNull() {
            addCriterion("fguartime is null");
            return (Criteria) this;
        }

        public Criteria andFguartimeIsNotNull() {
            addCriterion("fguartime is not null");
            return (Criteria) this;
        }

        public Criteria andFguartimeEqualTo(Double value) {
            addCriterion("fguartime =", value, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeNotEqualTo(Double value) {
            addCriterion("fguartime <>", value, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeGreaterThan(Double value) {
            addCriterion("fguartime >", value, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeGreaterThanOrEqualTo(Double value) {
            addCriterion("fguartime >=", value, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeLessThan(Double value) {
            addCriterion("fguartime <", value, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeLessThanOrEqualTo(Double value) {
            addCriterion("fguartime <=", value, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeLike(Double value) {
            addCriterion("fguartime like", value, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeNotLike(Double value) {
            addCriterion("fguartime not like", value, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeIn(List<Double> values) {
            addCriterion("fguartime in", values, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeNotIn(List<Double> values) {
            addCriterion("fguartime not in", values, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeBetween(Double value1, Double value2) {
            addCriterion("fguartime between", value1, value2, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFguartimeNotBetween(Double value1, Double value2) {
            addCriterion("fguartime not between", value1, value2, "fguartime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeIsNull() {
            addCriterion("fdeltime is null");
            return (Criteria) this;
        }

        public Criteria andFdeltimeIsNotNull() {
            addCriterion("fdeltime is not null");
            return (Criteria) this;
        }

        public Criteria andFdeltimeEqualTo(Date value) {
            addCriterion("fdeltime =", value, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeNotEqualTo(Date value) {
            addCriterion("fdeltime <>", value, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeGreaterThan(Date value) {
            addCriterion("fdeltime >", value, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fdeltime >=", value, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeLessThan(Date value) {
            addCriterion("fdeltime <", value, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeLessThanOrEqualTo(Date value) {
            addCriterion("fdeltime <=", value, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeIn(List<Date> values) {
            addCriterion("fdeltime in", values, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeNotIn(List<Date> values) {
            addCriterion("fdeltime not in", values, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeBetween(Date value1, Date value2) {
            addCriterion("fdeltime between", value1, value2, "fdeltime");
            return (Criteria) this;
        }

        public Criteria andFdeltimeNotBetween(Date value1, Date value2) {
            addCriterion("fdeltime not between", value1, value2, "fdeltime");
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