package cn.bronze.entities;

import java.util.Date;

public class TMobilizepeople {
    private Integer id;

    private String username;

    private String originaldep;

    private String newdep;

    private String financialdep;

    private String usedep;

    private String servicedep;

    private Boolean status;

    private String depchange;

    private Date sendtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getOriginaldep() {
        return originaldep;
    }

    public void setOriginaldep(String originaldep) {
        this.originaldep = originaldep == null ? null : originaldep.trim();
    }

    public String getNewdep() {
        return newdep;
    }

    public void setNewdep(String newdep) {
        this.newdep = newdep == null ? null : newdep.trim();
    }

    public String getFinancialdep() {
        return financialdep;
    }

    public void setFinancialdep(String financialdep) {
        this.financialdep = financialdep == null ? null : financialdep.trim();
    }

    public String getUsedep() {
        return usedep;
    }

    public void setUsedep(String usedep) {
        this.usedep = usedep == null ? null : usedep.trim();
    }

    public String getServicedep() {
        return servicedep;
    }

    public void setServicedep(String servicedep) {
        this.servicedep = servicedep == null ? null : servicedep.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDepchange() {
        return depchange;
    }

    public void setDepchange(String depchange) {
        this.depchange = depchange == null ? null : depchange.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}