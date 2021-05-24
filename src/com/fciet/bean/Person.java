package com.fciet.bean;

import java.io.Serializable;

/**
 * Person在之后会有2个子类，这里就描述 Person的信息
 * @author merlin
 *
 */
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 私有属性
	 */
	private String name ;
	private String sex ;
	private Integer age;
	private String pwd;

	/**
	 * 	无参数构造器
	 */
	public Person() {}
	
	
	/**
	 * 	带参数构造器
	 * @param pwd
	 */
	public Person(String pwd) {
		super();
		this.pwd = pwd;
	}
	
	/**
	 * 	带参数构造器
	 * @param name
	 * @param sex
	 * @param age
	 * @param pwd
	 */
	public Person(String name, String sex, Integer age , String pwd) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.pwd = pwd;
	}
	


	/**
	 * 	每个私有属性的 set 和 get 方法
	 */
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 	方法重写
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
