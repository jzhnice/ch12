package com.fciet.service;

import java.util.Scanner;

import com.fciet.bean.Customer;
import com.fciet.bean.Courier;

/**
 * 	登录管理的业务逻辑
 * @author merlin
 *
 */
public class LoginService {

//	LogisService
//
//			后勤服务

	private Scanner sc = null;
	
	public LoginService() {}
	
	public LoginService(Scanner sc) {
		this.sc = sc;
	}
	
	/**
	 *  	用户登录
	 */
	public void login() {
		
		System.out.println("请输入用户编号：");
		String id = sc.next();
		
		System.out.println("请输入用户的密码");
		String pwd = sc.next();
		
		System.out.println("选择角色（1：用户\t2：快递员）");
		String role = sc.next();
	
		
		if( "1".equals(role) ) {
			invokeClientService( id + pwd );
			
		//	快递员
		} else {
			invokeCourierService( id );
		}
	}


	/**
	 * 	用户注册
	 */
	public void register(Scanner sc) {

		System.out.println("请输入用户编号：");
		String clientId = sc.next();
		System.out.println("请输入用户的密码");
		String pwd = sc.next();
		System.out.println("请输入用户名");
		String name = sc.next();
		System.out.println("请输入年龄：");
		Integer age = sc.nextInt();
		System.out.println("请输入性别：");
		String sex = sc.next();
		System.out.println("请输入手机号码：");
		String phone = sc.next();
		
		String key = clientId + pwd;
		
		Customer client = CustomerService.CLIENTDATA.get( key );
		
		if( null != client ) {
			System.out.println("用户已经存在，请重新输入");
			client = null;
			register(sc);
			
		} else {
			client = Customer.builder().clientId(clientId).pwd(pwd);
			client.setName(name);
			client.setAge(age);
			client.setPhone(phone);
			client.setSex(sex);
			CustomerService.update( client);
		}
	}


	public void invokeClientService(String key ) {
		
		Customer client = CustomerService.CLIENTDATA.get( key );
		
		if( null == client ) {
			System.out.println("没有这个用户");
			return ;
		} 
		
		new CustomerService( sc , client).menu();
	}

	
	public void invokeCourierService(String key ) {
		
		
		Courier courier = CourierService.COURIERDATA.get(key);
		
		if( null == courier) {
			System.out.println( "没有这个快递员");
			return ;
		}
		
		new CourierService(sc).menu();
		
	}
	
	
}



