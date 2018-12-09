package com.sun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.dto.User;
import com.sun.service.impl.AdminerService;
import com.sun.service.impl.UserService;

/*
 * @Controller 锟斤拷锟斤拷一锟斤拷锟斤拷为action
 */
@Controller
public class HelloworldController {

	
	final String  adminuser = "admin";
	
	/*
	 * @RequestMapping 通锟斤拷注锟解，指锟斤拷action锟斤拷锟�
	 * Model 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷页锟芥传锟斤拷锟斤拷锟斤拷
	 */
	//
	//@Resource  //使锟斤拷@Resource锟斤拷锟斤拷@Autowired锟斤拷签锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷遥锟斤拷锟斤拷远锟阶帮拷锟�
	@Autowired
	public UserService userService;
	
	
	@Autowired
	public AdminerService adminerService;
	
	@RequestMapping("/hello")
	public String hello(Model model){
		
		//锟斤拷锟斤拷锟斤拷锟斤拷锟捷革拷页锟斤拷锟斤拷示
		model.addAttribute("name", "page name ====== hello");
		
		return "hello";
	}
	
	
	//锟斤拷锟斤拷锟斤拷撇锟斤拷锟�
	@RequestMapping("/springtest")
	public String springtest(){
		
		//1.spring锟街讹拷装锟斤拷
		
/*		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");  
		 UserService us  = (UserService) ctx.getBean("userService");
		 us.sayHello();*/
		//2.锟皆讹拷扫锟斤拷锟斤拷锟� 
		 userService.sayHello();
		 
		 userService.userInfoData("dao");
		 
		 //adminerService.init();

		 
		return "springtest";
	}
	
	

	/*
	 * @RequestParam 锟斤拷锟斤拷锟斤拷锟秸筹拷锟斤拷锟接的诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷默锟斤拷值
	 */
	
	@RequestMapping("/userInfo")
	public String userInfo(Model model,@RequestParam(value="name",defaultValue=adminuser) String name){
		
		
		if("admin".equals(name)){
			//锟斤拷锟斤拷锟斤拷锟斤拷锟捷革拷页锟斤拷锟斤拷示
			model.addAttribute("name", "page name ====== "+ name);
		}else{
			model.addAttribute("name", "page name ====== "+ name);
		}
		
		return "userInfo";
	}
	
	/*
	 * @PathVariable 指锟斤拷path锟斤拷锟斤拷牟锟斤拷锟�
	 */
	@RequestMapping(value="/pathview/{age}/{years}/{month}",method = RequestMethod.GET)
	public String pathview(Model model,
			@PathVariable(value="age") String age,
			@PathVariable(value="years") String years,
			@PathVariable(value="month") String month
			){
		
			model.addAttribute("age", age);
			model.addAttribute("years", years);
			model.addAttribute("month", month);
			model.addAttribute("name", "page name ====== pathview");
		
		
		return "pathview";
	}
	
	//锟斤拷锟斤拷json
	@ResponseBody
	@RequestMapping("/responseBody")
	public String responseBody(Model model){
		
		model.addAttribute("name", "page name ====== responseBody");
		System.out.println("12231313");
		return "responseBody";
	}
	
	@ResponseBody
	@RequestMapping("/responseBody2")
	public  User responseBody2(){
		
		String name  = "Tom";
		Integer age  = 19;
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		/*Map<String,String> map=new HashMap<String, String>();
        map.put("001", "Tom");
        map.put("002", "19");
        
		/*String jsonString = JSON.toJSONString(map);
		
		JSONObject jsStr = new JSONObject();
		jsStr.put("name", "Tom");
		jsStr.put("age", 26);*/
		
		return user;
	}
	
	
	
	
	@RequestMapping(value ="/newuser",method=RequestMethod.GET)
	public ModelAndView  newuser(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("newuser");
		//mav.addObject(new User());
		return mav;
	}
	
	
	
	//锟斤拷锟斤拷页锟芥，同时锟斤拷锟斤拷值
	@RequestMapping(value = "/queryListMV.do")
	public ModelAndView queryListMV(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/newuser"); //锟斤拷锟斤拷页锟斤拷锟斤拷
		mv.addObject("data", new User());//锟斤拷锟斤拷map锟斤拷锟斤拷
		return mv;
	}
	
	
	@RequestMapping(value = "/queryListMV2.do",method=RequestMethod.GET)
	public ModelAndView queryListMV2(HttpServletRequest request,
			HttpServletResponse response) {
		
		String name  = request.getParameter("name");
		Integer age  = Integer.valueOf(request.getParameter("age"));
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/newuser"); //锟斤拷锟斤拷页锟斤拷锟斤拷
		mv.addObject("data",user);//锟斤拷锟斤拷map锟斤拷锟斤拷
		return mv;
	}
	
	/*
	 *  * 锟斤拷锟捷讹拷锟斤拷,通锟斤拷锟斤拷锟襟，斤拷锟斤拷form锟斤拷锟侥讹拷锟斤拷值
	 */
	 
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String adduser(Model model,@ModelAttribute("SpringWeb")User user){
		
		model.addAttribute("name", user.getName());
		model.addAttribute("age", user.getAge());
		model.addAttribute("id", user.getId());
		
		System.out.println("12231313");
		return "adduser";
	}
	
	
	/*
	 * 锟截讹拷锟斤拷牟锟斤拷锟�
	 */
	@RequestMapping(value="/redirect",method=RequestMethod.GET)
	public String redirect(){
		
		System.out.println("redirect锟斤拷锟斤拷锟斤拷锟截讹拷锟津方凤拷");
		return "redirect:finalPage";
	}
	
	@RequestMapping(value="/finalPage",method=RequestMethod.GET)
	public String finalPage(){
		
		System.out.println("finalPage锟斤拷锟斤拷锟斤拷锟截讹拷锟津方凤拷");
		return "finalPage";
	}
	
	
	
	@RequestMapping("/login")
	public String say(){
		
		System.out.println("login");
		
		return "login";
	}
	
}
