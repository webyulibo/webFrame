package cn.bronze.entities;

import java.util.Date;



public class AssetCustom extends Asset{
	private Date abortpurchasetime; //截止购置日期
	private Date abortmakecardtime;//截止制卡日期
	private Date abortstartusetime;//截止启用日期
	private Date abortvalue;//截止资产金额
	private String isbegin1;
	
	private String type1;
	private String type2;
	private String type3;
	private String type4;
	private String type5;
	
	
	
	
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	public String getType5() {
		return type5;
	}
	public void setType5(String type5) {
		this.type5 = type5;
	}
	public String getIsbegin1() {
		return isbegin1;
	}
	public void setIsbegin1(String isbegin1) {
		this.isbegin1 = isbegin1;
	}
	public Date getAbortpurchasetime() {
		return abortpurchasetime;
	}
	public void setAbortpurchasetime(Date abortpurchasetime) {
		this.abortpurchasetime = abortpurchasetime;
	}
	public Date getAbortmakecardtime() {
		return abortmakecardtime;
	}
	public void setAbortmakecardtime(Date abortmakecardtime) {
		this.abortmakecardtime = abortmakecardtime;
	}
	public Date getAbortstartusetime() {
		return abortstartusetime;
	}
	public void setAbortstartusetime(Date abortstartusetime) {
		this.abortstartusetime = abortstartusetime;
	}
	public Date getAbortvalue() {
		return abortvalue;
	}
	public void setAbortvalue(Date abortvalue) {
		this.abortvalue = abortvalue;
	}
}
