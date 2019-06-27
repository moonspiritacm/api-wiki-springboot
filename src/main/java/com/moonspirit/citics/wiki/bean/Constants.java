package com.moonspirit.citics.wiki.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName      Constants
 * @Description    配置参数
 * @author         moonspirit
 * @date           2019年6月25日 上午10:32:21
 * @version        1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "constants")
public class Constants {

	/**
	 * sessionUser  会话属性值
	 */
	private String sessionUser;

	/**
	 * tokenAuth  令牌内容
	 */
	private String tokenAuth;

	/**
	 * tokenExpires  令牌过期时间
	 */
	private Integer tokenExpires;

	/**
	 * imagesUrl  图片访问地址
	 */
	private String imagesUrl;

	/**
	 * imagesPath  图片存储路径
	 */
	private String imagesPath;

	public String getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(String sessionUser) {
		this.sessionUser = sessionUser;
	}

	public String getTokenAuth() {
		return tokenAuth;
	}

	public void setTokenAuth(String tokenAuth) {
		this.tokenAuth = tokenAuth;
	}

	public Integer getTokenExpires() {
		return tokenExpires;
	}

	public void setTokenExpires(Integer tokenExpires) {
		this.tokenExpires = tokenExpires;
	}

	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	public String getImagesPath() {
		return imagesPath;
	}

	public void setImagesPath(String imagesPath) {
		this.imagesPath = imagesPath;
	}

	@Override
	public String toString() {
		return "Constants [sessionUser=" + sessionUser + ", tokenAuth=" + tokenAuth + ", tokenExpires=" + tokenExpires
				+ ", imagesUrl=" + imagesUrl + ", imagesPath=" + imagesPath + "]";
	}

}
