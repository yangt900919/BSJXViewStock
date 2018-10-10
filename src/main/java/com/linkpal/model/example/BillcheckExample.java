package com.linkpal.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillcheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillcheckExample() {
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

        public Criteria andFcruidIsNull() {
            addCriterion("fcruid is null");
            return (Criteria) this;
        }

        public Criteria andFcruidIsNotNull() {
            addCriterion("fcruid is not null");
            return (Criteria) this;
        }

        public Criteria andFcruidEqualTo(Integer value) {
            addCriterion("fcruid =", value, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidNotEqualTo(Integer value) {
            addCriterion("fcruid <>", value, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidGreaterThan(Integer value) {
            addCriterion("fcruid >", value, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fcruid >=", value, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidLessThan(Integer value) {
            addCriterion("fcruid <", value, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidLessThanOrEqualTo(Integer value) {
            addCriterion("fcruid <=", value, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidIn(List<Integer> values) {
            addCriterion("fcruid in", values, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidNotIn(List<Integer> values) {
            addCriterion("fcruid not in", values, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidBetween(Integer value1, Integer value2) {
            addCriterion("fcruid between", value1, value2, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFcruidNotBetween(Integer value1, Integer value2) {
            addCriterion("fcruid not between", value1, value2, "fcruid");
            return (Criteria) this;
        }

        public Criteria andFchuidIsNull() {
            addCriterion("fchuid is null");
            return (Criteria) this;
        }

        public Criteria andFchuidIsNotNull() {
            addCriterion("fchuid is not null");
            return (Criteria) this;
        }

        public Criteria andFchuidEqualTo(Integer value) {
            addCriterion("fchuid =", value, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidNotEqualTo(Integer value) {
            addCriterion("fchuid <>", value, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidGreaterThan(Integer value) {
            addCriterion("fchuid >", value, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fchuid >=", value, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidLessThan(Integer value) {
            addCriterion("fchuid <", value, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidLessThanOrEqualTo(Integer value) {
            addCriterion("fchuid <=", value, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidIn(List<Integer> values) {
            addCriterion("fchuid in", values, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidNotIn(List<Integer> values) {
            addCriterion("fchuid not in", values, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidBetween(Integer value1, Integer value2) {
            addCriterion("fchuid between", value1, value2, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFchuidNotBetween(Integer value1, Integer value2) {
            addCriterion("fchuid not between", value1, value2, "fchuid");
            return (Criteria) this;
        }

        public Criteria andFcretimeIsNull() {
            addCriterion("fcretime is null");
            return (Criteria) this;
        }

        public Criteria andFcretimeIsNotNull() {
            addCriterion("fcretime is not null");
            return (Criteria) this;
        }

        public Criteria andFcretimeEqualTo(Date value) {
            addCriterion("fcretime =", value, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeNotEqualTo(Date value) {
            addCriterion("fcretime <>", value, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeGreaterThan(Date value) {
            addCriterion("fcretime >", value, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fcretime >=", value, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeLessThan(Date value) {
            addCriterion("fcretime <", value, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeLessThanOrEqualTo(Date value) {
            addCriterion("fcretime <=", value, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeIn(List<Date> values) {
            addCriterion("fcretime in", values, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeNotIn(List<Date> values) {
            addCriterion("fcretime not in", values, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeBetween(Date value1, Date value2) {
            addCriterion("fcretime between", value1, value2, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFcretimeNotBetween(Date value1, Date value2) {
            addCriterion("fcretime not between", value1, value2, "fcretime");
            return (Criteria) this;
        }

        public Criteria andFchetimeIsNull() {
            addCriterion("fchetime is null");
            return (Criteria) this;
        }

        public Criteria andFchetimeIsNotNull() {
            addCriterion("fchetime is not null");
            return (Criteria) this;
        }

        public Criteria andFchetimeEqualTo(Date value) {
            addCriterion("fchetime =", value, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeNotEqualTo(Date value) {
            addCriterion("fchetime <>", value, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeGreaterThan(Date value) {
            addCriterion("fchetime >", value, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fchetime >=", value, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeLessThan(Date value) {
            addCriterion("fchetime <", value, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeLessThanOrEqualTo(Date value) {
            addCriterion("fchetime <=", value, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeIn(List<Date> values) {
            addCriterion("fchetime in", values, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeNotIn(List<Date> values) {
            addCriterion("fchetime not in", values, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeBetween(Date value1, Date value2) {
            addCriterion("fchetime between", value1, value2, "fchetime");
            return (Criteria) this;
        }

        public Criteria andFchetimeNotBetween(Date value1, Date value2) {
            addCriterion("fchetime not between", value1, value2, "fchetime");
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

        public BillcheckExample.Criteria andFboxnoIsNull() {
            addCriterion("fboxno is null");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoIsNotNull() {
            addCriterion("fboxno is not null");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoEqualTo(String value) {
            addCriterion("fboxno =", value, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoNotEqualTo(String value) {
            addCriterion("fboxno <>", value, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoGreaterThan(String value) {
            addCriterion("fboxno >", value, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoGreaterThanOrEqualTo(String value) {
            addCriterion("fboxno >=", value, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoLessThan(String value) {
            addCriterion("fboxno <", value, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoLessThanOrEqualTo(String value) {
            addCriterion("fboxno <=", value, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoLike(String value) {
            addCriterion("t0.fnumber like", value, "fnumber");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoNotLike(String value) {
            addCriterion("fboxno not like", value, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoIn(List<String> values) {
            addCriterion("fboxno in", values, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoNotIn(List<String> values) {
            addCriterion("fboxno not in", values, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoBetween(String value1, String value2) {
            addCriterion("fboxno between", value1, value2, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFboxnoNotBetween(String value1, String value2) {
            addCriterion("fboxno not between", value1, value2, "fboxno");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutIsNull() {
            addCriterion("fisinout is null");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutIsNotNull() {
            addCriterion("fisinout is not null");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutEqualTo(Integer value) {
            addCriterion("fisinout =", value, "fisinout");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutNotEqualTo(Integer value) {
            addCriterion("fisinout <>", value, "fisinout");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutGreaterThan(Integer value) {
            addCriterion("fisinout >", value, "fisinout");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("fisinout >=", value, "fisinout");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutLessThan(Integer value) {
            addCriterion("fisinout <", value, "fisinout");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutLessThanOrEqualTo(Integer value) {
            addCriterion("fisinout <=", value, "fisinout");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutIn(List<Integer> values) {
            addCriterion("fisinout in", values, "fisinout");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutNotIn(List<Integer> values) {
            addCriterion("fkeeperid not in", values, "fkeeperid");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutBetween(Integer value1, Integer value2) {
            addCriterion("fisinout between", value1, value2, "fisinout");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisinoutNotBetween(Integer value1, Integer value2) {
            addCriterion("fisinout not between", value1, value2, "fisqt");
            return (BillcheckExample.Criteria) this;
        }


        public BillcheckExample.Criteria andFisqtIsNull() {
            addCriterion("fisqt is null");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtIsNotNull() {
            addCriterion("fisqt is not null");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtEqualTo(Integer value) {
            addCriterion("fisqt =", value, "fisqt");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtNotEqualTo(Integer value) {
            addCriterion("fisqt <>", value, "fisqt");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtGreaterThan(Integer value) {
            addCriterion("fisqt >", value, "fisqt");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtGreaterThanOrEqualTo(Integer value) {
            addCriterion("fisqt >=", value, "fisqt");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtLessThan(Integer value) {
            addCriterion("fisqt <", value, "fisqt");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtLessThanOrEqualTo(Integer value) {
            addCriterion("fisqt <=", value, "fisqt");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtIn(List<Integer> values) {
            addCriterion("fisqt in", values, "fisqt");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtNotIn(List<Integer> values) {
            addCriterion("fkeeperid not in", values, "fkeeperid");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtBetween(Integer value1, Integer value2) {
            addCriterion("fisqt between", value1, value2, "fisqt");
            return (BillcheckExample.Criteria) this;
        }

        public BillcheckExample.Criteria andFisqtNotBetween(Integer value1, Integer value2) {
            addCriterion("fisqt not between", value1, value2, "fisqt");
            return (BillcheckExample.Criteria) this;
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