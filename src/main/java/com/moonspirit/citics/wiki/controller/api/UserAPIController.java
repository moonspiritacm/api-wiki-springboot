package com.moonspirit.citics.wiki.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moonspirit.citics.wiki.annotation.LoginAuth;
import com.moonspirit.citics.wiki.bean.Constants;
import com.moonspirit.citics.wiki.bean.Token;
import com.moonspirit.citics.wiki.bean.User;
import com.moonspirit.citics.wiki.result.CodeMsg;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.UserService;

/**
 * @ClassName      UserAPIController
 * @Description    用户操作控制器
 * @author         moonspirit
 * @date           2019年6月17日 下午10:41:45
 * @version        1.0.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class UserAPIController {

	private static Logger logger = LoggerFactory.getLogger(UserAPIController.class);

	@Autowired
	Constants constants;

	@Autowired
	public UserService userService;

	/**
	  * @MethodName       login
	  * @Description      登录
	  * @param            email
	  * @param            password
	  * @param            request
	  * @return
	  */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result<Object> login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request) {
		logger.info("input args: [email=" + email + ", password=" + password + "]");
		User user = userService.findUserByEmail(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				// 基于 Session 实现
				//				HttpSession session = request.getSession(true); // 获取当前会话（没有则自动创建新会话）
				//				session.setAttribute(constants.getSessionUser(), user.getId()); // 添加会话属性
				//				return Result.success();
				// 基于 Token 实现
				Token token = userService.createToken(user.getId().toString());
				return Result.success(token.getUserId() + token.getToken());
			} else {
				return Result.failure(CodeMsg.PASSWORD_ERROR);
			}
		} else {
			return Result.failure(CodeMsg.USER_NOT_EXIST);
		}
	}

	/**
	  * @MethodName       logout
	  * @Description      登出
	  * @param            request
	  * @return
	  */
	@LoginAuth
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Result<Object> logout(HttpServletRequest request) {
		// 基于 Session 实现
		request.getSession().invalidate();

		return Result.success();
	}

}
