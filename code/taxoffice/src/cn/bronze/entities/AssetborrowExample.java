package cn.bronze.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AssetborrowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetborrowExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBorrownumIsNull() {
            addCriterion("borrownum is null");
            return (Criteria) this;
        }

        public Criteria andBorrownumIsNotNull() {
            addCriterion("borrownum is not null");
            return (Criteria) this;
        }

        public Criteria andBorrownumEqualTo(String value) {
            addCriterion("borrownum =", value, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumNotEqualTo(String value) {
            addCriterion("borrownum <>", value, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumGreaterThan(String value) {
            addCriterion("borrownum >", value, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumGreaterThanOrEqualTo(String value) {
            addCriterion("borrownum >=", value, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumLessThan(String value) {
            addCriterion("borrownum <", value, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumLessThanOrEqualTo(String value) {
            addCriterion("borrownum <=", value, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumLike(String value) {
            addCriterion("borrownum like", value, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumNotLike(String value) {
            addCriterion("borrownum not like", value, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumIn(List<String> values) {
            addCriterion("borrownum in", values, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumNotIn(List<String> values) {
            addCriterion("borrownum not in", values, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumBetween(String value1, String value2) {
            addCriterion("borrownum between", value1, value2, "borrownum");
            return (Criteria) this;
        }

        public Criteria andBorrownumNotBetween(String value1, String value2) {
            addCriterion("borrownum not between", value1, value2, "borrownum");
            return (Criteria) this;
        }

        public Criteria andAssetnameIsNull() {
            addCriterion("assetname is null");
            return (Criteria) this;
        }

        public Criteria andAssetnameIsNotNull() {
            addCriterion("assetname is not null");
            return (Criteria) this;
        }

        public Criteria andAssetnameEqualTo(String value) {
            addCriterion("assetname =", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameNotEqualTo(String value) {
            addCriterion("assetname <>", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameGreaterThan(String value) {
            addCriterion("assetname >", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameGreaterThanOrEqualTo(String value) {
            addCriterion("assetname >=", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameLessThan(String value) {
            addCriterion("assetname <", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameLessThanOrEqualTo(String value) {
            addCriterion("assetname <=", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameLike(String value) {
            addCriterion("assetname like", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameNotLike(String value) {
            addCriterion("assetname not like", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameIn(List<String> values) {
            addCriterion("assetname in", values, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameNotIn(List<String> values) {
            addCriterion("assetname not in", values, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameBetween(String value1, String value2) {
            addCriterion("assetname between", value1, value2, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameNotBetween(String value1, String value2) {
            addCriterion("assetname not between", value1, value2, "assetname");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNull() {
            addCriterion("borrowdate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNotNull() {
            addCriterion("borrowdate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate =", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate <>", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThan(Date value) {
            addCriterionForJDBCDate("borrowdate >", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate >=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThan(Date value) {
            addCriterionForJDBCDate("borrowdate <", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate <=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIn(List<Date> values) {
            addCriterionForJDBCDate("borrowdate in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("borrowdate not in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("borrowdate between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("borrowdate not between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdepIsNull() {
            addCriterion("borrowdep is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdepIsNotNull() {
            addCriterion("borrowdep is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdepEqualTo(String value) {
            addCriterion("borrowdep =", value, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepNotEqualTo(String value) {
            addCriterion("borrowdep <>", value, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepGreaterThan(String value) {
            addCriterion("borrowdep >", value, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepGreaterThanOrEqualTo(String value) {
            addCriterion("borrowdep >=", value, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepLessThan(String value) {
            addCriterion("borrowdep <", value, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepLessThanOrEqualTo(String value) {
            addCriterion("borrowdep <=", value, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepLike(String value) {
            addCriterion("borrowdep like", value, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepNotLike(String value) {
            addCriterion("borrowdep not like", value, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepIn(List<String> values) {
            addCriterion("borrowdep in", values, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepNotIn(List<String> values) {
            addCriterion("borrowdep not in", values, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepBetween(String value1, String value2) {
            addCriterion("borrowdep between", value1, value2, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowdepNotBetween(String value1, String value2) {
            addCriterion("borrowdep not between", value1, value2, "borrowdep");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleIsNull() {
            addCriterion("borrowpeople is null");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleIsNotNull() {
            addCriterion("borrowpeople is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleEqualTo(String value) {
            addCriterion("borrowpeople =", value, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleNotEqualTo(String value) {
            addCriterion("borrowpeople <>", value, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleGreaterThan(String value) {
            addCriterion("borrowpeople >", value, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleGreaterThanOrEqualTo(String value) {
            addCriterion("borrowpeople >=", value, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleLessThan(String value) {
            addCriterion("borrowpeople <", value, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleLessThanOrEqualTo(String value) {
            addCriterion("borrowpeople <=", value, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleLike(String value) {
            addCriterion("borrowpeople like", value, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleNotLike(String value) {
            addCriterion("borrowpeople not like", value, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleIn(List<String> values) {
            addCriterion("borrowpeople in", values, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleNotIn(List<String> values) {
            addCriterion("borrowpeople not in", values, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleBetween(String value1, String value2) {
            addCriterion("borrowpeople between", value1, value2, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andBorrowpeopleNotBetween(String value1, String value2) {
            addCriterion("borrowpeople not between", value1, value2, "borrowpeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleIsNull() {
            addCriterion("approvepeople is null");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleIsNotNull() {
            addCriterion("approvepeople is not null");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleEqualTo(String value) {
            addCriterion("approvepeople =", value, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleNotEqualTo(String value) {
            addCriterion("approvepeople <>", value, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleGreaterThan(String value) {
            addCriterion("approvepeople >", value, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleGreaterThanOrEqualTo(String value) {
            addCriterion("approvepeople >=", value, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleLessThan(String value) {
            addCriterion("approvepeople <", value, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleLessThanOrEqualTo(String value) {
            addCriterion("approvepeople <=", value, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleLike(String value) {
            addCriterion("approvepeople like", value, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleNotLike(String value) {
            addCriterion("approvepeople not like", value, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleIn(List<String> values) {
            addCriterion("approvepeople in", values, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleNotIn(List<String> values) {
            addCriterion("approvepeople not in", values, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleBetween(String value1, String value2) {
            addCriterion("approvepeople between", value1, value2, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andApprovepeopleNotBetween(String value1, String value2) {
            addCriterion("approvepeople not between", value1, value2, "approvepeople");
            return (Criteria) this;
        }

        public Criteria andPlandateIsNull() {
            addCriterion("plandate is null");
            return (Criteria) this;
        }

        public Criteria andPlandateIsNotNull() {
            addCriterion("plandate is not null");
            return (Criteria) this;
        }

        public Criteria andPlandateEqualTo(Date value) {
            addCriterionForJDBCDate("plandate =", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateNotEqualTo(Date value) {
            addCriterionForJDBCDate("plandate <>", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateGreaterThan(Date value) {
            addCriterionForJDBCDate("plandate >", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plandate >=", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateLessThan(Date value) {
            addCriterionForJDBCDate("plandate <", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plandate <=", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateIn(List<Date> values) {
            addCriterionForJDBCDate("plandate in", values, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateNotIn(List<Date> values) {
            addCriterionForJDBCDate("plandate not in", values, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plandate between", value1, value2, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plandate not between", value1, value2, "plandate");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepIsNull() {
            addCriterion("borrowusedep is null");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepIsNotNull() {
            addCriterion("borrowusedep is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepEqualTo(String value) {
            addCriterion("borrowusedep =", value, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepNotEqualTo(String value) {
            addCriterion("borrowusedep <>", value, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepGreaterThan(String value) {
            addCriterion("borrowusedep >", value, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepGreaterThanOrEqualTo(String value) {
            addCriterion("borrowusedep >=", value, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepLessThan(String value) {
            addCriterion("borrowusedep <", value, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepLessThanOrEqualTo(String value) {
            addCriterion("borrowusedep <=", value, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepLike(String value) {
            addCriterion("borrowusedep like", value, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepNotLike(String value) {
            addCriterion("borrowusedep not like", value, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepIn(List<String> values) {
            addCriterion("borrowusedep in", values, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepNotIn(List<String> values) {
            addCriterion("borrowusedep not in", values, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepBetween(String value1, String value2) {
            addCriterion("borrowusedep between", value1, value2, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowusedepNotBetween(String value1, String value2) {
            addCriterion("borrowusedep not between", value1, value2, "borrowusedep");
            return (Criteria) this;
        }

        public Criteria andBorrowuserIsNull() {
            addCriterion("borrowuser is null");
            return (Criteria) this;
        }

        public Criteria andBorrowuserIsNotNull() {
            addCriterion("borrowuser is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowuserEqualTo(String value) {
            addCriterion("borrowuser =", value, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserNotEqualTo(String value) {
            addCriterion("borrowuser <>", value, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserGreaterThan(String value) {
            addCriterion("borrowuser >", value, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserGreaterThanOrEqualTo(String value) {
            addCriterion("borrowuser >=", value, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserLessThan(String value) {
            addCriterion("borrowuser <", value, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserLessThanOrEqualTo(String value) {
            addCriterion("borrowuser <=", value, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserLike(String value) {
            addCriterion("borrowuser like", value, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserNotLike(String value) {
            addCriterion("borrowuser not like", value, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserIn(List<String> values) {
            addCriterion("borrowuser in", values, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserNotIn(List<String> values) {
            addCriterion("borrowuser not in", values, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserBetween(String value1, String value2) {
            addCriterion("borrowuser between", value1, value2, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andBorrowuserNotBetween(String value1, String value2) {
            addCriterion("borrowuser not between", value1, value2, "borrowuser");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAssetcodeIsNull() {
            addCriterion("assetcode is null");
            return (Criteria) this;
        }

        public Criteria andAssetcodeIsNotNull() {
            addCriterion("assetcode is not null");
            return (Criteria) this;
        }

        public Criteria andAssetcodeEqualTo(String value) {
            addCriterion("assetcode =", value, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeNotEqualTo(String value) {
            addCriterion("assetcode <>", value, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeGreaterThan(String value) {
            addCriterion("assetcode >", value, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeGreaterThanOrEqualTo(String value) {
            addCriterion("assetcode >=", value, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeLessThan(String value) {
            addCriterion("assetcode <", value, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeLessThanOrEqualTo(String value) {
            addCriterion("assetcode <=", value, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeLike(String value) {
            addCriterion("assetcode like", value, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeNotLike(String value) {
            addCriterion("assetcode not like", value, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeIn(List<String> values) {
            addCriterion("assetcode in", values, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeNotIn(List<String> values) {
            addCriterion("assetcode not in", values, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeBetween(String value1, String value2) {
            addCriterion("assetcode between", value1, value2, "assetcode");
            return (Criteria) this;
        }

        public Criteria andAssetcodeNotBetween(String value1, String value2) {
            addCriterion("assetcode not between", value1, value2, "assetcode");
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