package com.moonspirit.citics.wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName      MainController
 * @Description    页面跳转控制器
 * @author         moonspirit
 * @date           2019年6月18日 上午9:12:42
 * @version        1.0.0
 */
@Controller
public class MainController {

	@RequestMapping(value = "/editor", method = RequestMethod.GET)
	public String toEditor() {
		return "editor";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toRegister() {
		return "register";
	}

}
