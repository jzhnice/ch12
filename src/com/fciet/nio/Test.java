package com.fciet.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {
	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");
		// 创建一个FileOutputStream流
		FileOutputStream outputStream = new FileOutputStream(file);
		//得到FileChannel对象
		FileChannel channel = outputStream.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 声明字符串
		String string = "java nio";
		buffer.put(string.getBytes());
		buffer.flip(); // 此处必须要调用buffer的flip方法
		channel.write(buffer);
		channel.close();
		outputStream.close();
	}
}
