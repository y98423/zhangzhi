package com.zhangzhi.common.sql;

public class Convert {

	public static String ToString(Object object) {
		return ((object == null) ? "" : object.toString());
	}

	public static Integer ToInteger(Object object) {
		return ((object == null) ? 0 : Integer.parseInt(object.toString()));
	}

	public static Integer ToInteger(String string) {
		try {
			return (Integer.parseInt(string));
		} catch (Exception e) {
			return 0;
		}
	}

	public static String getString(Object object, String defVal) {
		if (defVal == null) {
			defVal = "";
		}
		return ((object == null) ? defVal : object.toString());
	}

	public static Integer getInteger(Object object, Integer defVal) {
		if (defVal == null) {
			defVal = 0;
		}
		return ((object == null) ? defVal : Integer.parseInt(object.toString()));
	}

}
