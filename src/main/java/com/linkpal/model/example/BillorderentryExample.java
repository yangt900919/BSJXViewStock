package com.linkpal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillorderentryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillorderentryExample() {
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

        public Criteria andFentriyidIsNull() {
            addCriterion("fentriyid is null");
            return (Criteria) this;
        }

        public Criteria andFentriyidIsNotNull() {
            addCriterion("fentriyid is not null");
            return (Criteria) this;
        }

        public Criteria andFentriyidEqualTo(Integer value) {
            addCriterion("fentriyid =", value, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidNotEqualTo(Integer value) {
            addCriterion("fentriyid <>", value, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidGreaterThan(Integer value) {
            addCriterion("fentriyid >", value, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fentriyid >=", value, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidLessThan(Integer value) {
            addCriterion("fentriyid <", value, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidLessThanOrEqualTo(Integer value) {
            addCriterion("fentriyid <=", value, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidIn(List<Integer> values) {
            addCriterion("fentriyid in", values, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidNotIn(List<Integer> values) {
            addCriterion("fentriyid not in", values, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidBetween(Integer value1, Integer value2) {
            addCriterion("fentriyid between", value1, value2, "fentriyid");
            return (Criteria) this;
        }

        public Criteria andFentriyidNotBetween(Integer value1, Integer value2) {
            addCriterion("fentriyid not between", value1, value2, "fentriyid");
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

        public Criteria andFpriceIsNull() {
            addCriterion("fprice is null");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNotNull() {
            addCriterion("fprice is not null");
            return (Criteria) this;
        }

        public Criteria andFpriceEqualTo(Double value) {
            addCriterion("fprice =", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotEqualTo(Double value) {
            addCriterion("fprice <>", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThan(Double value) {
            addCriterion("fprice >", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("fprice >=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThan(Double value) {
            addCriterion("fprice <", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThanOrEqualTo(Double value) {
            addCriterion("fprice <=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceIn(List<Double> values) {
            addCriterion("fprice in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotIn(List<Double> values) {
            addCriterion("fprice not in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceBetween(Double value1, Double value2) {
            addCriterion("fprice between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotBetween(Double value1, Double value2) {
            addCriterion("fprice not between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFstateIsNull() {
            addCriterion("fstate is null");
            return (Criteria) this;
        }

        public Criteria andFstateIsNotNull() {
            addCriterion("fstate is not null");
            return (Criteria) this;
        }

        public Criteria andFstateEqualTo(Integer value) {
            addCriterion("fstate =", value, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateNotEqualTo(Integer value) {
            addCriterion("fstate <>", value, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateGreaterThan(Integer value) {
            addCriterion("fstate >", value, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("fstate >=", value, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateLessThan(Integer value) {
            addCriterion("fstate <", value, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateLessThanOrEqualTo(Integer value) {
            addCriterion("fstate <=", value, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateIn(List<Integer> values) {
            addCriterion("fstate in", values, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateNotIn(List<Integer> values) {
            addCriterion("fstate not in", values, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateBetween(Integer value1, Integer value2) {
            addCriterion("fstate between", value1, value2, "fstate");
            return (Criteria) this;
        }

        public Criteria andFstateNotBetween(Integer value1, Integer value2) {
            addCriterion("fstate not between", value1, value2, "fstate");
            return (Criteria) this;
        }

        public Criteria andFbrandIsNull() {
            addCriterion("fbrand is null");
            return (Criteria) this;
        }

        public Criteria andFbrandIsNotNull() {
            addCriterion("fbrand is not null");
            return (Criteria) this;
        }

        public Criteria andFbrandEqualTo(String value) {
            addCriterion("fbrand =", value, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandNotEqualTo(String value) {
            addCriterion("fbrand <>", value, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandGreaterThan(String value) {
            addCriterion("fbrand >", value, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandGreaterThanOrEqualTo(String value) {
            addCriterion("fbrand >=", value, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandLessThan(String value) {
            addCriterion("fbrand <", value, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandLessThanOrEqualTo(String value) {
            addCriterion("fbrand <=", value, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandLike(String value) {
            addCriterion("fbrand like", value, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandNotLike(String value) {
            addCriterion("fbrand not like", value, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandIn(List<String> values) {
            addCriterion("fbrand in", values, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandNotIn(List<String> values) {
            addCriterion("fbrand not in", values, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandBetween(String value1, String value2) {
            addCriterion("fbrand between", value1, value2, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFbrandNotBetween(String value1, String value2) {
            addCriterion("fbrand not between", value1, value2, "fbrand");
            return (Criteria) this;
        }

        public Criteria andFqulityIsNull() {
            addCriterion("fqulity is null");
            return (Criteria) this;
        }

        public Criteria andFqulityIsNotNull() {
            addCriterion("fqulity is not null");
            return (Criteria) this;
        }

        public Criteria andFqulityEqualTo(String value) {
            addCriterion("fqulity =", value, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityNotEqualTo(String value) {
            addCriterion("fqulity <>", value, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityGreaterThan(String value) {
            addCriterion("fqulity >", value, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityGreaterThanOrEqualTo(String value) {
            addCriterion("fqulity >=", value, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityLessThan(String value) {
            addCriterion("fqulity <", value, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityLessThanOrEqualTo(String value) {
            addCriterion("fqulity <=", value, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityLike(String value) {
            addCriterion("fqulity like", value, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityNotLike(String value) {
            addCriterion("fqulity not like", value, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityIn(List<String> values) {
            addCriterion("fqulity in", values, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityNotIn(List<String> values) {
            addCriterion("fqulity not in", values, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityBetween(String value1, String value2) {
            addCriterion("fqulity between", value1, value2, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFqulityNotBetween(String value1, String value2) {
            addCriterion("fqulity not between", value1, value2, "fqulity");
            return (Criteria) this;
        }

        public Criteria andFdeldateIsNull() {
            addCriterion("fdeldate is null");
            return (Criteria) this;
        }

        public Criteria andFdeldateIsNotNull() {
            addCriterion("fdeldate is not null");
            return (Criteria) this;
        }

        public Criteria andFdeldateEqualTo(Date value) {
            addCriterion("fdeldate =", value, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateNotEqualTo(Date value) {
            addCriterion("fdeldate <>", value, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateGreaterThan(Date value) {
            addCriterion("fdeldate >", value, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateGreaterThanOrEqualTo(Date value) {
            addCriterion("fdeldate >=", value, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateLessThan(Date value) {
            addCriterion("fdeldate <", value, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateLessThanOrEqualTo(Date value) {
            addCriterion("fdeldate <=", value, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateIn(List<Date> values) {
            addCriterion("fdeldate in", values, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateNotIn(List<Date> values) {
            addCriterion("fdeldate not in", values, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateBetween(Date value1, Date value2) {
            addCriterion("fdeldate between", value1, value2, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFdeldateNotBetween(Date value1, Date value2) {
            addCriterion("fdeldate not between", value1, value2, "fdeldate");
            return (Criteria) this;
        }

        public Criteria andFcontnumIsNull() {
            addCriterion("fcontnum is null");
            return (Criteria) this;
        }

        public Criteria andFcontnumIsNotNull() {
            addCriterion("fcontnum is not null");
            return (Criteria) this;
        }

        public Criteria andFcontnumEqualTo(String value) {
            addCriterion("fcontnum =", value, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumNotEqualTo(String value) {
            addCriterion("fcontnum <>", value, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumGreaterThan(String value) {
            addCriterion("fcontnum >", value, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumGreaterThanOrEqualTo(String value) {
            addCriterion("fcontnum >=", value, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumLessThan(String value) {
            addCriterion("fcontnum <", value, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumLessThanOrEqualTo(String value) {
            addCriterion("fcontnum <=", value, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumLike(String value) {
            addCriterion("fcontnum like", value, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumNotLike(String value) {
            addCriterion("fcontnum not like", value, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumIn(List<String> values) {
            addCriterion("fcontnum in", values, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumNotIn(List<String> values) {
            addCriterion("fcontnum not in", values, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumBetween(String value1, String value2) {
            addCriterion("fcontnum between", value1, value2, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFcontnumNotBetween(String value1, String value2) {
            addCriterion("fcontnum not between", value1, value2, "fcontnum");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyIsNull() {
            addCriterion("freceiptqty is null");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyIsNotNull() {
            addCriterion("freceiptqty is not null");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyEqualTo(Double value) {
            addCriterion("freceiptqty =", value, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyNotEqualTo(Double value) {
            addCriterion("freceiptqty <>", value, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyGreaterThan(Double value) {
            addCriterion("freceiptqty >", value, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("freceiptqty >=", value, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyLessThan(Double value) {
            addCriterion("freceiptqty <", value, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyLessThanOrEqualTo(Double value) {
            addCriterion("freceiptqty <=", value, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyIn(List<Double> values) {
            addCriterion("freceiptqty in", values, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyNotIn(List<Double> values) {
            addCriterion("freceiptqty not in", values, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyBetween(Double value1, Double value2) {
            addCriterion("freceiptqty between", value1, value2, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFreceiptqtyNotBetween(Double value1, Double value2) {
            addCriterion("freceiptqty not between", value1, value2, "freceiptqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyIsNull() {
            addCriterion("frefoundqty is null");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyIsNotNull() {
            addCriterion("frefoundqty is not null");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyEqualTo(Double value) {
            addCriterion("frefoundqty =", value, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyNotEqualTo(Double value) {
            addCriterion("frefoundqty <>", value, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyGreaterThan(Double value) {
            addCriterion("frefoundqty >", value, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("frefoundqty >=", value, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyLessThan(Double value) {
            addCriterion("frefoundqty <", value, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyLessThanOrEqualTo(Double value) {
            addCriterion("frefoundqty <=", value, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyIn(List<Double> values) {
            addCriterion("frefoundqty in", values, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyNotIn(List<Double> values) {
            addCriterion("frefoundqty not in", values, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyBetween(Double value1, Double value2) {
            addCriterion("frefoundqty between", value1, value2, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFrefoundqtyNotBetween(Double value1, Double value2) {
            addCriterion("frefoundqty not between", value1, value2, "frefoundqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyIsNull() {
            addCriterion("fstoredqty is null");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyIsNotNull() {
            addCriterion("fstoredqty is not null");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyEqualTo(Double value) {
            addCriterion("fstoredqty =", value, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyNotEqualTo(Double value) {
            addCriterion("fstoredqty <>", value, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyGreaterThan(Double value) {
            addCriterion("fstoredqty >", value, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("fstoredqty >=", value, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyLessThan(Double value) {
            addCriterion("fstoredqty <", value, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyLessThanOrEqualTo(Double value) {
            addCriterion("fstoredqty <=", value, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyIn(List<Double> values) {
            addCriterion("fstoredqty in", values, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyNotIn(List<Double> values) {
            addCriterion("fstoredqty not in", values, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyBetween(Double value1, Double value2) {
            addCriterion("fstoredqty between", value1, value2, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFstoredqtyNotBetween(Double value1, Double value2) {
            addCriterion("fstoredqty not between", value1, value2, "fstoredqty");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeIsNull() {
            addCriterion("fjudgetype is null");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeIsNotNull() {
            addCriterion("fjudgetype is not null");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeEqualTo(String value) {
            addCriterion("fjudgetype =", value, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeNotEqualTo(String value) {
            addCriterion("fjudgetype <>", value, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeGreaterThan(String value) {
            addCriterion("fjudgetype >", value, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeGreaterThanOrEqualTo(String value) {
            addCriterion("fjudgetype >=", value, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeLessThan(String value) {
            addCriterion("fjudgetype <", value, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeLessThanOrEqualTo(String value) {
            addCriterion("fjudgetype <=", value, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeLike(String value) {
            addCriterion("fjudgetype like", value, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeNotLike(String value) {
            addCriterion("fjudgetype not like", value, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeIn(List<String> values) {
            addCriterion("fjudgetype in", values, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeNotIn(List<String> values) {
            addCriterion("fjudgetype not in", values, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeBetween(String value1, String value2) {
            addCriterion("fjudgetype between", value1, value2, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFjudgetypeNotBetween(String value1, String value2) {
            addCriterion("fjudgetype not between", value1, value2, "fjudgetype");
            return (Criteria) this;
        }

        public Criteria andFcurrencyIsNull() {
            addCriterion("fcurrency is null");
            return (Criteria) this;
        }

        public Criteria andFcurrencyIsNotNull() {
            addCriterion("fcurrency is not null");
            return (Criteria) this;
        }

        public Criteria andFcurrencyEqualTo(String value) {
            addCriterion("fcurrency =", value, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyNotEqualTo(String value) {
            addCriterion("fcurrency <>", value, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyGreaterThan(String value) {
            addCriterion("fcurrency >", value, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("fcurrency >=", value, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyLessThan(String value) {
            addCriterion("fcurrency <", value, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyLessThanOrEqualTo(String value) {
            addCriterion("fcurrency <=", value, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyLike(String value) {
            addCriterion("fcurrency like", value, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyNotLike(String value) {
            addCriterion("fcurrency not like", value, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyIn(List<String> values) {
            addCriterion("fcurrency in", values, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyNotIn(List<String> values) {
            addCriterion("fcurrency not in", values, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyBetween(String value1, String value2) {
            addCriterion("fcurrency between", value1, value2, "fcurrency");
            return (Criteria) this;
        }

        public Criteria andFcurrencyNotBetween(String value1, String value2) {
            addCriterion("fcurrency not between", value1, value2, "fcurrency");
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