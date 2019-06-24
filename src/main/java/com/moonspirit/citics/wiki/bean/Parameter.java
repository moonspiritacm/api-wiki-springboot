package com.moonspirit.citics.wiki.bean;

/**
 * @ClassName      Article
 * @Description    文章实体类
 * @author         moonspirit
 * @date           2019年6月17日 下午3:57:50
 * @version        1.0.0
 */
public class Parameter {

	private Integer id;
	private Integer userId;
	private String title;
	private String content;

	public Parameter() {
	}

	public Parameter(Integer userId, String title, String content) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
	}

	public Parameter(Integer id, Integer userId, String title, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
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

	@Override
	public String toString() {
		return "Article [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content + "]";
	}

}
