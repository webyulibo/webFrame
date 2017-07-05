/**
* 
* <p>Description: </p>
* <p>Company: 燕山大学</p> 
* @author   于海强
* @date       2016-3-12
*/
package cn.bronze.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bronze.daos.BaseDao;

//import cn.itcast.yhq.po.Items;
//import cn.itcast.yhq.po.ItemsExample;

/** * @author  作者 E-mail: 
 * @date 创建时间：2016-3-12 上午10:20:08 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
/**
 * 
 * <p>Description: </p>
 * <p>Company: 燕山大学</p> 
 * @author   于海强
 * @date       2016-3-12
 */
public interface GenernicService<T,Example> {
	/**
	 * 
	 * <p>Description: </p>
	 * <p>Company: 燕山大学</p> 
	 * @author   于海强
	 * @date       2016-3-12
	 */
	void setDao(BaseDao<T,Example> dao);
	
	int countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExampleWithBLOBs(Example example);

    List<T> selectByExample(Example example);

    T selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Example example);

    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") Example example);

    int updateByExample(@Param("record") T record, @Param("example") Example example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey( T record);
	
	
}
