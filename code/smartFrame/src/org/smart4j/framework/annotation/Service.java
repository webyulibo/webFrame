package org.smart4j.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务类注解
 *
 * @since 1.0.0
 */
@Target(ElementType.TYPE)  //表示作用于类上
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
