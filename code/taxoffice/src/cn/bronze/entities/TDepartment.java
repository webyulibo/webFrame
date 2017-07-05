package cn.bronze.entities;

public class TDepartment {
    private Integer id;

    private String depcode;

    private String depname;

    private String depaddress;

    private String depprincipal;

    private String deptelephone;

    private Boolean depstage;

    private String depstate;

    private Integer depusernum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode == null ? null : depcode.trim();
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname == null ? null : depname.trim();
    }

    public String getDepaddress() {
        return depaddress;
    }

    public void setDepaddress(String depaddress) {
        this.depaddress = depaddress == null ? null : depaddress.trim();
    }

    public String getDepprincipal() {
        return depprincipal;
    }

    public void setDepprincipal(String depprincipal) {
        this.depprincipal = depprincipal == null ? null : depprincipal.trim();
    }

    public String getDeptelephone() {
        return deptelephone;
    }

    public void setDeptelephone(String deptelephone) {
        this.deptelephone = deptelephone == null ? null : deptelephone.trim();
    }

    public Boolean getDepstage() {
        return depstage;
    }

    public void setDepstage(Boolean depstage) {
        this.depstage = depstage;
    }

    public String getDepstate() {
        return depstate;
    }

    public void setDepstate(String depstate) {
        this.depstate = depstate == null ? null : depstate.trim();
    }

    public Integer getDepusernum() {
        return depusernum;
    }

    public void setDepusernum(Integer depusernum) {
        this.depusernum = depusernum;
    }
}