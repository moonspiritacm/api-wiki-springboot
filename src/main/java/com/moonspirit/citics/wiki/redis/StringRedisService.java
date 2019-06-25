package com.moonspirit.citics.wiki.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName      StringRedisService
 * @Description    Redis 工具类（String 类型）
 * @author         moonspirit
 * @date           2019年6月25日 下午4:51:29
 * @version        1.0.0
 */
@Service
public class StringRedisService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 获取当个对象
	 * */
	public <T> T get(Prefix prefix, String key, Class<T> clazz) {
		String fullKey = prefix.getName() + key;
		String value = (String) redisTemplate.opsForValue().get(fullKey);
		T t = stringToBean(value, clazz);
		return t;

	}

	public static <T> String beanToString(T value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();
		if (clazz == int.class || clazz == Integer.class) {
			return "" + value;
		} else if (clazz == String.class) {
			return (String) value;
		} else if (clazz == long.class || clazz == Long.class) {
			return "" + value;
		} else {
			return JSON.toJSONString(value);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T stringToBean(String str, Class<T> clazz) {
		if (str == null || str.length() <= 0 || clazz == null) {
			return null;
		}
		if (clazz == int.class || clazz == Integer.class) {
			return (T) Integer.valueOf(str);
		} else if (clazz == String.class) {
			return (T) str;
		} else if (clazz == long.class || clazz == Long.class) {
			return (T) Long.valueOf(str);
		} else {
			return JSON.toJavaObject(JSON.parseObject(str), clazz);
		}
	}
}
