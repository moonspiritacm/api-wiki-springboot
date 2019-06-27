package com.moonspirit.citics.wiki.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.moonspirit.citics.wiki.bean.User;

/**
 * @ClassName      UserMapper
 * @Description    用户表数据操作映射
 * @author         moonspirit
 * @date           2019年6月24日 下午1:48:34
 * @version        1.0.0
 */
@Mapper
public interface UserMapper {

	@Insert("insert into user(name, password, email, salt, uuid) values(#{name}, #{password}, #{email}, #{salt}, #{uuid})")
	int insert(User user);

	@Select("select * from user where email=#{email}")
	User findUserByEmail(String email);

}
