package com.moonspirit.citics.wiki.bean;

/**
 * @ClassName      Parameter
 * @Description    参数实体类
 * @author         moonspirit
 * @date           2019年6月24日 上午11:18:55
 * @version        1.0.0
 */
public class Parameter {

	/**
	 * id  参数编号
	 */
	private Integer id;

	/**
	 * interfacesId  接口编号
	 */
	private Integer interfacesId;

	/**
	 * parentId  父接口编号
	 */
	private Integer parentId;

	/**
	 * name  参数名称
	 */
	private String name;

	/**
	 * description  参数描述
	 */
	private String description;

	/**
	 * type  参数类型：0-请求，1-响应
	 */
	private Boolean type;

	/**
	 * dataType  数据类型
	 */
	private Integer dataType;

	/**
	 * necessary  0-可选，1-必选
	 */
	private Boolean necessary;

	/**
	 * rule  生成规则
	 */
	private String rule;

	public Parameter() {
		super();
	}

	public Parameter(Integer id, Integer interfacesId, Integer parentId, String name, String description, Boolean type,
			Integer dataType, Boolean necessary, String rule) {
		super();
		this.id = id;
		this.interfacesId = interfacesId;
		this.parentId = parentId;
		this.name = name;
		this.description = description;
		this.type = type;
		this.dataType = dataType;
		this.necessary = necessary;
		this.rule = rule;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInterfacesId() {
		return interfacesId;
	}

	public void setInterfacesId(Integer interfacesId) {
		this.interfacesId = interfacesId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public Boolean getNecessary() {
		return necessary;
	}

	public void setNecessary(Boolean necessary) {
		this.necessary = necessary;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	@Override
	public String toString() {
		return "Parameter [id=" + id + ", interfacesId=" + interfacesId + ", parentId=" + parentId + ", name=" + name
				+ ", description=" + description + ", type=" + type + ", dataType=" + dataType + ", necessary="
				+ necessary + ", rule=" + rule + "]";
	}

}
