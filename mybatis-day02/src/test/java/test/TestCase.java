package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmpDAO;
import entity.Emp;
import entity.Emp2;

public class TestCase {

	SqlSession session=null;
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb=
				new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf=
				ssfb.build(TestCase.class.
						getClassLoader().
						getResourceAsStream(
								"SqlMapConfig.xml"));
		session=
				ssf.openSession();
	}
	
	@Test
	public void test1(){
		//增加员工数据
		
		//如何用那个Mapper映射器
		//sqlsession的一个方法
		//getMapper方法可以传入类名来获取这个映射器
		EmpDAO dao=
				session.getMapper(EmpDAO.class);
		Emp emp=new Emp();
		emp.setName("jackey");
		emp.setAge(23);
		dao.save(emp);
		//增删查仍然需要提交事务
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		//查询信息
		EmpDAO dao=
				session.getMapper(EmpDAO.class);
		List<Emp> emps=
				dao.findAll();
		System.out.println(emps);
	}
	
	@Test
	//条件查询
	public void test3(){
		EmpDAO dao=
				session.getMapper(EmpDAO.class);
		Emp emp=dao.findById(41);
		System.out.println(emp);
	}
	
	@Test
	//修改数据
	public void test4(){
		//例如要修改id=41的数据内容
		EmpDAO dao=
				session.getMapper(EmpDAO.class);
		Emp emp=dao.findById(41);
		emp.setAge(emp.getAge()+10);
		dao.modify(emp);
		session.commit();
		session.close();
	}
	
	@Test
	//删除数据
	public void test5(){
		EmpDAO dao=
				session.getMapper(EmpDAO.class);
		dao.delete(41);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		EmpDAO dao=
				session.getMapper(EmpDAO.class);
		Map emps=dao.findById2(62);
		System.out.println(emps);
		session.close();
	}
	
	
	@Test
	public void test7(){
		//这是表的字段名和实体类属性不同的情况
		//用resultMap来解决
		EmpDAO dao=
				session.getMapper(EmpDAO.class);
		Emp2 emp2=dao.findById3(62);
		System.out.println(emp2);
		session.close();
	}
}
