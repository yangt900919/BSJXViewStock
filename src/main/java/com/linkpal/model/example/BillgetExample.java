package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillgetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillgetExample() {
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
            addCriterion("t0.fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("t0.fid =", value, "fid");
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

        public Criteria andFdodateIsNull() {
            addCriterion("fdodate is null");
            return (Criteria) this;
        }

        public Criteria andFdodateIsNotNull() {
            addCriterion("fdodate is not null");
            return (Criteria) this;
        }

        public Criteria andFdodateEqualTo(Date value) {
            addCriterion("fdodate =", value, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateNotEqualTo(Date value) {
            addCriterion("fdodate <>", value, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateGreaterThan(Date value) {
            addCriterion("fdodate >", value, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateGreaterThanOrEqualTo(Date value) {
            addCriterion("fdodate >=", value, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateLessThan(Date value) {
            addCriterion("fdodate <", value, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateLessThanOrEqualTo(Date value) {
            addCriterion("fdodate <=", value, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateIn(List<Date> values) {
            addCriterion("fdodate in", values, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateNotIn(List<Date> values) {
            addCriterion("fdodate not in", values, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateBetween(Date value1, Date value2) {
            addCriterion("fdodate between", value1, value2, "fdodate");
            return (Criteria) this;
        }

        public Criteria andFdodateNotBetween(Date value1, Date value2) {
            addCriterion("fdodate not between", value1, value2, "fdodate");
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

        public Criteria andFgeteridIsNull() {
            addCriterion("fgeterid is null");
            return (Criteria) this;
        }

        public Criteria andFgeteridIsNotNull() {
            addCriterion("fgeterid is not null");
            return (Criteria) this;
        }

        public Criteria andFgeteridEqualTo(Integer value) {
            addCriterion("fgeterid =", value, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridNotEqualTo(Integer value) {
            addCriterion("fgeterid <>", value, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridGreaterThan(Integer value) {
            addCriterion("fgeterid >", value, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fgeterid >=", value, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridLessThan(Integer value) {
            addCriterion("fgeterid <", value, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridLessThanOrEqualTo(Integer value) {
            addCriterion("fgeterid <=", value, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridIn(List<Integer> values) {
            addCriterion("fgeterid in", values, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridNotIn(List<Integer> values) {
            addCriterion("fgeterid not in", values, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridBetween(Integer value1, Integer value2) {
            addCriterion("fgeterid between", value1, value2, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFgeteridNotBetween(Integer value1, Integer value2) {
            addCriterion("fgeterid not between", value1, value2, "fgeterid");
            return (Criteria) this;
        }

        public Criteria andFsenderidIsNull() {
            addCriterion("fsenderid is null");
            return (Criteria) this;
        }

        public Criteria andFsenderidIsNotNull() {
            addCriterion("fsenderid is not null");
            return (Criteria) this;
        }

        public Criteria andFsenderidEqualTo(Integer value) {
            addCriterion("fsenderid =", value, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidNotEqualTo(Integer value) {
            addCriterion("fsenderid <>", value, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidGreaterThan(Integer value) {
            addCriterion("fsenderid >", value, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsenderid >=", value, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidLessThan(Integer value) {
            addCriterion("fsenderid <", value, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidLessThanOrEqualTo(Integer value) {
            addCriterion("fsenderid <=", value, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidIn(List<Integer> values) {
            addCriterion("fsenderid in", values, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidNotIn(List<Integer> values) {
            addCriterion("fsenderid not in", values, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidBetween(Integer value1, Integer value2) {
            addCriterion("fsenderid between", value1, value2, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFsenderidNotBetween(Integer value1, Integer value2) {
            addCriterion("fsenderid not between", value1, value2, "fsenderid");
            return (Criteria) this;
        }

        public Criteria andFcreateridIsNull() {
            addCriterion("fcreaterid is null");
            return (Criteria) this;
        }

        public Criteria andFcreateridIsNotNull() {
            addCriterion("fcreaterid is not null");
            return (Criteria) this;
        }

        public Criteria andFcreateridEqualTo(Integer value) {
            addCriterion("fcreaterid =", value, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridNotEqualTo(Integer value) {
            addCriterion("fcreaterid <>", value, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridGreaterThan(Integer value) {
            addCriterion("fcreaterid >", value, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fcreaterid >=", value, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridLessThan(Integer value) {
            addCriterion("fcreaterid <", value, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridLessThanOrEqualTo(Integer value) {
            addCriterion("fcreaterid <=", value, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridIn(List<Integer> values) {
            addCriterion("fcreaterid in", values, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridNotIn(List<Integer> values) {
            addCriterion("fcreaterid not in", values, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridBetween(Integer value1, Integer value2) {
            addCriterion("fcreaterid between", value1, value2, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreateridNotBetween(Integer value1, Integer value2) {
            addCriterion("fcreaterid not between", value1, value2, "fcreaterid");
            return (Criteria) this;
        }

        public Criteria andFcreatedateIsNull() {
            addCriterion("fcreatedate is null");
            return (Criteria) this;
        }

        public Criteria andFcreatedateIsNotNull() {
            addCriterion("fcreatedate is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatedateEqualTo(Date value) {
            addCriterion("fcreatedate =", value, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateNotEqualTo(Date value) {
            addCriterion("fcreatedate <>", value, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateGreaterThan(Date value) {
            addCriterion("fcreatedate >", value, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("fcreatedate >=", value, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateLessThan(Date value) {
            addCriterion("fcreatedate <", value, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateLessThanOrEqualTo(Date value) {
            addCriterion("fcreatedate <=", value, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateIn(List<Date> values) {
            addCriterion("fcreatedate in", values, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateNotIn(List<Date> values) {
            addCriterion("fcreatedate not in", values, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateBetween(Date value1, Date value2) {
            addCriterion("fcreatedate between", value1, value2, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFcreatedateNotBetween(Date value1, Date value2) {
            addCriterion("fcreatedate not between", value1, value2, "fcreatedate");
            return (Criteria) this;
        }

        public Criteria andFauditoridIsNull() {
            addCriterion("fauditorid is null");
            return (Criteria) this;
        }

        public Criteria andFauditoridIsNotNull() {
            addCriterion("fauditorid is not null");
            return (Criteria) this;
        }

        public Criteria andFauditoridEqualTo(Integer value) {
            addCriterion("fauditorid =", value, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridNotEqualTo(Integer value) {
            addCriterion("fauditorid <>", value, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridGreaterThan(Integer value) {
            addCriterion("fauditorid >", value, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fauditorid >=", value, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridLessThan(Integer value) {
            addCriterion("fauditorid <", value, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridLessThanOrEqualTo(Integer value) {
            addCriterion("fauditorid <=", value, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridIn(List<Integer> values) {
            addCriterion("fauditorid in", values, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridNotIn(List<Integer> values) {
            addCriterion("fauditorid not in", values, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridBetween(Integer value1, Integer value2) {
            addCriterion("fauditorid between", value1, value2, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditoridNotBetween(Integer value1, Integer value2) {
            addCriterion("fauditorid not between", value1, value2, "fauditorid");
            return (Criteria) this;
        }

        public Criteria andFauditdateIsNull() {
            addCriterion("fauditdate is null");
            return (Criteria) this;
        }

        public Criteria andFauditdateIsNotNull() {
            addCriterion("fauditdate is not null");
            return (Criteria) this;
        }

        public Criteria andFauditdateEqualTo(Date value) {
            addCriterion("fauditdate =", value, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateNotEqualTo(Date value) {
            addCriterion("fauditdate <>", value, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateGreaterThan(Date value) {
            addCriterion("fauditdate >", value, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateGreaterThanOrEqualTo(Date value) {
            addCriterion("fauditdate >=", value, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateLessThan(Date value) {
            addCriterion("fauditdate <", value, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateLessThanOrEqualTo(Date value) {
            addCriterion("fauditdate <=", value, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateIn(List<Date> values) {
            addCriterion("fauditdate in", values, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateNotIn(List<Date> values) {
            addCriterion("fauditdate not in", values, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateBetween(Date value1, Date value2) {
            addCriterion("fauditdate between", value1, value2, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFauditdateNotBetween(Date value1, Date value2) {
            addCriterion("fauditdate not between", value1, value2, "fauditdate");
            return (Criteria) this;
        }

        public Criteria andFbiztypeIsNull() {
            addCriterion("fbiztype is null");
            return (Criteria) this;
        }

        public Criteria andFbiztypeIsNotNull() {
            addCriterion("fbiztype is not null");
            return (Criteria) this;
        }

        public Criteria andFbiztypeEqualTo(String value) {
            addCriterion("fbiztype =", value, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeNotEqualTo(String value) {
            addCriterion("fbiztype <>", value, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeGreaterThan(String value) {
            addCriterion("fbiztype >", value, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeGreaterThanOrEqualTo(String value) {
            addCriterion("fbiztype >=", value, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeLessThan(String value) {
            addCriterion("fbiztype <", value, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeLessThanOrEqualTo(String value) {
            addCriterion("fbiztype <=", value, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeLike(String value) {
            addCriterion("fbiztype like", value, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeNotLike(String value) {
            addCriterion("fbiztype not like", value, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeIn(List<String> values) {
            addCriterion("fbiztype in", values, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeNotIn(List<String> values) {
            addCriterion("fbiztype not in", values, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeBetween(String value1, String value2) {
            addCriterion("fbiztype between", value1, value2, "fbiztype");
            return (Criteria) this;
        }

        public Criteria andFbiztypeNotBetween(String value1, String value2) {
            addCriterion("fbiztype not between", value1, value2, "fbiztype");
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

        public BillgetExample.Criteria andFisqtIsNull() {
            addCriterion("fisqt is null");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtIsNotNull() {
            addCriterion("fisqt is not null");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtEqualTo(Integer value) {
            addCriterion("fisqt =", value, "fisqt");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtNotEqualTo(Integer value) {
            addCriterion("fisqt <>", value, "fisqt");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtGreaterThan(Integer value) {
            addCriterion("fisqt >", value, "fisqt");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtGreaterThanOrEqualTo(Integer value) {
            addCriterion("fisqt >=", value, "fisqt");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtLessThan(Integer value) {
            addCriterion("fisqt <", value, "fisqt");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtLessThanOrEqualTo(Integer value) {
            addCriterion("fisqt <=", value, "fisqt");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtIn(List<Integer> values) {
            addCriterion("fisqt in", values, "fisqt");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtNotIn(List<Integer> values) {
            addCriterion("fkeeperid not in", values, "fkeeperid");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtBetween(Integer value1, Integer value2) {
            addCriterion("fisqt between", value1, value2, "fisqt");
            return (BillgetExample.Criteria) this;
        }

        public BillgetExample.Criteria andFisqtNotBetween(Integer value1, Integer value2) {
            addCriterion("fisqt not between", value1, value2, "fisqt");
            return (BillgetExample.Criteria) this;
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