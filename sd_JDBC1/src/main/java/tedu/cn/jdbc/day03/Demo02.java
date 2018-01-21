package tedu.cn.jdbc.day03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import tedu.cn.jdbc.DBUtils;

public class Demo02 {

	public static void main(String[] args) {
		String sql="select * from robin_user";
		print(sql);
	}
    /*
     * 打印一个查询结果的全部列名
     * 内部的System.out.println来打印输出
     * 
     */
	public static void print(String sql){
    	Connection conn=null;
    	try {
			conn=DBUtils.getConnection();
			Statement sta=conn.createStatement();
			ResultSet rs=sta.executeQuery(sql);
			ResultSetMetaData rsm=rs.getMetaData();
			int columnCount=rsm.getColumnCount();
			for(int i=1;i<=columnCount;i++){
				String columnName=rsm.getColumnName(i);
				System.out.println(columnName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn);
		}
    }
}
