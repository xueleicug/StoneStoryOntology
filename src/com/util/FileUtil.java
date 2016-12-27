package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author xuelei xueleicug@163.com
 * @time   2016年12月5日 下午5:30:26
 **/
public class FileUtil {
	
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("fileLogger");
	/**
	 * 获取文件字节输入流
	 * @param fileName	文件名称
	 * @return	文件字节输入流
	 * InputStream
	 */
	public static InputStream getInputStreamByFile(String fileName) {
		InputStream in = null;
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				logger.info("文件\"" + fileName + "\"不存在");
				return null;
			}
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	/**
	 * 获取文件字节输出流对象
	 * @param fileName	文件名称
	 * @return 文件字节输出流
	 * OutputStream
	 */
	public static OutputStream getOutputStream(String fileName) {
		OutputStream out = null;
		try {
			File file = new File(fileName);
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return out;
	}
	
	/**
	 * 获取文件字符输入流对象
	 * @param fileName 文件名称
	 * @return 文件字符输入流
	 * InputStreamReader
	 */
	public static Reader getInputStreamReader(String fileName) {
		Reader inReader = null;
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				logger.info("文件\"" + fileName + "\"不存在");
				return null;
			}
			inReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return inReader;
	}
	
	/**
	 * 获取文件字符输出流
	 * @param fileName 文件名称
	 * @return 文件字符输出流
	 * Writer
	 */
	public static Writer getOutputStreamWriter(String fileName) {
		Writer outWriter = null;
		try {
			File file = new File(fileName);
			outWriter = new FileWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outWriter;
	}
	
	/**
	 * 获取BufferedReader缓冲对象
	 * @param in 文件输入流
	 * @return BufferedReader缓冲对象
	 * BufferedReader
	 */
	public static BufferedReader getBufferedReader(InputStream in) {
		BufferedReader br = null;
		if (in != null) {
			br = new BufferedReader(new InputStreamReader(in));
		}
		return br;
	}
	
	/**
	 * 获取BufferedReader缓冲对象
	 * @param reader 文件字符输入流
	 * @return BufferedReader缓冲对象
	 * BufferedReader
	 */
	public static BufferedReader getBufferedReader(Reader reader) {
		BufferedReader br = null;
		if (reader != null) {
			br = new BufferedReader(reader);
		}
		return br;
	}
	
	/**
	 * 关闭BufferedReader缓冲对象
	 * @param br BufferedReader缓冲对象
	 * void
	 */
	public static void closeBufferedReader(BufferedReader br) {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭文件输入流
	 * @param in 输入流对象
	 * void
	 */
	public static void closeInputStream(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭文件输出流
	 * @param out 输出流对象
	 * void
	 */
	public static void closeOutputStream(OutputStream out) {
		if (out != null) {
			try {
				out.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void closeReader(Reader reader) {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static void closeWriter(Writer writer) {
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
