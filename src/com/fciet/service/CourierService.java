package com.fciet.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fciet.bean.Courier;
import com.fciet.bean.Order;

/**
 * 	快递员主要是做订单获取，送快递2件事情
 * 	
 * 
 * 	快递员并不需要注册，所以在类中直接初始化N个快递员对象就可以了
 * 
 * @author merlin
 *
 */
public class CourierService {

	/**
	 * 	保存数据的 Map使用的是一个静态对象，可以设计为非静态么 ？ 为什么？
	 */
	public static Map<String, Courier> COURIERDATA = new HashMap<String, Courier>();
	
	
	/**
	 * 	在静态代码块中进行数据的初始化
	 * 	1. 可以使用非静态代码块么？
	 * 	2. 可以在创建对象在构造器中对数据初始化么？
	 * 	3. 以上2种方案和静态相比有什么不同 ？
	 */
	static {
		COURIERDATA.put("101", new Courier("101" , "张三" , "男" , 33 , "111"));
		COURIERDATA.put("102", new Courier("102" , "八云" , "男" , 22 , "222"));
	}

	private Scanner sc;
	
	private OrderService orderService = new OrderService(sc);
	
	public CourierService(Scanner sc) {
		this.sc = sc;
		menu();
	}
	
	public void menu() {
		System.out.println("1. 查看所有用户的订单");
		System.out.println("2. 接单派送");
		System.out.println("3. 退出系统");
		
		String key = sc.next();
		
		switch( key ) {
		case "1":
			orderService.printAllOrderInfo();
			break;
			
		case "2":
			shipments();
			break;
			
		case "3":
		default:
			break;
		}
	}
	
	
	public void shipments() {
		System.out.println("请输入订单号：");
		Order order = OrderService.ORDERS.get( sc.next() );
		order.setFlag(true);
		System.out.println("订单："+ order.getOrderId() + " 派送中....");
	}
	
}
