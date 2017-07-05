package cn.bronze.entities;

public class TAuthority {
    private Integer id;

    private String authorityname;

    private String authoritykey;

    private String authorityremark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorityname() {
        return authorityname;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityname = authorityname == null ? null : authorityname.trim();
    }

    public String getAuthoritykey() {
        return authoritykey;
    }

    public void setAuthoritykey(String authoritykey) {
        this.authoritykey = authoritykey == null ? null : authoritykey.trim();
    }

    public String getAuthorityremark() {
        return authorityremark;
    }

    public void setAuthorityremark(String authorityremark) {
        this.authorityremark = authorityremark == null ? null : authorityremark.trim();
    }
}