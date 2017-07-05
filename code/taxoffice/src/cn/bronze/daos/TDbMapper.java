package cn.bronze.daos;

import cn.bronze.entities.TDb;
import cn.bronze.entities.TDbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDbMapper {
    int countByExample(TDbExample example);

    int deleteByExample(TDbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDb record);

    int insertSelective(TDb record);

    List<TDb> selectByExample(TDbExample example);

    TDb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDb record, @Param("example") TDbExample example);

    int updateByExample(@Param("record") TDb record, @Param("example") TDbExample example);

    int updateByPrimaryKeySelective(TDb record);

    int updateByPrimaryKey(TDb record);
}