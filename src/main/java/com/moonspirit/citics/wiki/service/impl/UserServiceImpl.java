package com.moonspirit.citics.wiki.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonspirit.citics.wiki.bean.User;
import com.moonspirit.citics.wiki.mapper.UserMapper;
import com.moonspirit.citics.wiki.result.CodeMsg;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.UserService;

/**
 * @ClassName      UserServiceImpl
 * @Description    用户逻辑实现类
 * @author         moonspirit
 * @date           2019年6月17日 下午4:08:45
 * @version        1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserMapper userMapper;

	@Override
	public User findUserByEmail(String email) {
		return userMapper.findUserByEmail(email);
	}

	@Override
	public Result<Object> register(User user) {
		// 用户存在
		if (isUserExist(user.getName())) {
			return Result.failure(CodeMsg.USER_IS_EXIST);
		}
		user.setSalt("0");
		userMapper.insert(user);
		return Result.success();
	}

	private boolean isUserExist(String phone) {
		Integer userId = userMapper.findUserIdByPhone(phone);
		if (userId == null)
			logger.info("null");
		return userId != null;
	}
}
