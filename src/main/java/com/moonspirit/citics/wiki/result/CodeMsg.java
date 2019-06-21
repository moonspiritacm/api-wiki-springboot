package com.moonspirit.citics.wiki.result;

/**
 * @ClassName      CodeMsg
 * @Description    状态码枚举类
 * @author         moonspirit
 * @date           2019年6月18日 上午8:53:39
 * @version        1.0.0
 */
public enum CodeMsg {

	SUCCESS(200, "成功"), ERROR(500, "未知错误"), USER_NOT_EXIST(500101, "用户不存在"), USER_IS_EXIST(500102, "用户已存在"),
	PASSWORD_ERROR(500103, "密码错误"), ARTICLE_NOT_EXIST(500201, "文章不存在"), PROJECT_NAME_IS_NULL(500301, "项目名称不能为空！"),
	PROJECT_IS_EXIST(500302, "项目名称不能重复！");

	private Integer code;
	private String msg;

	private CodeMsg() {
	}

	private CodeMsg(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
