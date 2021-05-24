package com.fciet.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 	客户 
 * @author merlin
 *
 */
public class Customer extends Person {

	private static final long serialVersionUID = 1L;
	private String customerId;
	private String phone;
	
	/**
	 * 	每个用户都拥有自己的地址集合，这里使用 Map 进行管理。
	 * 	使用 List 和Set 可以么 ？
	 */
	private Map<String, Address> addresses = new HashMap<String, Address>();
	
	/**
	 * 注意，这里的构造器和 Courier的少许区别，这里没有显式调用 super() 
	 * 父类对象会创建出来么？
	 */
	public Customer() {}
	
	
	public Customer(String customerId, String pwd) {
		super(pwd);
		this.customerId = customerId;
	}


	public Customer(String customerId,String name, String sex, Integer age , String phone,String pwd) {
		super(name,sex,age, pwd);
		this.customerId = customerId;
		this.phone = phone;
	}
	
	
	public static Customer builder() {
		return new Customer();
	}
	
	
	public Customer clientId(String customerId) {
		this.customerId = customerId;
		return this;
	}
	
	public Customer pwd(String pwd) {
		super.setPwd(pwd);
		return this;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Map<String, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<String, Address> addresses) {
		this.addresses = addresses;
	}


	/**
	 * 方法重写，但是需要注意的是这里通过 super 关键字调用了父类的方法
	 * 
	 * 注意，这里并没有循环 addresses
	 */
	@Override
	public String toString() {
		return "用户信息 [ 编号=" + customerId +" , 姓名="+ super.getName() +" , 性别="+ super.getSex()
			+ "  , 年龄="+ super.getAge() +" , 手机号码="+ phone +"]";
	}
	
	
}
