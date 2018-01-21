package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查，判断账号密码是否正确
 * 相当于NETSCTOSS项目的MainServlet.login()
 * 
 * 主要是为了演示cookie功能
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//获取浏览器端传入的参数(账号密码)
		String code=req.getParameter("code");
		//检查逻辑，这个步骤简化(省略)
		//转发或重定向(省略)
		//检查通过后将账号信息传入cookie
		//创建cookie，每个cookie对象只能存入一条数据
		//包括key和value
		//value就是要保存的数据
		Cookie c1=new Cookie("code", code);
		
		//声明Cookie的生存时间
		//参数为秒,大于0则表示保存在硬盘上的时间
		//默认值是小于0保存在内存上，等于0则是删除
		c1.setMaxAge(600000);
		//设置Cookie的有效路径
		//这样就可以对整个项目下的所有类有效
		//项目及项目下级都可以用
		c1.setPath("/jsp4");
		//将cookie发送给浏览器
		//浏览器接收到cookie后会自动保存
		//这也是浏览器根据服务器机制应运而生开发的一个功能
		//用于保存用户数据和识别同一个用户的操作
		res.addCookie(c1);
		
		
		//再创建一个Cookie用于保存中文字符
		//Cookie中文字符编码
		Cookie c2=new Cookie(
				"city", URLEncoder.encode(
						"北京", "utf-8"));
		res.addCookie(c2);
	}

}
