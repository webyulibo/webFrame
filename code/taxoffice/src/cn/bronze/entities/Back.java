package cn.bronze.entities;

import java.util.Date;

public class Back {
    private Integer id;

    private String borrownum;

    private String backnum;

    private Date backdate;

    private String backpeople;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrownum() {
        return borrownum;
    }

    public void setBorrownum(String borrownum) {
        this.borrownum = borrownum == null ? null : borrownum.trim();
    }

    public String getBacknum() {
        return backnum;
    }

    public void setBacknum(String backnum) {
        this.backnum = backnum == null ? null : backnum.trim();
    }

    public Date getBackdate() {
        return backdate;
    }

    public void setBackdate(Date backdate) {
        this.backdate = backdate;
    }

    public String getBackpeople() {
        return backpeople;
    }

    public void setBackpeople(String backpeople) {
        this.backpeople = backpeople == null ? null : backpeople.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}