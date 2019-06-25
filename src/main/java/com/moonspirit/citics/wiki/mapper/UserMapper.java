package com.moonspirit.citics.wiki.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.moonspirit.citics.wiki.bean.User;

/**
 * @ClassName      UserMapper
 * @Description    用户表关系映射
 * @author         moonspirit
 * @date           2019年6月24日 下午1:48:34
 * @version        1.0.0
 */
@Mapper
public interface UserMapper {

	@Select("select username from tb_user where id=#{id}")
	String findUsernameById(int id);

	@Insert("insert into tb_user(username, password, phone, salt) values(#{username}, #{password}, #{phone}, #{salt})")
	void insert(User user);

	@Select("select id from tb_user where phone=#{phone}")
	Integer findUserIdByPhone(String phone);

	@Select("select username from tb_user where phone=#{phone}")
	String findUsernameByPhone(String phone);

	@Select("select * from user where email=#{email}")
	User findUserByEmail(String email);

}
