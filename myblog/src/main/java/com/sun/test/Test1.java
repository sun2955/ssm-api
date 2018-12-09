package com.sun.test;

import org.apache.log4j.Logger;

/**
 * @author  szy 
 * @version 创建时间：2018-4-5 下午9:35:00
 * 
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//读取使用Java的特性文件编写的配置文件
        //DOMConfigurator.configure( "D:\\jar\\log4j.xml" );
        
		Logger logger =  Logger.getLogger(Test1.class);
		
		logger.debug("[1]-my level is DEBUG 天");
		logger.info("[2]-my level is INFO");
		logger.warn("[3]-my level is WARN");
		logger.error("[4]-my level is ERROR");
	}

}
