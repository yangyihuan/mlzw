package org.mlzw.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean{
	
	private String personName;
	
	private String address;
	
	private Integer sex;
	
	private BeanFactory beanFactory;
	
	private String beanName;

	public Person() {
		System.out.println("【构造器】调用Person的构造器实例化");
	}
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("设置beanFactory" + beanFactory);
		this.beanFactory = beanFactory;
	}
	
	public void setBeanName(String name) {
		System.out.println("设置beanName" + name);
		this.beanName = name;
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
	}
	
	public void destroy() throws Exception {
		System.out.println("bean is detroy");
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		System.out.println("设置姓名");
		this.personName = personName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("设置地址");
		this.address = address;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		System.out.println("设置性别");
		this.sex = sex;
	}
	
	
	
	
}
