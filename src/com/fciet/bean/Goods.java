package com.fciet.bean;

/**
 * 	商品
 * @author merlin
 *
 */
public class Goods {

	/**
	 * 商品的编号
	 */
	private Integer goodsId;
	
	/**
	 * 	商品的名称
	 */
	private String goodsName;
	
	/**
	 * 	商品出售的价格
	 */
	private double price;
	
	/**
	 * 	购买的商品的总量
	 * 	实际开发中是不可能在商品类里面进行设计的
	 */
	private Integer count;
	
	
	/**
	 * 	没有使用 extends继承父类，那么这里的super是调用谁的方法呢?
	 */
	public Goods() {
		super();
	}
	

	public Goods(Integer goodsId, String goodsName, double price ) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
	}




	public Integer getGoodsId() {
		return goodsId;
	}


	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}


	public String getGoodsName() {
		return goodsName;
	}


	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "商品信息 [编号=" + goodsId + ", 商品名称=" + goodsName + ", 价格=" + price +  "]";
	}
	
}
