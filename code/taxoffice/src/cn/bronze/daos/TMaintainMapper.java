package cn.bronze.daos;

import cn.bronze.entities.TMaintain;
import cn.bronze.entities.TMaintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMaintainMapper {
    int countByExample(TMaintainExample example);

    int deleteByExample(TMaintainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMaintain record);

    int insertSelective(TMaintain record);

    List<TMaintain> selectByExample(TMaintainExample example);

    TMaintain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMaintain record, @Param("example") TMaintainExample example);

    int updateByExample(@Param("record") TMaintain record, @Param("example") TMaintainExample example);

    int updateByPrimaryKeySelective(TMaintain record);

    int updateByPrimaryKey(TMaintain record);
}