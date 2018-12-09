package com.sun.util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.service.impl.UserService;

import redis.clients.jedis.Jedis;

/**
 * @author  szy 
 * @version 创建时间�?2018-5-5 下午12:07:17
 * 异步 工具
 */
public class AsyncThreadUntil {
	
	private static ExecutorService executor;
	
	static{
        
		try {
			executor = getInstance();
			
			System.out.println("executorInstance is  successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
	}
	
	private static ExecutorService getInstance(){
		if(executor == null){
			executor = Executors.newFixedThreadPool(1);
		}
		
       System.out.println("初始化成功");
		return executor;
	
	}
	
	public static void task2(){
		 executor.submit(new Callable(){

			@Override
			public Object call() throws Exception {
				// TODO Auto-generated method stub
				
				//增加睡眠时间，便于查看结果
			    /* try {
	                    Thread.sleep(10000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }*/
			     
				//异步提交
				int sum  = 0;
				for (int i = 0; i < 10000; i++) {
					 sum += i;
				}
				System.out.println("task2执行数据的大量导入或者导出");
				System.out.println("task2="+sum);
				System.out.println("task2导入或者导出完成");
				return null;
			}
			 
			 
		 });
		
	}
	    
	
}
