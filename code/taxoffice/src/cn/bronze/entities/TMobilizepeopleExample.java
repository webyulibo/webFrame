package cn.bronze.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMobilizepeopleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMobilizepeopleExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andOriginaldepIsNull() {
            addCriterion("originaldep is null");
            return (Criteria) this;
        }

        public Criteria andOriginaldepIsNotNull() {
            addCriterion("originaldep is not null");
            return (Criteria) this;
        }

        public Criteria andOriginaldepEqualTo(String value) {
            addCriterion("originaldep =", value, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepNotEqualTo(String value) {
            addCriterion("originaldep <>", value, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepGreaterThan(String value) {
            addCriterion("originaldep >", value, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepGreaterThanOrEqualTo(String value) {
            addCriterion("originaldep >=", value, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepLessThan(String value) {
            addCriterion("originaldep <", value, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepLessThanOrEqualTo(String value) {
            addCriterion("originaldep <=", value, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepLike(String value) {
            addCriterion("originaldep like", value, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepNotLike(String value) {
            addCriterion("originaldep not like", value, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepIn(List<String> values) {
            addCriterion("originaldep in", values, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepNotIn(List<String> values) {
            addCriterion("originaldep not in", values, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepBetween(String value1, String value2) {
            addCriterion("originaldep between", value1, value2, "originaldep");
            return (Criteria) this;
        }

        public Criteria andOriginaldepNotBetween(String value1, String value2) {
            addCriterion("originaldep not between", value1, value2, "originaldep");
            return (Criteria) this;
        }

        public Criteria andNewdepIsNull() {
            addCriterion("newdep is null");
            return (Criteria) this;
        }

        public Criteria andNewdepIsNotNull() {
            addCriterion("newdep is not null");
            return (Criteria) this;
        }

        public Criteria andNewdepEqualTo(String value) {
            addCriterion("newdep =", value, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepNotEqualTo(String value) {
            addCriterion("newdep <>", value, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepGreaterThan(String value) {
            addCriterion("newdep >", value, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepGreaterThanOrEqualTo(String value) {
            addCriterion("newdep >=", value, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepLessThan(String value) {
            addCriterion("newdep <", value, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepLessThanOrEqualTo(String value) {
            addCriterion("newdep <=", value, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepLike(String value) {
            addCriterion("newdep like", value, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepNotLike(String value) {
            addCriterion("newdep not like", value, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepIn(List<String> values) {
            addCriterion("newdep in", values, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepNotIn(List<String> values) {
            addCriterion("newdep not in", values, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepBetween(String value1, String value2) {
            addCriterion("newdep between", value1, value2, "newdep");
            return (Criteria) this;
        }

        public Criteria andNewdepNotBetween(String value1, String value2) {
            addCriterion("newdep not between", value1, value2, "newdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepIsNull() {
            addCriterion("financialdep is null");
            return (Criteria) this;
        }

        public Criteria andFinancialdepIsNotNull() {
            addCriterion("financialdep is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialdepEqualTo(String value) {
            addCriterion("financialdep =", value, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepNotEqualTo(String value) {
            addCriterion("financialdep <>", value, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepGreaterThan(String value) {
            addCriterion("financialdep >", value, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepGreaterThanOrEqualTo(String value) {
            addCriterion("financialdep >=", value, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepLessThan(String value) {
            addCriterion("financialdep <", value, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepLessThanOrEqualTo(String value) {
            addCriterion("financialdep <=", value, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepLike(String value) {
            addCriterion("financialdep like", value, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepNotLike(String value) {
            addCriterion("financialdep not like", value, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepIn(List<String> values) {
            addCriterion("financialdep in", values, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepNotIn(List<String> values) {
            addCriterion("financialdep not in", values, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepBetween(String value1, String value2) {
            addCriterion("financialdep between", value1, value2, "financialdep");
            return (Criteria) this;
        }

        public Criteria andFinancialdepNotBetween(String value1, String value2) {
            addCriterion("financialdep not between", value1, value2, "financialdep");
            return (Criteria) this;
        }

        public Criteria andUsedepIsNull() {
            addCriterion("usedep is null");
            return (Criteria) this;
        }

        public Criteria andUsedepIsNotNull() {
            addCriterion("usedep is not null");
            return (Criteria) this;
        }

        public Criteria andUsedepEqualTo(String value) {
            addCriterion("usedep =", value, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepNotEqualTo(String value) {
            addCriterion("usedep <>", value, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepGreaterThan(String value) {
            addCriterion("usedep >", value, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepGreaterThanOrEqualTo(String value) {
            addCriterion("usedep >=", value, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepLessThan(String value) {
            addCriterion("usedep <", value, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepLessThanOrEqualTo(String value) {
            addCriterion("usedep <=", value, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepLike(String value) {
            addCriterion("usedep like", value, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepNotLike(String value) {
            addCriterion("usedep not like", value, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepIn(List<String> values) {
            addCriterion("usedep in", values, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepNotIn(List<String> values) {
            addCriterion("usedep not in", values, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepBetween(String value1, String value2) {
            addCriterion("usedep between", value1, value2, "usedep");
            return (Criteria) this;
        }

        public Criteria andUsedepNotBetween(String value1, String value2) {
            addCriterion("usedep not between", value1, value2, "usedep");
            return (Criteria) this;
        }

        public Criteria andServicedepIsNull() {
            addCriterion("servicedep is null");
            return (Criteria) this;
        }

        public Criteria andServicedepIsNotNull() {
            addCriterion("servicedep is not null");
            return (Criteria) this;
        }

        public Criteria andServicedepEqualTo(String value) {
            addCriterion("servicedep =", value, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepNotEqualTo(String value) {
            addCriterion("servicedep <>", value, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepGreaterThan(String value) {
            addCriterion("servicedep >", value, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepGreaterThanOrEqualTo(String value) {
            addCriterion("servicedep >=", value, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepLessThan(String value) {
            addCriterion("servicedep <", value, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepLessThanOrEqualTo(String value) {
            addCriterion("servicedep <=", value, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepLike(String value) {
            addCriterion("servicedep like", value, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepNotLike(String value) {
            addCriterion("servicedep not like", value, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepIn(List<String> values) {
            addCriterion("servicedep in", values, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepNotIn(List<String> values) {
            addCriterion("servicedep not in", values, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepBetween(String value1, String value2) {
            addCriterion("servicedep between", value1, value2, "servicedep");
            return (Criteria) this;
        }

        public Criteria andServicedepNotBetween(String value1, String value2) {
            addCriterion("servicedep not between", value1, value2, "servicedep");
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

        public Criteria andDepchangeIsNull() {
            addCriterion("depchange is null");
            return (Criteria) this;
        }

        public Criteria andDepchangeIsNotNull() {
            addCriterion("depchange is not null");
            return (Criteria) this;
        }

        public Criteria andDepchangeEqualTo(String value) {
            addCriterion("depchange =", value, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeNotEqualTo(String value) {
            addCriterion("depchange <>", value, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeGreaterThan(String value) {
            addCriterion("depchange >", value, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeGreaterThanOrEqualTo(String value) {
            addCriterion("depchange >=", value, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeLessThan(String value) {
            addCriterion("depchange <", value, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeLessThanOrEqualTo(String value) {
            addCriterion("depchange <=", value, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeLike(String value) {
            addCriterion("depchange like", value, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeNotLike(String value) {
            addCriterion("depchange not like", value, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeIn(List<String> values) {
            addCriterion("depchange in", values, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeNotIn(List<String> values) {
            addCriterion("depchange not in", values, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeBetween(String value1, String value2) {
            addCriterion("depchange between", value1, value2, "depchange");
            return (Criteria) this;
        }

        public Criteria andDepchangeNotBetween(String value1, String value2) {
            addCriterion("depchange not between", value1, value2, "depchange");
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