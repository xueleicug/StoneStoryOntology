package com.util;

import java.io.PrintStream;

/**
 *
 * @author xuelei xueleicug@163.com
 * @time   2016年3月25日 上午9:51:53
 **/
public class TimerUtil {
	
	private static PrintStream p = System.out;
	private long startTIme = 0;
	private long stopTime = 0;
	
	public TimerUtil() {
		
	}
	
	/**
	 *  开始计时
	 * void
	 */
	public void startTimeRecord() {
		this.startTIme = System.currentTimeMillis();
	}
	
	/**
	 * 停止计时
	 * void
	 */
	public void stopTimeRecord() {
		this.stopTime = System.currentTimeMillis();
		this.showRunningTime(startTIme, stopTime);
	}
	
	/**
	 * 显示运行时间
	 * @param t1 起始时间
	 * @param t2 中止时间
	 * void
	 */
	private void showRunningTime(long t1, long t2) {
		long timeLonger = t2 - t1;
		String timeStr = "";
		if (timeLonger <= 1000) {
			timeStr = new Long(timeLonger).toString() + " 毫秒";
		}
		else if (timeLonger <= 60000 && timeLonger > 1000){
			timeStr = new Double(new Long(timeLonger).doubleValue() / 1000.0d).toString() + " 秒";
		}
		else {
			long minites = timeLonger / 60000l;
			long milliSecond = timeLonger % 60000l;
			long second = milliSecond / 1000l;
			timeStr = new Long(minites).toString() + " 分 " + new Long(second).toString() + " 秒";
		}
		p.println("运行共计耗时：" + timeStr);
	}
}
