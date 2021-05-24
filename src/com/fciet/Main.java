package com.fciet;

import java.util.Scanner;

import com.fciet.service.GoodsService;
import com.fciet.service.LoginService;

/**
 * 	主程序，从这里开始运行程序
 * 
 * 	开始后可以进行：
 * 	1. 查看商品
 * 	2.用户登录和注册
 * 
 * @author merlin
 *
 */
public class Main {
	
	private Scanner sc = new Scanner(System.in);
	
	private LoginService loginService = null;
	private GoodsService goodsService = null;

	public Main() {}

	public void menu() {
		System.out.println("***************************");
		System.out.println("***\t欢迎使用购物系统 \t***");
		System.out.println("***************************");
		System.out.println("1. 用户注册");
		System.out.println("2. 登录系统");
		System.out.println("3. 商品查看");
		System.out.println("4. 退出系统");
		System.out.print("请输入：");
		String key = sc.next();

		/**
		 * 	这里除了 switch ，使用if可以么 ？使用 while 循环可以么？
		 * 	写法上有什么区别呢 ？
		 */
		switch (key) {
		case "1":
			loginService = new LoginService();
			loginService.register(sc);
			menu();
			break;
			
		case "2":
			loginService = new LoginService(sc);
			loginService.login();
			menu();
			break;
			
		case "3":
			
			goodsService = new GoodsService(sc);
			goodsService.menu();
			menu();
			break;

		/**
		 * 	输入4 或者是 1， 2， 3， 4 以外的内容，都默认是系统退出
		 */
		case "4":
		default:
			//	资源在不再使用的时候一定要进行释放
			sc.close();
			System.exit(0);
		}
	}

	/**
	 * main 方法，程序启动入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		new Main().menu();
	}
}
