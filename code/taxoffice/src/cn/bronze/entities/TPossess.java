package cn.bronze.entities;

import java.util.Date;

public class TPossess {
    private Integer id;

    private String assetcode;

    private String code;

    private String possesspeople;

    private String possessdepartment;

    private Date possessdate;

    private String possessremark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode == null ? null : assetcode.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPossesspeople() {
        return possesspeople;
    }

    public void setPossesspeople(String possesspeople) {
        this.possesspeople = possesspeople == null ? null : possesspeople.trim();
    }

    public String getPossessdepartment() {
        return possessdepartment;
    }

    public void setPossessdepartment(String possessdepartment) {
        this.possessdepartment = possessdepartment == null ? null : possessdepartment.trim();
    }

    public Date getPossessdate() {
        return possessdate;
    }

    public void setPossessdate(Date possessdate) {
        this.possessdate = possessdate;
    }

    public String getPossessremark() {
        return possessremark;
    }

    public void setPossessremark(String possessremark) {
        this.possessremark = possessremark == null ? null : possessremark.trim();
    }
}