package com.fciet.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TextNIO {
	public static void main(String[] args) {
//		writeFileByNIO();
		readFileByNIO();
	}

	/**
	 * 读取文件
	 */
	public static void readFileByNIO() {
		try {
			// 打开文件流
			FileInputStream fis = new FileInputStream("d:/nio.txt");
			// 打开通道
			FileChannel fc = fis.getChannel();
			// 新建缓冲区，并分配空间
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			// 将文件内容存入缓冲区
			fc.read(buffer);
			// 翻转缓冲区
			// 因为刚刚是将数据写入缓冲区，接下来我们要开始从缓冲区读取数据了，
			// 需要将容量设为刚刚写入的大小（limit=position），下一个指针操作位置设为0（position=0）
			// 如果不执行此操作，读取不到刚刚写入的缓冲区数据
			buffer.flip();
			StringBuffer sb = new StringBuffer();
			while (buffer.remaining() > 0) {
				byte b = buffer.get();
				sb.append((char) b);
			}
			System.out.println("读取：" + sb);
			fc.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写入文件
	 */
	public static void writeFileByNIO() {
		try {
			// 打开文件
			File file = new File("d:/nio.txt");
			// 打开文件写入流
			// 文件追加写入 new FileOutputStream(file,true);
			FileOutputStream fos = new FileOutputStream(file);
			// 打开通道
			FileChannel fc = fos.getChannel();
			// 创建缓冲器，并分配空间
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			String str = "Hello NIO";
			// 将字符写入缓冲器
			buffer.put(str.getBytes());
			// 翻转缓冲器
			buffer.flip();
			// 将缓冲器中的数据写入通道内，通道会将数据传输给文件流
			fc.write(buffer);
			fc.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
