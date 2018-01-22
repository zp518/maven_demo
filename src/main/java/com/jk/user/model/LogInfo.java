/** 
 * <pre>项目名称:ssm-mongodb-zp 
 * 文件名称:LogInfo.java 
 * 包名:com.jk.model 
 * 创建日期:2017年11月24日下午8:06:55 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.user.model;

import java.util.Date;

import javax.persistence.Id;


/** 
 * <pre>项目名称：ssm-mongodb-zp    
 * 类名称：LogInfo    
 * 类描述：    
 * 创建人：张萍萍 1452640509@qq.com      
 * 创建时间：2017年11月24日 下午8:06:55    
 * 修改人：张萍萍 1452640509@qq.com   
 * 修改时间：2017年11月24日 下午8:06:55    
 * 修改备注：       
 * @version </pre>    
 */
//@Document(collection="log-Logs")
public class LogInfo {
	@Id
	private String logId;
	private String method;
	private String paramVal;
	private String returnVal;
	private String implUrl;
	private String invokeTime;
	private Date methDate;
	
	
	private String mintime;
	private String maxtime;
	
	
	public String getMintime() {
		return mintime;
	}
	public void setMintime(String mintime) {
		this.mintime = mintime;
	}
	public String getMaxtime() {
		return maxtime;
	}
	public void setMaxtime(String maxtime) {
		this.maxtime = maxtime;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParamVal() {
		return paramVal;
	}
	public void setParamVal(String paramVal) {
		this.paramVal = paramVal;
	}
	public String getReturnVal() {
		return returnVal;
	}
	public void setReturnVal(String returnVal) {
		this.returnVal = returnVal;
	}
	
	public String getImplUrl() {
		return implUrl;
	}
	public void setImplUrl(String implUrl) {
		this.implUrl = implUrl;
	}
	public String getInvokeTime() {
		return invokeTime;
	}
	public void setInvokeTime(String invokeTime) {
		this.invokeTime = invokeTime;
	}
	public Date getMethDate() {
		return methDate;
	}
	public void setMethDate(Date methDate) {
		this.methDate = methDate;
	}
	

}
