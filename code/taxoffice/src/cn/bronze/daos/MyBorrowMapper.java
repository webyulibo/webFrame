package cn.bronze.daos;

import java.util.List;

import cn.bronze.entities.Asset;
import cn.bronze.entities.TAssetborrow;

public interface MyBorrowMapper {
	//实时获得assetcode(于立波）
    List<String> getAssetcode(String assetcode);
  //实时获得所有的assetcode(于立波）
    List<String> getAllAssetcode();
    //根据assetcode获得对应的assetname(于立波）
   String    getAssetname(String assetcode);
   //根据assetname获得对应的assetcode(于立波）
  List< String>    getAssetcode1(String assetname);
  List< String>    getAssetcode11(String assetname);
   //检查资产的状态
   String     checkAssetState(String assetcode);
   //改变资产的状态
   void   changeAssetState(String assetcode);
   //实时获得所有的assetname(于立波）
   List<String> getAllAssetname();
   //删除对应的借用记录
void deleteReturnRecord(String borrownum);

String getAssetcode2(String assetcode);

List<String> getAssetname3(String assetname);

List<String> getBorrownumJson1();

TAssetborrow getcheck1(String borrownum);

Asset getAsset1(String assetcode);
   
}
