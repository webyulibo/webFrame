package cn.bronze.entities;

public class AssetCustomUnusual extends Asset {

	//原使用人
	private String originaluser;
	//原使用部门
	private String originaldepartment;
	//异常备注
	private String unusualremark;
	public String getOriginaluser() {
		return originaluser;
	}
	public void setOriginaluser(String originaluser) {
		this.originaluser = originaluser;
	}
	public String getOriginaldepartment() {
		return originaldepartment;
	}
	public void setOriginaldepartment(String originaldepartment) {
		this.originaldepartment = originaldepartment;
	}
	public String getUnusualremark() {
		return unusualremark;
	}
	public void setUnusualremark(String unusualremark) {
		this.unusualremark = unusualremark;
	}
	
	
}
