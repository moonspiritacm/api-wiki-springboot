package com.moonspirit.citics.wiki.bean;

import java.util.List;

/**
 * @ClassName      Interfaces
 * @Description    接口实体类
 * @author         moonspirit
 * @date           2019年6月24日 上午11:12:33
 * @version        1.0.0
 */
public class Interfaces {

	/**
	 * id  接口编号
	 */
	private Integer id;

	/**
	 * moduleId  模块编号
	 */
	private Integer moduleId;

	/**
	 * name  接口名称
	 */
	private String name;

	/**
	 * description  接口描述
	 */
	private String description;

	/**
	 * url  访问地址
	 */
	private String url;

	/**
	 * method  请求类型
	 */
	private Integer method;

	/**
	 * uuid  预留字段
	 */
	private String uuid;

	/**
	 * parameters  接口包含的参数列表
	 */
	private List<Parameter> parameters;

	public Interfaces() {
		super();
	}

	public Interfaces(Integer id, Integer moduleId, String name, String description, String url, Integer method,
			String uuid, List<Parameter> parameters) {
		super();
		this.id = id;
		this.moduleId = moduleId;
		this.name = name;
		this.description = description;
		this.url = url;
		this.method = method;
		this.uuid = uuid;
		this.parameters = parameters;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "Interfaces [id=" + id + ", moduleId=" + moduleId + ", name=" + name + ", description=" + description
				+ ", url=" + url + ", method=" + method + ", uuid=" + uuid + ", parameters=" + parameters + "]";
	}

}
