package cn.bronze.daos;

import cn.bronze.entities.TDb;

//数据库备份(于立波)
public interface MyDbMapper {
    //查询文件名称
	String getName(String dbname);
  //保存备份记录
	void insert(TDb db);
	//查询sql文件路径
	String getFilePath(String dbname);
	//删除记录
	void delete(String dbname);
}
