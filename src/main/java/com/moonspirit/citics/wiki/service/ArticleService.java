package com.moonspirit.citics.wiki.service;

import org.springframework.transaction.annotation.Transactional;

import com.moonspirit.citics.wiki.bean.Article;
import com.moonspirit.citics.wiki.result.Result;

/**
 * @ClassName      ArticleService
 * @Description    文章管理功能接口类
 * @author         moonspirit
 * @date           2019年6月18日 下午4:51:48
 * @version        1.0.0
 */
public interface ArticleService {

	/**
	  * @MethodName       findArticleById
	  * @Description      根据文章编号获取特定文章
	  * @param            id 文章编号
	  * @return           Result<Object>
	  */
	Result<Object> findArticleById(Integer id);

	/**
	  * @MethodName       findAllArticles
	  * @Description      
	  * @return
	  */
	Result<Object> findAllArticles();

	Result<Object> insertArticle(Article article);

	@Transactional
	String updateArticle(Article article);

}
