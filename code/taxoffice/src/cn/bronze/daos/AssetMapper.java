package cn.bronze.daos;

import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetMapper extends BaseDao<Asset, AssetExample> {
    int countByExample(AssetExample example);

    int deleteByExample(AssetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Asset record);

    int insertSelective(Asset record);

    List<Asset> selectByExample(AssetExample example);

    Asset selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Asset record, @Param("example") AssetExample example);

    int updateByExample(@Param("record") Asset record, @Param("example") AssetExample example);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}