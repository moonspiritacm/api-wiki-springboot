package com.moonspirit.citics.wiki.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.moonspirit.citics.wiki.bean.Article;

/**
 * @ClassName      ArticleMapper
 * @Description    文章表数据操作映射
 * @author         moonspirit
 * @date           2019年6月27日 下午3:17:44
 * @version        1.0.0
 */
@Mapper
public interface ArticleMapper {

	@Insert("insert into article(user_id, project_id, title, content, uuid) values(#{userId}, #{projectId}, #{title}, #{content}, #{uuid})")
	int insert(Article article);

	@Select("select * from article where id=#{id}")
	Article findArticleById(int id);

	@Select("select * from article")
	List<Article> findArticles();

	@Select("select * from article where user_id=#{userId}")
	List<Article> findArticlesByUserId(int userId);

	@Select("select * from article where project_id=#{projectId}")
	List<Article> findArticlesByProjectId(int projectId);

	@Select("select * from article where title like CONCAT('%',#{title},'%')")
	List<Article> findArticlesByTitle(String title);

}
