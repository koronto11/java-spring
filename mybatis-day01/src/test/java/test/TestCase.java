package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;
import entity.Emp2;

public class TestCase {

	private SqlSession session;
	@Before
	public void init(){
		//mybatis最主要是调用SqlSession的方法来访问数据库
		//如何获取这个SqlSession对象
		SqlSessionFactoryBuilder ssfb=
					new SqlSessionFactoryBuilder();
		//类加载方式，其参数是Mybatis的配置文件
		SqlSessionFactory ssf=
				ssfb.build(TestCase.class.
					getClassLoader().
					getResourceAsStream("SqlMapConfig.xml"));
		session=ssf.openSession();
	}
	
	
	@Test
	public void test1(){
		
		//SqlSession对象插入数据的方法
		//第一个参数是映射文件的id，完整id是Mapper的命名空间namespace.id
		//所以这里的第一个字符串参数填的是test.save
		//test是Mapper的namespace
		//save是映射文件的id
		//第二个对象则是要插入的数据实体类对象
		Emp emp=new Emp();
		emp.setName("Eric");
		emp.setAge(22);
		
		session.insert("test.save",emp);
		
		session.commit();
		session.close();//关闭资源，最好放在finally中
		System.out.println("插入成功");
		
	}
	
	//查询
	@Test
	public void test2(){
		List<Emp> emps=
		    session.selectList("test.findAll");
		System.out.println(emps);
		session.close();
	}
	
	//条件查询
	//selectone就是查一条
	//映射文件中已经规定了findById的返回类型是Emp
	//所以一定要是Emp
	@Test
	public void test3(){
		Emp emp=
		 session.selectOne("test.findById",21);
		System.out.println(emp);
		session.close();
	}
	
	
	@Test
	public void test4(){
		//修改数据，要将一个Emp实例作为参数进行修改
		//先找出要修改的员工对象
		Emp emp=
		   session.selectOne("test.findById",21);
		emp.setAge(emp.getAge()+10);
		session.update("test.modify", emp);
		session.commit();
		session.close();
		System.out.println("修改成功");
	}
	
	@Test
	public void test5(){
		session.delete("test.delete", 21);
		//增删改操作必须要提交，调commit方法，不然就无效
		session.commit();
		session.close();
		System.out.println("删除成功");
		
	}
	
	//返回中间结果集map
	@Test
	public void test6(){
		Map data=
			session.selectOne("findById2", 41);
		System.out.println(data);
		session.close();
	}
	
	//使用ResultMap来解决实体类的属性名
	//和表的字段名不匹配的情况
	@Test
	public void test7(){
		Emp2 emp=
				session.selectOne("test.findById3", 41);
		System.out.println(emp);
		
		//配置完ResultMap后就可以成功取到数据了
	}
}
