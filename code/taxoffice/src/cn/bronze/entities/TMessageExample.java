package cn.bronze.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMessageExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSendpeopleIsNull() {
            addCriterion("sendpeople is null");
            return (Criteria) this;
        }

        public Criteria andSendpeopleIsNotNull() {
            addCriterion("sendpeople is not null");
            return (Criteria) this;
        }

        public Criteria andSendpeopleEqualTo(String value) {
            addCriterion("sendpeople =", value, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleNotEqualTo(String value) {
            addCriterion("sendpeople <>", value, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleGreaterThan(String value) {
            addCriterion("sendpeople >", value, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleGreaterThanOrEqualTo(String value) {
            addCriterion("sendpeople >=", value, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleLessThan(String value) {
            addCriterion("sendpeople <", value, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleLessThanOrEqualTo(String value) {
            addCriterion("sendpeople <=", value, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleLike(String value) {
            addCriterion("sendpeople like", value, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleNotLike(String value) {
            addCriterion("sendpeople not like", value, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleIn(List<String> values) {
            addCriterion("sendpeople in", values, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleNotIn(List<String> values) {
            addCriterion("sendpeople not in", values, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleBetween(String value1, String value2) {
            addCriterion("sendpeople between", value1, value2, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendpeopleNotBetween(String value1, String value2) {
            addCriterion("sendpeople not between", value1, value2, "sendpeople");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendtime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeIsNull() {
            addCriterion("senddepcode is null");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeIsNotNull() {
            addCriterion("senddepcode is not null");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeEqualTo(String value) {
            addCriterion("senddepcode =", value, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeNotEqualTo(String value) {
            addCriterion("senddepcode <>", value, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeGreaterThan(String value) {
            addCriterion("senddepcode >", value, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeGreaterThanOrEqualTo(String value) {
            addCriterion("senddepcode >=", value, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeLessThan(String value) {
            addCriterion("senddepcode <", value, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeLessThanOrEqualTo(String value) {
            addCriterion("senddepcode <=", value, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeLike(String value) {
            addCriterion("senddepcode like", value, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeNotLike(String value) {
            addCriterion("senddepcode not like", value, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeIn(List<String> values) {
            addCriterion("senddepcode in", values, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeNotIn(List<String> values) {
            addCriterion("senddepcode not in", values, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeBetween(String value1, String value2) {
            addCriterion("senddepcode between", value1, value2, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andSenddepcodeNotBetween(String value1, String value2) {
            addCriterion("senddepcode not between", value1, value2, "senddepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeIsNull() {
            addCriterion("acceptdepcode is null");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeIsNotNull() {
            addCriterion("acceptdepcode is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeEqualTo(String value) {
            addCriterion("acceptdepcode =", value, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeNotEqualTo(String value) {
            addCriterion("acceptdepcode <>", value, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeGreaterThan(String value) {
            addCriterion("acceptdepcode >", value, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeGreaterThanOrEqualTo(String value) {
            addCriterion("acceptdepcode >=", value, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeLessThan(String value) {
            addCriterion("acceptdepcode <", value, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeLessThanOrEqualTo(String value) {
            addCriterion("acceptdepcode <=", value, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeLike(String value) {
            addCriterion("acceptdepcode like", value, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeNotLike(String value) {
            addCriterion("acceptdepcode not like", value, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeIn(List<String> values) {
            addCriterion("acceptdepcode in", values, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeNotIn(List<String> values) {
            addCriterion("acceptdepcode not in", values, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeBetween(String value1, String value2) {
            addCriterion("acceptdepcode between", value1, value2, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andAcceptdepcodeNotBetween(String value1, String value2) {
            addCriterion("acceptdepcode not between", value1, value2, "acceptdepcode");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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