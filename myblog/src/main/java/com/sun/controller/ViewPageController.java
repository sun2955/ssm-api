package com.sun.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.service.impl.UserService;

@Controller
@RequestMapping("/view")
public class ViewPageController {

	private Logger log = Logger.getLogger(ViewPageController.class);
	
	//给变量赋值
	@Value(value = "/view")
	public String controllerName;
	
	
	
	@RequestMapping("/index")
	public String Index(){
		
		log.info("this controller name is ="+ controllerName);	
		return "index";
	}
	
	
	@RequestMapping("/index2")
	public String Index2(){
		
			
		return "index2";
	}
	
	
	
/*	@RequestMapping(value = "/index3/{user}{pwd}")
	public @ResponseBody String Index3(@RequestParam("user") String user,@RequestParam("pwd") String pwd){
		
		System.out.println(user);
		System.out.println(pwd);
		return "index3";
	}*/
}
