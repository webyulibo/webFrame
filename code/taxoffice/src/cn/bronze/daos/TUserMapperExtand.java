package cn.bronze.daos;

import java.util.List;

public interface TUserMapperExtand {
	List<String> selectUserState();
	List<String> selectUserDuty();
	List<String> selectUserType();
	List<String> selectUserDep();
}
