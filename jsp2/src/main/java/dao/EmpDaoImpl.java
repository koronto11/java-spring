package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;

public class EmpDaoImpl implements EmpDao, Serializable {

	//这个方法模拟实现查询所有员工信息
	public List<Emp> findall() {
		//创建集合
		//这个集合就是获取的数据
		List<Emp> list=
				new ArrayList<Emp>();
		
		//创建实现类Emp
		//模拟三组员工数据
		Emp e1=new Emp();
		e1.setEmpno(1);
		e1.setEname("hs");
		e1.setJob("leader");
		e1.setSal(9000.0);
		list.add(e1);
		
		Emp e2=new Emp();
		e2.setEmpno(2);
		e2.setEname("wy");
		e2.setJob("manager");
		e2.setSal(8000.0);
		list.add(e2);
		
		Emp e3=new Emp();
		e3.setEmpno(3);
		e3.setEname("ls");
		e3.setJob("driver");
		e3.setSal(4000.0);
		list.add(e3);
		
		//调用这个findall方法获取数据
		return list;
	}
	
	//模拟增加一个员工
	public void save(Emp e){
		//服务器后台这个save方法被调用
		//模拟输出一句话表示添加成功
		System.out.println("增加了员工:"+e.getEname());
		
	}

}
