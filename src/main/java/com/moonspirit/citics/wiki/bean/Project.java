package com.moonspirit.citics.wiki.bean;

/**
 * @ClassName      Project
 * @Description    项目实体类
 * @author         moonspirit
 * @date           2019年6月19日 上午9:54:14
 * @version        1.0.0
 */
public class Project {

	/**
	 * 项目编号（主键）
	 */
	private int id;

	/**
	 * UUID
	 */
	private String uuid;

	/**
	 * 项目名称
	 */
	private String name;

	/**
	 * 项目描述
	 */
	private String description;

	public Project() {
		super();
	}

	public Project(int id, String uuid, String name, String description) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	@Override
	public String toString() {
		return "Project [id=" + id + ", uuid=" + uuid + ", name=" + name + ", description=" + description + "]";
	}

}
