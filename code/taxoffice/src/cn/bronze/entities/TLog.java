package cn.bronze.entities;

import java.util.Date;

public class TLog {
    private Integer id;

    private String operatorpeople;

    private String peopledep;

    private Date operatortime;

    private String operatorname;

    private String operatorautho;

    private String operatorrole;

    private String operatedescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperatorpeople() {
        return operatorpeople;
    }

    public void setOperatorpeople(String operatorpeople) {
        this.operatorpeople = operatorpeople == null ? null : operatorpeople.trim();
    }

    public String getPeopledep() {
        return peopledep;
    }

    public void setPeopledep(String peopledep) {
        this.peopledep = peopledep == null ? null : peopledep.trim();
    }

    public Date getOperatortime() {
        return operatortime;
    }

    public void setOperatortime(Date operatortime) {
        this.operatortime = operatortime;
    }

    public String getOperatorname() {
        return operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname == null ? null : operatorname.trim();
    }

    public String getOperatorautho() {
        return operatorautho;
    }

    public void setOperatorautho(String operatorautho) {
        this.operatorautho = operatorautho == null ? null : operatorautho.trim();
    }

    public String getOperatorrole() {
        return operatorrole;
    }

    public void setOperatorrole(String operatorrole) {
        this.operatorrole = operatorrole == null ? null : operatorrole.trim();
    }

    public String getOperatedescription() {
        return operatedescription;
    }

    public void setOperatedescription(String operatedescription) {
        this.operatedescription = operatedescription == null ? null : operatedescription.trim();
    }
}