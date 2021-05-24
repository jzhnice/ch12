package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.fciet.bean.Address;
import com.fciet.bean.Customer;

public class Test01 {

	public static void main(String[] args) throws IOException {
		
		Customer zs = new Customer("C0001","张三","男",22,"13512345678","123");
		Address address1 = new Address("李四", "王府大街001", "1234567899876");
		zs.getAddresses().put(address1.getAddressId() , address1);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clients.txt"));
		oos.writeObject(zs);
		oos.flush();
		oos.close();
	
		Customer client = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clients.txt"))) {
		    client = (Customer) ois.readObject();
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}

		System.out.println("客户信息"+ client );
		System.out.println("收获地址："+ client.getAddresses());
	}
}
