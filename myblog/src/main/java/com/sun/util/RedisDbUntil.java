package com.sun.util;
import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * @author  szy 
 * @version 创建时间�?2018-5-5 下午12:07:17
 * 
 */
public class RedisDbUntil {

	private static  Jedis jedisInstance;
	
	static{
        
		try {
			jedisInstance = getInstance();
			
			System.out.println("jedisInstance Connect to database successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
	}
	
	private static Jedis getInstance(){
		 //连接本地的 Redis 服务
		if(jedisInstance == null){
			jedisInstance  = new Jedis("localhost");
		}
		
       System.out.println("连接成功");
       //查看服务是否运行
		return jedisInstance;
	
	}
	    
	/**
	 * 获取单个字符串的值
	 * @param name
	 * @return
	 */
	public static String getRedisToString(String keyname){
		
	     //########字符串的存取实例
        System.out.println("服务正在运行: "+jedisInstance.ping());
        String value = jedisInstance.get(keyname); 
        System.out.println("name=" + value);
        return value;
	}
	
	/**
	 * 获取列表
	 * @param name
	 * @return
	 */
	public static List<String>getRedisToList(String keyname){
		
	     List<String> list = jedisInstance.lrange(keyname, 0 ,2);
	        for(int i=0; i<list.size(); i++) {
	            System.out.println("列表项为: "+list.get(i));
	        }
	        
		return list;
	}
	
	/**
	 *  插入数组
	 *  后入先出的原则，后插入得在最前面
	 * @param keyname
	 * @param alist
	 */
	public static void InsertRedisByList(String keyname,List<String> alist){
		
		for (String string : alist) {
			   //########列表的存取实例
		     jedisInstance.lpush(keyname, string);
		}
	
	}
	
}
