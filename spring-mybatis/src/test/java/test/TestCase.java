package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class TestCase {

	//测试dao接口
	@Test
	public void test1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(
			     "spring-mybatis.xml");
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user=dao.findByName("demo");
		if(user!=null){
			System.out.println("用户存在！");
			System.out.println(user);
		}else{
			System.out.println("用户不存在！");
		}
	}
}
