package tedu.cn.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 这个DbUtils与单线程连接的机制不一样
 * 加入了连接池技术
 * @author Administrator
 *
 */
public class DBUtils {
    //部署静态变量 
	private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static int initSize;
    private static int maxActive;
    //数据库连接池作为静态变量创建，全局只需要创建一个
    private static BasicDataSource ds;
    //用文件流的方法读取配置信息并赋值给静态分量
    static{
    	try {
    		//区别于单连接，这次用的是BasicDataSource连接池
        	//因为连接池只需要创建一个就好，并不需要程序运行就创建，这也耗费资源
        	ds=new BasicDataSource();
    		
    		Properties cfg=new Properties();
			InputStream in=DBUtils.class.getClassLoader().
					getResourceAsStream("db.properties");
			cfg.load(in);
			
			driver=cfg.getProperty("jdbc.driver");
			url=cfg.getProperty("jdbc.url");
			username=cfg.getProperty("jdbc.username");
			password=cfg.getProperty("jdbc.password");
			initSize=Integer.parseInt(cfg.getProperty("jdbc.initSize"));
			maxActive=Integer.parseInt(cfg.getProperty("jdbc.maxActive"));
			
			in.close();
			
			//初始化连接池
			//设置必要参数
	    	ds.setDriverClassName(driver);
	    	ds.setUrl(url);
	    	ds.setUsername(username);
	    	ds.setPassword(password);
	    	
	    	//设置管理参数
	    	ds.setInitialSize(initSize);
	    	ds.setMaxActive(maxActive);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static Connection getConnection(){
    	try{
    	//用连接池对象来获取Connection
        //从连接池中获取重用的连接
    	//若连接池满了，则进入阻塞等待
    	//若有连接归还，则获取重用的连接
    	Connection conn=ds.getConnection();
    	//返回得到的Connection对象
    	return conn;
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    }
    
    public static void close(Connection conn){
    	try{
    		//这是归还连接给连接池
    		if(conn!=null){
    			conn.close();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public static void rollback(Connection conn){
    	if(conn!=null){
    		try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }
    
}
