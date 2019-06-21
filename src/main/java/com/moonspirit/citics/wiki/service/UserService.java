package com.moonspirit.citics.wiki.service;

import org.springframework.transaction.annotation.Transactional;

import com.moonspirit.citics.wiki.bean.User;
import com.moonspirit.citics.wiki.result.Result;

/**
 * @ClassName      UserService
 * @Description    用户逻辑接口类
 * @author         moonspirit
 * @date           2019年6月17日 下午3:59:13
 * @version        1.0.0
 */
public interface UserService {

	@Transactional
	Result<Object> register(User user);

	User findUserByPhone(String phone);

}
