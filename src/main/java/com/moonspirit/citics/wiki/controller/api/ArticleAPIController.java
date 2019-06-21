package com.moonspirit.citics.wiki.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.ArticleService;
import com.moonspirit.citics.wiki.service.UserService;

/**
 * @ClassName      ArticleAPIController
 * @Description    文章管理模块
 * @author         moonspirit
 * @date           2019年6月18日 下午4:04:54
 * @version        1.0.0
 */
@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ArticleAPIController {
	private Logger logger = LoggerFactory.getLogger(ArticleAPIController.class);

	@Autowired
	ArticleService articleService;

	@Autowired
	UserService userService;

	/**
	  * @MethodName       findAllArticles
	  * @Description      获取全部文章（分页）
	  * @param            pageNum 分页编号
	  * @param            pageSize 分页规模
	  * @return
	  */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Result<Object> findAllArticles(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return articleService.findAllArticles();
	}

	/**
	  * @MethodName       findArticleById
	  * @Description      根据文章编号获取特定文章
	  * @param            id 文章编号
	  * @return           Result<Object>
	  */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)

	public Result<Object> findArticleById(@PathVariable("id") Integer id) {
		logger.info(id.toString());
		return articleService.findArticleById(id);
	}

}
