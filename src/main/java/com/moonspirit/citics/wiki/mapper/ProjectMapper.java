package com.moonspirit.citics.wiki.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.moonspirit.citics.wiki.bean.Project;

/**
 * @ClassName      ProjectMapper
 * @Description    项目表数据操作映射
 * @author         moonspirit
 * @date           2019年6月19日 上午10:44:48
 * @version        1.0.0
 */
@Mapper
public interface ProjectMapper {

	@Insert("insert into project(name, description, uuid) values(#{name}, #{description}), #{uuid}")
	int insert(Project project);

	@Select("select * from project where id=#{id}")
	Project findProjectById(int id);

	@Select("select * from project")
	List<Project> findProjects();

}
