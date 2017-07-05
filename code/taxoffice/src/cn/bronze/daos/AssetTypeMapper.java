package cn.bronze.daos;

import cn.bronze.entities.AssetType;
import cn.bronze.entities.AssetTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetTypeMapper extends BaseDao<AssetType,AssetTypeExample> {
    int countByExample(AssetTypeExample example);

    int deleteByExample(AssetTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AssetType record);

    int insertSelective(AssetType record);

    List<AssetType> selectByExample(AssetTypeExample example);

    AssetType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AssetType record, @Param("example") AssetTypeExample example);

    int updateByExample(@Param("record") AssetType record, @Param("example") AssetTypeExample example);

    int updateByPrimaryKeySelective(AssetType record);

    int updateByPrimaryKey(AssetType record);
}