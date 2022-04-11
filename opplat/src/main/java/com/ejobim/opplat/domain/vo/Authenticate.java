package com.ejobim.opplat.domain.vo;



import java.lang.annotation.*;

/**
 * 权限验证注解
 * 1.放在Controller类的方法上
 * @author ethan
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authenticate {

	//request对象中保存token签名的键名
	public static String TokenSubject="tokenSubject";

	//是否检查token
	boolean checkToken() default true;

}
