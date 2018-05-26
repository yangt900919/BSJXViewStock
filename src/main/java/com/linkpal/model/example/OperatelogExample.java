package com.linkpal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperatelogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperatelogExample() {
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

        public Criteria andFnumerIsNull() {
            addCriterion("FNumer is null");
            return (Criteria) this;
        }

        public Criteria andFnumerIsNotNull() {
            addCriterion("FNumer is not null");
            return (Criteria) this;
        }

        public Criteria andFnumerEqualTo(String value) {
            addCriterion("FNumer =", value, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerNotEqualTo(String value) {
            addCriterion("FNumer <>", value, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerGreaterThan(String value) {
            addCriterion("FNumer >", value, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerGreaterThanOrEqualTo(String value) {
            addCriterion("FNumer >=", value, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerLessThan(String value) {
            addCriterion("FNumer <", value, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerLessThanOrEqualTo(String value) {
            addCriterion("FNumer <=", value, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerLike(String value) {
            addCriterion("FNumer like", value, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerNotLike(String value) {
            addCriterion("FNumer not like", value, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerIn(List<String> values) {
            addCriterion("FNumer in", values, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerNotIn(List<String> values) {
            addCriterion("FNumer not in", values, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerBetween(String value1, String value2) {
            addCriterion("FNumer between", value1, value2, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFnumerNotBetween(String value1, String value2) {
            addCriterion("FNumer not between", value1, value2, "fnumer");
            return (Criteria) this;
        }

        public Criteria andFbillidIsNull() {
            addCriterion("FBillID is null");
            return (Criteria) this;
        }

        public Criteria andFbillidIsNotNull() {
            addCriterion("FBillID is not null");
            return (Criteria) this;
        }

        public Criteria andFbillidEqualTo(Integer value) {
            addCriterion("FBillID =", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidNotEqualTo(Integer value) {
            addCriterion("FBillID <>", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidGreaterThan(Integer value) {
            addCriterion("FBillID >", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FBillID >=", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidLessThan(Integer value) {
            addCriterion("FBillID <", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidLessThanOrEqualTo(Integer value) {
            addCriterion("FBillID <=", value, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidIn(List<Integer> values) {
            addCriterion("FBillID in", values, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidNotIn(List<Integer> values) {
            addCriterion("FBillID not in", values, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidBetween(Integer value1, Integer value2) {
            addCriterion("FBillID between", value1, value2, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFbillidNotBetween(Integer value1, Integer value2) {
            addCriterion("FBillID not between", value1, value2, "fbillid");
            return (Criteria) this;
        }

        public Criteria andFentryidIsNull() {
            addCriterion("FEntryID is null");
            return (Criteria) this;
        }

        public Criteria andFentryidIsNotNull() {
            addCriterion("FEntryID is not null");
            return (Criteria) this;
        }

        public Criteria andFentryidEqualTo(Integer value) {
            addCriterion("FEntryID =", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotEqualTo(Integer value) {
            addCriterion("FEntryID <>", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidGreaterThan(Integer value) {
            addCriterion("FEntryID >", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEntryID >=", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidLessThan(Integer value) {
            addCriterion("FEntryID <", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidLessThanOrEqualTo(Integer value) {
            addCriterion("FEntryID <=", value, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidIn(List<Integer> values) {
            addCriterion("FEntryID in", values, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotIn(List<Integer> values) {
            addCriterion("FEntryID not in", values, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidBetween(Integer value1, Integer value2) {
            addCriterion("FEntryID between", value1, value2, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFentryidNotBetween(Integer value1, Integer value2) {
            addCriterion("FEntryID not between", value1, value2, "fentryid");
            return (Criteria) this;
        }

        public Criteria andFuserIsNull() {
            addCriterion("FUser is null");
            return (Criteria) this;
        }

        public Criteria andFuserIsNotNull() {
            addCriterion("FUser is not null");
            return (Criteria) this;
        }

        public Criteria andFuserEqualTo(String value) {
            addCriterion("FUser =", value, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserNotEqualTo(String value) {
            addCriterion("FUser <>", value, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserGreaterThan(String value) {
            addCriterion("FUser >", value, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserGreaterThanOrEqualTo(String value) {
            addCriterion("FUser >=", value, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserLessThan(String value) {
            addCriterion("FUser <", value, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserLessThanOrEqualTo(String value) {
            addCriterion("FUser <=", value, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserLike(String value) {
            addCriterion("FUser like", value, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserNotLike(String value) {
            addCriterion("FUser not like", value, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserIn(List<String> values) {
            addCriterion("FUser in", values, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserNotIn(List<String> values) {
            addCriterion("FUser not in", values, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserBetween(String value1, String value2) {
            addCriterion("FUser between", value1, value2, "fuser");
            return (Criteria) this;
        }

        public Criteria andFuserNotBetween(String value1, String value2) {
            addCriterion("FUser not between", value1, value2, "fuser");
            return (Criteria) this;
        }

        public Criteria andFdateIsNull() {
            addCriterion("FDate is null");
            return (Criteria) this;
        }

        public Criteria andFdateIsNotNull() {
            addCriterion("FDate is not null");
            return (Criteria) this;
        }

        public Criteria andFdateEqualTo(Date value) {
            addCriterion("FDate =", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotEqualTo(Date value) {
            addCriterion("FDate <>", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThan(Date value) {
            addCriterion("FDate >", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThanOrEqualTo(Date value) {
            addCriterion("FDate >=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThan(Date value) {
            addCriterion("FDate <", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThanOrEqualTo(Date value) {
            addCriterion("FDate <=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateIn(List<Date> values) {
            addCriterion("FDate in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotIn(List<Date> values) {
            addCriterion("FDate not in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateBetween(Date value1, Date value2) {
            addCriterion("FDate between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotBetween(Date value1, Date value2) {
            addCriterion("FDate not between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNull() {
            addCriterion("FType is null");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNotNull() {
            addCriterion("FType is not null");
            return (Criteria) this;
        }

        public Criteria andFtypeEqualTo(String value) {
            addCriterion("FType =", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotEqualTo(String value) {
            addCriterion("FType <>", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThan(String value) {
            addCriterion("FType >", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThanOrEqualTo(String value) {
            addCriterion("FType >=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThan(String value) {
            addCriterion("FType <", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThanOrEqualTo(String value) {
            addCriterion("FType <=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLike(String value) {
            addCriterion("FType like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotLike(String value) {
            addCriterion("FType not like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeIn(List<String> values) {
            addCriterion("FType in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotIn(List<String> values) {
            addCriterion("FType not in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeBetween(String value1, String value2) {
            addCriterion("FType between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotBetween(String value1, String value2) {
            addCriterion("FType not between", value1, value2, "ftype");
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

        public Criteria andFacqtyIsNull() {
            addCriterion("FAcQty is null");
            return (Criteria) this;
        }

        public Criteria andFacqtyIsNotNull() {
            addCriterion("FAcQty is not null");
            return (Criteria) this;
        }

        public Criteria andFacqtyEqualTo(Double value) {
            addCriterion("FAcQty =", value, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyNotEqualTo(Double value) {
            addCriterion("FAcQty <>", value, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyGreaterThan(Double value) {
            addCriterion("FAcQty >", value, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyGreaterThanOrEqualTo(Double value) {
            addCriterion("FAcQty >=", value, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyLessThan(Double value) {
            addCriterion("FAcQty <", value, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyLessThanOrEqualTo(Double value) {
            addCriterion("FAcQty <=", value, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyIn(List<Double> values) {
            addCriterion("FAcQty in", values, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyNotIn(List<Double> values) {
            addCriterion("FAcQty not in", values, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyBetween(Double value1, Double value2) {
            addCriterion("FAcQty between", value1, value2, "facqty");
            return (Criteria) this;
        }

        public Criteria andFacqtyNotBetween(Double value1, Double value2) {
            addCriterion("FAcQty not between", value1, value2, "facqty");
            return (Criteria) this;
        }

        public Criteria andFstockIsNull() {
            addCriterion("FStock is null");
            return (Criteria) this;
        }

        public Criteria andFstockIsNotNull() {
            addCriterion("FStock is not null");
            return (Criteria) this;
        }

        public Criteria andFstockEqualTo(String value) {
            addCriterion("FStock =", value, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockNotEqualTo(String value) {
            addCriterion("FStock <>", value, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockGreaterThan(String value) {
            addCriterion("FStock >", value, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockGreaterThanOrEqualTo(String value) {
            addCriterion("FStock >=", value, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockLessThan(String value) {
            addCriterion("FStock <", value, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockLessThanOrEqualTo(String value) {
            addCriterion("FStock <=", value, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockLike(String value) {
            addCriterion("FStock like", value, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockNotLike(String value) {
            addCriterion("FStock not like", value, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockIn(List<String> values) {
            addCriterion("FStock in", values, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockNotIn(List<String> values) {
            addCriterion("FStock not in", values, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockBetween(String value1, String value2) {
            addCriterion("FStock between", value1, value2, "fstock");
            return (Criteria) this;
        }

        public Criteria andFstockNotBetween(String value1, String value2) {
            addCriterion("FStock not between", value1, value2, "fstock");
            return (Criteria) this;
        }

        public Criteria andFgoodseatIsNull() {
            addCriterion("FGoodSeat is null");
            return (Criteria) this;
        }

        public Criteria andFgoodseatIsNotNull() {
            addCriterion("FGoodSeat is not null");
            return (Criteria) this;
        }

        public Criteria andFgoodseatEqualTo(String value) {
            addCriterion("FGoodSeat =", value, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatNotEqualTo(String value) {
            addCriterion("FGoodSeat <>", value, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatGreaterThan(String value) {
            addCriterion("FGoodSeat >", value, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatGreaterThanOrEqualTo(String value) {
            addCriterion("FGoodSeat >=", value, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatLessThan(String value) {
            addCriterion("FGoodSeat <", value, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatLessThanOrEqualTo(String value) {
            addCriterion("FGoodSeat <=", value, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatLike(String value) {
            addCriterion("FGoodSeat like", value, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatNotLike(String value) {
            addCriterion("FGoodSeat not like", value, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatIn(List<String> values) {
            addCriterion("FGoodSeat in", values, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatNotIn(List<String> values) {
            addCriterion("FGoodSeat not in", values, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatBetween(String value1, String value2) {
            addCriterion("FGoodSeat between", value1, value2, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFgoodseatNotBetween(String value1, String value2) {
            addCriterion("FGoodSeat not between", value1, value2, "fgoodseat");
            return (Criteria) this;
        }

        public Criteria andFmdateIsNull() {
            addCriterion("FMdate is null");
            return (Criteria) this;
        }

        public Criteria andFmdateIsNotNull() {
            addCriterion("FMdate is not null");
            return (Criteria) this;
        }

        public Criteria andFmdateEqualTo(Date value) {
            addCriterion("FMdate =", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateNotEqualTo(Date value) {
            addCriterion("FMdate <>", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateGreaterThan(Date value) {
            addCriterion("FMdate >", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateGreaterThanOrEqualTo(Date value) {
            addCriterion("FMdate >=", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateLessThan(Date value) {
            addCriterion("FMdate <", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateLessThanOrEqualTo(Date value) {
            addCriterion("FMdate <=", value, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateIn(List<Date> values) {
            addCriterion("FMdate in", values, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateNotIn(List<Date> values) {
            addCriterion("FMdate not in", values, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateBetween(Date value1, Date value2) {
            addCriterion("FMdate between", value1, value2, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFmdateNotBetween(Date value1, Date value2) {
            addCriterion("FMdate not between", value1, value2, "fmdate");
            return (Criteria) this;
        }

        public Criteria andFgperiodIsNull() {
            addCriterion("FGperiod is null");
            return (Criteria) this;
        }

        public Criteria andFgperiodIsNotNull() {
            addCriterion("FGperiod is not null");
            return (Criteria) this;
        }

        public Criteria andFgperiodEqualTo(Double value) {
            addCriterion("FGperiod =", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodNotEqualTo(Double value) {
            addCriterion("FGperiod <>", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodGreaterThan(Double value) {
            addCriterion("FGperiod >", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodGreaterThanOrEqualTo(Double value) {
            addCriterion("FGperiod >=", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodLessThan(Double value) {
            addCriterion("FGperiod <", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodLessThanOrEqualTo(Double value) {
            addCriterion("FGperiod <=", value, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodIn(List<Double> values) {
            addCriterion("FGperiod in", values, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodNotIn(List<Double> values) {
            addCriterion("FGperiod not in", values, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodBetween(Double value1, Double value2) {
            addCriterion("FGperiod between", value1, value2, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFgperiodNotBetween(Double value1, Double value2) {
            addCriterion("FGperiod not between", value1, value2, "fgperiod");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberIsNull() {
            addCriterion("FSrc_Number is null");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberIsNotNull() {
            addCriterion("FSrc_Number is not null");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberEqualTo(String value) {
            addCriterion("FSrc_Number =", value, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberNotEqualTo(String value) {
            addCriterion("FSrc_Number <>", value, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberGreaterThan(String value) {
            addCriterion("FSrc_Number >", value, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberGreaterThanOrEqualTo(String value) {
            addCriterion("FSrc_Number >=", value, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberLessThan(String value) {
            addCriterion("FSrc_Number <", value, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberLessThanOrEqualTo(String value) {
            addCriterion("FSrc_Number <=", value, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberLike(String value) {
            addCriterion("FSrc_Number like", value, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberNotLike(String value) {
            addCriterion("FSrc_Number not like", value, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberIn(List<String> values) {
            addCriterion("FSrc_Number in", values, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberNotIn(List<String> values) {
            addCriterion("FSrc_Number not in", values, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberBetween(String value1, String value2) {
            addCriterion("FSrc_Number between", value1, value2, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFsrcNumberNotBetween(String value1, String value2) {
            addCriterion("FSrc_Number not between", value1, value2, "fsrcNumber");
            return (Criteria) this;
        }

        public Criteria andFdeviceidIsNull() {
            addCriterion("FDeviceID is null");
            return (Criteria) this;
        }

        public Criteria andFdeviceidIsNotNull() {
            addCriterion("FDeviceID is not null");
            return (Criteria) this;
        }

        public Criteria andFdeviceidEqualTo(String value) {
            addCriterion("FDeviceID =", value, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidNotEqualTo(String value) {
            addCriterion("FDeviceID <>", value, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidGreaterThan(String value) {
            addCriterion("FDeviceID >", value, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("FDeviceID >=", value, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidLessThan(String value) {
            addCriterion("FDeviceID <", value, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidLessThanOrEqualTo(String value) {
            addCriterion("FDeviceID <=", value, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidLike(String value) {
            addCriterion("FDeviceID like", value, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidNotLike(String value) {
            addCriterion("FDeviceID not like", value, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidIn(List<String> values) {
            addCriterion("FDeviceID in", values, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidNotIn(List<String> values) {
            addCriterion("FDeviceID not in", values, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidBetween(String value1, String value2) {
            addCriterion("FDeviceID between", value1, value2, "fdeviceid");
            return (Criteria) this;
        }

        public Criteria andFdeviceidNotBetween(String value1, String value2) {
            addCriterion("FDeviceID not between", value1, value2, "fdeviceid");
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