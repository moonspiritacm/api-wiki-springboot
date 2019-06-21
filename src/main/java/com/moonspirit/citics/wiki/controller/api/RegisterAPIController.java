package com.moonspirit.citics.wiki.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moonspirit.citics.wiki.bean.User;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.UserService;

/**
 * @ClassName      RegisterAPIController
 * @Description    用户注册控制器
 * @author         moonspirit
 * @date           2019年6月18日 下午1:05:13
 * @version        1.0.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class RegisterAPIController {
	private static Logger logger = LoggerFactory.getLogger(RegisterAPIController.class);

	@Autowired
	public UserService userService;

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result<Object> register(@ModelAttribute User user) {
		logger.info("input args: " + user.toString());
		return userService.register(user);
	}

}
