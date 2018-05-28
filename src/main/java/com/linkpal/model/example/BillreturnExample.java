package com.linkpal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillreturnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillreturnExample() {
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

        public Criteria andFcreatoridIsNull() {
            addCriterion("fcreatorid is null");
            return (Criteria) this;
        }

        public Criteria andFcreatoridIsNotNull() {
            addCriterion("fcreatorid is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatoridEqualTo(Integer value) {
            addCriterion("fcreatorid =", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridNotEqualTo(Integer value) {
            addCriterion("fcreatorid <>", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridGreaterThan(Integer value) {
            addCriterion("fcreatorid >", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fcreatorid >=", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridLessThan(Integer value) {
            addCriterion("fcreatorid <", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridLessThanOrEqualTo(Integer value) {
            addCriterion("fcreatorid <=", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridIn(List<Integer> values) {
            addCriterion("fcreatorid in", values, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridNotIn(List<Integer> values) {
            addCriterion("fcreatorid not in", values, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridBetween(Integer value1, Integer value2) {
            addCriterion("fcreatorid between", value1, value2, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("fcreatorid not between", value1, value2, "fcreatorid");
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