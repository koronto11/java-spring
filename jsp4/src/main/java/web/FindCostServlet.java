package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCostServlet extends HttpServlet {

	
	/**
	 * 演示不同路径对Cookie接收的问题
	 * 这里的路径配置是<url-pattern>/cost/find</url-pattern>
	 * 但是Cookie是在<url-pattern>/main/login</url-pattern>下创建的
	 * Cookie只对创建的那个路径及其下级路径有效
	 * 所以可以通过修改路径的方式
	 */
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		
				Cookie[] cs=req.getCookies();
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
