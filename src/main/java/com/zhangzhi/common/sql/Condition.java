/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;



/**
 * 条件对象
 * 
 * @author lidinghui@star-net.cn
 * @version Id: Condition.java, v 0.5 2014年8月11日 lidinghui
 */
public class Condition {

	private Operation operation;

	private String key;

	private Object value;

	/**
	 * @return the operation
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(Operation operation) {
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
	public Condition(Operation operation, String key, Object value) {
		super();
		this.operation = operation;
		this.key = key;
		this.value = value;
	}

	public Condition() {
	}
	
	public static Condition create(Operation operation, String key, Object value){
		return new Condition(operation, key, value);
	}

}
