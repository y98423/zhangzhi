/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;

/**
 * 更新操作符号枚举
 * 
 * @author lidinghui@star-net.cn
 * @version Id: Operation.java, v 0.5 2014年8月11日 lidinghui
 */
public enum UpOperation {
	eq("="), key("");

	String value;

	UpOperation(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
