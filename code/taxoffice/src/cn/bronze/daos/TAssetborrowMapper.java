package cn.bronze.daos;

import cn.bronze.entities.TAssetborrow;
import cn.bronze.entities.TAssetborrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAssetborrowMapper {
    int countByExample(TAssetborrowExample example);

    int deleteByExample(TAssetborrowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAssetborrow record);

    int insertSelective(TAssetborrow record);

    List<TAssetborrow> selectByExample(TAssetborrowExample example);

    TAssetborrow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAssetborrow record, @Param("example") TAssetborrowExample example);

    int updateByExample(@Param("record") TAssetborrow record, @Param("example") TAssetborrowExample example);

    int updateByPrimaryKeySelective(TAssetborrow record);

    int updateByPrimaryKey(TAssetborrow record);
}