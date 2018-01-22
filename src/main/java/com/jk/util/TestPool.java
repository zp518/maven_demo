/** 
 * <pre>项目名称:UserRoles-maven 
 * 文件名称:TestPool.java 
 * 包名:com.jk.util 
 * 创建日期:2018年1月2日下午3:08:50 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** 
 * <pre>项目名称：UserRoles-maven    
 * 类名称：TestPool    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2018年1月2日 下午3:08:50    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2018年1月2日 下午3:08:50    
 * 修改备注：       
 * @version </pre>    
 */
public class TestPool {
	static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
	static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
	static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();  
	//缓存线程池
	public static void executeCacheThreadPool(Runnable runnable){
		 cachedThreadPool.execute(runnable);
	}
	//定长线程池
	public static void executeFixedThreadPool(Runnable runnable){
		fixedThreadPool.execute(runnable);
	}
	
	//定时定长线程池
	public static void executeScheduledThreadPool(Runnable runnable,long time,TimeUnit unit){
		scheduledThreadPool.schedule(runnable, time, unit);
	}
	
	public static void executeSingleThreadPool(Runnable runnable){
		singleThreadExecutor.execute(runnable);
	}
	 

}
