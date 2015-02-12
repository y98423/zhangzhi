/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author lidinghui@star-net.cn
 * @version Id: Parameter.java, v 0.5 2014年8月20日 lidinghui
 */
public class Parameter {

	/**
	 * 必要key
	 */
	private String table;

	/**
	 * 规则集合
	 */
	private List<Condition> rules;

	/**
	 * @return the rules
	 */
	public List<Condition> getRules() {
		return rules;
	}

	/**
	 * @param rules
	 *            the rules to set
	 */
	public void setRules(List<Condition> rules) {
		this.rules = rules;
	}

	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(String table) {
		this.table = table;
	}

	/**
	 * @param table
	 * @param rules
	 */
	public Parameter(String table, List<Condition> rules) {
		super();
		this.table = table;
		this.rules = rules;
	}

	public Parameter() {
	}

	public Parameter(String table) {
		this.table = table;
	}

	/**
	 * 逐个添加条件
	 * 
	 * @param model
	 */
	public Parameter addRule(Condition condition) {
		if (rules == null) {
			rules = new ArrayList<Condition>();
		}
		rules.add(condition);
		return this;
	}

	/**
	 * @param buildQuery
	 */
	public Parameter addRules(List<Condition> buildQuery) {
		if (rules == null) {
			rules = new ArrayList<Condition>();
		}
		rules.addAll(buildQuery);
		return this;
	}
}
