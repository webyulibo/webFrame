package cn.bronze.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.MyDbMapper;
import cn.bronze.daos.TDbMapper;
import cn.bronze.entities.AssetborrowExampleCustom;
import cn.bronze.entities.TAssetborrow;
import cn.bronze.entities.TAssetborrowExample;
import cn.bronze.entities.TDb;
import cn.bronze.entities.TDbExampleCustom;
import cn.bronze.log.Log;
import cn.bronze.util.db.Backup;
import cn.bronze.util.db.Recover;
import cn.bronze.util.page.PageParameter;
@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminDbService {
	@Autowired
	public TDbMapper dbMapper;
	@Autowired
	public MyDbMapper myDbMapper;
	/**
	 * 于立波
	 * 查询数据库备份记录
	 * @param page
	 * @return
	 */
	
	   public List<TDb> getDbRecord(
			   PageParameter page
			   ){
		   List<TDb> dbList=new ArrayList<>();
		   TDbExampleCustom dbExample=new TDbExampleCustom();
		   dbExample.setPage(page);
		   dbList=dbMapper.selectByExample(dbExample);
		   return dbList;
	   }
	   /**
	    * 于立波
	    * 备份数据库
	    * @param path
	    */
      public void backupDb(
    		  String path
    		  ){
    	  Backup ba=new Backup();
    	  ba.backup(path);
      }
      /**
       * 于立波
       * 查询文件名称
       * @param dbname
       * @return
       */
	public String getName(String dbname) {
		// TODO Auto-generated method stub
		String name=myDbMapper.getName(dbname);
		return name;
	}
	/**
	 * 于立波
	 * 保存备份记录
	 * @param db
	 */
	@Log(descrp="执行备份数据库记录操作",type="系统管理权限")
	public String  saveRecord(TDb db) {
		// TODO Auto-generated method stub
		//dbMapper.insert(db);
		try {
			myDbMapper.insert(db);
			return "ok";
		} catch (Exception e) {
			// TODO: handle exception
			return "no";
		}
	}
	/**
	 * 于立波
	 * 查询数据库路径
	 * @param dbname
	 * @return
	 */
	public String getRecoverPath(
			String dbname
			) {
		// TODO Auto-generated method stub
		String filePath=myDbMapper.getFilePath(dbname);
		
		return filePath;
	}
	   /**
	    * 于立波
	    * 还原数据库
	    * @param path
	    */
	public String recoverDb(
			String filePath1
			) {
		// TODO Auto-generated method stub
		Recover re=new Recover();
		try {
			re.recover(filePath1);
			return "ok";
		} catch (Exception e) {
			// TODO: handle exception
			return "no";
		}
	}
	   /**
	    * 于立波
	    * 删除记录
	    * @param dbname
	    */
	@Log(descrp="执行删除数据库记录操作",type="系统管理权限")
	public String deleteDb(String dbname) {
		// TODO Auto-generated method stub
		try {
			myDbMapper.delete(dbname);
			return "ok";
		} catch (Exception e) {
			// TODO: handle exception
			return "no";
		}
	}
}
