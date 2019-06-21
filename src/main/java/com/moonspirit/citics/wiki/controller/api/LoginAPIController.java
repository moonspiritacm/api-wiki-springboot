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

import com.moonspirit.citics.wiki.bean.User;
import com.moonspirit.citics.wiki.result.CodeMsg;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.UserService;

/**
 * @ClassName      LoginAPIController
 * @Description    用户登录控制器
 * @author         moonspirit
 * @date           2019年6月17日 下午10:41:45
 * @version        1.0.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class LoginAPIController {
	private static Logger logger = LoggerFactory.getLogger(LoginAPIController.class);

	@Autowired
	public UserService userService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result<Object> login(@RequestParam("phone") String phone, @RequestParam("password") String password,
			HttpServletRequest request) {
		logger.info("input args: [phone=" + phone + ", password=" + password + "]");
		User dbUser = userService.findUserByPhone(phone);
		if (dbUser != null) {
			if (dbUser.getPassword().equals(password)) {
				request.getSession().setAttribute("users", dbUser.getId());
				return Result.success();
			} else {
				return Result.failure(CodeMsg.PASSWORD_ERROR);
			}
		} else {
			return Result.failure(CodeMsg.USER_NOT_EXIST);
		}
	}
}
