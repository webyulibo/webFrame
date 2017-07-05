package cn.bronze.quartz;



/*
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TMessageMapper;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TMessage;

public class MyJob implements Job{

	@Autowired
	private TDepartmentMapper tDepartmentMapper;
	
	@Autowired
	private TMessageMapper tMessageMapper;
	
	@Override
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		// TODO Auto-generated method stub
		Map dataMap=jctx.getJobDetail().getJobDataMap();
		String size=(String) dataMap.get("size");
		
		ApplicationContext ctxApplicationContext=(ApplicationContext) dataMap.get("applicationContext");
		
		System.out.println("size:"+size);
		
		TDepartmentExample example=new TDepartmentExample();
		//先从部门表中将所有部门代码查出来
		//TDepartmentExample.Criteria criteria=example.createCriteria();
		List<TDepartment> departments=tDepartmentMapper.selectByExample(example);
		
		if (departments!=null&&departments.size()>0) {
			//封装一个message对象，用户插入数据
			for (int i = 0; i < departments.size(); i++) {
				TMessage tMessage=new TMessage();
				Date date=new Date();
				tMessage.setTitle("系统通知");
				tMessage.setSendtime(date);
				tMessage.setMsg("各位资产管理员，年初了该制定按月抽查盘点计划和年终盘点计划了");
				tMessage.setAcceptdepcode(departments.get(i).getDepcode());
				tMessageMapper.insert(tMessage);
			}
			
		}
		
		
		
		
	}
}	
*/

