package com.ejobim.opplat.util;

/**
 * 异常枚举
 * 
 * @author guoyanyong
 * @email 
 * @time 
 */
public enum ErrorMsg {
	/** ------@Valid 输入参数绑定错误 ----- */
	SystemException(999,"系统异常，请稍后重试"),
	TokenIsNotComplete(1000,"Token参数不完整"),
	TokenIsExpired(1003,"token已过期"),
	TokenInsufficientPermissions(1004,"访问权限不足"),
	InvalidDateTime(1005, "无效的时间"),
	APPIDIsInvalid(1006,"无效的APPID"),
	InvalidRequestParams(1007, "访问参数错误！"),
	PasswordError(2005,"密码错误"),
	ACCCOUNT_NOEXIST(2006, "账号不存在"),
	PARAMETER_ISNULL(2008, "参数不能为空");
	public int state;
	public String msg;

	ErrorMsg(int state, String msg) {
		this.state = state;
		this.msg = msg;
	}
}
