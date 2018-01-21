package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Student;

public class FindStudentServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//1.获取参数(略)，没有浏览器传过来的数据
		//2.处理业务(查询)
		//有两个实体类
		//模拟从数据库中查询了数据
		Student stu=new Student();
		stu.setName("路飞");
		stu.setAge(23);
		stu.setSex("M");
		stu.setInterests(
				new String[]{"拳","脚","头槌"});
		Course c=new Course();
		c.setId(1);
		c.setName("三档");
		c.setDays(730);
		stu.setCourse(c);
		//3.转发给JSP或重定向
		//3.1先将数据存入request中，以方便转发
		req.setAttribute("stu", stu);
		//3.2转发
		//与JSP文件的相对路径
		req.getRequestDispatcher("find_student.jsp")
		                .forward(req, res);
		
		
	}

}
