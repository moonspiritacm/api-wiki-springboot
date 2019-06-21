package com.moonspirit.citics.wiki.bean;

/**
 * @ClassName      User
 * @Description    用户实体类
 * @author         moonspirit
 * @date           2019年6月17日 下午3:57:34
 * @version        1.0.0
 */
public class User {

	private Integer id;
	private String username;
	private String password;
	private String phone;
	private String salt;

	public User() {
	}

	public User(String username, String password, String phone, String salt) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.salt = salt;
	}

	public User(Integer id, String username, String password, String phone, String salt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.salt = salt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", salt="
				+ salt + "]";
	}

}
