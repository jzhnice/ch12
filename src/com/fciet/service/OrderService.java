package com.fciet.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fciet.bean.Address;
import com.fciet.bean.Customer;
import com.fciet.bean.Goods;
import com.fciet.bean.Order;
import com.fciet.tools.DateTools;

/**
 * 	订单业务逻辑
 * @author merlin
 *
 */
public class OrderService {

	private Scanner sc;
	private Customer client;
	
	
	public static Map<String, Order> ORDERS = new HashMap<String, Order>();
	
	
	public OrderService(Scanner sc) {
		this.sc = sc;
	}
	
	/**
	 * 	为什么要把客户对象传递进来呢 ？
	 * @param sc
	 * @param c
	 */
	public OrderService(Scanner sc , Customer c ) {
		this.sc = sc;
		this.client = c;
	}
	
	
	public void menu() {
		System.out.println("1.查看所有订单");
		System.out.println("2.查看单个订单");
		System.out.println("3.下单");
		System.out.println("4.返回");
		
		String key = sc.next();
		
		switch( key ) {
		
		case "1":
			printAllOrderInfo();
			menu();
			break;
			
		case "2":
			System.out.print("请输入单号：");
			getOrderInfo( sc.next() );
			menu();
			break;
			
		case "3":
			placeOrder();
			menu();
			break;
		
		case "4":
		default:
			break;
		}
	}
	
	
	public void printAllOrderInfo() {
		for(Map.Entry<String, Order> o : ORDERS.entrySet()) {
			System.out.println( o.getValue() );
		}
	}
	
	
	private void getOrderInfo(String orderId) {
		System.out.println( ORDERS.get(orderId) );
	}
	
	/**
	 * 	下订单需要使用
	 * 	1. 商品信息
	 * 	2.客户信息（包含了联系电话）
	 * 	3.派送地址（在客户信息中获取到）
	 */
	private void placeOrder() {
		
		Order order = new Order();
		
		AddressService addressService = new AddressService( sc, client.getAddresses() );
		
		System.out.print("请输入要购买的商品编号：");
		Goods goods = GoodsService.GOODSMAP.get(sc.nextInt());
		
		if( null == goods) {
			System.out.println("没有找到这个商品信息");
			return;
		}
		
		order.setGoods( goods );
		
		Address address = null;
		if( client.getAddresses().size() == 0 ) {
			
			System.out.println("没有地址，请填写派送信息：");
			address =  addressService.save();
			
		} else {
			System.out.println("从下列地址中进行选择：");
			addressService.printAllAddress();
			System.out.print("请输入使用的地址编号：");
			address = addressService.get( sc.next() );
		}
		order.setAddress(address);
		order.setCreateDate( DateTools.getDateStringForFormat("yyyy-MM-dd HH:mm:ss"));
		
		ORDERS.put(order.getOrderId(), order);
		System.out.println("添加订单完成");
	}
	
}
