package com.fciet.bean;

import com.fciet.tools.DateTools;

/**
 * 订单
 * 
 * @author merlin
 *
 */
public class Order {

	private String orderId;
	
	
	/**
	 * 	订单创建时间，使用当前的年月日小时分秒
	 */
	private String createDate;
	
	
	/**
	 * 	这个布尔变量用于判断是否已经发货，默认是 false
	 */
	private boolean flag = false;

	private Goods goods;

	private Address address;
	
	
	/**
	 * 	这里对变量直接赋值，使用变量的 set 方法可以么 ？
	 * 	2种方式有什么区别呢 ？
	 */
	public Order() {
		orderId = DateTools.getDateStringForFormat("yyyy-MM-dd-HH-mm-ss") ;
	}
	

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Goods getGoods() {
		return goods;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	@Override
	public String toString() {
		return "订单信 编号：" + orderId + getAddress() + ", 发货状态="+ flag +"]";
	}
	
	
}
