package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//获取session
		//由于本次请求浏览器传入了sessionID
		//所以服务器就根据这个SessionID找到那个旧的session
		//可以从中读写之前存的数据
		HttpSession session=req.getSession();
		//因为是Object所以需要转型String，大转小强制转
		String code=(String)session.getAttribute("code");
		//输出给浏览器
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		out.println(code);
		out.close();
	}

}
