package com.moonspirit.citics.wiki.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.moonspirit.citics.wiki.annotation.LoginAuth;
import com.moonspirit.citics.wiki.bean.Constants;
import com.moonspirit.citics.wiki.bean.Token;
import com.moonspirit.citics.wiki.result.CodeMsg;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.UserService;
import com.moonspirit.citics.wiki.utils.ReturnUtil;

/**
 * @ClassName      LoginInterceptor
 * @Description    拦截未登录用户
 * @author         moonspirit
 * @date           2019年6月24日 下午5:27:29
 * @version        1.0.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Autowired
	Constants constants;

	@Autowired
	UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		if (method.getAnnotation(LoginAuth.class) == null) {
			return true;
		}
		logger.info(this.getClass().getSimpleName() + " running......");

		//		// 基于 Session 实现
		//		HttpSession session = request.getSession(false); // 获取当前会话（没有也不自动创建新会话）
		//		if (session == null || session.getAttribute(constants.getSessionUser()) == null) {
		//			Result<Object> result = Result.failure(CodeMsg.USER_NOT_LOGIN);
		//			ReturnUtil.returnJson(response, result);
		//			return false;
		//		}

		// 基于 Token 实现
		String authorization = request.getHeader(constants.getAuthorization());
		Token token = userService.getToken(authorization);
		if (!userService.checkToken(token)) {
			Result<Object> result = Result.failure(CodeMsg.USER_NOT_LOGIN);
			ReturnUtil.returnJson(response, result);
			return false;
		}
		logger.info(this.getClass().getSimpleName() + " success.");
		request.setAttribute(constants.getTokenUserId(), token.getUserId());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
	}

}
