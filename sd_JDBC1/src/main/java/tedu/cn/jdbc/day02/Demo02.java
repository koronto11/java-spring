package tedu.cn.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import tedu.cn.jdbc.DBUtils;

public class Demo02 {

	public static void main(String[] args) {
		Connection conn=null;
		try{
		//从数据库连接池中获取连接，用于并发操作
		conn=DBUtils.getConnection();
		Statement sta=conn.createStatement();
		String dql="SELECT 'hello' as a "
				+ "from dual";
		ResultSet rs=sta.executeQuery(dql);
		while(rs.next()){
			String str=rs.getString("a");
			System.out.println(str);
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBUtils.close(conn);
	}

	}

}
