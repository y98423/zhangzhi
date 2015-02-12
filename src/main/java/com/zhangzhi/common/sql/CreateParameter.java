/**
a * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 新增记录封裝对象
 * 
 * @author lidinghui@star-net.cn
 * @version Id: CreateParameter.java, v 0.5 2014年8月31日 lidinghui
 */
public class CreateParameter {

	private String table;

	/**
	 * 待写入值的集合
	 */
	private List<FiledModel> models;

	public List<FiledModel> getModels() {
		return models;
	}

	public void setModels(List<FiledModel> models) {
		this.models = models;
	}

	/**
	 * 逐个添加要更新的对象
	 * 
	 * @param model
	 */
	public CreateParameter addModel(FiledModel model) {
		if (this.models == null) {
			this.models = new ArrayList<FiledModel>();
		}
		this.models.add(model);
		return this;
	}

	public CreateParameter() {
	}

	public CreateParameter(String table) {
		this.table = table;

	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

}
