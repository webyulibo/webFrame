package cn.bronze.entities;

public class CheckResultDetail {
    private Integer id;

    private String resultnum;

    private String code;

    private String result;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}