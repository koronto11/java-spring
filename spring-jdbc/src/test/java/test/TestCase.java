package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;

public class TestCase {

	//dao对象要创建在外面，不然其他方法取不到
	private EmpDAO dao;
	@Before
	public void init(){
		ApplicationContext ac=
				new ClassPathXmlApplicationContext(
						"springmvc.xml");
		dao=ac.getBean("empDAO",EmpDAO.class);
	}
	
	@Test
	public void test1(){
		//容器启动
		ApplicationContext ac=
				new ClassPathXmlApplicationContext(
						"springmvc.xml");
		Emp emp=new Emp();
		emp.setName("hs");
		emp.setAge(23);
		
		EmpDAO dao=ac.getBean("empDAO",EmpDAO.class);
		dao.save(emp);
		System.out.println("插入成功");
		
		//测试成功
	}
	
	@Test
	public void test2(){
		List<Emp> list=dao.findAll();
		System.out.println(list);
		
		//测试成功
	}
	
	@Test
	public void test3(){
		//数据库的主键是从1开始的
		Emp emp=dao.findById(11);
		System.out.println(emp);
		
		//若找不到则会报错
		//测试成功
	}
	
	@Test
	public void test4(){
		//数据库的主键是从1开始的
		Emp emp=dao.findById2(1);
		System.out.println(emp);
		
		//若找不到不会报错
		//测试成功
	}
	
	@Test
	public void test5(){
		//修改数据
		Emp emp=dao.findById2(1);
		//将原来年龄改为两倍
		emp.setAge(emp.getAge()*2);
		dao.modify(emp);
		
	}
	
	
	@Test
	public void test6(){
		dao.delete(1);
	}
	
}
