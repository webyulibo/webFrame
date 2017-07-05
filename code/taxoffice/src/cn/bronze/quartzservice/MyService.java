package cn.bronze.quartzservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TMessageMapper;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TMessage;



public class MyService {
	
	@Autowired
	private TDepartmentMapper tDepartmentMapper;
	
	@Autowired
	private TMessageMapper tMessageMapper;
	
	public void doJob(){

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
				tMessage.setSenddepcode("16");
				tMessage.setSendtime(date);
				tMessage.setMsg("各位资产管理员，年初了该制定按月抽查盘点计划和年终盘点计划了");
				tMessage.setStatus(false);
				tMessage.setAcceptdepcode(departments.get(i).getDepcode());
				tMessageMapper.insert(tMessage);
			}
			
		}
		
		System.out.println("cz测试：任务完成");
		
	}
}
