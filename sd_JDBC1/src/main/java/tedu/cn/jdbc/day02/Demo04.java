package tedu.cn.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import tedu.cn.jdbc.day01.DbUtils;

/**
 * 测试执行计划
 * @author Administrator
 *
 */
public class Demo04 {

	public static void main(String[] args) {
	Connection conn=null;
	try {
		conn=DbUtils.getConnection();
		String sql="UPDATE robin_demo "
				+ "set name=? "
				+ "where id=?";
		PreparedStatement ps=
				conn.prepareStatement(sql);
		ps.setString(1, "potty");
		ps.setInt(2, 3);
		int n=ps.executeUpdate();
		System.out.println(n);
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		DbUtils.close(conn);
	}
	}

}
