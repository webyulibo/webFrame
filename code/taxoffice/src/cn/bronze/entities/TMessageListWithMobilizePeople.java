package cn.bronze.entities;

import java.util.Date;

public class TMessageListWithMobilizePeople {
		private Integer sid;

	    private String title;

	    private String sendpeople;

	    private Date sendtime;

	    private String senddepname;

		private String mark;

	    private Boolean status;

		public Integer getSid() {
			return sid;
		}

		public String getTitle() {
			return title;
		}

		public String getSendpeople() {
			return sendpeople;
		}

		public Date getSendtime() {
			return sendtime;
		}

		public String getSenddepname() {
			return senddepname;
		}

		public String getMark() {
			return mark;
		}

		public Boolean getStatus() {
			return status;
		}

		public void setSid(Integer sid) {
			this.sid = sid;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setSendpeople(String sendpeople) {
			this.sendpeople = sendpeople;
		}

		public void setSendtime(Date sendtime) {
			this.sendtime = sendtime;
		}

		public void setSenddepname(String senddepname) {
			this.senddepname = senddepname;
		}

		public void setMark(String mark) {
			this.mark = mark;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		

}
