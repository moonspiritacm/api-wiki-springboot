package com.moonspirit.citics.wiki.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.moonspirit.citics.wiki.bean.Article;

@Mapper
public interface ArticleMapper {

	@Insert("insert into tb_article(user_id, title, content) values(#{userId}, #{title}, #{content})")
	int insert(Article article);

	@Select("select * from tb_article where id=#{id}")
	Article findArticleById(int id);
}
