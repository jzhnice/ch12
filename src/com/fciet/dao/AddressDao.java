package com.fciet.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.fciet.bean.Address;

public class AddressDao {

	/**
	 * 地址储存的的文件，没有写完整路径。那么文件将在项目的根路径进行查询
	 */
	private File addressFile = new File("address.txt");

	
	/**
	 * 	读取数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Address> query() {

		Map<String, Address> data = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(addressFile))) {

			data = (Map<String, Address>) ois.readObject();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return data;
	}

	public  void update(Map<String, Address> data) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(addressFile, false))) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
