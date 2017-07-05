package cn.bronze.daos;

import java.util.List;

public interface MyReturnMapper {
	//改变资产的状态
		void changeAssetState(String assetcode);
  //根据borrownum得到assetcode
		String getAssetcode(String borrownum);
		//根据borrownum得到assetname
		String getAssetname(String borrownum);
		//根据borrownum得到borrowpeople
		String getBorrowpeople(String borrownum);
		 //根据assetcode
		String getBorrownum1(String assetcode);
		
		String getAssetname1(String assetcode);
		
		String getBorrowpeople1(String assetcode);
		 //根据assetname
		List<String> getBorrownum2(String assetname);
		
		List<String> getAssetcode2(String assetname);
		
		List<String> getBorrowpeople2(String assetname);
}
