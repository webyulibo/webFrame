package cn.bronze.entities;

import java.util.Date;

public class TScrap {
    private Integer id;

    private String scrapnum;

    private String assetname;

    private String assetcode;

    private Date cleandate;

    private String cleanway;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScrapnum() {
        return scrapnum;
    }

    public void setScrapnum(String scrapnum) {
        this.scrapnum = scrapnum == null ? null : scrapnum.trim();
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

    public Date getCleandate() {
        return cleandate;
    }

    public void setCleandate(Date cleandate) {
        this.cleandate = cleandate;
    }

    public String getCleanway() {
        return cleanway;
    }

    public void setCleanway(String cleanway) {
        this.cleanway = cleanway == null ? null : cleanway.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}