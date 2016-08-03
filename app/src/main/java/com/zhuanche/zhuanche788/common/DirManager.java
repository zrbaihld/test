package com.zhuanche.zhuanche788.common;


import com.zhuanche.zhuanche788.utils.FileUtils;
import com.zhuanche.zhuanche788.utils.SdCardUtils;

/**
 * 项目目录管理
 * 
 * @author Administrator
 * 
 */
public class DirManager {
	public static String appRoot = "/dishan/";
	public static String cache = "cache/";
	public static String data = "data/";
	public static String log = "log/";
	public static String imageCache = "cache/image/";

	/**
	 * 程序更路�?
	 * 
	 * @return
	 */
	public static String getAppRoot() {
		return SdCardUtils.getSdCardRoot() + appRoot;
	}

	/**
	 * 缓存路径
	 * 
	 * @return
	 */
	public static String getCachePath() {
		return getAppRoot() + cache;
	}

	/**
	 * 数据路径
	 * 
	 * @return
	 */
	public static String getDataPath() {
		return getAppRoot() + data;
	}

	/**
	 * 日志路径
	 * 
	 * @return
	 */
	public static String getLogPath() {
		return getAppRoot() + log;
	}

	public static String getImageCache() {
		return getAppRoot() + imageCache;
	}

	/**
	 * 创建app�?�?的的目录
	 */
	public static void createAppDirs() {
		FileUtils.makeDirs(getAppRoot());
		FileUtils.makeDirs(getCachePath());
		FileUtils.makeDirs(getDataPath());
		FileUtils.makeDirs(getLogPath());
		FileUtils.makeDirs(getImageCache());
	}
}
