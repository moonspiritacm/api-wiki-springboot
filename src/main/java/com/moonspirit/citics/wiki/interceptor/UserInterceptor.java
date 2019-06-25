package com.moonspirit.citics.wiki.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.moonspirit.citics.wiki.annotation.UserAuth;

/**
 * @ClassName      UserInterceptor
 * @Description    拦截非指定用户
 * @author         moonspirit
 * @date           2019年6月24日 下午5:27:29
 * @version        1.0.0
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		if (method.getAnnotation(UserAuth.class) == null) {
			return true;
		}

		// 基于 Session 实现
		HttpSession session = request.getSession(false); // 获取当前会话（没有也不自动创建新会话）
		if (session == null || session.getAttribute("users") == null) {
			response.reset();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");

			PrintWriter pw = response.getWriter();

			//	        if (user == null) {
			//	            pw.write(JsonUtil.objToJson(ServerResponse.createByErrorCodeAndMessage(ResponseCode.NEED_LOGIN.getCode(), "拦截器拦截，请登录")));
			//	        } else {
			//	            pw.write(JsonUtil.objToJson(ServerResponse.createByErrorCodeAndMessage(ResponseCode.ERROR.getCode(), "拦截器拦截，无权限操作")));
			//	        }

			pw.flush();
			pw.close();
			return false;
		}
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
