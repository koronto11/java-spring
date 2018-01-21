package tedu.cn.jdbc.day01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 用于封装JDBC注册以及连接数据库步骤 
 * 简化操作
 * 
 * 我们用到的4个参数一般来说是连接固定不变的
 * 怎么样才能优化使得代码重用性能更好
 * 不用动源代码就可以修改参数值
 * 
 * @author Administrator
 *
 */
public class DbUtils {
  //用静态方法来封装，返回值为Connection类型
	
	//还没有进行初始化
	static String driver;
	static String url;
	static String username;
	static String password;
	
	//如何初始化静态代码串
	//用静态代码块
	static{
		//初始化静态属性,从配置文件dbproperties中提取参数值
		//用Properties读取文件流资源的形式来获取数据库连接参数
				//进一步简化并增加了代码的灵活性
		try{		
		Properties cfg=new Properties();
		InputStream in=DbUtils.class.getClassLoader()
						.getResourceAsStream("db.properties");
		cfg.load(in);
		driver=cfg.getProperty("jdbc.driver");
		url=cfg.getProperty("jdbc.url");
		username=cfg.getProperty("jdbc.username");
		password=cfg.getProperty("jdbc.password");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 4个不变参数用作静态变量，需要加static关键字才能在
	 * 静态方法getConnection中使用
	 * 静态变量只有一份，全局共有
	 * 静态局部变量在函数内定义，
	 * 但不像自动变量那样，当调用时就存在，
	 * 退出函数时就消失。静态局部变量始终存在着，
	 * 也就是说它的生存期为整个源程序。
	 * 这样做性能更好
	 * 
	 * 但是这样又带来一个新的问题
	 * 变量数据在程序中是写死的，不利用方法的重用优化
	 * 我们可以考虑读文件的形式，将这四个参数放置在文件中
	 * 以读取的方式来调用文件
	 * 
	 * 也可以采用XML文档的方式
	 */
	//static String driver="oracle.jdbc.OracleDriver";
	//static String url="jdbc:oracle:thin:@localhost:1521:xe";
	//static String username="system";
	//static String password="294823013";
	
	/*
	 * 读取文件中的数据库连接参数，便于数据修改
	 * 需要修改时直接修改Setting配置文件即可
	 * 这种做法叫做消除软件中的硬编码
	 * 将一些重复率高或者需要多方应用的代码
	 * 放置到配置文件中，这样可以避免硬编码问题
	 * 避免参数写死，不利于后期维护和利用
	 * 
	 * 一般我们关于这一个项目project所需要的文件或者图片资源
	 * 我们都放在resource这个资源中去
	 * 行业的命名规则为以.properties为后缀的文件
	 * 创建一个db.properties用于保存数据库连接信息
	 * 以#号开头为注释
	 * 尾部不能有分号不能有空格
	 * 也不能中文显示
	 * 也不能双引号
	 * 
	 * java提供API解决读取文本文件的方法
	 * 直接将文本文件读成Map
	 * 
	 */
    
	
	
	
	public static Connection getConnection(){
		try{
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(
				           url,username, password);
		return conn;
		}catch(Exception e){
			e.printStackTrace();
			/*
			 * e是这个异常引用
			 * 添加这个自抛异常的目的是
			 * 防止在try-catch中return没有执行到
			 * 这样就没有返回值了，而我么规定了必须要有
			 * 返回值，那么加上这个异常就是解决这个问题
			 * 要么程序正常运行返回conn要么抛异常
			 * 总之肯定有返回结果
			 * 意思就是给个解决机制
			 */
			throw new RuntimeException(e);
		}
	}
	
	//DbUtils的close方法封装
	/*
	 * 关闭数据库连接方法
	 * 封装close，这样我们在项目中使用这个静态方法
	 * 直接调用DbUtils.close(Connection)即可
	 */
	public static void close(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
