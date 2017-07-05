package cn.bronze.entities;

import java.util.List;

public class CustomAssetCheckData {

	//鐩樼偣璧勪骇鍒楄〃
	private List<Asset> assets;
	
	//鐩樼偣璧勪骇鐨勬煡璇㈡潯浠�	
	private List<String> selectTerms;

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	public List<String> getSelectTerms() {
		return selectTerms;
	}

	public void setSelectTerms(List<String> selectTerms) {
		this.selectTerms = selectTerms;
	}
	
	
	
}
