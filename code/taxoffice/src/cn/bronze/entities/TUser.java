package cn.bronze.entities;

public class TUser {
    private Integer id;

    private String useraccount;

    private String userpassword;

    private String usercode;

    private String username;

    private String usertype;

    private String userbankcode;

    private String usersalarycode;

    private String usersex;

    private String userstate;

    private String userdep;

    private Integer userrole;

    private String userduty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getUserbankcode() {
        return userbankcode;
    }

    public void setUserbankcode(String userbankcode) {
        this.userbankcode = userbankcode == null ? null : userbankcode.trim();
    }

    public String getUsersalarycode() {
        return usersalarycode;
    }

    public void setUsersalarycode(String usersalarycode) {
        this.usersalarycode = usersalarycode == null ? null : usersalarycode.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    public String getUserstate() {
        return userstate;
    }

    public void setUserstate(String userstate) {
        this.userstate = userstate == null ? null : userstate.trim();
    }

    public String getUserdep() {
        return userdep;
    }

    public void setUserdep(String userdep) {
        this.userdep = userdep == null ? null : userdep.trim();
    }

    public Integer getUserrole() {
        return userrole;
    }

    public void setUserrole(Integer userrole) {
        this.userrole = userrole;
    }

    public String getUserduty() {
        return userduty;
    }

    public void setUserduty(String userduty) {
        this.userduty = userduty == null ? null : userduty.trim();
    }
}