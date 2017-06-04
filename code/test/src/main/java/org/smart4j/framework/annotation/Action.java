package org.smart4j.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Action 方法注解
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)  //表示作用范围是方法
@Retention(RetentionPolicy.RUNTIME)  //表示作用时间  
public @interface Action {  //使用@interface自动继承了java.lang.annotation接口

    /**
     * 请求类型与路径
     */
    String value();
}
