package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模拟打开主页功能
 * 
 * 主要演示看当浏览器再次访问服务器时是否会自动发送cookie
 * @author Administrator
 *
 */
public class IndexServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//此时的cookie已经在浏览器中
		//想浏览器输出主页内容(省略)
		//获取浏览器端所有cookie
		Cookie[] cs=req.getCookies();
		//返回的是一个Cookie数组，以为每个Cookie对象是一条数据
		//可能有多个Cookie
		//request的getCookie方法是将所有Cookie都取到
		if(cs!=null){
			//设置响应形式和字符集编码
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			for(Cookie c:cs){
				//Cookie解码
				out.println(c.getName()+":"
			            +URLDecoder.decode(c.getValue(),"utf-8"));
			}
			out.close();
		}
	}

}
