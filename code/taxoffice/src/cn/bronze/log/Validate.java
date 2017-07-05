package cn.bronze.log;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TLogMapper;
import cn.bronze.daos.TRoleMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TLog;
import cn.bronze.entities.TLogExample;
import cn.bronze.entities.TRole;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.services.BaseTLogService;

@Aspect
@Component
public class Validate {

	@Autowired
	private BaseTLogService logService;
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TDepartmentMapper tDepartmentMapper;
	@Autowired
	private TRoleMapper tRoleMapper;
	@Autowired
	private TLogMapper tLogMapper;
	
	@Pointcut("execution(* cn.bronze.services.*.*(.. ))")
	public void anyMethod(){}

	@Around("anyMethod()")
		public Object validate(ProceedingJoinPoint join) throws SecurityException, NoSuchMethodException{
			Object[] args = join.getArgs();
			String classNameString = join.getSignature().getDeclaringTypeName();
			String methodName = /*classNameString+"."+ */join.getSignature().getName();
			Class<? extends Object>[] clazz = new Class[args.length];
			for(int i = 0;i<args.length;i++){
				if(args[i]!=null){
					clazz[i] = args[i].getClass();
				}
			}
			Class<?> targetClazz=join.getSignature().getDeclaringType();
			
			LogModule logModule=targetClazz.getAnnotation(LogModule.class);
			String module="";//设置其方法类型
			if(logModule!=null){
				module=logModule.module();
			}
			
			
			Method method =null;
			try{
				method=join.getSignature().getDeclaringType().getMethod(join.getSignature().getName(), clazz);
			}catch(NoSuchMethodException e){
				Method[] methods=join.getSignature().getDeclaringType().getDeclaredMethods();
				for(int i=0;i<methods.length;i++){
/*					System.out.println(i+" "+methods[i].getName());
					System.out.println(i+" "+methodName);*/
					if(methods[i].getName().equals(join.getSignature().getName())==true&&methods[i].getParameterTypes().length==join.getArgs().length){
						method=methods[i];
					}
				}
			}
			finally{
				if(method==null){
					try {
						System.out.println("nlq:在记录日志时，为取到对应的方法名！");
						return join.proceed();
					} catch (Throwable e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
			Log log=method.getAnnotation(Log.class);
			if(log!=null){//若取出对应的方法，则进行对应的日志记录操作
				/*System.out.println(UserSession.get("user")+":"+log.descrp()+" "+log.type());*/
				if(log.module()!=null&&log.module().equals("")==false){
					module=log.module();//若此操作对应的类型不为空那么      设置其类型为用户自定义的logmodule
				}
				String useraccount=UserSession.get("user").toString();
				TUserExample tUserExample=new TUserExample();
				TUserExample.Criteria tuserCriteria=tUserExample.createCriteria();
				tuserCriteria.andUseraccountEqualTo(useraccount);
				List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);/*返回该用户对应的用户信息List*/
				
				TDepartmentExample tDepartmentExample=new TDepartmentExample();
				TDepartmentExample.Criteria tCriteria=tDepartmentExample.createCriteria();
				tCriteria.andDepcodeEqualTo(tUsersList.get(0).getUserdep());
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
				
				TRole tRole=tRoleMapper.selectByPrimaryKey(tUsersList.get(0).getUserrole());
				
				
				TLog tLog = new TLog();//用到Tlog类
				tLog.setOperatorpeople(tUsersList.get(0).getUsername());//操作人姓名
				tLog.setPeopledep(tDepartmentsList.get(0).getDepname());//操作人所属部门
				tLog.setOperatorname(log.descrp());//设置方法描述
				tLog.setOperatorautho(log.type());//所属权限
				tLog.setOperatorrole(tRole.getRolename());//操作的角色名称
				 Date date = new Date(); 
				tLog.setOperatortime(date);//操作的时间
				logService.insert(tLog);//对日志的数据库进行写入
			}
			Object result=null;
			try{
				result=join.proceed();
			}catch(Throwable e){
				e.printStackTrace();
			}
			return result; 
		    
			
			
		}
}
