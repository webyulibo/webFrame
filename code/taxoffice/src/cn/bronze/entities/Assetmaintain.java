package cn.bronze.entities;

import java.util.Date;

public class Assetmaintain extends TMaintain {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Date purchasedata;
	
	public Date getPurchasedata() {
		return purchasedata;
	}
	public void setPurchasedata(Date purchasedata) {
		this.purchasedata = purchasedata;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getGhostyears() {
		return ghostyears;
	}
	public void setGhostyears(String ghostyears) {
		this.ghostyears = ghostyears;
	}
	private String model;
	private String ghostyears;

}
