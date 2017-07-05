package cn.bronze.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLogExample() {
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

        public Criteria andOperatorpeopleIsNull() {
            addCriterion("operatorpeople is null");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleIsNotNull() {
            addCriterion("operatorpeople is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleEqualTo(String value) {
            addCriterion("operatorpeople =", value, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleNotEqualTo(String value) {
            addCriterion("operatorpeople <>", value, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleGreaterThan(String value) {
            addCriterion("operatorpeople >", value, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleGreaterThanOrEqualTo(String value) {
            addCriterion("operatorpeople >=", value, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleLessThan(String value) {
            addCriterion("operatorpeople <", value, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleLessThanOrEqualTo(String value) {
            addCriterion("operatorpeople <=", value, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleLike(String value) {
            addCriterion("operatorpeople like", value, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleNotLike(String value) {
            addCriterion("operatorpeople not like", value, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleIn(List<String> values) {
            addCriterion("operatorpeople in", values, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleNotIn(List<String> values) {
            addCriterion("operatorpeople not in", values, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleBetween(String value1, String value2) {
            addCriterion("operatorpeople between", value1, value2, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andOperatorpeopleNotBetween(String value1, String value2) {
            addCriterion("operatorpeople not between", value1, value2, "operatorpeople");
            return (Criteria) this;
        }

        public Criteria andPeopledepIsNull() {
            addCriterion("peopledep is null");
            return (Criteria) this;
        }

        public Criteria andPeopledepIsNotNull() {
            addCriterion("peopledep is not null");
            return (Criteria) this;
        }

        public Criteria andPeopledepEqualTo(String value) {
            addCriterion("peopledep =", value, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepNotEqualTo(String value) {
            addCriterion("peopledep <>", value, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepGreaterThan(String value) {
            addCriterion("peopledep >", value, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepGreaterThanOrEqualTo(String value) {
            addCriterion("peopledep >=", value, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepLessThan(String value) {
            addCriterion("peopledep <", value, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepLessThanOrEqualTo(String value) {
            addCriterion("peopledep <=", value, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepLike(String value) {
            addCriterion("peopledep like", value, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepNotLike(String value) {
            addCriterion("peopledep not like", value, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepIn(List<String> values) {
            addCriterion("peopledep in", values, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepNotIn(List<String> values) {
            addCriterion("peopledep not in", values, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepBetween(String value1, String value2) {
            addCriterion("peopledep between", value1, value2, "peopledep");
            return (Criteria) this;
        }

        public Criteria andPeopledepNotBetween(String value1, String value2) {
            addCriterion("peopledep not between", value1, value2, "peopledep");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIsNull() {
            addCriterion("operatortime is null");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIsNotNull() {
            addCriterion("operatortime is not null");
            return (Criteria) this;
        }

        public Criteria andOperatortimeEqualTo(Date value) {
            addCriterion("operatortime =", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotEqualTo(Date value) {
            addCriterion("operatortime <>", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeGreaterThan(Date value) {
            addCriterion("operatortime >", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operatortime >=", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeLessThan(Date value) {
            addCriterion("operatortime <", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeLessThanOrEqualTo(Date value) {
            addCriterion("operatortime <=", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIn(List<Date> values) {
            addCriterion("operatortime in", values, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotIn(List<Date> values) {
            addCriterion("operatortime not in", values, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeBetween(Date value1, Date value2) {
            addCriterion("operatortime between", value1, value2, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotBetween(Date value1, Date value2) {
            addCriterion("operatortime not between", value1, value2, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatornameIsNull() {
            addCriterion("operatorname is null");
            return (Criteria) this;
        }

        public Criteria andOperatornameIsNotNull() {
            addCriterion("operatorname is not null");
            return (Criteria) this;
        }

        public Criteria andOperatornameEqualTo(String value) {
            addCriterion("operatorname =", value, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameNotEqualTo(String value) {
            addCriterion("operatorname <>", value, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameGreaterThan(String value) {
            addCriterion("operatorname >", value, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameGreaterThanOrEqualTo(String value) {
            addCriterion("operatorname >=", value, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameLessThan(String value) {
            addCriterion("operatorname <", value, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameLessThanOrEqualTo(String value) {
            addCriterion("operatorname <=", value, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameLike(String value) {
            addCriterion("operatorname like", value, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameNotLike(String value) {
            addCriterion("operatorname not like", value, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameIn(List<String> values) {
            addCriterion("operatorname in", values, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameNotIn(List<String> values) {
            addCriterion("operatorname not in", values, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameBetween(String value1, String value2) {
            addCriterion("operatorname between", value1, value2, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatornameNotBetween(String value1, String value2) {
            addCriterion("operatorname not between", value1, value2, "operatorname");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoIsNull() {
            addCriterion("operatorautho is null");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoIsNotNull() {
            addCriterion("operatorautho is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoEqualTo(String value) {
            addCriterion("operatorautho =", value, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoNotEqualTo(String value) {
            addCriterion("operatorautho <>", value, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoGreaterThan(String value) {
            addCriterion("operatorautho >", value, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoGreaterThanOrEqualTo(String value) {
            addCriterion("operatorautho >=", value, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoLessThan(String value) {
            addCriterion("operatorautho <", value, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoLessThanOrEqualTo(String value) {
            addCriterion("operatorautho <=", value, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoLike(String value) {
            addCriterion("operatorautho like", value, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoNotLike(String value) {
            addCriterion("operatorautho not like", value, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoIn(List<String> values) {
            addCriterion("operatorautho in", values, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoNotIn(List<String> values) {
            addCriterion("operatorautho not in", values, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoBetween(String value1, String value2) {
            addCriterion("operatorautho between", value1, value2, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorauthoNotBetween(String value1, String value2) {
            addCriterion("operatorautho not between", value1, value2, "operatorautho");
            return (Criteria) this;
        }

        public Criteria andOperatorroleIsNull() {
            addCriterion("operatorrole is null");
            return (Criteria) this;
        }

        public Criteria andOperatorroleIsNotNull() {
            addCriterion("operatorrole is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorroleEqualTo(String value) {
            addCriterion("operatorrole =", value, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleNotEqualTo(String value) {
            addCriterion("operatorrole <>", value, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleGreaterThan(String value) {
            addCriterion("operatorrole >", value, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleGreaterThanOrEqualTo(String value) {
            addCriterion("operatorrole >=", value, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleLessThan(String value) {
            addCriterion("operatorrole <", value, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleLessThanOrEqualTo(String value) {
            addCriterion("operatorrole <=", value, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleLike(String value) {
            addCriterion("operatorrole like", value, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleNotLike(String value) {
            addCriterion("operatorrole not like", value, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleIn(List<String> values) {
            addCriterion("operatorrole in", values, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleNotIn(List<String> values) {
            addCriterion("operatorrole not in", values, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleBetween(String value1, String value2) {
            addCriterion("operatorrole between", value1, value2, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatorroleNotBetween(String value1, String value2) {
            addCriterion("operatorrole not between", value1, value2, "operatorrole");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionIsNull() {
            addCriterion("operatedescription is null");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionIsNotNull() {
            addCriterion("operatedescription is not null");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionEqualTo(String value) {
            addCriterion("operatedescription =", value, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionNotEqualTo(String value) {
            addCriterion("operatedescription <>", value, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionGreaterThan(String value) {
            addCriterion("operatedescription >", value, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("operatedescription >=", value, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionLessThan(String value) {
            addCriterion("operatedescription <", value, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionLessThanOrEqualTo(String value) {
            addCriterion("operatedescription <=", value, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionLike(String value) {
            addCriterion("operatedescription like", value, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionNotLike(String value) {
            addCriterion("operatedescription not like", value, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionIn(List<String> values) {
            addCriterion("operatedescription in", values, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionNotIn(List<String> values) {
            addCriterion("operatedescription not in", values, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionBetween(String value1, String value2) {
            addCriterion("operatedescription between", value1, value2, "operatedescription");
            return (Criteria) this;
        }

        public Criteria andOperatedescriptionNotBetween(String value1, String value2) {
            addCriterion("operatedescription not between", value1, value2, "operatedescription");
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