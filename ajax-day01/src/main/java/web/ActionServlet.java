package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	//这里面模拟的执行步骤其实是Struts2的写法
	//内部逻辑就是这个步骤
	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()");
		//获取请求资源路径
		//uri就是绝对路径，不包括ip和端口号
		//url才是最完整的路径名包括p和端口号
		//uri格式是/项目名称/网名(servlet访问路径地址)
		
		//例如：http://ip/port/ajax-day01/check.do
		//uri就是/ajax-day01/check.do
		String uri=request.getRequestURI();
		System.out.println("uri"+uri);
		//截取这个uri的子字符串
		//beginIndex是开始的字符串
		//endIndex是结束的字符串
		//截取最后一个/号到最后一个.的数据
		//就是项目名称和.do后缀不要了
		// uri:/ajax-day01/check.do
		//只截出/check
		String action=uri.substring(uri.lastIndexOf("/"), 
				                          uri.lastIndexOf("."));
		//输出检测
		System.out.println("action:"+action);
		
		//针对不同的action(路径)进行不同的处理
		//先设置响应的字符集编码
		response.setContentType("text/html;charset=utf-8");
		//然后创建输出流
		PrintWriter out=response.getWriter();
		if("/check_admin".equals(action)){
			//读取用户名,getParameter内填的参数adminCode
			//不是根据表单id读取的
			//而是根据ajax前期设置里面那个路径？号后面的参数
			//check_admin.do?$admincode'+$F('adminCode')
			//ajax的get方式提交，然后填写这个提交的adminCode参数保持一致
			String adminCode=
					request.getParameter("adminCode");
			System.out.println(adminCode);
			//模拟查询结果
			//模拟数据库查询并检查的过程，忽略
			//响应一个文本
			if("king".equals(adminCode)){
				//若账号是king则显示账号已经存在
				out.println("此账号已经存在");
			}else{
				out.println("可以使用");
			}
		}
		
		
	}

	
}
