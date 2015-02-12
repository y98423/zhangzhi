/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.dao.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.zhangzhi.common.sql.Condition;
import com.zhangzhi.common.sql.Convert;
import com.zhangzhi.common.sql.CreateParameter;
import com.zhangzhi.common.sql.Delparameter;
import com.zhangzhi.common.sql.FiledModel;
import com.zhangzhi.common.sql.MapBean;
import com.zhangzhi.common.sql.Operation;
import com.zhangzhi.common.sql.QueryParameter;
import com.zhangzhi.common.sql.UpOperation;
import com.zhangzhi.common.sql.UpdateModel;
import com.zhangzhi.common.sql.UpdateParameter;

/**
 * 
 * 
 * @author yangxiaobin@star-net.cn
 * @version Id: BaseDaoImpl.java, v 0.5 2014年7月28日 yangxiaobin
 */
@Component
public class BaseDaoImpl extends SimpleDaoSupport
		implements BaseDao{

	/**
	 * @return
	 * @Description:
	 */
	protected SimpleJdbcInsert getSimpleJdbcInsert(String identify) {
		return new SimpleJdbcInsert(this.getJdbcTemplate())
				.usingGeneratedKeyColumns(identify);
	}

	/**
	 * @return
	 * @Description:
	 */
	protected SimpleJdbcInsert getSimpleJdbcInsert() {
		return new SimpleJdbcInsert(this.getJdbcTemplate());
	}

	public int execute(String sql, Object[] args) {
		return this.getJdbcTemplate().update(sql, args);

	}

	public Map<String, Object> queryForMap(String sql, Object[] objs) {
		try {
			return this.getJdbcTemplate().queryForMap(sql, objs);
		} catch (Exception e) {
			logger.error("sql:" + sql + ",params：" + objs.toString());
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ktvme.common.dao.BaseDao#queryForMap(java.lang.String)
	 */
	@Override
	public Map<String, Object> queryForMap(String sql) {
		try {
			return this.getJdbcTemplate().queryForMap(sql);
		} catch (Exception e) {
			logger.error("sql:" + sql);
			return null;
		}
	}

	public int update(String sql) {
		return this.getJdbcTemplate().update(sql);
	}

	public int update(String sql, Object[] objs) {
		return this.getJdbcTemplate().update(sql, objs);
	}

	public Integer queryForInt(String sql) {
		try {
			return this.getJdbcTemplate().queryForInt(sql);
		} catch (Exception e) {
			logger.error("sql:" + sql);
			return 0;
		}

	}

	public Integer queryForInt(String sql, Object[] args) {
		try {
			return this.getJdbcTemplate().queryForInt(sql, args);
		} catch (Exception e) {
			logger.error("sql:" + sql + ",params：" + args.toString());
			return 0;
		}
	}

	public Long queryForLong(String sql) {
		return this.getJdbcTemplate().queryForLong(sql);
	}

	public Long queryForLong(String sql, Object[] args) {
		try {
			return this.getJdbcTemplate().queryForLong(sql, args);
		} catch (Exception e) {
			logger.error("sql:" + sql + ",params：" + args.toString());
			return 0L;
		}
	}

	public List<Map<String, Object>> queryForList(String sql, Object[] args) {
		return this.getJdbcTemplate().queryForList(sql, args);
	}


	public List<Map<String, Object>> queryForList(String sql,
			Map<String, ?> paramMap) {
		return this.getNamedParameterJdbcTemplate().queryForList(sql, paramMap);
	}

	public Long queryForLong(String sql, Map<String, ?> paramMap) {
		try {
			return this.getNamedParameterJdbcTemplate().queryForLong(sql,
					paramMap);
		} catch (Exception e) {
			logger.error("sql:" + sql + ",params：" + paramMap.toString());
			return 0L;
		}
	}


	public List<Map<String, Object>> queryForList(QueryParameter parameter) {
		String limit = Convert.getString(parameter.getLimit(), "");
		String table = Convert.getString(parameter.getTable(), "");
		String output = Convert.getString(parameter.getOutput(), " * ");
		String order = Convert.getString(parameter.getOrder(), "");
		return select(table, output, parameter.getRules(), order + " " + limit);
	}

	/**
	 * 组合查询
	 * 
	 * @param table
	 * @param output
	 * @param rules
	 * @param order
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> select(String table, String result,
			List<Condition> rules, String order) {
		result = Convert.getString(result, " * ");
		order = Convert.getString(order, " ");
		Object[] bRuleAndParams = buildRulesAndParams(rules);
		String rule = bRuleAndParams[0].toString();
		Map<String, Object> params = (Map<String, Object>) bRuleAndParams[1];
		StringBuffer sql = new StringBuffer("");
		if (rule.length() > 0) {
			sql.append("select ").append(result).append(" from ").append(table);
			sql.append(" where ").append(rule).append(" ").append(order);
		} else {
			sql.append("select ").append(result).append(" from ").append(table)
					.append(" ").append(order);
		}
		try {
			return this.queryForList(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}


	public Map<String, Object> queryForFirstMap(QueryParameter parameter) {
		List<Map<String, Object>> list = this.queryForList(parameter);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Integer queryForInt(QueryParameter parameter) {
		List<Map<String, Object>> list = queryForList(parameter);
		if (list.size() > 0) {
			return Integer.parseInt(list.get(0).get(parameter.getOutput())
					.toString());
		} else {
			return null;
		}
	}

	@Override
	public String queryForString(QueryParameter parameter) {
		List<Map<String, Object>> list = queryForList(parameter);
		if (list.size() > 0) {
			return (String) list.get(0).get(parameter.getOutput());
		} else {
			return null;
		}
	}

	@Override
	public Long queryForLong(QueryParameter parameter) {
		List<Map<String, Object>> list = queryForList(parameter);
		if (list.size() > 0) {
			return (Long) list.get(0).get(parameter.getOutput());
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public int update(UpdateParameter parameter) {
		if (parameter.getTable() == null || parameter.getModels() == null
				|| parameter.getRules() == null
				|| parameter.getRules().size() == 0
				|| parameter.getModels().size() == 0) {
			return 0;
		}
		StringBuffer sql = new StringBuffer("");
		String table = parameter.getTable();
		// 创建规则语句
		Object[] bRuleAndParams = buildRulesAndParams(parameter.getRules());
		String rule = bRuleAndParams[0].toString();
		Map<String, Object> params = (Map<String, Object>) bRuleAndParams[1];
		// 创建要更新的语句
		String sets = buildKeySet(parameter.getModels(), params);
		sql.append("update  ").append(table).append(" set ")
				.append(sets.toString()).append(" ");
		if (rule.length() > 0) {
			sql.append(" where ").append(rule.toString()).append(" ");
		}
		try {
			return this.getNamedParameterJdbcTemplate().update(sql.toString(),
					params);
		} catch (DataAccessException e) {
			logger.info("更新表[" + table + "]数据失败,异常= " + e);
			return -1;
		}

	}

	/**
	 * 创建要更新的语句
	 * 
	 * @param models
	 * @return
	 */
	private String buildKeySet(List<UpdateModel> models,
			Map<String, Object> params) {
		StringBuffer set = new StringBuffer(" ");
		if (models != null && models.size() > 0) {
			int num = 0;
			for (UpdateModel cd : models) {
				if (UpOperation.key != cd.getOperation()) {
					set.append(cd.getKey())
							.append(cd.getOperation().getValue());
					set.append(":ukey_" + num);
					params.put("ukey_" + num, cd.getValue());
				} else {
					set.append(cd.getValue());
				}
				if (num < models.size() - 1) {
					set.append(", ");
				}
				num++;
			}
		}
		return set.toString();
	}

	@SuppressWarnings("unchecked")
	public int delete(Delparameter parameter) {
		if (parameter.getTable() == null || parameter.getRules() == null
				|| parameter.getRules().size() == 0) {
			return 0;
		}
		StringBuffer sql = new StringBuffer("");
		String table = parameter.getTable();
		// 创建规则语句
		Object[] bRuleAndParams = buildRulesAndParams(parameter.getRules());
		String rule = bRuleAndParams[0].toString();
		Map<String, Object> params = (Map<String, Object>) bRuleAndParams[1];
		sql.append("delete  from  ").append(table).append("  ");
		if (rule.length() > 0) {
			sql.append(" where ").append(rule.toString()).append(" ");
		}
		try {
			return this.getNamedParameterJdbcTemplate().update(sql.toString(),
					params);
		} catch (DataAccessException e) {
			logger.info("刪除表[" + table + "]数据失败,异常= " + e);
			return -1;
		}
	}

	/**
	 * 创建规则语句
	 * 
	 * @param models
	 * @return
	 */
	private Object[] buildRulesAndParams(List<Condition> rules) {

		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer rule = new StringBuffer("");
		if (rules != null && rules.size() > 0) {
			int num = 0;
			for (Condition cd : rules) {
				if (Operation.key != cd.getOperation()) {
					if (Operation.in != cd.getOperation()) {
						rule.append(" ").append(cd.getKey())
								.append(cd.getOperation().getValue());
						rule.append(":key_" + num);
						params.put("key_" + num, cd.getValue());
					} else {
						rule.append(" ").append(cd.getKey()).append(" ");
						rule.append(cd.getOperation().getValue());
						rule.append(" (");
						String v = cd.getValue().toString();
						String[] obj = StringUtils.split(v, ",");
						if (obj.length > 0) {
							for (int i = 0, len = obj.length; i < len; i++) {
								String nv = obj[i];
								if (i < len - 1) {
									rule.append(":key_" + num + "_" + i + ",");
								} else {
									rule.append(":key_" + num + "_" + i + "");
								}
								params.put("key_" + num + "_" + i, nv);
							}
						}
						rule.append(")");
						// params.put("key_" + num, cd.getValue());
					}
				} else {
					rule.append(" ").append(cd.getValue());
				}
				if (num < rules.size() - 1) {
					rule.append(" and ");
				}
				num++;
			}
		}
		return new Object[] { rule.toString(), params };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ktvme.common.dao.BaseDao#queryForList(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> queryForList(String sql) {
		return this.getJdbcTemplate().queryForList(sql);
	}

	public int insert(CreateParameter parameter) {
		if (parameter.getTable() == null || parameter.getModels() == null
				|| parameter.getModels().size() == 0) {
			return 0;
		}
		StringBuffer sql = new StringBuffer("");
		String table = parameter.getTable();
		Map<String, Object> params = new HashMap<String, Object>();
		// 创建要写入的语句
		String[] sets = buildInsertParams(parameter.getModels(), params);
		sql.append("insert  into ").append(table).append("(");
		sql.append(sets[0]).append(")").append("  values(");
		sql.append(sets[1]).append(")");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				params);
		try {
			int retNum = this.getNamedParameterJdbcTemplate().update(
					sql.toString(), sqlParameterSource, keyHolder);
			if (keyHolder.getKey() != null) {
				return keyHolder.getKey().intValue();
			} else {
				return retNum;
			}

		} catch (DataAccessException e) {
			logger.info("写入表[" + table + "]数据失败,异常= " + e);
			return -1;
		}

	}

	/**
	 * 拼接insert语句
	 * 
	 * @param models
	 * @param params
	 * @return
	 */
	private String[] buildInsertParams(List<FiledModel> models,
			Map<String, Object> params) {
		StringBuffer filed = new StringBuffer("");
		StringBuffer val = new StringBuffer("");
		if (models != null && models.size() > 0) {
			int num = 0;
			for (FiledModel cd : models) {
				filed.append(cd.getKey());
				val.append(":ukey_" + num);
				params.put("ukey_" + num, cd.getValue());
				if (num < models.size() - 1) {
					filed.append(",");
					val.append(", ");
				}
				num++;
			}
		}
		return new String[] { filed.toString(), val.toString() };
	}

	public MapBean query2FirstMapbean(QueryParameter parameter) {

		Map<String, Object> map = this.queryForFirstMap(parameter);
		if (map != null) {
			MapBean bean = new MapBean();
			bean.putAll(map);
			return bean;
		} else {
			return null;
		}
	}

	public List<MapBean> query2ListMapbean(QueryParameter parameter) {

		List<Map<String, Object>> list = this.queryForList(parameter);

		if (list != null) {
			List<MapBean> listBean = new ArrayList<MapBean>();
			for (Map<String, Object> map : list) {
				MapBean bean = new MapBean();
				bean.putAll(map);
				listBean.add(bean);
			}
			return listBean;

		} else {
			return null;
		}

	}

	@Override
	public int[] updateBatch(String sql) {
		return null;
	}

}
