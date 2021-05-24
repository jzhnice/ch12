package com.fciet.bean;

/**
 * 	快递员
 * @author merlin
 *
 */
public class Courier extends Person {

	private static final long serialVersionUID = 1L;
	
	private String courierId;
	
	
	/**
	 * 	这里显式调用了 super()，是调用了父类的什么方法？
	 */
	public Courier() {
		super();
	}
	
	public Courier(String courierId , String pwd) {
		super(pwd);
		this.courierId = courierId;
	}

	
	public Courier(String courierId,String name, String sex, Integer age , String pwd) {
		super(name,sex,age , pwd);
		this.courierId = courierId;
	}


	public String getCourierId() {
		return courierId;
	}


	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}


	/**
	 * 方法重写，但是需要注意的是这里通过 super 关键字调用了父类的方法
	 */
	@Override
	public String toString() {
		return "快递员信息 [编号=" + courierId +" , 姓名="+ super.getName() +" , 性别="+ super.getSex()
			+ "  , 年龄="+ super.getAge() +"]";
	}
	
	
	
	
}
