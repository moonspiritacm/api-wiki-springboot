package com.moonspirit.citics.wiki.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.moonspirit.citics.wiki.bean.Project;

/**
 * @ClassName      ProjectMapper
 * @Description    项目表映射
 * @author         moonspirit
 * @date           2019年6月19日 上午10:44:48
 * @version        1.0.0
 */
@Mapper
public interface ProjectMapper {

	@Insert("insert into project(uuid, name, description) values(#{uuid}, #{name}, #{description})")
	int insert(Project project);

	@Select("select * from project")
	List<Project> findAllProject();

	@Select("select count(*) from project where name=#{name}")
	int countProjectByName(String name);

}
