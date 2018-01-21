package tedu.cn.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 执行DML语句
 * @author Administrator
 *
 */
public class Demo02 {

	public static void main(String[] args)throws Exception {
	//1导入驱动 OracleDriver
	//2注册驱动
	Class.forName("oracle.jdbc.OracleDriver");
	//3连接数据库
	String url="jdbc:oracle:thin:"
			+ "@localhost:1521:xe";
	String username="system";
	String password="294823013";
	
	Connection conn=
			DriverManager.getConnection(url, username, password);
	
	System.out.println(conn.getClass());
	
	//4建立语句对象
	Statement sta=conn.createStatement();
	
	//5输出语句,不要用分号结尾，否则会有麻烦：无效字符
	String dml="delete robin_demo "
			+ "where id=1";
	int num=sta.executeUpdate(dml);
	System.out.println(num);
	
	//6关闭数据库，必须做的流程
	conn.close();
	

	}

}
