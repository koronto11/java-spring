package controller;
/**
 * Controller处理器写法
 * 实现Controller接口和返回MedolAndView对象
 * 
 * 若是用注解方式配置，那么不需要实现Controller接口
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("demo")
public class HelloController{

	//方法名不作要求，返回类型可以是String，也可以是
	//ModelAndView，当返回值只有视图名没有封装处理数据时
	//用String类型即可
	@RequestMapping("/hello.do")
	public String hello(HttpServletRequest req,
            HttpServletResponse res)throws Exception{
		System.out.println("hello()");
		//返回一个视图名
		return new String("hello");
		
	}
   
}
