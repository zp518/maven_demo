package com.jk.util;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class BaseAction {

	private static final long serialVersionUID = -9079055950435953564L;

	public static void responseWrite(HttpServletResponse response,String jsonStr){
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				writer.flush();
				writer.close();
			}
		}
	}
	
	
}
