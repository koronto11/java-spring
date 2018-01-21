package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.A;
import scope.MessageBean;
import scope.ScopeBean;

public class TestCase {
      @Test
      //测试作用域
      public void test1(){
    	 //启动Spring容器
    	  ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"scope.xml"); 
    	 //通过容器去获得相应的对象
    	 //默认情况下scope=singleton
    	 //容器对于某个Bean都只会创建一次实例
    	  //输出结果为true
    	 ScopeBean s1=
    			 ac.getBean("scope",ScopeBean.class);
    	 ScopeBean s2=
    			 ac.getBean("scope",ScopeBean.class);
    	 System.out.println(s1==s2);
      }
      
      @Test
      //用于测试生命周期
      public void test2(){
    	  AbstractApplicationContext ac=
    				new ClassPathXmlApplicationContext(
    						"scope.xml");
    	  MessageBean mb=
    			  ac.getBean("msg",MessageBean.class);
    	  mb.sendMsg();
    	  //关闭容器
    	  ac.close();
      }
      
      @Test
      //测试延迟加载项目
      public void test3(){
    	  //启动Spring容器
    	  ApplicationContext ac=
    				new ClassPathXmlApplicationContext(
    						"scope.xml"); 
    	  
      }
      
      @Test
      //测试setter注入
      public void test4(){
    	  ApplicationContext ac=
  				new ClassPathXmlApplicationContext(
  						"ioc.xml");
    	  A a=ac.getBean("a1",A.class);
    	  a.execute();
      }
      
}
