/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;

/**
 * 
 * 
 * @author lidinghui@star-net.cn
 * @version Id: UpdateCondition.java, v 0.5 2014年8月20日 lidinghui
 */
public class UpdateModel {

	private UpOperation operation;

	private String key;

	private Object value;

	/**
	 * @return the operation
	 */
	public UpOperation getOperation() {
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(UpOperation operation) {
		this.operation = operation;
	}

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
	public UpdateModel(UpOperation operation, String key, Object value) {
		super();
		this.operation = operation;
		this.key = key;
		this.value = value;
	}

	public UpdateModel() {
	}

	public static UpdateModel create(UpOperation operation, String key,
			Object value) {
		return new UpdateModel(operation, key, value);
	}
}
