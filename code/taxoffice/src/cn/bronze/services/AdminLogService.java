package cn.bronze.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.TLogMapper;
import cn.bronze.daos.TLogMapperExtand;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TLog;
import cn.bronze.entities.TLogExample;
import cn.bronze.entities.TLogExampleCumtom;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;
@Component//定义切面
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminLogService {
	@Autowired
	private TLogMapper tLogMapper;
	@Autowired
	private TLogMapperExtand tLogMapperExtand;
	
	/***
	 * 尼雷清
	 * 根据查询条件查询日志信息    getTlogByConditionWithPage
	 * @param pageParameter
	 * @param condition
	 * @param text
	 * @return List<TLog>
	 */
	public List<TLog> getTlogByConditionWithPage(String condition,String text,PageParameter pageParameter){
	
		TLogExampleCumtom tLogExampleCumtom=new TLogExampleCumtom();
		TLogExampleCumtom.Criteria tLogCriteria=tLogExampleCumtom.createCriteria();
		if(condition!=null&&condition!=""){
			if(text!=null&&text!=""){
				if(condition.equals("operatorpeople")==true){//按照操作人查询
					tLogExampleCumtom.setOrderByClause("id desc");
					tLogCriteria.andOperatorpeopleEqualTo(text);
				}else if(condition.equals("peopledep")==true){//按照操作人所属部门查询	
					tLogExampleCumtom.setOrderByClause("id desc");
					tLogCriteria.andPeopledepEqualTo(text);
					//tUserCriteria.andUsercodeLike("%"+text+"%");//模糊查询
				}else if(condition.equals("operatorname")==true){//根据操作名称查询
					tLogExampleCumtom.setOrderByClause("id desc");
					tLogCriteria.andOperatornameEqualTo(text);
				}
				tLogExampleCumtom.setPage(pageParameter);
				List<TLog> tLogsList=tLogMapper.selectByExample(tLogExampleCumtom);
				return tLogsList;
			}else{//若查询条件选择，但未输入值那么直接按照对应的字段排序
				tLogExampleCumtom.setOrderByClause("id desc");
				tLogExampleCumtom.setPage(pageParameter);
				List<TLog> tLogsList=tLogMapper.selectByExample(tLogExampleCumtom);
				return tLogsList;
			}
		}else{
			System.out.println("查询条件condition为空!");
			return null;
		}

	}
	/***
	 * 尼雷清
	 * 点击查询按钮之后的查询操作
	 * （本质上同getTlogByConditionWithPage操作是一样的但是说，如果记录日志的时候，每次显示一次页面记录一次查询日志的记录的时候将会比较繁琐
	 *  所以此处直接将  查询按钮的调用方法同普通的显示日志按钮区分开）
	 * @param pageParameter
	 * @param condition
	 * @param text
	 * @return List<TLog>
	 */
	public List<TLog> findTlogByConditionWithPage(String condition,String text,PageParameter pageParameter){
		List<TLog> tLogsList=getTlogByConditionWithPage(condition, text, pageParameter);
		return tLogsList;

	}
	/***
	 * 尼雷清
	 * 测试通过查询条件condition生成下一个下拉框的jsonArray
	 * @param 
	 * @return 
	 */
	public JSONArray getLogJson(String condition){
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=new JSONArray();
	
		if(condition.equals("operatorpeople")==true){
			List<String> operatorpeopleList=tLogMapperExtand.selectLogOperatorpeople();
			for(int i=0;i<operatorpeopleList.size();i++){
				jsonObject.put("value", operatorpeopleList.get(i));
				jsonObject.put("text", operatorpeopleList.get(i));
				jsonArray.add(i, jsonObject);
			}
		}
		if(condition.equals("peopledep")==true){
			List<String> peopledepList=tLogMapperExtand.selectLogPeopledep();
			for(int i=0;i<peopledepList.size();i++){
				jsonObject.put("value", peopledepList.get(i));
				jsonObject.put("text", peopledepList.get(i));
				jsonArray.add(i, jsonObject);
			}
		}
		if(condition.equals("operatorname")==true){
			List<String> operatornameList=tLogMapperExtand.selectLogOperatorname();
			for(int i=0;i<operatornameList.size();i++){
				jsonObject.put("value", operatornameList.get(i));
				jsonObject.put("text", operatornameList.get(i));
				jsonArray.add(i, jsonObject);
			}
		}
		return jsonArray;
	}
	/***
	 * 尼雷清
	 * 日志信息导出前先按照查询条件 生成其对应的List集合
	 * @param 
	 * @return 
	 */
	@Log(descrp="执行日志导出操作",type="系统管理员权限")
	public List<TLog> geTLogsExportList(String condition,String text){
		TLogExample tLogExample=new TLogExampleCumtom();
		TLogExample.Criteria tLogCriteria=tLogExample.createCriteria();
		if(condition!=null&&condition!=""){
			if(text!=null&&text!=""){
				if(condition.equals("operatorpeople")==true){//按照操作人查询
					tLogCriteria.andOperatorpeopleEqualTo(text);
				}else if(condition.equals("peopledep")==true){//按照操作人所属部门查询	
					tLogCriteria.andPeopledepEqualTo(text);
					//tUserCriteria.andUsercodeLike("%"+text+"%");//模糊查询
				}else if(condition.equals("operatorname")==true){//根据操作名称查询
					tLogCriteria.andOperatornameEqualTo(text);
				}
				List<TLog> tLogsList=tLogMapper.selectByExample(tLogExample);
				return tLogsList;
			}else{//若查询条件选择，但未输入值那么直接按照对应的字段排序
				tLogExample.setOrderByClause("id desc");
				List<TLog> tLogsList=tLogMapper.selectByExample(tLogExample);
				for(int i=0;i<tLogsList.size();i++){
					String returnStr = null;
			        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        returnStr = f.format(tLogsList.get(i).getOperatortime());
			        TLog tLog=tLogsList.get(i);
			        tLog.setOperatedescription(returnStr);
			        tLogsList.set(i, tLog);
				}
				
				return tLogsList;
			}
		}else{
			System.out.println("查询条件condition为空!");
			return null;
		}
	}
}
