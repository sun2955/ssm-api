package com.sun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.dao.LoginDao;
import com.sun.service.impl.AdminerService;
@Repository
public class AdminerServiceImpl implements AdminerService {

	
	@Override
	public String init() {
		// TODO Auto-generated method stub
		System.out.println("AdminerService is init ");
		return null;
	}

}
