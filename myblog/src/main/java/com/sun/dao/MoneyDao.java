package com.sun.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sun.entity.MoneyInfo;
import com.sun.entity.UserInfo;

public interface MoneyDao {
	public MoneyInfo getmoney(@Param("id") int userID);
	
	public void InsertMony(@Param("money") int Money);
	
}
