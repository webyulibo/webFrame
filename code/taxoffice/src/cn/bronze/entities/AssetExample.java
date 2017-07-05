package cn.bronze.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetExample() {
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

        public Criteria andSobIsNull() {
            addCriterion("sob is null");
            return (Criteria) this;
        }

        public Criteria andSobIsNotNull() {
            addCriterion("sob is not null");
            return (Criteria) this;
        }

        public Criteria andSobEqualTo(String value) {
            addCriterion("sob =", value, "sob");
            return (Criteria) this;
        }

        public Criteria andSobNotEqualTo(String value) {
            addCriterion("sob <>", value, "sob");
            return (Criteria) this;
        }

        public Criteria andSobGreaterThan(String value) {
            addCriterion("sob >", value, "sob");
            return (Criteria) this;
        }

        public Criteria andSobGreaterThanOrEqualTo(String value) {
            addCriterion("sob >=", value, "sob");
            return (Criteria) this;
        }

        public Criteria andSobLessThan(String value) {
            addCriterion("sob <", value, "sob");
            return (Criteria) this;
        }

        public Criteria andSobLessThanOrEqualTo(String value) {
            addCriterion("sob <=", value, "sob");
            return (Criteria) this;
        }

        public Criteria andSobLike(String value) {
            addCriterion("sob like", value, "sob");
            return (Criteria) this;
        }

        public Criteria andSobNotLike(String value) {
            addCriterion("sob not like", value, "sob");
            return (Criteria) this;
        }

        public Criteria andSobIn(List<String> values) {
            addCriterion("sob in", values, "sob");
            return (Criteria) this;
        }

        public Criteria andSobNotIn(List<String> values) {
            addCriterion("sob not in", values, "sob");
            return (Criteria) this;
        }

        public Criteria andSobBetween(String value1, String value2) {
            addCriterion("sob between", value1, value2, "sob");
            return (Criteria) this;
        }

        public Criteria andSobNotBetween(String value1, String value2) {
            addCriterion("sob not between", value1, value2, "sob");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeIsNull() {
            addCriterion("purchasetime is null");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeIsNotNull() {
            addCriterion("purchasetime is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeEqualTo(Date value) {
            addCriterion("purchasetime =", value, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeNotEqualTo(Date value) {
            addCriterion("purchasetime <>", value, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeGreaterThan(Date value) {
            addCriterion("purchasetime >", value, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchasetime >=", value, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeLessThan(Date value) {
            addCriterion("purchasetime <", value, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeLessThanOrEqualTo(Date value) {
            addCriterion("purchasetime <=", value, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeIn(List<Date> values) {
            addCriterion("purchasetime in", values, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeNotIn(List<Date> values) {
            addCriterion("purchasetime not in", values, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeBetween(Date value1, Date value2) {
            addCriterion("purchasetime between", value1, value2, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andPurchasetimeNotBetween(Date value1, Date value2) {
            addCriterion("purchasetime not between", value1, value2, "purchasetime");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(Double value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(Double value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(Double value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(Double value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(Double value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(Double value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<Double> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<Double> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(Double value1, Double value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(Double value1, Double value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentIsNull() {
            addCriterion("usedepartment is null");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentIsNotNull() {
            addCriterion("usedepartment is not null");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentEqualTo(String value) {
            addCriterion("usedepartment =", value, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentNotEqualTo(String value) {
            addCriterion("usedepartment <>", value, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentGreaterThan(String value) {
            addCriterion("usedepartment >", value, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("usedepartment >=", value, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentLessThan(String value) {
            addCriterion("usedepartment <", value, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentLessThanOrEqualTo(String value) {
            addCriterion("usedepartment <=", value, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentLike(String value) {
            addCriterion("usedepartment like", value, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentNotLike(String value) {
            addCriterion("usedepartment not like", value, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentIn(List<String> values) {
            addCriterion("usedepartment in", values, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentNotIn(List<String> values) {
            addCriterion("usedepartment not in", values, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentBetween(String value1, String value2) {
            addCriterion("usedepartment between", value1, value2, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andUsedepartmentNotBetween(String value1, String value2) {
            addCriterion("usedepartment not between", value1, value2, "usedepartment");
            return (Criteria) this;
        }

        public Criteria andKeeperIsNull() {
            addCriterion("keeper is null");
            return (Criteria) this;
        }

        public Criteria andKeeperIsNotNull() {
            addCriterion("keeper is not null");
            return (Criteria) this;
        }

        public Criteria andKeeperEqualTo(String value) {
            addCriterion("keeper =", value, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperNotEqualTo(String value) {
            addCriterion("keeper <>", value, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperGreaterThan(String value) {
            addCriterion("keeper >", value, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperGreaterThanOrEqualTo(String value) {
            addCriterion("keeper >=", value, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperLessThan(String value) {
            addCriterion("keeper <", value, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperLessThanOrEqualTo(String value) {
            addCriterion("keeper <=", value, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperLike(String value) {
            addCriterion("keeper like", value, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperNotLike(String value) {
            addCriterion("keeper not like", value, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperIn(List<String> values) {
            addCriterion("keeper in", values, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperNotIn(List<String> values) {
            addCriterion("keeper not in", values, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperBetween(String value1, String value2) {
            addCriterion("keeper between", value1, value2, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeeperNotBetween(String value1, String value2) {
            addCriterion("keeper not between", value1, value2, "keeper");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentIsNull() {
            addCriterion("keepdepartment is null");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentIsNotNull() {
            addCriterion("keepdepartment is not null");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentEqualTo(String value) {
            addCriterion("keepdepartment =", value, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentNotEqualTo(String value) {
            addCriterion("keepdepartment <>", value, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentGreaterThan(String value) {
            addCriterion("keepdepartment >", value, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("keepdepartment >=", value, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentLessThan(String value) {
            addCriterion("keepdepartment <", value, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentLessThanOrEqualTo(String value) {
            addCriterion("keepdepartment <=", value, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentLike(String value) {
            addCriterion("keepdepartment like", value, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentNotLike(String value) {
            addCriterion("keepdepartment not like", value, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentIn(List<String> values) {
            addCriterion("keepdepartment in", values, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentNotIn(List<String> values) {
            addCriterion("keepdepartment not in", values, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentBetween(String value1, String value2) {
            addCriterion("keepdepartment between", value1, value2, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andKeepdepartmentNotBetween(String value1, String value2) {
            addCriterion("keepdepartment not between", value1, value2, "keepdepartment");
            return (Criteria) this;
        }

        public Criteria andUsestateIsNull() {
            addCriterion("usestate is null");
            return (Criteria) this;
        }

        public Criteria andUsestateIsNotNull() {
            addCriterion("usestate is not null");
            return (Criteria) this;
        }

        public Criteria andUsestateEqualTo(String value) {
            addCriterion("usestate =", value, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateNotEqualTo(String value) {
            addCriterion("usestate <>", value, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateGreaterThan(String value) {
            addCriterion("usestate >", value, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateGreaterThanOrEqualTo(String value) {
            addCriterion("usestate >=", value, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateLessThan(String value) {
            addCriterion("usestate <", value, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateLessThanOrEqualTo(String value) {
            addCriterion("usestate <=", value, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateLike(String value) {
            addCriterion("usestate like", value, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateNotLike(String value) {
            addCriterion("usestate not like", value, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateIn(List<String> values) {
            addCriterion("usestate in", values, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateNotIn(List<String> values) {
            addCriterion("usestate not in", values, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateBetween(String value1, String value2) {
            addCriterion("usestate between", value1, value2, "usestate");
            return (Criteria) this;
        }

        public Criteria andUsestateNotBetween(String value1, String value2) {
            addCriterion("usestate not between", value1, value2, "usestate");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNull() {
            addCriterion("certificate is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNotNull() {
            addCriterion("certificate is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEqualTo(String value) {
            addCriterion("certificate =", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotEqualTo(String value) {
            addCriterion("certificate <>", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThan(String value) {
            addCriterion("certificate >", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("certificate >=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThan(String value) {
            addCriterion("certificate <", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThanOrEqualTo(String value) {
            addCriterion("certificate <=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLike(String value) {
            addCriterion("certificate like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotLike(String value) {
            addCriterion("certificate not like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateIn(List<String> values) {
            addCriterion("certificate in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotIn(List<String> values) {
            addCriterion("certificate not in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateBetween(String value1, String value2) {
            addCriterion("certificate between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotBetween(String value1, String value2) {
            addCriterion("certificate not between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andIsbeginIsNull() {
            addCriterion("isbegin is null");
            return (Criteria) this;
        }

        public Criteria andIsbeginIsNotNull() {
            addCriterion("isbegin is not null");
            return (Criteria) this;
        }

        public Criteria andIsbeginEqualTo(Boolean value) {
            addCriterion("isbegin =", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginNotEqualTo(Boolean value) {
            addCriterion("isbegin <>", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginGreaterThan(Boolean value) {
            addCriterion("isbegin >", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isbegin >=", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginLessThan(Boolean value) {
            addCriterion("isbegin <", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginLessThanOrEqualTo(Boolean value) {
            addCriterion("isbegin <=", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginIn(List<Boolean> values) {
            addCriterion("isbegin in", values, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginNotIn(List<Boolean> values) {
            addCriterion("isbegin not in", values, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginBetween(Boolean value1, Boolean value2) {
            addCriterion("isbegin between", value1, value2, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isbegin not between", value1, value2, "isbegin");
            return (Criteria) this;
        }

        public Criteria andGhostyearIsNull() {
            addCriterion("ghostyear is null");
            return (Criteria) this;
        }

        public Criteria andGhostyearIsNotNull() {
            addCriterion("ghostyear is not null");
            return (Criteria) this;
        }

        public Criteria andGhostyearEqualTo(String value) {
            addCriterion("ghostyear =", value, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearNotEqualTo(String value) {
            addCriterion("ghostyear <>", value, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearGreaterThan(String value) {
            addCriterion("ghostyear >", value, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearGreaterThanOrEqualTo(String value) {
            addCriterion("ghostyear >=", value, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearLessThan(String value) {
            addCriterion("ghostyear <", value, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearLessThanOrEqualTo(String value) {
            addCriterion("ghostyear <=", value, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearLike(String value) {
            addCriterion("ghostyear like", value, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearNotLike(String value) {
            addCriterion("ghostyear not like", value, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearIn(List<String> values) {
            addCriterion("ghostyear in", values, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearNotIn(List<String> values) {
            addCriterion("ghostyear not in", values, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearBetween(String value1, String value2) {
            addCriterion("ghostyear between", value1, value2, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andGhostyearNotBetween(String value1, String value2) {
            addCriterion("ghostyear not between", value1, value2, "ghostyear");
            return (Criteria) this;
        }

        public Criteria andStartusetimeIsNull() {
            addCriterion("startusetime is null");
            return (Criteria) this;
        }

        public Criteria andStartusetimeIsNotNull() {
            addCriterion("startusetime is not null");
            return (Criteria) this;
        }

        public Criteria andStartusetimeEqualTo(Date value) {
            addCriterion("startusetime =", value, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeNotEqualTo(Date value) {
            addCriterion("startusetime <>", value, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeGreaterThan(Date value) {
            addCriterion("startusetime >", value, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startusetime >=", value, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeLessThan(Date value) {
            addCriterion("startusetime <", value, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeLessThanOrEqualTo(Date value) {
            addCriterion("startusetime <=", value, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeIn(List<Date> values) {
            addCriterion("startusetime in", values, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeNotIn(List<Date> values) {
            addCriterion("startusetime not in", values, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeBetween(Date value1, Date value2) {
            addCriterion("startusetime between", value1, value2, "startusetime");
            return (Criteria) this;
        }

        public Criteria andStartusetimeNotBetween(Date value1, Date value2) {
            addCriterion("startusetime not between", value1, value2, "startusetime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeIsNull() {
            addCriterion("makecardtime is null");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeIsNotNull() {
            addCriterion("makecardtime is not null");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeEqualTo(Date value) {
            addCriterion("makecardtime =", value, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeNotEqualTo(Date value) {
            addCriterion("makecardtime <>", value, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeGreaterThan(Date value) {
            addCriterion("makecardtime >", value, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("makecardtime >=", value, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeLessThan(Date value) {
            addCriterion("makecardtime <", value, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeLessThanOrEqualTo(Date value) {
            addCriterion("makecardtime <=", value, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeIn(List<Date> values) {
            addCriterion("makecardtime in", values, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeNotIn(List<Date> values) {
            addCriterion("makecardtime not in", values, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeBetween(Date value1, Date value2) {
            addCriterion("makecardtime between", value1, value2, "makecardtime");
            return (Criteria) this;
        }

        public Criteria andMakecardtimeNotBetween(Date value1, Date value2) {
            addCriterion("makecardtime not between", value1, value2, "makecardtime");
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
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