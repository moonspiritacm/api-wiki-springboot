package com.moonspirit.citics.wiki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonspirit.citics.wiki.bean.Article;
import com.moonspirit.citics.wiki.mapper.ArticleMapper;
import com.moonspirit.citics.wiki.result.CodeMsg;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.ArticleService;

/**
 * @ClassName      ArticleServiceImpl
 * @Description    文章管理功能实现类
 * @author         moonspirit
 * @date           2019年6月18日 下午5:09:36
 * @version        1.0.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleMapper articleMapper;

	@Override
	public Result<Object> insertArticle(Article article) {
		articleMapper.insert(article);
		return Result.success();
	}

	@Override
	public String updateArticle(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> findArticleById(Integer id) {
		Article article = articleMapper.findArticleById(id);
		if (article != null) {
			return Result.success(article);
		} else {
			return Result.failure(CodeMsg.ARTICLE_NOT_EXIST);
		}
	}

	@Override
	public Result<Object> findAllArticles() {
		// TODO Auto-generated method stub
		return null;
	}

}
