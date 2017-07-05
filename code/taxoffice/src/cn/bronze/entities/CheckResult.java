package cn.bronze.entities;

import java.util.Date;

public class CheckResult {
    private Integer id;

    private String resultnum;

    private String checkpeople;

    private Date checktime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResultnum() {
        return resultnum;
    }

    public void setResultnum(String resultnum) {
        this.resultnum = resultnum == null ? null : resultnum.trim();
    }

    public String getCheckpeople() {
        return checkpeople;
    }

    public void setCheckpeople(String checkpeople) {
        this.checkpeople = checkpeople == null ? null : checkpeople.trim();
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}