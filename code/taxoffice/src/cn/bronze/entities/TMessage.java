package cn.bronze.entities;

import java.util.Date;

public class TMessage {
    private Integer id;

    private String title;

    private String sendpeople;

    private Date sendtime;

    private String senddepcode;

    private String acceptdepcode;

    private String msg;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSendpeople() {
        return sendpeople;
    }

    public void setSendpeople(String sendpeople) {
        this.sendpeople = sendpeople == null ? null : sendpeople.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getSenddepcode() {
        return senddepcode;
    }

    public void setSenddepcode(String senddepcode) {
        this.senddepcode = senddepcode == null ? null : senddepcode.trim();
    }

    public String getAcceptdepcode() {
        return acceptdepcode;
    }

    public void setAcceptdepcode(String acceptdepcode) {
        this.acceptdepcode = acceptdepcode == null ? null : acceptdepcode.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}