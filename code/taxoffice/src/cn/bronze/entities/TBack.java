package cn.bronze.entities;

import java.util.Date;

public class TBack {
    private Integer id;

    private String assetname;

    private String assetcode;

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

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname == null ? null : assetname.trim();
    }

    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode == null ? null : assetcode.trim();
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