package cn.bronze.entities;

import java.util.ArrayList;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
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

        public Criteria andUseraccountIsNull() {
            addCriterion("useraccount is null");
            return (Criteria) this;
        }

        public Criteria andUseraccountIsNotNull() {
            addCriterion("useraccount is not null");
            return (Criteria) this;
        }

        public Criteria andUseraccountEqualTo(String value) {
            addCriterion("useraccount =", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotEqualTo(String value) {
            addCriterion("useraccount <>", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountGreaterThan(String value) {
            addCriterion("useraccount >", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountGreaterThanOrEqualTo(String value) {
            addCriterion("useraccount >=", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLessThan(String value) {
            addCriterion("useraccount <", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLessThanOrEqualTo(String value) {
            addCriterion("useraccount <=", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLike(String value) {
            addCriterion("useraccount like", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotLike(String value) {
            addCriterion("useraccount not like", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountIn(List<String> values) {
            addCriterion("useraccount in", values, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotIn(List<String> values) {
            addCriterion("useraccount not in", values, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountBetween(String value1, String value2) {
            addCriterion("useraccount between", value1, value2, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotBetween(String value1, String value2) {
            addCriterion("useraccount not between", value1, value2, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNull() {
            addCriterion("userpassword is null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNotNull() {
            addCriterion("userpassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordEqualTo(String value) {
            addCriterion("userpassword =", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotEqualTo(String value) {
            addCriterion("userpassword <>", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThan(String value) {
            addCriterion("userpassword >", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("userpassword >=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThan(String value) {
            addCriterion("userpassword <", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThanOrEqualTo(String value) {
            addCriterion("userpassword <=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLike(String value) {
            addCriterion("userpassword like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotLike(String value) {
            addCriterion("userpassword not like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIn(List<String> values) {
            addCriterion("userpassword in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotIn(List<String> values) {
            addCriterion("userpassword not in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordBetween(String value1, String value2) {
            addCriterion("userpassword between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotBetween(String value1, String value2) {
            addCriterion("userpassword not between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNull() {
            addCriterion("usercode is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("usercode is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(String value) {
            addCriterion("usercode =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(String value) {
            addCriterion("usercode <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(String value) {
            addCriterion("usercode >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(String value) {
            addCriterion("usercode >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(String value) {
            addCriterion("usercode <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(String value) {
            addCriterion("usercode <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLike(String value) {
            addCriterion("usercode like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotLike(String value) {
            addCriterion("usercode not like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<String> values) {
            addCriterion("usercode in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<String> values) {
            addCriterion("usercode not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(String value1, String value2) {
            addCriterion("usercode between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(String value1, String value2) {
            addCriterion("usercode not between", value1, value2, "usercode");
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

        public Criteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(String value) {
            addCriterion("usertype =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(String value) {
            addCriterion("usertype <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(String value) {
            addCriterion("usertype >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(String value) {
            addCriterion("usertype >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(String value) {
            addCriterion("usertype <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(String value) {
            addCriterion("usertype <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLike(String value) {
            addCriterion("usertype like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotLike(String value) {
            addCriterion("usertype not like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<String> values) {
            addCriterion("usertype in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<String> values) {
            addCriterion("usertype not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(String value1, String value2) {
            addCriterion("usertype between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(String value1, String value2) {
            addCriterion("usertype not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeIsNull() {
            addCriterion("userbankcode is null");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeIsNotNull() {
            addCriterion("userbankcode is not null");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeEqualTo(String value) {
            addCriterion("userbankcode =", value, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeNotEqualTo(String value) {
            addCriterion("userbankcode <>", value, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeGreaterThan(String value) {
            addCriterion("userbankcode >", value, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeGreaterThanOrEqualTo(String value) {
            addCriterion("userbankcode >=", value, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeLessThan(String value) {
            addCriterion("userbankcode <", value, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeLessThanOrEqualTo(String value) {
            addCriterion("userbankcode <=", value, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeLike(String value) {
            addCriterion("userbankcode like", value, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeNotLike(String value) {
            addCriterion("userbankcode not like", value, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeIn(List<String> values) {
            addCriterion("userbankcode in", values, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeNotIn(List<String> values) {
            addCriterion("userbankcode not in", values, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeBetween(String value1, String value2) {
            addCriterion("userbankcode between", value1, value2, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUserbankcodeNotBetween(String value1, String value2) {
            addCriterion("userbankcode not between", value1, value2, "userbankcode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeIsNull() {
            addCriterion("usersalarycode is null");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeIsNotNull() {
            addCriterion("usersalarycode is not null");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeEqualTo(String value) {
            addCriterion("usersalarycode =", value, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeNotEqualTo(String value) {
            addCriterion("usersalarycode <>", value, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeGreaterThan(String value) {
            addCriterion("usersalarycode >", value, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeGreaterThanOrEqualTo(String value) {
            addCriterion("usersalarycode >=", value, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeLessThan(String value) {
            addCriterion("usersalarycode <", value, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeLessThanOrEqualTo(String value) {
            addCriterion("usersalarycode <=", value, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeLike(String value) {
            addCriterion("usersalarycode like", value, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeNotLike(String value) {
            addCriterion("usersalarycode not like", value, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeIn(List<String> values) {
            addCriterion("usersalarycode in", values, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeNotIn(List<String> values) {
            addCriterion("usersalarycode not in", values, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeBetween(String value1, String value2) {
            addCriterion("usersalarycode between", value1, value2, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersalarycodeNotBetween(String value1, String value2) {
            addCriterion("usersalarycode not between", value1, value2, "usersalarycode");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNull() {
            addCriterion("usersex is null");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNotNull() {
            addCriterion("usersex is not null");
            return (Criteria) this;
        }

        public Criteria andUsersexEqualTo(String value) {
            addCriterion("usersex =", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotEqualTo(String value) {
            addCriterion("usersex <>", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThan(String value) {
            addCriterion("usersex >", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThanOrEqualTo(String value) {
            addCriterion("usersex >=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThan(String value) {
            addCriterion("usersex <", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThanOrEqualTo(String value) {
            addCriterion("usersex <=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLike(String value) {
            addCriterion("usersex like", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotLike(String value) {
            addCriterion("usersex not like", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexIn(List<String> values) {
            addCriterion("usersex in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotIn(List<String> values) {
            addCriterion("usersex not in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexBetween(String value1, String value2) {
            addCriterion("usersex between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotBetween(String value1, String value2) {
            addCriterion("usersex not between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUserstateIsNull() {
            addCriterion("userstate is null");
            return (Criteria) this;
        }

        public Criteria andUserstateIsNotNull() {
            addCriterion("userstate is not null");
            return (Criteria) this;
        }

        public Criteria andUserstateEqualTo(String value) {
            addCriterion("userstate =", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateNotEqualTo(String value) {
            addCriterion("userstate <>", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateGreaterThan(String value) {
            addCriterion("userstate >", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateGreaterThanOrEqualTo(String value) {
            addCriterion("userstate >=", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateLessThan(String value) {
            addCriterion("userstate <", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateLessThanOrEqualTo(String value) {
            addCriterion("userstate <=", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateLike(String value) {
            addCriterion("userstate like", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateNotLike(String value) {
            addCriterion("userstate not like", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateIn(List<String> values) {
            addCriterion("userstate in", values, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateNotIn(List<String> values) {
            addCriterion("userstate not in", values, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateBetween(String value1, String value2) {
            addCriterion("userstate between", value1, value2, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateNotBetween(String value1, String value2) {
            addCriterion("userstate not between", value1, value2, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserdepIsNull() {
            addCriterion("userdep is null");
            return (Criteria) this;
        }

        public Criteria andUserdepIsNotNull() {
            addCriterion("userdep is not null");
            return (Criteria) this;
        }

        public Criteria andUserdepEqualTo(String value) {
            addCriterion("userdep =", value, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepNotEqualTo(String value) {
            addCriterion("userdep <>", value, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepGreaterThan(String value) {
            addCriterion("userdep >", value, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepGreaterThanOrEqualTo(String value) {
            addCriterion("userdep >=", value, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepLessThan(String value) {
            addCriterion("userdep <", value, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepLessThanOrEqualTo(String value) {
            addCriterion("userdep <=", value, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepLike(String value) {
            addCriterion("userdep like", value, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepNotLike(String value) {
            addCriterion("userdep not like", value, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepIn(List<String> values) {
            addCriterion("userdep in", values, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepNotIn(List<String> values) {
            addCriterion("userdep not in", values, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepBetween(String value1, String value2) {
            addCriterion("userdep between", value1, value2, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserdepNotBetween(String value1, String value2) {
            addCriterion("userdep not between", value1, value2, "userdep");
            return (Criteria) this;
        }

        public Criteria andUserroleIsNull() {
            addCriterion("userrole is null");
            return (Criteria) this;
        }

        public Criteria andUserroleIsNotNull() {
            addCriterion("userrole is not null");
            return (Criteria) this;
        }

        public Criteria andUserroleEqualTo(Integer value) {
            addCriterion("userrole =", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotEqualTo(Integer value) {
            addCriterion("userrole <>", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleGreaterThan(Integer value) {
            addCriterion("userrole >", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleGreaterThanOrEqualTo(Integer value) {
            addCriterion("userrole >=", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleLessThan(Integer value) {
            addCriterion("userrole <", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleLessThanOrEqualTo(Integer value) {
            addCriterion("userrole <=", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleIn(List<Integer> values) {
            addCriterion("userrole in", values, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotIn(List<Integer> values) {
            addCriterion("userrole not in", values, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleBetween(Integer value1, Integer value2) {
            addCriterion("userrole between", value1, value2, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotBetween(Integer value1, Integer value2) {
            addCriterion("userrole not between", value1, value2, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserdutyIsNull() {
            addCriterion("userduty is null");
            return (Criteria) this;
        }

        public Criteria andUserdutyIsNotNull() {
            addCriterion("userduty is not null");
            return (Criteria) this;
        }

        public Criteria andUserdutyEqualTo(String value) {
            addCriterion("userduty =", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyNotEqualTo(String value) {
            addCriterion("userduty <>", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyGreaterThan(String value) {
            addCriterion("userduty >", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyGreaterThanOrEqualTo(String value) {
            addCriterion("userduty >=", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyLessThan(String value) {
            addCriterion("userduty <", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyLessThanOrEqualTo(String value) {
            addCriterion("userduty <=", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyLike(String value) {
            addCriterion("userduty like", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyNotLike(String value) {
            addCriterion("userduty not like", value, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyIn(List<String> values) {
            addCriterion("userduty in", values, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyNotIn(List<String> values) {
            addCriterion("userduty not in", values, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyBetween(String value1, String value2) {
            addCriterion("userduty between", value1, value2, "userduty");
            return (Criteria) this;
        }

        public Criteria andUserdutyNotBetween(String value1, String value2) {
            addCriterion("userduty not between", value1, value2, "userduty");
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