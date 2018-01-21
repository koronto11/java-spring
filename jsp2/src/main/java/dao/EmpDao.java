package dao;

import java.util.List;

import entity.Emp;

/*
 * 这是一个接口，用于servlet进行调用
 * 这个接口有对应的实现类
 * 封装了Dao
 */
public interface EmpDao {
    
	//取全部员工信息，其泛型为Emp实例，返回类型为List<Emp>
	//创建findall()方法
	//这里可以省去public
	//因为创建接口的时候已经声明过public了
	List<Emp> findall();
	
	//增加一个save方法用于保存
	//servlet接收到浏览器增加的员工数据
	//然后在servlet内部封装成Emp实例
	//然后调用这个方法传给EmpDao进行保存
	void save(Emp e);
}
