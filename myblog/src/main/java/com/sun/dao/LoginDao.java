package com.sun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sun.entity.UserInfo;

public interface LoginDao {
	public UserInfo getUser(int userID);
    public UserInfo getUserName(String userName);
    public void InsertUser (@Param("id")int  id,@Param("userName")String userName);
    
}
