package cn.bronze.entities;

import java.util.ArrayList;
import java.util.List;

public class TDepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDepartmentExample() {
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

        public Criteria andDepcodeIsNull() {
            addCriterion("depcode is null");
            return (Criteria) this;
        }

        public Criteria andDepcodeIsNotNull() {
            addCriterion("depcode is not null");
            return (Criteria) this;
        }

        public Criteria andDepcodeEqualTo(String value) {
            addCriterion("depcode =", value, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeNotEqualTo(String value) {
            addCriterion("depcode <>", value, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeGreaterThan(String value) {
            addCriterion("depcode >", value, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeGreaterThanOrEqualTo(String value) {
            addCriterion("depcode >=", value, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeLessThan(String value) {
            addCriterion("depcode <", value, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeLessThanOrEqualTo(String value) {
            addCriterion("depcode <=", value, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeLike(String value) {
            addCriterion("depcode like", value, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeNotLike(String value) {
            addCriterion("depcode not like", value, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeIn(List<String> values) {
            addCriterion("depcode in", values, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeNotIn(List<String> values) {
            addCriterion("depcode not in", values, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeBetween(String value1, String value2) {
            addCriterion("depcode between", value1, value2, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepcodeNotBetween(String value1, String value2) {
            addCriterion("depcode not between", value1, value2, "depcode");
            return (Criteria) this;
        }

        public Criteria andDepnameIsNull() {
            addCriterion("depname is null");
            return (Criteria) this;
        }

        public Criteria andDepnameIsNotNull() {
            addCriterion("depname is not null");
            return (Criteria) this;
        }

        public Criteria andDepnameEqualTo(String value) {
            addCriterion("depname =", value, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameNotEqualTo(String value) {
            addCriterion("depname <>", value, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameGreaterThan(String value) {
            addCriterion("depname >", value, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameGreaterThanOrEqualTo(String value) {
            addCriterion("depname >=", value, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameLessThan(String value) {
            addCriterion("depname <", value, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameLessThanOrEqualTo(String value) {
            addCriterion("depname <=", value, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameLike(String value) {
            addCriterion("depname like", value, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameNotLike(String value) {
            addCriterion("depname not like", value, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameIn(List<String> values) {
            addCriterion("depname in", values, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameNotIn(List<String> values) {
            addCriterion("depname not in", values, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameBetween(String value1, String value2) {
            addCriterion("depname between", value1, value2, "depname");
            return (Criteria) this;
        }

        public Criteria andDepnameNotBetween(String value1, String value2) {
            addCriterion("depname not between", value1, value2, "depname");
            return (Criteria) this;
        }

        public Criteria andDepaddressIsNull() {
            addCriterion("depaddress is null");
            return (Criteria) this;
        }

        public Criteria andDepaddressIsNotNull() {
            addCriterion("depaddress is not null");
            return (Criteria) this;
        }

        public Criteria andDepaddressEqualTo(String value) {
            addCriterion("depaddress =", value, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressNotEqualTo(String value) {
            addCriterion("depaddress <>", value, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressGreaterThan(String value) {
            addCriterion("depaddress >", value, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressGreaterThanOrEqualTo(String value) {
            addCriterion("depaddress >=", value, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressLessThan(String value) {
            addCriterion("depaddress <", value, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressLessThanOrEqualTo(String value) {
            addCriterion("depaddress <=", value, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressLike(String value) {
            addCriterion("depaddress like", value, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressNotLike(String value) {
            addCriterion("depaddress not like", value, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressIn(List<String> values) {
            addCriterion("depaddress in", values, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressNotIn(List<String> values) {
            addCriterion("depaddress not in", values, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressBetween(String value1, String value2) {
            addCriterion("depaddress between", value1, value2, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepaddressNotBetween(String value1, String value2) {
            addCriterion("depaddress not between", value1, value2, "depaddress");
            return (Criteria) this;
        }

        public Criteria andDepprincipalIsNull() {
            addCriterion("depprincipal is null");
            return (Criteria) this;
        }

        public Criteria andDepprincipalIsNotNull() {
            addCriterion("depprincipal is not null");
            return (Criteria) this;
        }

        public Criteria andDepprincipalEqualTo(String value) {
            addCriterion("depprincipal =", value, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalNotEqualTo(String value) {
            addCriterion("depprincipal <>", value, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalGreaterThan(String value) {
            addCriterion("depprincipal >", value, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalGreaterThanOrEqualTo(String value) {
            addCriterion("depprincipal >=", value, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalLessThan(String value) {
            addCriterion("depprincipal <", value, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalLessThanOrEqualTo(String value) {
            addCriterion("depprincipal <=", value, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalLike(String value) {
            addCriterion("depprincipal like", value, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalNotLike(String value) {
            addCriterion("depprincipal not like", value, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalIn(List<String> values) {
            addCriterion("depprincipal in", values, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalNotIn(List<String> values) {
            addCriterion("depprincipal not in", values, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalBetween(String value1, String value2) {
            addCriterion("depprincipal between", value1, value2, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDepprincipalNotBetween(String value1, String value2) {
            addCriterion("depprincipal not between", value1, value2, "depprincipal");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneIsNull() {
            addCriterion("deptelephone is null");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneIsNotNull() {
            addCriterion("deptelephone is not null");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneEqualTo(String value) {
            addCriterion("deptelephone =", value, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneNotEqualTo(String value) {
            addCriterion("deptelephone <>", value, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneGreaterThan(String value) {
            addCriterion("deptelephone >", value, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("deptelephone >=", value, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneLessThan(String value) {
            addCriterion("deptelephone <", value, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneLessThanOrEqualTo(String value) {
            addCriterion("deptelephone <=", value, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneLike(String value) {
            addCriterion("deptelephone like", value, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneNotLike(String value) {
            addCriterion("deptelephone not like", value, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneIn(List<String> values) {
            addCriterion("deptelephone in", values, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneNotIn(List<String> values) {
            addCriterion("deptelephone not in", values, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneBetween(String value1, String value2) {
            addCriterion("deptelephone between", value1, value2, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDeptelephoneNotBetween(String value1, String value2) {
            addCriterion("deptelephone not between", value1, value2, "deptelephone");
            return (Criteria) this;
        }

        public Criteria andDepstageIsNull() {
            addCriterion("depstage is null");
            return (Criteria) this;
        }

        public Criteria andDepstageIsNotNull() {
            addCriterion("depstage is not null");
            return (Criteria) this;
        }

        public Criteria andDepstageEqualTo(Boolean value) {
            addCriterion("depstage =", value, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageNotEqualTo(Boolean value) {
            addCriterion("depstage <>", value, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageGreaterThan(Boolean value) {
            addCriterion("depstage >", value, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageGreaterThanOrEqualTo(Boolean value) {
            addCriterion("depstage >=", value, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageLessThan(Boolean value) {
            addCriterion("depstage <", value, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageLessThanOrEqualTo(Boolean value) {
            addCriterion("depstage <=", value, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageIn(List<Boolean> values) {
            addCriterion("depstage in", values, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageNotIn(List<Boolean> values) {
            addCriterion("depstage not in", values, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageBetween(Boolean value1, Boolean value2) {
            addCriterion("depstage between", value1, value2, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstageNotBetween(Boolean value1, Boolean value2) {
            addCriterion("depstage not between", value1, value2, "depstage");
            return (Criteria) this;
        }

        public Criteria andDepstateIsNull() {
            addCriterion("depstate is null");
            return (Criteria) this;
        }

        public Criteria andDepstateIsNotNull() {
            addCriterion("depstate is not null");
            return (Criteria) this;
        }

        public Criteria andDepstateEqualTo(String value) {
            addCriterion("depstate =", value, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateNotEqualTo(String value) {
            addCriterion("depstate <>", value, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateGreaterThan(String value) {
            addCriterion("depstate >", value, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateGreaterThanOrEqualTo(String value) {
            addCriterion("depstate >=", value, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateLessThan(String value) {
            addCriterion("depstate <", value, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateLessThanOrEqualTo(String value) {
            addCriterion("depstate <=", value, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateLike(String value) {
            addCriterion("depstate like", value, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateNotLike(String value) {
            addCriterion("depstate not like", value, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateIn(List<String> values) {
            addCriterion("depstate in", values, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateNotIn(List<String> values) {
            addCriterion("depstate not in", values, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateBetween(String value1, String value2) {
            addCriterion("depstate between", value1, value2, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepstateNotBetween(String value1, String value2) {
            addCriterion("depstate not between", value1, value2, "depstate");
            return (Criteria) this;
        }

        public Criteria andDepusernumIsNull() {
            addCriterion("depusernum is null");
            return (Criteria) this;
        }

        public Criteria andDepusernumIsNotNull() {
            addCriterion("depusernum is not null");
            return (Criteria) this;
        }

        public Criteria andDepusernumEqualTo(Integer value) {
            addCriterion("depusernum =", value, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumNotEqualTo(Integer value) {
            addCriterion("depusernum <>", value, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumGreaterThan(Integer value) {
            addCriterion("depusernum >", value, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("depusernum >=", value, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumLessThan(Integer value) {
            addCriterion("depusernum <", value, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumLessThanOrEqualTo(Integer value) {
            addCriterion("depusernum <=", value, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumIn(List<Integer> values) {
            addCriterion("depusernum in", values, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumNotIn(List<Integer> values) {
            addCriterion("depusernum not in", values, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumBetween(Integer value1, Integer value2) {
            addCriterion("depusernum between", value1, value2, "depusernum");
            return (Criteria) this;
        }

        public Criteria andDepusernumNotBetween(Integer value1, Integer value2) {
            addCriterion("depusernum not between", value1, value2, "depusernum");
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