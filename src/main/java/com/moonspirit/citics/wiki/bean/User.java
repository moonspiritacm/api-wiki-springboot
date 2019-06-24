package com.moonspirit.citics.wiki.bean;

import java.util.List;

/**
 * @ClassName      User
 * @Description    用户实体类
 * @author         moonspirit
 * @date           2019年6月17日 下午3:57:34
 * @version        1.0.0
 */
public class User {

	/**
	 * id  用户编号
	 */
	private Integer id;

	/**
	 * name  用户名
	 */
	private String name;

	/**
	 * password  密码
	 */
	private String password;

	/**
	 * email  邮箱
	 */
	private String email;

	/**
	 * type  用户类型：0-系统管理员 1-普通用户
	 */
	private Integer type;

	/**
	 * salt  随机加盐
	 */
	private String salt;

	/**
	 * uuid  预留字段
	 */
	private String uuid;

	/**
	 * articles  用户创建的文章列表
	 */
	private List<Article> articles;

	/**
	 * projects  用户参与的项目列表
	 */
	private List<Project> projects;

	public User() {
		super();
	}

	public User(Integer id, String name, String password, String email, Integer type, String salt, String uuid,
			List<Article> articles, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.type = type;
		this.salt = salt;
		this.uuid = uuid;
		this.articles = articles;
		this.projects = projects;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", type=" + type
				+ ", salt=" + salt + ", uuid=" + uuid + ", articles=" + articles + ", projects=" + projects + "]";
	}

}
