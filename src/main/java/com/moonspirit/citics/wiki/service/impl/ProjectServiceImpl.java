package com.moonspirit.citics.wiki.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonspirit.citics.wiki.bean.Project;
import com.moonspirit.citics.wiki.mapper.ProjectMapper;
import com.moonspirit.citics.wiki.result.CodeMsg;
import com.moonspirit.citics.wiki.result.Result;
import com.moonspirit.citics.wiki.service.ProjectService;

/**
 * @ClassName      ProjectServiceImpl
 * @Description    项目管理实现类
 * @author         moonspirit
 * @date           2019年6月19日 上午11:19:25
 * @version        1.0.0
 */
@Service
public class ProjectServiceImpl implements ProjectService {
	private Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	ProjectMapper projectMapper;

	@Override
	public Result<Object> insertProject(Project project) {
		// 参数校验：项目名称不能为空
		if (StringUtils.isBlank(project.getName())) {
			return Result.failure(CodeMsg.PROJECT_NAME_IS_NULL);
		}
		// 插入校验：项目名称唯一约束
		if (isProjectExist(project.getName())) {
			return Result.failure(CodeMsg.PROJECT_IS_EXIST);
		}

		String uuid = UUID.randomUUID().toString();
		project.setName(project.getName().trim());
		project.setUuid(uuid);
		int res = projectMapper.insert(project);
		logger.info("Insert result : " + Integer.toString(res));
		return (res == 0) ? Result.failure(CodeMsg.ERROR) : Result.success();
	}

	@Override
	public Result<Object> findAllProject() {
		List<Project> list = projectMapper.findAllProject();
		return Result.success(list);
	}

	private boolean isProjectExist(String name) {
		int count = projectMapper.countProjectByName(name);
		return count != 0;
	}

}
