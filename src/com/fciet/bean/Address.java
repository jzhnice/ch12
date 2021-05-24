package com.fciet.bean;

import java.io.Serializable;

import com.fciet.tools.DateTools;

/**
 * 	配送地址
 * @author merlin
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private String addressId;
	
	/**
	 * 	收货人联系电话，和客户的电话未必是同一个人
	 */
	private String phone;
	
	/**
	 * 	收货人/收件人姓名
	 */
	private String consigneeName;
	
	
	/**
	 * 	地址
	 */
	private String loc;
	
	public Address() {
		setAddressId( DateTools.getDateStringForFormat("yyyyMMddHHmmss") );
	}


	/**
	 * 	这个构造器第一行 this() 是调用什么方法了 ？ 
	 * 	这样做有什么用 ？
	 * 
	 * @param consigneeName
	 * @param loc
	 */
	public Address(String consigneeName, String loc , String phone) {
		this();
		this.consigneeName = consigneeName;
		this.loc = loc;
		this.phone = phone;
	}


	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}


	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "收件人地址 [编号="+ addressId +", 收件人姓名=" + consigneeName + ", 地址="+ loc + ", 联系电话="+ phone + "]";
	}
	
}
