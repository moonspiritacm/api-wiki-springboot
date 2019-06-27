package com.moonspirit.citics.wiki.bean;

/**
 * @ClassName      Token
 * @Description    登陆令牌（Redis）
 * @author         moonspirit
 * @date           2019年6月27日 上午9:49:07
 * @version        1.0.0
 */
public class Token {

	/**
	 * userId  用户编号
	 */
	private String userId;

	/**
	 * token  随机令牌
	 */
	private String token;

	public Token() {
		super();
	}

	public Token(String userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Token [userId=" + userId + ", token=" + token + "]";
	}

}
