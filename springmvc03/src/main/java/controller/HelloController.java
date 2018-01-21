package controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    
	
	//异常处理方法
	//这个方法用以处理其他方法抛出的异常
	@ExceptionHandler
	//ex参数是其他方法所抛出的异常
	public String exHandler(Exception ex,
			HttpServletRequest request){
		System.out.println("exHandler()");
		//根据接收异常类型的不同而进行不同的处理
		//根据接收异常的不同而进行动态的变化
		
		//下面两个例子异常是可以恢复的应用异常
		//需要明确告诉用户是什么原因的错误导致异常
		//然后根据这个异常做出不同的提示
		if(ex instanceof NumberFormatException){
			//绑定信息
			//在页面中通过EL表达式就可以获取这个信息进行显示
			request.setAttribute("errorMsg", "亲！请输入正确的数字" );
			return "error";
		}else if(ex instanceof StringIndexOutOfBoundsException){
			request.setAttribute("errorMsg" , "下标越界了");
			return "error";
		}else{
			//这个是排除各种异常情况之外的应用异常
			//直接转到系统异常的页面，稍后重试
			return "system_error";
		}
		
		
	}
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		
		//测试错误类型异常
		//这里将100a转换为int型
		//会产生类型转换错误
		Integer.parseInt("100a");
		return "hello";
	}
    
    @RequestMapping("/demo/hello.do")
	public String hello1(){
		System.out.println("hello1()");
		String str="abcd";
		//StringIndexOutOfBoundsException下标越界异常
		str.charAt(10);
		return "hello";
	}
}
