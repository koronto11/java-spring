package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 演示session
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//接收账号
		String code=req.getParameter("code");
		//先获得session
		HttpSession session=req.getSession();
		//将用户数据存入session
		//可以存Object类型的，没有限制，可以存任何东西
		session.setAttribute("code", code);
		
	}

}
