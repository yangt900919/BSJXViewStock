package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillstockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillstockExample() {
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

        public Criteria andFuseridIsNull() {
            addCriterion("fuserid is null");
            return (Criteria) this;
        }

        public Criteria andFuseridIsNotNull() {
            addCriterion("fuserid is not null");
            return (Criteria) this;
        }

        public Criteria andFuseridEqualTo(Integer value) {
            addCriterion("fuserid =", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridNotEqualTo(Integer value) {
            addCriterion("fuserid <>", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridGreaterThan(Integer value) {
            addCriterion("fuserid >", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuserid >=", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridLessThan(Integer value) {
            addCriterion("fuserid <", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridLessThanOrEqualTo(Integer value) {
            addCriterion("fuserid <=", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridIn(List<Integer> values) {
            addCriterion("fuserid in", values, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridNotIn(List<Integer> values) {
            addCriterion("fuserid not in", values, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridBetween(Integer value1, Integer value2) {
            addCriterion("fuserid between", value1, value2, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("fuserid not between", value1, value2, "fuserid");
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

        public Criteria andFchedateIsNull() {
            addCriterion("fchedate is null");
            return (Criteria) this;
        }

        public Criteria andFchedateIsNotNull() {
            addCriterion("fchedate is not null");
            return (Criteria) this;
        }

        public Criteria andFchedateEqualTo(Date value) {
            addCriterion("fchedate =", value, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateNotEqualTo(Date value) {
            addCriterion("fchedate <>", value, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateGreaterThan(Date value) {
            addCriterion("fchedate >", value, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateGreaterThanOrEqualTo(Date value) {
            addCriterion("fchedate >=", value, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateLessThan(Date value) {
            addCriterion("fchedate <", value, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateLessThanOrEqualTo(Date value) {
            addCriterion("fchedate <=", value, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateIn(List<Date> values) {
            addCriterion("fchedate in", values, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateNotIn(List<Date> values) {
            addCriterion("fchedate not in", values, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateBetween(Date value1, Date value2) {
            addCriterion("fchedate between", value1, value2, "fchedate");
            return (Criteria) this;
        }

        public Criteria andFchedateNotBetween(Date value1, Date value2) {
            addCriterion("fchedate not between", value1, value2, "fchedate");
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

        public Criteria andFboxnoIsNull() {
            addCriterion("fboxno is null");
            return (Criteria) this;
        }

        public Criteria andFboxnoIsNotNull() {
            addCriterion("fboxno is not null");
            return (Criteria) this;
        }

        public Criteria andFboxnoEqualTo(String value) {
            addCriterion("fboxno =", value, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoNotEqualTo(String value) {
            addCriterion("fboxno <>", value, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoGreaterThan(String value) {
            addCriterion("fboxno >", value, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoGreaterThanOrEqualTo(String value) {
            addCriterion("fboxno >=", value, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoLessThan(String value) {
            addCriterion("fboxno <", value, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoLessThanOrEqualTo(String value) {
            addCriterion("fboxno <=", value, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoLike(String value) {
            addCriterion("t0.fnumber like", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFboxnoNotLike(String value) {
            addCriterion("fboxno not like", value, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoIn(List<String> values) {
            addCriterion("fboxno in", values, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoNotIn(List<String> values) {
            addCriterion("fboxno not in", values, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoBetween(String value1, String value2) {
            addCriterion("fboxno between", value1, value2, "fboxno");
            return (Criteria) this;
        }

        public Criteria andFboxnoNotBetween(String value1, String value2) {
            addCriterion("fboxno not between", value1, value2, "fboxno");
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

        public Criteria andFisqtIsNull() {
            addCriterion("fisqt is null");
            return (Criteria) this;
        }

        public Criteria andFisqtIsNotNull() {
            addCriterion("fisqt is not null");
            return (Criteria) this;
        }

        public Criteria andFisqtEqualTo(Integer value) {
            addCriterion("fisqt =", value, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFisqtNotEqualTo(Integer value) {
            addCriterion("fisqt <>", value, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFisqtGreaterThan(Integer value) {
            addCriterion("fisqt >", value, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFisqtGreaterThanOrEqualTo(Integer value) {
            addCriterion("fisqt >=", value, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFisqtLessThan(Integer value) {
            addCriterion("fisqt <", value, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFisqtLessThanOrEqualTo(Integer value) {
            addCriterion("fisqt <=", value, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFisqtIn(List<Integer> values) {
            addCriterion("fisqt in", values, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFisqtNotIn(List<Integer> values) {
            addCriterion("fkeeperid not in", values, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFisqtBetween(Integer value1, Integer value2) {
            addCriterion("fisqt between", value1, value2, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFisqtNotBetween(Integer value1, Integer value2) {
            addCriterion("fisqt not between", value1, value2, "fisqt");
            return (Criteria) this;
        }

        public Criteria andFkeeperidIsNull() {
            addCriterion("fkeeperid is null");
            return (Criteria) this;
        }

        public Criteria andFkeeperidIsNotNull() {
            addCriterion("fkeeperid is not null");
            return (Criteria) this;
        }

        public Criteria andFkeeperidEqualTo(Integer value) {
            addCriterion("fkeeperid =", value, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidNotEqualTo(Integer value) {
            addCriterion("fkeeperid <>", value, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidGreaterThan(Integer value) {
            addCriterion("fkeeperid >", value, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fkeeperid >=", value, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidLessThan(Integer value) {
            addCriterion("fkeeperid <", value, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidLessThanOrEqualTo(Integer value) {
            addCriterion("fkeeperid <=", value, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidIn(List<Integer> values) {
            addCriterion("fkeeperid in", values, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidNotIn(List<Integer> values) {
            addCriterion("fkeeperid not in", values, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidBetween(Integer value1, Integer value2) {
            addCriterion("fkeeperid between", value1, value2, "fkeeperid");
            return (Criteria) this;
        }

        public Criteria andFkeeperidNotBetween(Integer value1, Integer value2) {
            addCriterion("fkeeperid not between", value1, value2, "fkeeperid");
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