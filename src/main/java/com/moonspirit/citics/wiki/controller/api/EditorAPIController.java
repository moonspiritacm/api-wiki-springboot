package com.moonspirit.citics.wiki.controller.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.moonspirit.citics.wiki.bean.Article;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.ArticleService;
import com.moonspirit.citics.wiki.service.UserService;
import com.moonspirit.citics.wiki.utils.FileUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class EditorAPIController {
	private Logger logger = LoggerFactory.getLogger(EditorAPIController.class);

	@Value("${images.url}")
	private String imageUrl;

	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;

	@RequestMapping(value = "/article", method = RequestMethod.POST)
	public Result<Object> publishArticle(@RequestParam("title") String title, @RequestParam("content") String content,
			HttpServletRequest request) {
		Integer userId = (Integer) request.getSession().getAttribute("users");
		Article article = new Article();
		article.setUserId(userId);
		article.setTitle(title);
		article.setContent(content);
		logger.info(article.toString());
		return articleService.insertArticle(article);
	}

	@RequestMapping(value = "/images", method = RequestMethod.POST)
	public Map<String, Object> uploadImage(HttpServletRequest request,
			@RequestParam(value = "editormd-image-file", required = false) MultipartFile multipartFile) {
		Map<String, Object> res = new HashMap<String, Object>();

		// String OriginalFilename = multipartFile.getOriginalFilename(); // photo.jpg
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		String contentType = multipartFile.getContentType(); // image/jpeg
		String fileType = contentType.substring(contentType.indexOf("/") + 1);
		String fileName = uuid + "." + fileType;
		String filePath = "upload/";
		try {
			FileUtil.uploadFile(multipartFile, filePath, fileName);
			res.put("success", 1);
			res.put("message", "上传成功");
			res.put("url", imageUrl.substring(0, imageUrl.length() - 2) + fileName);
		} catch (IOException e) {
			res.put("success", 0);
			res.put("message", "上传失败");
			e.printStackTrace();
		}
		return res;
	}

}
