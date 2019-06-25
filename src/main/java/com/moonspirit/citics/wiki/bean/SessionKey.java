package com.moonspirit.citics.wiki.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName      Session
 * @Description    会话属性配置类
 * @author         moonspirit
 * @date           2019年6月25日 上午10:32:21
 * @version        1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "session")
public class SessionKey {

	/**
	 * user  登录用户
	 */
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Session [user=" + user + "]";
	}

}
