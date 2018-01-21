package entity;

import java.io.Serializable;
/**
 * 此类用于模拟从数据库中取出的数据
 * 封装的查询结果
 * @author Administrator
 * 建议：
 * 1.尽量使用封装类型，因为它比基本类型多了null
 *   封装类型即包装类(包装基本类型的类,更多功能)
 * 2.使用java.sql包下的日期，
 *   因为JDBC支持这样的日期类型
 * 3.
 */
public class Emp implements Serializable{
/**
 * 此类须满足javaBean规范
 * 1.有包
 * 2.有默认构造器
 * 3.实现序列化接口
 * 4.有get和set方法(非必须) 
 **/
	//假设从数据库取出四个字段
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	
	
}
