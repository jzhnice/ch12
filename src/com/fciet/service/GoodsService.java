package com.fciet.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fciet.bean.Goods;

/**
 * 	商品业务逻辑
 * @author merlin
 *
 */
public class GoodsService {

	private Scanner sc ;
	
	/**
	 * 	保存数据的 Map使用的是一个静态对象，可以设计为非静态么 ？ 为什么？
	 */
	public static Map<Integer, Goods> GOODSMAP = new HashMap<Integer, Goods>();
	
	/**
	 * 	在静态代码块中进行数据的初始化
	 * 	1. 可以使用非静态代码块么？
	 * 	2. 可以在创建对象在构造器中对数据初始化么？
	 * 	3. 以上2种方案和静态相比有什么不同 ？
	 */
	static {
		GOODSMAP.put(1001, new Goods(1001, "iPad", 9999 ));
		GOODSMAP.put(1002, new Goods(1002, "matePad", 4999 ));
		GOODSMAP.put(1003, new Goods(1003, "iPhone", 8333 ));
	}
	
	
	public GoodsService(Scanner sc) {
		this.sc = sc;
	}

	
	/**
	 * 	商品菜单调用
	 */
	public void menu() {
		System.out.println("1. 查看所有商品");
		System.out.println("2. 查看单个商品");
		System.out.println("3. 返回");
		System.out.print("请输入选择：");
		
		String key = sc.next();

		switch( key ) {
			
		case "1":
			printAllGoods();
			menu();
			break;
			
		case "2":
			System.out.print("请输入商品的编号：");
			Goods g = get( sc.nextInt() );
			System.out.println("商品信息："+ g);
			menu();
			break;
			
		case "3":
		default:
			break;
		}
	}

	
	/**
	 * 	获取商品信息
	 * @param 商品ID
	 * @return
	 */
	public Goods get(Integer goodsId) {
		return GOODSMAP.get(goodsId);
	}
	
	
	/**
	 * 	查看所有的商品信息
	 */
	public void printAllGoods() {
		for (Map.Entry<Integer, Goods> g : GOODSMAP.entrySet()) {
			System.out.println("商品:"+ g.getKey() + "，商品信息 "+ g.getValue());
		}
	}
	
	
}
