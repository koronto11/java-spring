package tedu.cn.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 连接池项目
 * 导入包commons-dbcp-1.4-jar
 * 
 * @author Administrator
 *
 */
public class Demo01 {

	public static void main(String[] args) throws SQLException {
	//导入DBCP驱动
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String username="system";
	String password="294823013";
	
	BasicDataSource ds=
			new BasicDataSource();
	
	//设置必须的参数
	ds.setDriverClassName(driver);
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);
    
    //设置了连接池的管理策略参数,根据实际情况反馈测试的数据
    ds.setInitialSize(2);//规定初始化两个连接数
    ds.setMaxActive(20);//最大活跃连接数
  
    //使用连接池中的数据库连接
    Connection conn=ds.getConnection();
    
    //创建语句对象
    Statement sta=conn.createStatement();
    
    //执行SQL语句
    String dql="select 'hello' as a "
    		+ "from dual";
    ResultSet rs=sta.executeQuery(dql);
    
    while(rs.next()){
    	String str=rs.getString("a");
    	System.out.println(str);
    }
    
    //归还连接到数据库连接池中，close方法
    conn.close();
    
    
	}

}
