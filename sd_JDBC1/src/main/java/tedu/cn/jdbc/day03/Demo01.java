package tedu.cn.jdbc.day03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import tedu.cn.jdbc.DBUtils;

/**
 * 案例演示结果集以及元数据
 * ResultSetMetaData接口
 * 针对ResultSet进行操作
 * 获取列的编号，类型及属性等信息
 * @author Administrator
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DBUtils.getConnection();
			
			String sql="select * from robin_user";
			Statement sta=conn.createStatement();
			ResultSet rs=sta.executeQuery(sql);
			ResultSetMetaData rsm=rs.getMetaData();
			int columnCount=rsm.getColumnCount();
			System.out.println(columnCount);
			
			String columnName=null;
			for(int i=1;i<=columnCount;i++){
				columnName=rsm.getColumnName(i);
				System.out.println(columnName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn);
		}

	}

}
