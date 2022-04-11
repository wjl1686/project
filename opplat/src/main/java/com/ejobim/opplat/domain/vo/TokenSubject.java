package com.ejobim.opplat.domain.vo;


public class TokenSubject {

	//平台用户ID
	private Integer userid;
	//平台账号ID
	private Integer accountId;
	//平台管理员账号类型
	private Integer adminType;
	//平台会员账号类型
	private Integer memberType;
	//网易云信账号ID
	private String imAccid;
	//网易云信账号Token
	private String imToken;
	
	private String sessionid;
	//用户浏览器信息
	private String userAgent;

	/*public static TokenSubject getTokenSubject(HttpServletRequest request){
		return (TokenSubject) request.getAttribute(Authenticate.TokenSubject);
	}*/

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getAdminType() {
		return adminType;
	}

	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}

	public Integer getMemberType() {
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public String getImAccid() {
		return imAccid;
	}

	public void setImAccid(String imAccid) {
		this.imAccid = imAccid;
	}

	public String getImToken() {
		return imToken;
	}

	public void setImToken(String imToken) {
		this.imToken = imToken;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
}
