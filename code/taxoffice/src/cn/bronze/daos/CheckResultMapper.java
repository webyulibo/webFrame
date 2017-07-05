package cn.bronze.daos;

import cn.bronze.entities.CheckResult;
import cn.bronze.entities.CheckResultExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CheckResultMapper extends BaseDao<CheckResult, CheckResultExample> {
    int countByExample(CheckResultExample example);

    int deleteByExample(CheckResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckResult record);

    int insertSelective(CheckResult record);

    List<CheckResult> selectByExample(CheckResultExample example);

    CheckResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckResult record, @Param("example") CheckResultExample example);

    int updateByExample(@Param("record") CheckResult record, @Param("example") CheckResultExample example);

    int updateByPrimaryKeySelective(CheckResult record);

    int updateByPrimaryKey(CheckResult record);
    /**
     * 于立波
     * 通过checkbox选择导出的项
     * @param string
     * @return
     */
	CheckResult selectresultnumbycheckbox(String string);
}