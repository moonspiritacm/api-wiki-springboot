package com.moonspirit.citics.wiki.bean;

import java.util.List;

/**
 * @ClassName      Project
 * @Description    项目实体类
 * @author         moonspirit
 * @date           2019年6月19日 上午9:54:14
 * @version        1.0.0
 */
public class Project {

	/**
	 * id  项目编号
	 */
	private Integer id;

	/**
	 * name  项目名称
	 */
	private String name;

	/**
	 * description  项目描述
	 */
	private String description;

	/**
	 * uuid  生成项目访问地址
	 */
	private String uuid;

	/**
	 * users  参与项目的用户列表
	 */
	private List<User> users;

	/**
	 * articles  项目关联的文章列表
	 */
	private List<Article> articles;

	/**
	 * modules  项目包含的模块列表
	 */
	private List<Module> modules;

	public Project() {
		super();
	}

	public Project(Integer id, String name, String description, String uuid, List<User> users, List<Article> articles,
			List<Module> modules) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.uuid = uuid;
		this.users = users;
		this.articles = articles;
		this.modules = modules;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", uuid=" + uuid + ", users="
				+ users + ", articles=" + articles + ", modules=" + modules + "]";
	}

}
