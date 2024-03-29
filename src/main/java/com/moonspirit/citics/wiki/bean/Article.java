package com.moonspirit.citics.wiki.bean;

/**
 * @ClassName      Article
 * @Description    文章实体类
 * @author         moonspirit
 * @date           2019年6月17日 下午3:57:50
 * @version        1.0.0
 */
public class Article {

	/**
	 * id  文章编号
	 */
	private Integer id;

	/**
	 * userId  用户编号
	 */
	private Integer userId;

	/**
	 * projectId  项目编号
	 */
	private Integer projectId;

	/**
	 * title  标题
	 */
	private String title;

	/**
	 * content  正文
	 */
	private String content;

	/**
	 * uuid  生成文章访问地址
	 */
	private String uuid;

	public Article() {
		super();
	}

	public Article(Integer id, Integer userId, Integer projectId, String title, String content, String uuid) {
		super();
		this.id = id;
		this.userId = userId;
		this.projectId = projectId;
		this.title = title;
		this.content = content;
		this.uuid = uuid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", userId=" + userId + ", projectId=" + projectId + ", title=" + title
				+ ", content=" + content + ", uuid=" + uuid + "]";
	}

}
