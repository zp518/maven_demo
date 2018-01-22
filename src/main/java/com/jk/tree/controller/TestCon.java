/** 
 * <pre>项目名称:UserRoles-maven 
 * 文件名称:TestCon.java 
 * 包名:com.jk.tree.controller 
 * 创建日期:2018年1月2日上午11:31:53 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.tree.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk.tree.model.TestModel;
import com.jk.util.TestPool;

/** 
 * <pre>项目名称：UserRoles-maven    
 * 类名称：TestCon    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2018年1月2日 上午11:31:53    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2018年1月2日 上午11:31:53    
 * 修改备注：       
 * @version </pre>    
 */
@RequestMapping("test")
@Controller
public class TestCon implements Runnable{
	
	static TestModel  testModel = new TestModel();
	
	@RequestMapping("testSyn")
	public void run() {
		synchronized (TestModel.class) {
			testModel.play();
		}
	}
    public static void main(String[] args) {
    	TestPool test=new TestPool();
  	  TestCon testCon=new TestCon();
    	//缓存线程池
    	 /* 
	   		for (int i = 0; i < 20; i++) {
		   		test.executeFixedThreadPool(testCon);
				}*/
    	//定长线程池
    	/* 
    	 for (int i = 0; i < 20; i++) {
    	 test.executeFixedThreadPool(testCon);
    	 }*/
    	//定时定长线程池
  	/* for (int i = 0; i < 20; i++) {
    	 test.executeScheduledThreadPool(testCon, 10,TimeUnit.SECONDS);
    	 }*/
  	//单个线程池（有顺序） 不用加锁synchronized
  	for (int i = 0; i < 20; i++) {
   	 test.executeSingleThreadPool(testCon);
   	 }
	
}


}
