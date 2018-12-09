package com.sun.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author  szy 
 * @version 创建时间：2018-5-5 下午12:07:17
 * 
 */
public class MongoDbUntil {

	private static String databaseName;
	private static  MongoClient mongoClientInstance;
	private static  MongoDatabase database;
	
	
	static{
		
	   //库名
		databaseName = "test";
		
		try {
			mongoClientInstance = getInstance();
			
			database = mongoClientInstance.getDatabase(databaseName);
			
			System.out.println("MongoDatabase-1 inof is : "+database.getName());
			
			 //表里表里的集合
		    for (String name : database.listCollectionNames()) {
		        System.out.println("test表里的集合有："+name);
		    }
		    
			System.out.println("Connect to database successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
	}
	    
	
	private static MongoClient getInstance(){
		
		if(mongoClientInstance == null){
			mongoClientInstance  = new MongoClient("localhost", 27017);
		}
		return mongoClientInstance;
	}
	
	
	public static String getDateName(){
		
		database = mongoClientInstance.getDatabase(databaseName);
		
		System.out.println("MongoDatabase-2 inof is : "+database.getName());
		
		return null;
		
	}
	
	/**
	 * 插入一条mongo记录
	 * @param coll
	 */
    public static void InsertMongoDataByOne(String CollName){
    	
    	   //获得一个集合对象 
 	   MongoCollection<Document> coll = database.getCollection(CollName);
 	   
    	   //如果在集合中插入相同的_id，会报错  index: _id_ dup key: {
        Document document = new Document("_id", 2002).append("title", "MongoDB Insert Demo")
                .append("description","database")
                .append("likes", 30)
                .append("by", "yiibai point")
                .append("url", "http://www.yiibai.com/mongodb/");

        //再插入一条不指定id的，会自动分配一个_id
        Document document2 = new Document("title", "MongoDB Insert Demo")
                .append("description","database")
                .append("likes", 30)
                .append("by", "yiibai point")
                .append("url", "http://www.yiibai.com/mongodb/");
        coll.insertOne(document2);
        
        //往集合对插入一体爱记录
        coll.insertOne(document);
    }
	

	/**
	 * 多行插入
	 * @param coll
	 */
   public static void InsertMongoDataByList(String CollName){
	   
	   //获得一个集合对象 
 	   MongoCollection<Document> coll = database.getCollection(CollName);
	   //多行插入
	    List<Document> documents = new ArrayList<Document>();
	    Document a1 = new Document("title", "2018");
	    
	    Document a2 = new Document("title", "2019");
	          
	    documents.add(a1);
	    documents.add(a2);
	    
	    coll.insertMany(documents);
	    System.out.println("Document inserted successfully");
	   
   }
    
    
}
