/**
 * ktvme.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.zhangzhi.common;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * spring 工具类
 * 
 * @author lidinghui@star-net.cn
 * @version Id: SpringContextUtil.java, v 0.5 2014年7月15日 lidinghui
 */
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	public static Object getBean(String name, Class<?> requiredType)
			throws BeansException {
		return applicationContext.getBean(name, requiredType);
	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.isSingleton(name);
	}

	public static Class<?> getType(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getType(name);
	}

	public static Object getBeanByClazz(Class<?> clazz)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getBean(clazz);
	}

	public static String[] getAliases(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getAliases(name);
	}

	public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> clazz){
		return applicationContext.getBeansWithAnnotation(clazz);
	}
	
	
}
