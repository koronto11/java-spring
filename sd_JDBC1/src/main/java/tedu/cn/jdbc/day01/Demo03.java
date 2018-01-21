package tedu.cn.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * DQL查询语句
 * 处理结果集
 * 
 * 可以将重复性代码进行简化，放到一个类中进行封装
 * @author Administrator
 *
 */
public class Demo03 {

	public static void main(String[] args) throws Exception {
	Connection conn=DbUtils.getConnection();
	Statement sta=conn.createStatement();
	//查询语句
	String dql="SELECT * FROM emp";
	ResultSet set=sta.executeQuery(dql);
	
	/*
	 * ResultSet集中有一些方法可以介绍
	 * 如何处理结果集
	 * ResultSet的next方法，检查是否有行
	 * 通常和while(set.next()){}配合使用,固定搭配
	 * ResultSet的next方法是移动游标到下一行
	 * 并检查是否有数据(是否有行)，有数据则返回true
	 * ResultSet相当与从数据库中查询的数据的映射
	 * 被查询到的数据(n行n列二维表)自带一个游标
	 * 刚开始在第一行标记
	 * 根据next()来移动游标检测行记录 
	 * 然后由while判断来输出
	 * 
	 * ResuleSet的getXXX("列名")方法是获得当前行中指定列的值
	 * 根据你要取得的列名的参数类型来选择用什么XXX方法
	 * 返回值就是你指定的类型，若是类型不符合则报错
	 * 
	 * ResultSet集和while(set.next())配合
	 * 
	 */
	while(set.next()){
		int id=set.getInt("empno");
		String name=set.getString("ename");
		String job=set.getString("job");
		int mgr=set.getInt("mgr");
		double salary=set.getDouble("sal");
		double comm=set.getDouble("comm");
		int deptno=set.getInt("deptno");
		String hiredate=set.getString("hiredate");
		//输出结果
		System.out.println(id+","+name+","+job
				+","+mgr+","+salary+","+comm+","+deptno+","+hiredate);
	}
	
	
    //关闭连接
    conn.close();
	}

}
