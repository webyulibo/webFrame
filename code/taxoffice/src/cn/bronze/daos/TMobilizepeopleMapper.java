package cn.bronze.daos;

import cn.bronze.entities.TMobilizepeople;
import cn.bronze.entities.TMobilizepeopleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMobilizepeopleMapper {
    int countByExample(TMobilizepeopleExample example);

    int deleteByExample(TMobilizepeopleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMobilizepeople record);

    int insertSelective(TMobilizepeople record);

    List<TMobilizepeople> selectByExample(TMobilizepeopleExample example);

    TMobilizepeople selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMobilizepeople record, @Param("example") TMobilizepeopleExample example);

    int updateByExample(@Param("record") TMobilizepeople record, @Param("example") TMobilizepeopleExample example);

    int updateByPrimaryKeySelective(TMobilizepeople record);

    int updateByPrimaryKey(TMobilizepeople record);
}