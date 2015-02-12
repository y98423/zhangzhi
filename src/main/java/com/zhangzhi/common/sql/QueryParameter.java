/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 查询封装对象
 * 
 * @author lidinghui@star-net.cn
 * @version Id: QueryParameter.java, v 0.5 2014年8月12日 lidinghui
 */
public class QueryParameter extends Parameter {

	/**
	 * 查询结果集，默认为*
	 */
	private String output = " * ";

	/**
	 * 排序方式字符串，默认为空
	 */
	private String order;

	/**
	 * //查询限制，默认为空
	 */
	private String limit;

	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @param output
	 *            the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the limit
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/**
	 * @param table
	 * @param output
	 * @param rules
	 * @param order
	 * @param limit
	 */
	public QueryParameter(String table, String output, List<Condition> rules,
			String order, String limit) {
		super(table, rules);
		this.output = output;
		this.order = order;
		this.limit = limit;
	}

	public QueryParameter() {
	}

	public QueryParameter(String table) {
		super(table);
	}

	public QueryParameter(String table, String output) {
		super(table);
		this.output = output;
	}


	

}
