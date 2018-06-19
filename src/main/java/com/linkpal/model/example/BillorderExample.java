package com.linkpal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillorderExample() {
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

        public Criteria andFnumberIsNull() {
            addCriterion("fnumber is null");
            return (Criteria) this;
        }

        public Criteria andFnumberIsNotNull() {
            addCriterion("fnumber is not null");
            return (Criteria) this;
        }

        public Criteria andFnumberEqualTo(String value) {
            addCriterion("fnumber =", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberNotEqualTo(String value) {
            addCriterion("fnumber <>", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberGreaterThan(String value) {
            addCriterion("fnumber >", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberGreaterThanOrEqualTo(String value) {
            addCriterion("fnumber >=", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberLessThan(String value) {
            addCriterion("fnumber <", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberLessThanOrEqualTo(String value) {
            addCriterion("fnumber <=", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberLike(String value) {
            addCriterion("t0.fnumber like", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberNotLike(String value) {
            addCriterion("fnumber not like", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberIn(List<String> values) {
            addCriterion("fnumber in", values, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberNotIn(List<String> values) {
            addCriterion("fnumber not in", values, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberBetween(String value1, String value2) {
            addCriterion("fnumber between", value1, value2, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberNotBetween(String value1, String value2) {
            addCriterion("fnumber not between", value1, value2, "fnumber");
            return (Criteria) this;
        }


        public Criteria andFbuyerIsNull() {
            addCriterion("fbuyer is null");
            return (Criteria) this;
        }

        public Criteria andFbuyerIsNotNull() {
            addCriterion("fbuyer is not null");
            return (Criteria) this;
        }

        public Criteria andFbuyerEqualTo(String value) {
            addCriterion("fbuyer =", value, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerNotEqualTo(String value) {
            addCriterion("fbuyer <>", value, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerGreaterThan(String value) {
            addCriterion("fbuyer >", value, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerGreaterThanOrEqualTo(String value) {
            addCriterion("fbuyer >=", value, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerLessThan(String value) {
            addCriterion("fbuyer <", value, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerLessThanOrEqualTo(String value) {
            addCriterion("fbuyer <=", value, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerLike(String value) {
            addCriterion("t0.fbuyer like", value, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerNotLike(String value) {
            addCriterion("fbuyer not like", value, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerIn(List<String> values) {
            addCriterion("fbuyer in", values, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerNotIn(List<String> values) {
            addCriterion("fbuyer not in", values, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerBetween(String value1, String value2) {
            addCriterion("fbuyer between", value1, value2, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFbuyerNotBetween(String value1, String value2) {
            addCriterion("fbuyer not between", value1, value2, "fbuyer");
            return (Criteria) this;
        }

        public Criteria andFsupplieridIsNull() {
            addCriterion("fsupplierid is null");
            return (Criteria) this;
        }

        public Criteria andFsupplieridIsNotNull() {
            addCriterion("fsupplierid is not null");
            return (Criteria) this;
        }

        public Criteria andFsupplieridEqualTo(Integer value) {
            addCriterion("fsupplierid =", value, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridNotEqualTo(Integer value) {
            addCriterion("fsupplierid <>", value, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridGreaterThan(Integer value) {
            addCriterion("fsupplierid >", value, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsupplierid >=", value, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridLessThan(Integer value) {
            addCriterion("fsupplierid <", value, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridLessThanOrEqualTo(Integer value) {
            addCriterion("fsupplierid <=", value, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridIn(List<Integer> values) {
            addCriterion("fsupplierid in", values, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridNotIn(List<Integer> values) {
            addCriterion("fsupplierid not in", values, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridBetween(Integer value1, Integer value2) {
            addCriterion("fsupplierid between", value1, value2, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFsupplieridNotBetween(Integer value1, Integer value2) {
            addCriterion("fsupplierid not between", value1, value2, "fsupplierid");
            return (Criteria) this;
        }

        public Criteria andFcustomidIsNull() {
            addCriterion("fcustomid is null");
            return (Criteria) this;
        }

        public Criteria andFcustomidIsNotNull() {
            addCriterion("fcustomid is not null");
            return (Criteria) this;
        }

        public Criteria andFcustomidEqualTo(Integer value) {
            addCriterion("fcustomid =", value, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidNotEqualTo(Integer value) {
            addCriterion("fcustomid <>", value, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidGreaterThan(Integer value) {
            addCriterion("fcustomid >", value, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fcustomid >=", value, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidLessThan(Integer value) {
            addCriterion("fcustomid <", value, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidLessThanOrEqualTo(Integer value) {
            addCriterion("fcustomid <=", value, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidIn(List<Integer> values) {
            addCriterion("fcustomid in", values, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidNotIn(List<Integer> values) {
            addCriterion("fcustomid not in", values, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidBetween(Integer value1, Integer value2) {
            addCriterion("fcustomid between", value1, value2, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFcustomidNotBetween(Integer value1, Integer value2) {
            addCriterion("fcustomid not between", value1, value2, "fcustomid");
            return (Criteria) this;
        }

        public Criteria andFrestockidIsNull() {
            addCriterion("frestockid is null");
            return (Criteria) this;
        }

        public Criteria andFrestockidIsNotNull() {
            addCriterion("frestockid is not null");
            return (Criteria) this;
        }

        public Criteria andFrestockidEqualTo(Integer value) {
            addCriterion("frestockid =", value, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidNotEqualTo(Integer value) {
            addCriterion("frestockid <>", value, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidGreaterThan(Integer value) {
            addCriterion("frestockid >", value, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidGreaterThanOrEqualTo(Integer value) {
            addCriterion("frestockid >=", value, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidLessThan(Integer value) {
            addCriterion("frestockid <", value, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidLessThanOrEqualTo(Integer value) {
            addCriterion("frestockid <=", value, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidIn(List<Integer> values) {
            addCriterion("frestockid in", values, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidNotIn(List<Integer> values) {
            addCriterion("frestockid not in", values, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidBetween(Integer value1, Integer value2) {
            addCriterion("frestockid between", value1, value2, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFrestockidNotBetween(Integer value1, Integer value2) {
            addCriterion("frestockid not between", value1, value2, "frestockid");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNull() {
            addCriterion("fcreatetime is null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNotNull() {
            addCriterion("fcreatetime is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeEqualTo(Date value) {
            addCriterion("fcreatetime =", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotEqualTo(Date value) {
            addCriterion("fcreatetime <>", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThan(Date value) {
            addCriterion("fcreatetime >", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fcreatetime >=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThan(Date value) {
            addCriterion("fcreatetime <", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("fcreatetime <=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIn(List<Date> values) {
            addCriterion("fcreatetime in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotIn(List<Date> values) {
            addCriterion("fcreatetime not in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeBetween(Date value1, Date value2) {
            addCriterion("fcreatetime between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("fcreatetime not between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFbizdateIsNull() {
            addCriterion("fbizdate is null");
            return (Criteria) this;
        }

        public Criteria andFbizdateIsNotNull() {
            addCriterion("fbizdate is not null");
            return (Criteria) this;
        }

        public Criteria andFbizdateEqualTo(Date value) {
            addCriterion("fbizdate =", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateNotEqualTo(Date value) {
            addCriterion("fbizdate <>", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateGreaterThan(Date value) {
            addCriterion("fbizdate >", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateGreaterThanOrEqualTo(Date value) {
            addCriterion("fbizdate >=", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateLessThan(Date value) {
            addCriterion("fbizdate <", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateLessThanOrEqualTo(Date value) {
            addCriterion("fbizdate <=", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateIn(List<Date> values) {
            addCriterion("fbizdate in", values, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateNotIn(List<Date> values) {
            addCriterion("fbizdate not in", values, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateBetween(Date value1, Date value2) {
            addCriterion("fbizdate between", value1, value2, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateNotBetween(Date value1, Date value2) {
            addCriterion("fbizdate not between", value1, value2, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFcruseridIsNull() {
            addCriterion("fcruserid is null");
            return (Criteria) this;
        }

        public Criteria andFcruseridIsNotNull() {
            addCriterion("fcruserid is not null");
            return (Criteria) this;
        }

        public Criteria andFcruseridEqualTo(Integer value) {
            addCriterion("fcruserid =", value, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridNotEqualTo(Integer value) {
            addCriterion("fcruserid <>", value, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridGreaterThan(Integer value) {
            addCriterion("fcruserid >", value, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fcruserid >=", value, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridLessThan(Integer value) {
            addCriterion("fcruserid <", value, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridLessThanOrEqualTo(Integer value) {
            addCriterion("fcruserid <=", value, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridIn(List<Integer> values) {
            addCriterion("fcruserid in", values, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridNotIn(List<Integer> values) {
            addCriterion("fcruserid not in", values, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridBetween(Integer value1, Integer value2) {
            addCriterion("fcruserid between", value1, value2, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcruseridNotBetween(Integer value1, Integer value2) {
            addCriterion("fcruserid not between", value1, value2, "fcruserid");
            return (Criteria) this;
        }

        public Criteria andFcheckdateIsNull() {
            addCriterion("fcheckdate is null");
            return (Criteria) this;
        }

        public Criteria andFcheckdateIsNotNull() {
            addCriterion("fcheckdate is not null");
            return (Criteria) this;
        }

        public Criteria andFcheckdateEqualTo(Date value) {
            addCriterion("fcheckdate =", value, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateNotEqualTo(Date value) {
            addCriterion("fcheckdate <>", value, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateGreaterThan(Date value) {
            addCriterion("fcheckdate >", value, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateGreaterThanOrEqualTo(Date value) {
            addCriterion("fcheckdate >=", value, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateLessThan(Date value) {
            addCriterion("fcheckdate <", value, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateLessThanOrEqualTo(Date value) {
            addCriterion("fcheckdate <=", value, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateIn(List<Date> values) {
            addCriterion("fcheckdate in", values, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateNotIn(List<Date> values) {
            addCriterion("fcheckdate not in", values, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateBetween(Date value1, Date value2) {
            addCriterion("fcheckdate between", value1, value2, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFcheckdateNotBetween(Date value1, Date value2) {
            addCriterion("fcheckdate not between", value1, value2, "fcheckdate");
            return (Criteria) this;
        }

        public Criteria andFchuseridIsNull() {
            addCriterion("fchuserid is null");
            return (Criteria) this;
        }

        public Criteria andFchuseridIsNotNull() {
            addCriterion("fchuserid is not null");
            return (Criteria) this;
        }

        public Criteria andFchuseridEqualTo(Integer value) {
            addCriterion("fchuserid =", value, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridNotEqualTo(Integer value) {
            addCriterion("fchuserid <>", value, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridGreaterThan(Integer value) {
            addCriterion("fchuserid >", value, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fchuserid >=", value, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridLessThan(Integer value) {
            addCriterion("fchuserid <", value, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridLessThanOrEqualTo(Integer value) {
            addCriterion("fchuserid <=", value, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridIn(List<Integer> values) {
            addCriterion("fchuserid in", values, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridNotIn(List<Integer> values) {
            addCriterion("fchuserid not in", values, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridBetween(Integer value1, Integer value2) {
            addCriterion("fchuserid between", value1, value2, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFchuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("fchuserid not between", value1, value2, "fchuserid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidIsNull() {
            addCriterion("fdepartmentid is null");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidIsNotNull() {
            addCriterion("fdepartmentid is not null");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidEqualTo(Integer value) {
            addCriterion("fdepartmentid =", value, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidNotEqualTo(Integer value) {
            addCriterion("fdepartmentid <>", value, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidGreaterThan(Integer value) {
            addCriterion("fdepartmentid >", value, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fdepartmentid >=", value, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidLessThan(Integer value) {
            addCriterion("fdepartmentid <", value, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidLessThanOrEqualTo(Integer value) {
            addCriterion("fdepartmentid <=", value, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidIn(List<Integer> values) {
            addCriterion("fdepartmentid in", values, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidNotIn(List<Integer> values) {
            addCriterion("fdepartmentid not in", values, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidBetween(Integer value1, Integer value2) {
            addCriterion("fdepartmentid between", value1, value2, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFdepartmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("fdepartmentid not between", value1, value2, "fdepartmentid");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNull() {
            addCriterion("fstatus is null");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNotNull() {
            addCriterion("fstatus is not null");
            return (Criteria) this;
        }

        public Criteria andFstatusEqualTo(Integer value) {
            addCriterion("fstatus =", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotEqualTo(Integer value) {
            addCriterion("fstatus <>", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThan(Integer value) {
            addCriterion("fstatus >", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fstatus >=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThan(Integer value) {
            addCriterion("fstatus <", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThanOrEqualTo(Integer value) {
            addCriterion("fstatus <=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusIn(List<Integer> values) {
            addCriterion("fstatus in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotIn(List<Integer> values) {
            addCriterion("fstatus not in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusBetween(Integer value1, Integer value2) {
            addCriterion("fstatus between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fstatus not between", value1, value2, "fstatus");
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