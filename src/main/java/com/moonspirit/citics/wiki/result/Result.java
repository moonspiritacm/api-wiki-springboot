package com.moonspirit.citics.wiki.result;

/**
 * @ClassName      Result
 * @Description    REST API 调用结果封装类
 * @author         moonspirit
 * @date           2019年6月18日 上午8:49:51
 * @version        1.0.0
 */
public class Result<T> {

	private Integer code;
	private String msg;
	private T data;

	public void setCodeMsg(CodeMsg codeMsg) {
		this.code = codeMsg.getCode();
		this.msg = codeMsg.getMsg();
	}

	public static <T> Result<T> success() {
		Result<T> result = new Result<T>();
		result.setCodeMsg(CodeMsg.SUCCESS);
		return result;
	}

	public static <T> Result<T> success(T data) {
		Result<T> result = new Result<T>();
		result.setCodeMsg(CodeMsg.SUCCESS);
		result.setData(data);
		return result;
	}

	public static <T> Result<T> failure() {
		Result<T> result = new Result<T>();
		result.setCodeMsg(CodeMsg.ERROR);
		return result;
	}

	public static <T> Result<T> failure(T data) {
		Result<T> result = new Result<T>();
		result.setCodeMsg(CodeMsg.ERROR);
		result.setData(data);
		return result;
	}

	public static <T> Result<T> failure(CodeMsg codeMsg) {
		Result<T> result = new Result<T>();
		result.setCodeMsg(codeMsg);
		return result;
	}

	public static <T> Result<T> failure(CodeMsg codeMsg, T data) {
		Result<T> result = new Result<T>();
		result.setCodeMsg(codeMsg);
		result.setData(data);
		return result;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
