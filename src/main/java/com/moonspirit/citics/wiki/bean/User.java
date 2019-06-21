package com.moonspirit.citics.wiki.bean;

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
	 * email  电子邮箱
	 */
	private String email;

	/**
	 * type  用户类型
	 */
	private Integer type;

	/**
	 * salt  随机加盐
	 */
	private String salt;

	public User() {
		super();
	}

	public User(Integer id, String name, String password, String email, Integer type, String salt) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.type = type;
		this.salt = salt;
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

}
