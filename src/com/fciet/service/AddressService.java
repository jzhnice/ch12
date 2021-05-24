package com.fciet.service;

import java.util.Map;
import java.util.Scanner;

import com.fciet.bean.Address;
import com.fciet.dao.AddressDao;

/**
 * 	地址管理的业务逻辑
 * 	
 * 	在没有数据库的情况下， 使用 Map 进行地址对象的管理
 * 
 * @author merlin
 *
 */
public class AddressService {

	private Scanner sc;
	
	private Map<String, Address> addressData = null;
	
	private AddressDao dao = new AddressDao();
	
	
	/**
	 * 	为什么传入 addressData ？ 
	 * 
	 * 	在当前类中直接对所有用户的地址进行管理可以么？
	 * 		|--- 如果没有问题，怎么判断地址是哪个用户的 ？
	 * 	
	 * @param sc
	 * @param addressData
	 */
	public AddressService(Scanner sc , Map<String, Address> addressData) {
		this.sc = sc;
		this.addressData = addressData;
		
		if( null == addressData ) {
			addressData = dao.query();
		}
	}
	
	public void menu() {
		System.out.println("1. 查看现有地址");
		System.out.println("2. 添加新的地址");
		System.out.println("3. 修改原来的地址");
		System.out.println("4. 删除地址");
		System.out.println("5. 返回");
		
		String key = sc.next();
		
		switch( key ) {
		case "1":
			printAllAddress();
			menu();
			break;
			
		case "2":
			save();
			menu();
			break;
			
		case "3":
			update();
			menu();
			break;
			
		case "4":
			System.out.print("请输入要删除的地址编号：");
			delete(sc.next());
			menu();
			break;
			
		case "5":	
		default: 
			break;
		}
	}
	
	
	public Address save() {
		
		Address newAddress = new Address();
		System.out.println("请输入收货人姓名：");
		newAddress.setConsigneeName(sc.next());
		System.out.println("请输入收货地址：");
		newAddress.setLoc(sc.next());
		System.out.println("请输入收货人的手机号码：");
		newAddress.setPhone( sc.next() );
		addressData.put( newAddress.getAddressId(), newAddress);
		dao.update(addressData);
		return newAddress;
	}
	
	public void update() {
		
		System.out.print("请输入要修改的地址编号：");
		Address address = get(sc.next());
		
		if( null == address) {
			System.out.println("没有这个地址");
			return;
		}
		
		System.out.println("请输入新的收件人姓名：");
		address.setConsigneeName(sc.next());
		System.out.println("请输入新的收获地址：");
		address.setLoc(sc.next());
		System.out.println("请输入新的手机号码：");
		address.setPhone( sc.next() );
		addressData.put(address.getAddressId() , address);
		dao.update(addressData);
		
		System.out.println("地址修改后："+ address);
	}
	
	public void delete(String addressId) {
		addressData.remove(addressId);
		dao.update(addressData);
	}
	
	public Address get(String addressId) {
		return addressData.get(addressId);
	}
	
	
	public void printAllAddress() {
		System.out.println("现有地址：");
		for( Map.Entry<String, Address> entry : addressData.entrySet() ) {
			System.out.println( entry.getValue() );
		}
	}
}
