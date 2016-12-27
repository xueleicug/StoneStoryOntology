package com.util;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author xuelei xueleicug@163.com
 * @time   2016年12月13日 下午5:08:22
 **/
public class XMLFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		if (pathname.getName().endsWith(".xml")) {
			return true;
		}
		return false;
	}

}
