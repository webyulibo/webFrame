package cn.bronze.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMaintainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMaintainExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andGuyIsNull() {
            addCriterion("guy is null");
            return (Criteria) this;
        }

        public Criteria andGuyIsNotNull() {
            addCriterion("guy is not null");
            return (Criteria) this;
        }

        public Criteria andGuyEqualTo(String value) {
            addCriterion("guy =", value, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyNotEqualTo(String value) {
            addCriterion("guy <>", value, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyGreaterThan(String value) {
            addCriterion("guy >", value, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyGreaterThanOrEqualTo(String value) {
            addCriterion("guy >=", value, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyLessThan(String value) {
            addCriterion("guy <", value, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyLessThanOrEqualTo(String value) {
            addCriterion("guy <=", value, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyLike(String value) {
            addCriterion("guy like", value, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyNotLike(String value) {
            addCriterion("guy not like", value, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyIn(List<String> values) {
            addCriterion("guy in", values, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyNotIn(List<String> values) {
            addCriterion("guy not in", values, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyBetween(String value1, String value2) {
            addCriterion("guy between", value1, value2, "guy");
            return (Criteria) this;
        }

        public Criteria andGuyNotBetween(String value1, String value2) {
            addCriterion("guy not between", value1, value2, "guy");
            return (Criteria) this;
        }

        public Criteria andSenddateIsNull() {
            addCriterion("senddate is null");
            return (Criteria) this;
        }

        public Criteria andSenddateIsNotNull() {
            addCriterion("senddate is not null");
            return (Criteria) this;
        }

        public Criteria andSenddateEqualTo(Date value) {
            addCriterion("senddate =", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotEqualTo(Date value) {
            addCriterion("senddate <>", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateGreaterThan(Date value) {
            addCriterion("senddate >", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("senddate >=", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateLessThan(Date value) {
            addCriterion("senddate <", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateLessThanOrEqualTo(Date value) {
            addCriterion("senddate <=", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateIn(List<Date> values) {
            addCriterion("senddate in", values, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotIn(List<Date> values) {
            addCriterion("senddate not in", values, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateBetween(Date value1, Date value2) {
            addCriterion("senddate between", value1, value2, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotBetween(Date value1, Date value2) {
            addCriterion("senddate not between", value1, value2, "senddate");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionIsNull() {
            addCriterion("faultdescription is null");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionIsNotNull() {
            addCriterion("faultdescription is not null");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionEqualTo(String value) {
            addCriterion("faultdescription =", value, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionNotEqualTo(String value) {
            addCriterion("faultdescription <>", value, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionGreaterThan(String value) {
            addCriterion("faultdescription >", value, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("faultdescription >=", value, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionLessThan(String value) {
            addCriterion("faultdescription <", value, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionLessThanOrEqualTo(String value) {
            addCriterion("faultdescription <=", value, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionLike(String value) {
            addCriterion("faultdescription like", value, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionNotLike(String value) {
            addCriterion("faultdescription not like", value, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionIn(List<String> values) {
            addCriterion("faultdescription in", values, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionNotIn(List<String> values) {
            addCriterion("faultdescription not in", values, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionBetween(String value1, String value2) {
            addCriterion("faultdescription between", value1, value2, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andFaultdescriptionNotBetween(String value1, String value2) {
            addCriterion("faultdescription not between", value1, value2, "faultdescription");
            return (Criteria) this;
        }

        public Criteria andDealresultIsNull() {
            addCriterion("dealresult is null");
            return (Criteria) this;
        }

        public Criteria andDealresultIsNotNull() {
            addCriterion("dealresult is not null");
            return (Criteria) this;
        }

        public Criteria andDealresultEqualTo(String value) {
            addCriterion("dealresult =", value, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultNotEqualTo(String value) {
            addCriterion("dealresult <>", value, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultGreaterThan(String value) {
            addCriterion("dealresult >", value, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultGreaterThanOrEqualTo(String value) {
            addCriterion("dealresult >=", value, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultLessThan(String value) {
            addCriterion("dealresult <", value, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultLessThanOrEqualTo(String value) {
            addCriterion("dealresult <=", value, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultLike(String value) {
            addCriterion("dealresult like", value, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultNotLike(String value) {
            addCriterion("dealresult not like", value, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultIn(List<String> values) {
            addCriterion("dealresult in", values, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultNotIn(List<String> values) {
            addCriterion("dealresult not in", values, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultBetween(String value1, String value2) {
            addCriterion("dealresult between", value1, value2, "dealresult");
            return (Criteria) this;
        }

        public Criteria andDealresultNotBetween(String value1, String value2) {
            addCriterion("dealresult not between", value1, value2, "dealresult");
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