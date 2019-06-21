package com.moonspirit.citics.wiki.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.moonspirit.citics.wiki.bean.Project;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.ProjectService;

/**
 * @ClassName      ProjectAPIController
 * @Description    项目管理模块
 * @author         moonspirit
 * @date           2019年6月19日 上午11:04:35
 * @version        1.0.0
 */
@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ProjectAPIController {
	private Logger logger = LoggerFactory.getLogger(ProjectAPIController.class);

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result<Object> insertProject(Project project) {
		logger.info("Input parms : " + project.toString());
		return projectService.insertProject(project);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result<Object> findAllArticle(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize) {
		logger.info("Input parms : pageNum=" + pageNum + ", pageSize=" + pageSize);
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		return projectService.findAllProject();
	}
}
