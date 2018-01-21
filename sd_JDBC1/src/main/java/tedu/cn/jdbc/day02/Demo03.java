package tedu.cn.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import tedu.cn.jdbc.DBUtils;

/**
 * 数据库执行计划
 * PreparedStatement
 * 演示预编译的SQL执行计划
 * @author Administrator
 *
 */

public class Demo03 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DBUtils.getConnection();
			//带参数的SQL语句
			String sql="insert into robin_demo(id,name) "
					+ "values(?,?)";
			//1.将SQL发送到数据库，创建执行计划
			//返回值psta就代表着这个执行计划
			//代表SQL语句在数据库服务器上的那个执行计划（转换的那个二进制代码）
			PreparedStatement psta=
					conn.prepareStatement(sql);
			//2.代入参数
			//替换执行计划中的参数，有几个参数就要发送几个
			//还要按照顺序序号发送，索引下标数字要对应参数
			psta.setInt(1,3);
			psta.setString(2,"harry");
			//3.执行SQL语句
			int n=psta.executeUpdate();
			System.out.println(n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
		}

	}

}
