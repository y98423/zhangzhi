/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common.sql;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * 转换HashMap<String, Object>的javabean对象
 * 
 * @author lidinghui@star-net.cn
 * @version Id: MapBean.java, v 0.5 2014年9月2日 lidinghui
 */
public class MapBean extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3045202960463525189L;

	public MapBean() {
	}

	public MapBean(Object... args) {
		put(args);
	}

	/**
	 * 获取对象
	 * 
	 * @param key
	 *            键值
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public Object get(Object key, Object defaultValue) {
		Object ret = defaultValue;
		ret = get(key);
		return (ret == null) ? defaultValue : ret;
	}

	public int getInt(Object key) {
		return getInt(key, 0);
	}

	public int getInt(Object key, int defaultInt) {
		Object i = get(key);
		return i == null ? defaultInt : Integer.valueOf(i.toString());
	}

	public float getFloat(Object key) {
		return getFloat(key, 0);
	}

	public float getFloat(Object key, float defaultFloat) {
		Object i = get(key);
		return i == null ? defaultFloat : Float.valueOf(i.toString());
	}

	public double getDouble(Object key) {
		return getDouble(key, 0d);
	}

	public double getDouble(Object key, Double defaultInt) {
		Object i = get(key);
		return i == null ? defaultInt : Double.valueOf(i.toString());
	}

	public String getString(Object key) {
		Object i = get(key);
		return i == null ? null : i.toString();
	}

	public String getString(Object key, String defaultValue) {
		String value = getString(key);
		return value == null ? defaultValue : value;
	}

	public Timestamp getTimestamp(Object key) {
		Object i = get(key);
		return i == null ? null : (Timestamp) i;
	}

	public Date getDate(Object key) {
		Object i = get(key);
		return i == null ? null : (Date) i;
	}

	public Long getLong(Object key) {
		Object i = get(key);
		return i == null ? null : (Long) i;
	}

	public Long getLong(Object key, Long defaultValue) {
		Long value = getLong(key);
		return value == null ? defaultValue : value;
	}

	public Boolean getBoolean(Object key) {
		Object i = get(key);
		return i == null ? false : (Boolean) i;
	}

	public Boolean getBoolean(Object key, Boolean defaultValue) {
		Boolean value = getBoolean(key);
		return value == null ? defaultValue : value;
	}

	public void put(Object... args) {
		for (int i = 1; i < args.length; i += 2) {
			put(String.valueOf(args[i - 1]), args[i]);
		}
	}

	public JSONObject toJson() {
		return JSONObject.fromObject(this);
	}

	public String toJsonString() {
		return toJson().toString();
	}

	public HashMap<String, Object> get(String... keys) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int leng = keys.length;
		for (int i = 1; i < leng; i++) {
			map.put(keys[i], get(keys[i]));
		}
		return map;

	}

	public boolean isExist(Object key) {
		return get(key) != null ? true : false;
	}
}
