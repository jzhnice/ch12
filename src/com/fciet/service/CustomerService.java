package com.fciet.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fciet.bean.Customer;
import com.fciet.dao.CustomerDao;

public class CustomerService {

	/**
	 * CustomerService
	 * 客户服务
	 * */

	/**
	 * 	存放所有用户信息的Map为什么要设置为静态的？
	 */
	public static Map<String, Customer> CLIENTDATA = new HashMap<String, Customer>();
	private static CustomerDao dao = new CustomerDao();

	static {
		CLIENTDATA = dao.query();
	}
	
	
	public static void readClient() {
		CLIENTDATA = dao.query();
	}
	
	public static void update(Customer client) {
		CLIENTDATA.put(client.getCustomerId() + client.getPwd() , client);
		dao.update(CLIENTDATA);
	}
	
	
	private Customer client;
	private Scanner sc ;
	
	
	public CustomerService(Scanner sc , Customer client) {
		this.sc = sc;
		this.client = client;
		readClient();
	}
	
	
	public void menu() {
		System.out.println("欢迎回来："+ client.getName() );
		System.out.println("------------------------");
		System.out.println("1. 查看商品");
		System.out.println("2. 订单管理");
		System.out.println("3. 地址管理");
		System.out.println("4. 注销");
		
		String key = sc.next();
		
		switch( key ) {
		case "1":
			new GoodsService(sc).menu();
			menu();
			break;
		case "2":
			new OrderService(sc , client).menu();
			menu();
			break;
		case "3":
			new AddressService(sc, client.getAddresses() ).menu();
			menu();
			break;
		case "4":
		default:
			break;
		}
	}
}
