package com.sun.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.LoginDao;
import com.sun.dao.MoneyDao;
import com.sun.entity.MoneyInfo;
import com.sun.entity.UserInfo;
import com.sun.service.impl.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired //讲dao层注入进来
	private LoginDao loginDao;
	
	@Autowired
	private MoneyDao moneyDao;
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		//
		  System.out.print("hello----userService is init");
	}

	
	//使用注解，进行事务控制
	@Transactional
	@Override
	public String userInfoData(String id) {
		// TODO Auto-generated method stub
		System.out.print("调用 dao层方法");
		UserInfo arr =  loginDao.getUser(1);
		System.out.println("arr id = "+ arr.getId());
		System.out.println("arr Username = "+ arr.getUsername());
		
		MoneyInfo money = moneyDao.getmoney(1);
		
		moneyDao.InsertMony(500);
		//安正事务是否起作用
		//loginDao.InsertUser(5, "Tigger");
		
		if(money!=null){
			System.out.println("money  = "+ money.getMoney());
			System.out.println("money  += "+ money.getMoney());
		}

		
		//1.mybatis 的自己调用方法
/*		try {
			mybatisTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//2.spring + mybatis整合后的调用
		
		return null;
	}


	
	//原生的mybatis测试查询成功
	public void mybatisTest() throws IOException{
		
		//构建sqlSession的工厂
		//SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader("mybatis.xml"); 
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		/**
		* 映射sql的标识字符串，
		* me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		* getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		*/
		String statement = "getUser";//映射sql的标识字符串
		//执行查询返回一个唯一user对象的sql
		UserInfo user = session.selectOne(statement, 1);
		System.out.println("userId=" + user.getId());
		System.out.println("username=" + user.getUsername());
		System.out.println("123");
	}
}
