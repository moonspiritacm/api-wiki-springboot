package com.moonspirit.citics.wiki.bean;

import java.util.List;

/**
 * @ClassName      Module
 * @Description    模块实体类
 * @author         moonspirit
 * @date           2019年6月19日 上午9:54:14
 * @version        1.0.0
 */
public class Module {

	/**
	 * id  模块编号
	 */
	private Integer id;

	/**
	 * projectId  项目编号
	 */
	private Integer projectId;

	/**
	 * name  模块名称
	 */
	private String name;

	/**
	 * description  模块描述
	 */
	private String description;

	/**
	 * uuid  预留字段
	 */
	private String uuid;

	/**
	 * interfaces  模块包含的接口列表
	 */
	private List<Interfaces> interfaces;

	public Module() {
		super();
	}

	public Module(Integer id, Integer projectId, String name, String description, String uuid,
			List<Interfaces> interfaces) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.uuid = uuid;
		this.interfaces = interfaces;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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

	public List<Interfaces> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<Interfaces> interfaces) {
		this.interfaces = interfaces;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", projectId=" + projectId + ", name=" + name + ", description=" + description
				+ ", uuid=" + uuid + ", interfaces=" + interfaces + "]";
	}

}
