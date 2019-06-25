package com.moonspirit.citics.wiki.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.moonspirit.citics.wiki.bean.Images;
import com.moonspirit.citics.wiki.interceptor.LoginInterceptor;
import com.moonspirit.citics.wiki.interceptor.ProjectInterceptor;
import com.moonspirit.citics.wiki.interceptor.UserInterceptor;

/**
 * @ClassName      WebMvcConfig
 * @Description    应用配置类
 * @author         moonspirit
 * @date           2019年6月25日 上午9:53:28
 * @version        1.0.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	Images images;

	@Autowired
	LoginInterceptor loginInterceptor;

	@Autowired
	ProjectInterceptor projectInterceptor;

	@Autowired
	UserInterceptor userInterceptor;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(images.getUrl()).addResourceLocations(images.getPath()); // 图片访问及存储路径
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**"); // 拦截未登录用户
		registry.addInterceptor(projectInterceptor).addPathPatterns("/**"); // 拦截非指定项目组成员
		registry.addInterceptor(userInterceptor).addPathPatterns("/**"); // 拦截非指定用户
	}
}
