package cn.bronze.daos;

import cn.bronze.entities.TLog;
import cn.bronze.entities.TLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLogMapper {
    int countByExample(TLogExample example);

    int deleteByExample(TLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLog record);

    int insertSelective(TLog record);

    List<TLog> selectByExample(TLogExample example);

    TLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLog record, @Param("example") TLogExample example);

    int updateByExample(@Param("record") TLog record, @Param("example") TLogExample example);

    int updateByPrimaryKeySelective(TLog record);

    int updateByPrimaryKey(TLog record);
}