package test;

import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.SomeBean;
import ioc2.Restaurant;
import value.ValueBean;

public class TestCase2 {

	@Test
	public void test1(){
		ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"ioc2.xml");
		Restaurant rest=
				ac.getBean("rest",Restaurant.class);
		System.out.println(rest);
		
		
		
	}
	
	@Test
	public void test2(){
		ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"ioc3.xml");
		ValueBean vb=
				ac.getBean("value",ValueBean.class);
	    //输出ValueBean的toString方法
		System.out.println(vb);
	    
	}
	
	@Test
	//读取Properties文件
	public void test3(){
		ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"value.xml");
		System.out.println(ac.getBean("config"));
	}
	
	@Test
	//读取Bean对象数据
	public void test4(){
		ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"value.xml");
		System.out.println(ac.getBean("sp1"));
	}
	
	@Test
	//测试组件扫描
	public void test5(){
		ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"annotation.xml");
		System.out.println(ac.getBean("sb"));
	}
	
	@Test
	//测试注解作用域
	public void test6(){
		ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"annotation.xml");
		System.out.println(ac.getBean("sb"));
		System.out.println(ac.getBean("sb"));
	}
	
	
	@Test
	//测试声明周期注解
	public void test7(){
		AbstractApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"annotation.xml");
		SomeBean sb=ac.getBean("sb",SomeBean.class);
		ac.close();
	}
	
	
	@Test
	//测试延迟加载注解
	public void test8(){
		ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"annotation.xml");
		
		
	}
}
