/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;

import java.io.Serializable;

/**
 * 新增字段对象
 * 
 * @author lidinghui@star-net.cn
 * @version Id: CreateModel.java, v 0.5 2014年8月31日 lidinghui
 */
public class FiledModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3497587598718306448L;

	private String key;

	private Object value;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @param operation
	 * @param key
	 * @param value
	 */
	public FiledModel(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	public FiledModel() {
	}

	public static FiledModel create(String key, Object value) {
		return new FiledModel(key, value);
	}
}
