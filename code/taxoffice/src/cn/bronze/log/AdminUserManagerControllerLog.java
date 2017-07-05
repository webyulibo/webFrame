package cn.bronze.log;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdminUserManagerControllerLog {
	/*@Pointcut("execution(public * cn.bronze.controllers.AdminUserManagerController*.*(.. ))")
	public void declareJointPointExpression(){
		
	}
	@AfterReturning(value="declareJointPointExpression()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		 	String returnStr = null;
	        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = new Date();
	        returnStr = f.format(date);
	      System.out.println("------->The method"+methodName+"begains with"+joinPoint.getArgs());
		  System.out.println("The method "+methodName+" end with "+result+" "+returnStr);
	}*/
}