package cn.bronze.daos;

import cn.bronze.entities.CheckResultDetail;
import cn.bronze.entities.CheckResultDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckResultDetailMapper extends BaseDao<CheckResultDetail,CheckResultDetailExample> {
    int countByExample(CheckResultDetailExample example);

    int deleteByExample(CheckResultDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckResultDetail record);

    int insertSelective(CheckResultDetail record);

    List<CheckResultDetail> selectByExample(CheckResultDetailExample example);

    CheckResultDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckResultDetail record, @Param("example") CheckResultDetailExample example);

    int updateByExample(@Param("record") CheckResultDetail record, @Param("example") CheckResultDetailExample example);

    int updateByPrimaryKeySelective(CheckResultDetail record);

    int updateByPrimaryKey(CheckResultDetail record);
}