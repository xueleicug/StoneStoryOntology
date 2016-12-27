package com.util;

public class PathUtil {
	
	private static final String fileSperator = System.getProperty("file.separator");
	
	/**
	 * 获取平台无关的文件路径
	 * @param path	windows或linux格式的路径
	 * @return 当前平台下的路径
	 * String
	 */
	public static String getPath(String path) {
		String p = path.replace("\\", fileSperator).replace("/", fileSperator);
		return p;
	}
}
