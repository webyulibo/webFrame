package cn.bronze.daos;

import cn.bronze.entities.TRoleandauth;
import cn.bronze.entities.TRoleandauthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleandauthMapper {
    int countByExample(TRoleandauthExample example);

    int deleteByExample(TRoleandauthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRoleandauth record);

    int insertSelective(TRoleandauth record);

    List<TRoleandauth> selectByExample(TRoleandauthExample example);

    TRoleandauth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRoleandauth record, @Param("example") TRoleandauthExample example);

    int updateByExample(@Param("record") TRoleandauth record, @Param("example") TRoleandauthExample example);

    int updateByPrimaryKeySelective(TRoleandauth record);

    int updateByPrimaryKey(TRoleandauth record);
}