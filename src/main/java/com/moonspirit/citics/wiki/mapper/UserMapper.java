package com.moonspirit.citics.wiki.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.moonspirit.citics.wiki.bean.User;

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

	@Select("select * from tb_user where phone=#{phone}")
	User findUserByPhone(String phone);

}
