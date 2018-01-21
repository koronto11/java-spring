package tedu.cn.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;

import tedu.cn.jdbc.DBUtils;
import tedu.cn.jdbc.day01.DbUtils;

/**
 * 执行一批DML语句
 * @author Administrator
 *
 */
public class Demo05 {

	public static void main(String[] args) {
		String sql="insert into log_02 "
				+ "(id,msg) "
				+ "values (?,?) ";
		
        Connection conn=null;
        try {
			conn=DbUtils.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement sta=conn.prepareStatement(sql);
			//每替换一次参数，都要调用addbatch添加一次缓冲区
			//这就是PreparedStatement添加sql到缓冲区的步骤
			
			
			/*sta.setInt(1, 1);
			sta.setString(2, "pgone");
			sta.addBatch();
			
			sta.setInt(1, 2);
			sta.setString(2, "bridge");
			sta.addBatch();
			int[] arg=sta.executeBatch();
			System.out.println(Arrays.toString(arg));
			*/
			
			for(int i=0;i<100;i++){
				sta.setInt(1, i);
				sta.setString(2, "msg"+i);
				sta.executeBatch();
				if((i+1)%8==0){
					int[] arg=sta.executeBatch();
					sta.clearBatch();
					System.out.println(Arrays.toString(arg));
				}
				int[] arg=sta.executeBatch();
				System.out.println(Arrays.toString(arg));
			}
			
			
			
			
			conn.commit();
			
			/*
			 * 结果返回[1, 1]
			 * 就是代表DML语句更新行数
			 * 这个与DDL语句的返回结果不一样
			 * 因为DDL的execute()没有返回值
			 * 而executeBatch是面向所有SQL语句
			 * 包括DDL,DML
			 * 查询java手册即可了解返回值具体参数
			 * 
			 * 结果返回[-2, -2]
			 * 则也表示成功，只不过是未知更新行数
			 */
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally{
			DbUtils.close(conn);
		}
	}

}
