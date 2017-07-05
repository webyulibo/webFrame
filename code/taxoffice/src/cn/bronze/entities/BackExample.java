package cn.bronze.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BackExample() {
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

        public Criteria andBacknumIsNull() {
            addCriterion("backnum is null");
            return (Criteria) this;
        }

        public Criteria andBacknumIsNotNull() {
            addCriterion("backnum is not null");
            return (Criteria) this;
        }

        public Criteria andBacknumEqualTo(String value) {
            addCriterion("backnum =", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumNotEqualTo(String value) {
            addCriterion("backnum <>", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumGreaterThan(String value) {
            addCriterion("backnum >", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumGreaterThanOrEqualTo(String value) {
            addCriterion("backnum >=", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumLessThan(String value) {
            addCriterion("backnum <", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumLessThanOrEqualTo(String value) {
            addCriterion("backnum <=", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumLike(String value) {
            addCriterion("backnum like", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumNotLike(String value) {
            addCriterion("backnum not like", value, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumIn(List<String> values) {
            addCriterion("backnum in", values, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumNotIn(List<String> values) {
            addCriterion("backnum not in", values, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumBetween(String value1, String value2) {
            addCriterion("backnum between", value1, value2, "backnum");
            return (Criteria) this;
        }

        public Criteria andBacknumNotBetween(String value1, String value2) {
            addCriterion("backnum not between", value1, value2, "backnum");
            return (Criteria) this;
        }

        public Criteria andBackdateIsNull() {
            addCriterion("backdate is null");
            return (Criteria) this;
        }

        public Criteria andBackdateIsNotNull() {
            addCriterion("backdate is not null");
            return (Criteria) this;
        }

        public Criteria andBackdateEqualTo(Date value) {
            addCriterionForJDBCDate("backdate =", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("backdate <>", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateGreaterThan(Date value) {
            addCriterionForJDBCDate("backdate >", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("backdate >=", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateLessThan(Date value) {
            addCriterionForJDBCDate("backdate <", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("backdate <=", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateIn(List<Date> values) {
            addCriterionForJDBCDate("backdate in", values, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("backdate not in", values, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("backdate between", value1, value2, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("backdate not between", value1, value2, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackpeopleIsNull() {
            addCriterion("backpeople is null");
            return (Criteria) this;
        }

        public Criteria andBackpeopleIsNotNull() {
            addCriterion("backpeople is not null");
            return (Criteria) this;
        }

        public Criteria andBackpeopleEqualTo(String value) {
            addCriterion("backpeople =", value, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleNotEqualTo(String value) {
            addCriterion("backpeople <>", value, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleGreaterThan(String value) {
            addCriterion("backpeople >", value, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleGreaterThanOrEqualTo(String value) {
            addCriterion("backpeople >=", value, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleLessThan(String value) {
            addCriterion("backpeople <", value, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleLessThanOrEqualTo(String value) {
            addCriterion("backpeople <=", value, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleLike(String value) {
            addCriterion("backpeople like", value, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleNotLike(String value) {
            addCriterion("backpeople not like", value, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleIn(List<String> values) {
            addCriterion("backpeople in", values, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleNotIn(List<String> values) {
            addCriterion("backpeople not in", values, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleBetween(String value1, String value2) {
            addCriterion("backpeople between", value1, value2, "backpeople");
            return (Criteria) this;
        }

        public Criteria andBackpeopleNotBetween(String value1, String value2) {
            addCriterion("backpeople not between", value1, value2, "backpeople");
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