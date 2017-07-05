package cn.bronze.daos;

public interface MyDepartmentMapper {
    //根据部门名称查出部门代码
	String getDepartmentCode(String borrowdep);
   //根据借出人选择借出部门
	String getBorrowdep1(String borrowpeople);
	
	String getBorrowdepName1(String borrowdep);

}
