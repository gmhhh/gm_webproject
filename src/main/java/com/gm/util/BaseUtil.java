package com.gm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 * @Description: 基础工具类
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
public class BaseUtil {
	
	/**
	 *	获取当前系统时间 
	 */
	public static String getSystemDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	/**
	 * 生成表ID
	 */
	public static final String getTableId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
