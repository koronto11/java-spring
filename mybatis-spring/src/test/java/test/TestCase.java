package test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;
import entity.Emp2;
/**
 * 整合Mybatis技术的spring框架
 * 其SqlSession全部由spring配置来完成
 * 我们不需要手动写了
 * @author Administrator
 *
 */
public class TestCase {

	private EmpDAO dao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(
						     "springmvc.xml");
	    //因为这边MapperScannerConfigurer
		//创建满足Mapper接口需求的对象
		//其默认id是接口名首字母小写
		dao=ac.getBean("eDAO",EmpDAO.class);
	}
	
	//spring整合Mybatis技术
	@Test
	public void test1(){
		//获取DAO对象
		//接口名首字母小写就是Mapper的id
		//在业务层中可以用注解注入这个dao对象
	    Emp emp=new Emp();
	    emp.setName("xiao");
	    emp.setAge(29);
	    //其底层的SqlSession的commit和close都由spring完成了
	    //我们只需要简单执行方法即可
		dao.save(emp);
	}
	
	
	@Test
	//查询
	public void test2(){
		List<Emp> emps=dao.findAll();
		System.out.println(emps);
	}
	
	
	@Test
	//条件查询
	public void test3(){
	   Emp emp=dao.findById(81);
	   System.out.println(emp);
	}
	
	@Test
	//条件查询
	public void test4(){
	   Emp2 emp=dao.findById3(81);
	   System.out.println(emp);
	}
	
	@Test
	//更改
	public void test5(){
		Emp emp=dao.findById(81);
		emp.setAge(emp.getAge()*2);
		dao.modify(emp);
		
	}
	
	@Test
	public void test6(){
		dao.delete(62);
	}
	
}
