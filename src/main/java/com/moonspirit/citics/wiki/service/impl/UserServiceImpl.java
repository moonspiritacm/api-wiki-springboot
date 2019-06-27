package com.moonspirit.citics.wiki.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonspirit.citics.wiki.bean.Constants;
import com.moonspirit.citics.wiki.bean.Token;
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
	Constants constants;

	@Autowired
	UserMapper userMapper;

	@Autowired
	RedisService redisService;

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

	@Override
	public Token createToken(String userId) {
		Token token = new Token(userId, UUID.randomUUID().toString());
		redisService.set(userId, token, constants.getTokenExpires());
		return token;
	}

	@Override
	public boolean checkToken(Token token) {
		if (token == null) {
			return false;
		}
		Token tokenRedis = (Token) redisService.get(token.getUserId());
		if (StringUtils.isBlank(token.getToken())) {
			return false;
		}
		return token.getToken().equals(tokenRedis.getToken());
	}

	@Override
	public Token getToken(String auth) {
		if (!StringUtils.isBlank(auth)) {
			return null;
		}
		if (auth.length() <= 36) {
			return null;
		}
		String userId = auth.substring(0, auth.length() - 36);
		String token = auth.substring(auth.length() - 36);
		return new Token(userId, token);
	}

	private boolean isUserExist(String phone) {
		Integer userId = userMapper.findUserIdByPhone(phone);
		if (userId == null)
			logger.info("null");
		return userId != null;
	}
}
