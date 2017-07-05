package cn.bronze.services;
import java.util.List;


import org.springframework.stereotype.Service;

import cn.bronze.daos.BaseDao;
/**
 * 
 * <p>Description: </p>
 * <p>Company: 燕山大学</p> 
 * @author   于海强
 * @date       2016-3-12
 */
/** * @author  作者 E-mail: 
 * @date 创建时间：2016-3-12 上午10:23:50 
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
@Service
public abstract class GenernicServiceImpl<T,Example> implements GenernicService<T, Example> {

	
	private BaseDao<T,Example> dao;
	
	/*@PostConstruct
	public void isSetDao(){
		if (dao==null) {
			 new Exception("空指针异常，没有设置Dao").printStackTrace();
		}
	}*/
	
	public void setDao(BaseDao<T, Example> dao){
		this.dao = dao ;
	}
	
	/**
	 *@description：
	 *@author: 于海强
	 *@date： 日期：2016-3-12 时间：上午10:23:50
	 *@param args
	 *@version 1.0
	 *@return 
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	/**
	 * 
	 * <p>Description: </p>
	 * <p>Company: 燕山大学</p> 
	 * @author   于海强
	 * @date       2016-3-12
	 */


	public List<T> selectAll(Example example){
		List<T> list = selectByExample(example);
		//System.out.println(systemMsgList.size());
		if(list.size()>0){
			return list;
		}
		else {
			new NullPointerException("数据库中没有记录").printStackTrace();
			return null;
		}	
	}


	@Override
	public int countByExample(Example example) {
	
		int count =  dao.countByExample(example);
		return count;
	
		
	}




	@Override
	public int deleteByExample(Example example) {
		
		return dao.deleteByExample(example);
	}




	@Override
	public  int deleteByPrimaryKey(Integer id) {
		
		return dao.deleteByPrimaryKey(id);
	}


	@Override
	public int insert(T record) {
		
		return dao.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		
		return dao.insertSelective(record);
	}




	@Override
	public List<T> selectByExampleWithBLOBs(Example example) {
		
		return dao.selectByExampleWithBLOBs(example);
	}




	@Override
	public List<T> selectByExample(Example example) {
	
		
		return dao.selectByExample(example);
		
	}




	@Override
	public T selectByPrimaryKey(Integer id) {
		
		return dao.selectByPrimaryKey(id);
	}




	@Override
	public int updateByExampleSelective(T record, Example example) {
		
		return dao.updateByExampleSelective(record, example);
	}




	@Override
	public int updateByExampleWithBLOBs(T record, Example example) {
		
		return dao.updateByExampleWithBLOBs(record, example);
	}




	@Override
	public int updateByExample(T record, Example example) {
		
		return dao.updateByExample(record, example);
	}




	@Override
	public int updateByPrimaryKeySelective(T record) {
		
		return dao.updateByPrimaryKeySelective(record);
	}




	@Override
	public int updateByPrimaryKeyWithBLOBs(T record) {
		
		return dao.updateByPrimaryKeyWithBLOBs(record);
	}




	@Override
	public int updateByPrimaryKey(T record) {
		
		return dao.updateByPrimaryKey(record);
	}
}
