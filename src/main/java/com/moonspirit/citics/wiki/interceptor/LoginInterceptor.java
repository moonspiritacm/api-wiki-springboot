package com.moonspirit.citics.wiki.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//		// 基于 Session 实现
		//		HttpSession session = request.getSession(false); // 获取当前会话（没有也不自动创建新会话）
		//		if (session == null || session.getAttribute(constants.getSessionUser()) == null) {
		//			Result<Object> result = Result.failure(CodeMsg.USER_NOT_LOGIN);
		//			ReturnUtil.returnJson(response, result);
		//			return false;
		//		}

		// 基于 Token 实现
		String auth = request.getHeader(constants.getTokenAuth());
		Token token = userService.getToken(auth);
		if (!userService.checkToken(token)) {
			Result<Object> result = Result.failure(CodeMsg.USER_NOT_LOGIN);
			ReturnUtil.returnJson(response, result);
			return false;
		}
		//		request.setAttribute(constants.userId, token.getUserId());
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

//
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

//		String authorization = request.getHeader(Constants.AUTHORIZATION);
//		TokenEntity tokenEntity = tokenService.getToken(authorization);
//
//		if (tokenService.checkToken(tokenEntity)) {
//			//如果token验证成功，将token对应的用户id存在request中，便于之后注入
//			request.setAttribute(Constants.CURRENT_USER_ID, tokenEntity.getUserId());
//			return true;
//		} else {
//			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			return false;
//		}
