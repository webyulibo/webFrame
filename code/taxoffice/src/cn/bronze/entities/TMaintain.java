package cn.bronze.entities;

import java.util.Date;

public class TMaintain {
	
    private Integer id;

    private String code;

    private String guy;

    private Date senddate;

    private String faultdescription;

    private String dealresult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getGuy() {
        return guy;
    }

    public void setGuy(String guy) {
        this.guy = guy == null ? null : guy.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public String getFaultdescription() {
        return faultdescription;
    }

    public void setFaultdescription(String faultdescription) {
        this.faultdescription = faultdescription == null ? null : faultdescription.trim();
    }

    public String getDealresult() {
        return dealresult;
    }

    public void setDealresult(String dealresult) {
        this.dealresult = dealresult == null ? null : dealresult.trim();
    }
}