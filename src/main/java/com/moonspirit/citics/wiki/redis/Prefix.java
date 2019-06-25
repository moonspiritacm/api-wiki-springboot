package com.moonspirit.citics.wiki.redis;

/**
 * @ClassName      Prefix
 * @Description    前缀抽象类
 * @author         moonspirit
 * @date           2019年6月25日 下午5:00:39
 * @version        1.0.0
 */
public abstract class Prefix {

	/**
	 * name  前缀名
	 */
	private String name;

	/**
	 * expireSeconds  过期时间（秒）
	 */
	private int expireSeconds;

	public Prefix() {
		super();
	}

	public Prefix(String name) {
		super();
		this.name = name;
		this.expireSeconds = 0; // 永不过期
	}

	public Prefix(String name, int expireSeconds) {
		super();
		this.name = name;
		this.expireSeconds = expireSeconds;
	}

	public String getName() {
		return getClass().getSimpleName() + ":" + this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

}
