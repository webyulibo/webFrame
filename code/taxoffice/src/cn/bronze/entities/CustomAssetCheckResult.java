package cn.bronze.entities;

import java.util.List;

public class CustomAssetCheckResult {
	
	//已盘资产列表
	private List<Asset> assetsChecked;
	
	//漏盘资产列表
	private List<Asset> assetsNotChecked;
	
	//异常资产列表
	private List<Asset> assetsStateWrong;
	
	//查询条件列表
	private List<String> selectTerms;
	
	
	
	public List<Asset> getAssetsStateWrong() {
		return assetsStateWrong;
	}

	public void setAssetsStateWrong(List<Asset> assetsStateWrong) {
		this.assetsStateWrong = assetsStateWrong;
	}

	public List<Asset> getAssetsChecked() {
		return assetsChecked;
	}

	public void setAssetsChecked(List<Asset> assetsChecked) {
		this.assetsChecked = assetsChecked;
	}

	public List<Asset> getAssetsNotChecked() {
		return assetsNotChecked;
	}

	public void setAssetsNotChecked(List<Asset> assetsNotChecked) {
		this.assetsNotChecked = assetsNotChecked;
	}

	public List<String> getSelectTerms() {
		return selectTerms;
	}

	public void setSelectTerms(List<String> selectTerms) {
		this.selectTerms = selectTerms;
	}
	
	

}
