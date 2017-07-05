package cn.bronze.daos;

import cn.bronze.entities.TPossess;
import cn.bronze.entities.TPossessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPossessMapper {
    int countByExample(TPossessExample example);

    int deleteByExample(TPossessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPossess record);

    int insertSelective(TPossess record);

    List<TPossess> selectByExample(TPossessExample example);

    TPossess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPossess record, @Param("example") TPossessExample example);

    int updateByExample(@Param("record") TPossess record, @Param("example") TPossessExample example);

    int updateByPrimaryKeySelective(TPossess record);

    int updateByPrimaryKey(TPossess record);
}