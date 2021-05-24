package com.fciet.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 	日期和时间的工具类
 * @author merlin
 *
 */
public class DateTools {

	private static SimpleDateFormat sdf = new SimpleDateFormat();
	
	
	/**
	 * 将系统时间格式化为指定格式的字符串
	 * @param format
	 * @return
	 */
	public static String getDateStringForFormat(String pattern) {
		sdf.applyPattern(pattern);
		return sdf.format( new Date() );
	}
	
	
	public static void main(String[] args) {
		String strimmg = DateTools.getDateStringForFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println( strimmg );
		
		System.out.println( DateTools.getDateStringForFormat("yyyy-MM-dd-HH-mm-ss") );
	}
}
