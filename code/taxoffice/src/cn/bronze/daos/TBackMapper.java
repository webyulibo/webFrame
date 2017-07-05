package cn.bronze.daos;

import cn.bronze.entities.TBack;
import cn.bronze.entities.TBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBackMapper {
    int countByExample(TBackExample example);

    int deleteByExample(TBackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBack record);

    int insertSelective(TBack record);

    List<TBack> selectByExample(TBackExample example);

    TBack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBack record, @Param("example") TBackExample example);

    int updateByExample(@Param("record") TBack record, @Param("example") TBackExample example);

    int updateByPrimaryKeySelective(TBack record);

    int updateByPrimaryKey(TBack record);
}