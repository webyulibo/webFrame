package cn.bronze.entities;

import java.util.List;

public class DepartmentWithUserMessage {
	
	public String getDepartmentname() {
		return departmentname;
	}

	public List<String> getUsermessagelist() {
		return usermessagelist;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public void setUsermessagelist(List<String> usermessagelist) {
		this.usermessagelist = usermessagelist;
	}

	private String departmentname;
	
	private List<String> usermessagelist ;
}
