package cn.tedu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.entity.User;

//加Controller标签是为了让springMVC帮我们把控制器组件给管理起来
//配置在spring.xml中的组件扫描会扫描到这个注解
@Controller
public class JsonController {
  
	//加上ResponseBody这个注解，调用jackson
	//自动转为json格式，这个jackson是将返回的数据对象自动进行JSON转换
	@RequestMapping("/json1.do") //匹配请求
	@ResponseBody
	public User loadUser(){
	    User user=new User(1,"jack","23");
		return user;
	  
    }
	
	@RequestMapping("/json2.do") //匹配请求
	@ResponseBody
	//返回一个List对象，已经转为json格式
	public List<User> loadUsers(){
		List<User> users=new ArrayList<User>();
		User user1=new User(1,"luffy","23");
		User user2=new User(2,"nami","20");
		User user3=new User(1,"nonoloya","23");
	    users.add(user1);
	    users.add(user2);
	    users.add(user3);
	    return users;
	}
	
	@RequestMapping("/json3.do") //匹配请求
	@ResponseBody
	public Map<String,Object> loadData(){
		Map<String,Object> data=new HashMap<String,Object>();
		//往map中添加数据
		data.put("id", 1);
		data.put("name", "dog");
		return data;
		
	}
}
