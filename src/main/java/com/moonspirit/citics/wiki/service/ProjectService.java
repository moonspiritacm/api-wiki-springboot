package com.moonspirit.citics.wiki.service;

import com.moonspirit.citics.wiki.bean.Project;
import com.moonspirit.citics.wiki.result.Result;

/**
 * @ClassName      ProjectService
 * @Description    项目管理接口类
 * @author         moonspirit
 * @date           2019年6月19日 上午11:16:47
 * @version        1.0.0
 */
public interface ProjectService {

	Result<Object> insertProject(Project project);

	Result<Object> findAllProject();

}
