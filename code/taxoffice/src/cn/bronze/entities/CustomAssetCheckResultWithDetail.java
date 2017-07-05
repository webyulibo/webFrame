package cn.bronze.entities;

import java.util.List;

public class CustomAssetCheckResultWithDetail {
	
	private CheckResult checkResult;
	
	private List<CheckResultDetail> checkResultDetails;

	public CheckResult getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(CheckResult checkResult) {
		this.checkResult = checkResult;
	}

	public List<CheckResultDetail> getCheckResultDetails() {
		return checkResultDetails;
	}

	public void setCheckResultDetails(List<CheckResultDetail> checkResultDetails) {
		this.checkResultDetails = checkResultDetails;
	}
	
	

}
