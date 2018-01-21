package tedu.cn.jdbc.day02;
/**
 * 测试查询在执行计划中
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tedu.cn.jdbc.DBUtils;
import tedu.cn.jdbc.day01.DbUtils;

public class Demo05 {

	public static void main(String[] args) {
	Connection conn=null;
	try {
		conn=DBUtils.getConnection();
		String sql="select * "
				+ "from robin_demo "
				+ "where name like ?";
		PreparedStatement ps=
				conn.prepareStatement(sql);
		ps.setString(1, "%s%");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			//get对应方法传入的参数可以是列名的字符串格式，也可以是列名的序号
			//getInt(列的序号)
			int id=rs.getInt(1);
			String name=rs.getString(2);
			System.out.println(id+","+name);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		DbUtils.close(conn);
	}

	}

}
