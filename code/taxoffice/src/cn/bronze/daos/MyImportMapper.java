package cn.bronze.daos;

import java.util.List;

import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TUser;

/**
 * @author lb_yu
 *
 */
public interface MyImportMapper {
    //查询username
	List<String> getNamelist();
	 //查询username
	String getName(String username);
	//更新人员记录
	void  updataUser(TUser user);
	//更新部门记录
	void updataUserdep();
	//查询部门名称
	String getDepname(String depname);
	//更新部门信息
	void updataDep(TDepartment tDepartment);
	//查询部门代码
	String getDepcode(String userdep);
	//查询部门代码1
		String getDepcode1(String depcode);
}
