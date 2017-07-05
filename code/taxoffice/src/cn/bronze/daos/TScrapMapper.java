package cn.bronze.daos;

import cn.bronze.entities.TScrap;
import cn.bronze.entities.TScrapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TScrapMapper {
    int countByExample(TScrapExample example);

    int deleteByExample(TScrapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TScrap record);

    int insertSelective(TScrap record);

    List<TScrap> selectByExample(TScrapExample example);

    TScrap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TScrap record, @Param("example") TScrapExample example);

    int updateByExample(@Param("record") TScrap record, @Param("example") TScrapExample example);

    int updateByPrimaryKeySelective(TScrap record);

    int updateByPrimaryKey(TScrap record);
}