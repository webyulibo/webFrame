package cn.bronze.entities;

import java.util.Date;

public class TAssetborrow {
    private Integer id;

    private String borrownum;

    private String assetcode;

    private String assetname;

    private Date borrowdate;

    private String borrowdep;

    private String borrowpeople;

    private String approvepeople;

    private Date plandate;

    private String borrowusedep;

    private String borrowuser;

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

    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode == null ? null : assetcode.trim();
    }

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname == null ? null : assetname.trim();
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public String getBorrowdep() {
        return borrowdep;
    }

    public void setBorrowdep(String borrowdep) {
        this.borrowdep = borrowdep == null ? null : borrowdep.trim();
    }

    public String getBorrowpeople() {
        return borrowpeople;
    }

    public void setBorrowpeople(String borrowpeople) {
        this.borrowpeople = borrowpeople == null ? null : borrowpeople.trim();
    }

    public String getApprovepeople() {
        return approvepeople;
    }

    public void setApprovepeople(String approvepeople) {
        this.approvepeople = approvepeople == null ? null : approvepeople.trim();
    }

    public Date getPlandate() {
        return plandate;
    }

    public void setPlandate(Date plandate) {
        this.plandate = plandate;
    }

    public String getBorrowusedep() {
        return borrowusedep;
    }

    public void setBorrowusedep(String borrowusedep) {
        this.borrowusedep = borrowusedep == null ? null : borrowusedep.trim();
    }

    public String getBorrowuser() {
        return borrowuser;
    }

    public void setBorrowuser(String borrowuser) {
        this.borrowuser = borrowuser == null ? null : borrowuser.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}