package com.util;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

/**
 *
 * @author xuelei xueleicug@163.com
 * @time   2016年6月6日 下午4:13:05
 **/
public class PropertiesUtil {
	
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("propertyLogger");
	private Properties prop = null;
	private String propertiesFileName = null;
	
    /**
	 * @param name 配置文件路径
	 */
	public PropertiesUtil(String name) {
		this.prop = new Properties();
		this.propertiesFileName = name;
		Reader reader = null;
		try {
			reader = FileUtil.getInputStreamReader(name);
			if (reader != null) {
				this.prop.load(reader);
				logger.info("载入配置文件\"" + name + "\"");
			}
			else {
				logger.info("寻找配置文件\"" + name + "\"失败");
			}
		} catch (IOException e) {
			// TODO: handle exception
			logger.info(e.getStackTrace());
		} finally {
			FileUtil.closeReader(reader);
		}
	}
	
	/**
	 * 获取key对应的值
	 * @param key key值
	 * @return value值
	 * String
	 */
	public String getValueofKey(String key) {
		String value = this.prop.getProperty(key);
		return value;
	}
	
	/**
	 * 添加键值对,不保存到本地
	 * @param key key值
	 * @param value value值
	 * @throws IOException
	 * void
	 */
	public void addKeyValue(String key, String value) {
		this.prop.setProperty(key, value);
	}
	
	/**
	 * 添加键值对，并保存到本地
	 * @param key key值
	 * @param value value值
	 * @throws IOException
	 * void
	 */
	public void saveKeyValue(String key, String value, String comments) {
		this.prop.setProperty(key, value);
		this.savaProperties(comments);
	}
	
	/**
	 * 保存配置文件
	 * @param comments
	 * void
	 */
	public void savaProperties(String comments) {
		Writer writer = FileUtil.getOutputStreamWriter(this.propertiesFileName);
		try {
			this.prop.store(writer, comments);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			FileUtil.closeWriter(writer);;
		}
	}
}
