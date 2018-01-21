package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//先从数据库取得数据
		EmpDao dao=new EmpDaoImpl();
		List<Emp> list=dao.findall();
		//转发，将显现部分交给JSP处理
		//1)将数据绑定到request上
		//  list是传入的数据，emps是数据名字自己取的
		req.setAttribute("emps",list);
		//2)将请求提交给JSP继续处理，同时要将处理请求的工具给JSP
		//  工具：request+response
		//req的getRequestDispatcher("")方法是获取转发器
		//其参数是目标JSP文件的路径
		//其路径写法选用相对路径
		//jsp文件也算静态资源，因此路径直接在项目下访问即可,平级关系
		//当前：/jsp2/findemp
		//目标：/jsp2/emp_list.jsp
		req.getRequestDispatcher("emp_list.jsp")
		                .forward(req, res);
		
		
	}

	
}
