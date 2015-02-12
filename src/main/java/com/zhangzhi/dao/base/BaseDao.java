/**

 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.dao.base;

import java.util.List;
import java.util.Map;

import com.zhangzhi.common.sql.CreateParameter;
import com.zhangzhi.common.sql.Delparameter;
import com.zhangzhi.common.sql.MapBean;
import com.zhangzhi.common.sql.QueryParameter;
import com.zhangzhi.common.sql.UpdateParameter;

public interface BaseDao {

	/**
	 * 根据sql更新记录
	 * 
	 * @param sql
	 * @return
	 */
	public int update(String sql);

	public int[] updateBatch(String sql);

	/**
	 * 根据sql更新记录
	 * 
	 * @param sql
	 * @param objs
	 * @return
	 */
	public int update(String sql, Object[] objs);

	public Map<String, Object> queryForMap(String sql, Object[] objs);

	public Map<String, Object> queryForMap(String sql);

	/**
	 * sql执行
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public int execute(String sql, Object[] args);

	/**
	 * 查询返回int
	 * 
	 * @param sql
	 * @return
	 */
	public Integer queryForInt(String sql);

	/**
	 * 查询返回int
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public Integer queryForInt(String sql, Object[] args);

	/**
	 * 查询返回long
	 * 
	 * @param sql
	 * @return
	 */
	public Long queryForLong(String sql);

	/**
	 * 查询返回long
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public Long queryForLong(String sql, Object[] args);

	/**
	 * 查询列表
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql, Object[] args);

	public List<Map<String, Object>> queryForList(String sql);

	/**
	 * 查询返回数据类型,支持命名参数，而不是传统的使用'？'占位符
	 * 
	 * 例:sql:select a from table where a=:b,paramMap.put("b","1");
	 * 
	 * @param sql
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql,
			Map<String, ?> paramMap);

	/**
	 * 查询返回数据,支持命名参数
	 * 
	 * @param sql
	 * @param paramMap
	 * @return
	 */
	public Long queryForLong(String sql, Map<String, ?> paramMap);

	/**
	 * 组合条件查询
	 * 
	 * @param parameter
	 * @return
	 */
	public List<Map<String, Object>> queryForList(QueryParameter parameter);

	/**
	 * 获取第一条数据
	 * 
	 * @param parameter
	 * @return
	 */
	public Map<String, Object> queryForFirstMap(QueryParameter parameter);

	public Integer queryForInt(QueryParameter parameter);

	public String queryForString(QueryParameter parameter);

	public Long queryForLong(QueryParameter parameter);

	/**
	 * 更新对象
	 * 
	 * @param parameter
	 * @return
	 */
	public int update(UpdateParameter parameter);

	/**
	 * 更新对象
	 * 
	 * @param parameter
	 * @return
	 */
	public int delete(Delparameter parameter);

	/**
	 * 写入对象
	 * 
	 * @param parameter
	 * @return
	 */
	public int insert(CreateParameter parameter);

	/**
	 * 查询返回一个mapbean实体
	 * 
	 * @param parameter
	 * @return
	 */
	public MapBean query2FirstMapbean(QueryParameter parameter);

	/**
	 * 查询返回一个mapbean列表
	 * 
	 * @param parameter
	 * @return
	 */
	public List<MapBean> query2ListMapbean(QueryParameter parameter);

}
