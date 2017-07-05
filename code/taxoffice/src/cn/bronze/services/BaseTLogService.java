package cn.bronze.services;

import org.apache.ibatis.annotations.Insert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.TLogMapper;
import cn.bronze.entities.TLog;
import cn.bronze.entities.TLogExample;
import cn.bronze.entities.TUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class BaseTLogService extends GenernicServiceImpl<TLog, TLogExample>{
	@Autowired
	private TLogMapper tLogMapper;
	
	public int insert(TLog tLog){
		return tLogMapper.insert(tLog);
	}
}
