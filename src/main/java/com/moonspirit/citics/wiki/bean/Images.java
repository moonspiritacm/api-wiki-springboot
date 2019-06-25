package com.moonspirit.citics.wiki.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName      Images
 * @Description    图片上传配置类
 * @author         moonspirit
 * @date           2019年6月25日 上午10:32:21
 * @version        1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "images")
public class Images {

	/**
	 * url  图片访问地址
	 */
	private String url;

	/**
	 * path  本地存储路径
	 */
	private String path;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Images [url=" + url + ", path=" + path + "]";
	}

}
