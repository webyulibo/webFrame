package cn.bronze.daos;

import java.util.List;

import cn.bronze.entities.TMessageListWithMobilizePeople;

public interface TMessageListWithMobilizePeopleMapper {
	
	List<TMessageListWithMobilizePeople> getMessageListWithMobilizePeoples(String depcode);//根据使用部门的depcode 显示对应的 普通通知和人员变动通知
	
	List<TMessageListWithMobilizePeople> getMessageListWithAllMobilizePeoples(String depcode);//根据人事部门、财务部门、机关服务中心 显示对应的 普通通知和人员变动通知
}
