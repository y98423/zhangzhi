/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * 更新封装对象
 * 
 * @author lidinghui@star-net.cn
 * @version Id: UpdateParameter.java, v 0.5 2014年8月20日 lidinghui
 */
public class UpdateParameter extends Parameter {

	/**
	 * 待更新值的集合
	 */
	private List<UpdateModel> models;

	/**
	 * @return the models
	 */
	public List<UpdateModel> getModels() {
		return models;
	}

	/**
	 * @param models
	 *            the models to set
	 */
	public void setModels(List<UpdateModel> models) {
		this.models = models;
	}

	/**
	 * @param table
	 * @param rules
	 * @param model
	 */
	public UpdateParameter(String table, List<Condition> rules,
			List<UpdateModel> models) {
		super(table, rules);
		this.models = models;
	}

	public UpdateParameter() {
	}

	public UpdateParameter(String table) {
		super(table);
	}

	/**
	 * 逐个添加要更新的对象
	 * 
	 * @param model
	 */
	public UpdateParameter addModel(UpdateModel model) {
		if (models == null) {
			models = new ArrayList<UpdateModel>();
		}
		models.add(model);
		return this;
	}

}
