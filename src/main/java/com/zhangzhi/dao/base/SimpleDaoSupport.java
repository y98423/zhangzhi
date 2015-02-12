/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.dao.base;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
/**
 * 
 * 继承SimpleJdbcDaoSupport类，实现初始化的注入方式 目的是所有的继承SimpleDaoSupport类的方法，不需要注入数据源
 * 皆采用注解的方式进行配置，不需要在xml中再进行手动注入。
 * 
 * @Resource 进行注入，或采用名字的方式都可以，本程序用的是name名字的方式
 * @Resource(name = "unitTestDB")
 * @author yangxiaobin@star-net.cn
 * @version Id: SimpleDaoSupport.java, v 0.5 2014年7月28日 yangxiaobin
 * 
 */
public class SimpleDaoSupport extends NamedParameterJdbcDaoSupport {

	@Resource
	protected void inject(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
