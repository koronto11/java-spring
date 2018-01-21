package tedu.cn.jdbc.day01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * properties类 其目的就是为了
		 * 读取.properties文件而设计的
		 * 因为我们才命名为.properties文件储存数据
		 * 其底层就是文件IO
		 * properties本身实现了Map接口
		 * 其内部是散列表结构
		 * 限定key和value都是String字符串类型
		 * 只能存字符串格式
		 * 
		 * 
		 * 其用到的方法有
		 * load(流对象) 将文件读取为散列表
		 * String getProperties(key) 查询key所对应value
		 * 
		 * 调用Properties的API来读取.properties文件
		 * 比起用普通的高级流BufferedReader来读取要快速的多
		 * 因为这个API就是为了读取.properties文件资源而存在的
		 * 
		 * 
		 */
         
		
		
		//1.创建properties对象,其本质就是一个散列表
		Properties cfg=new Properties();
		
		System.out.println(cfg);
		System.out.println(cfg.size());
		System.out.println(cfg.isEmpty());
		
		//2利用load来读取properties文件
		//使用类加载的方式来加载类包中的resources资源
		InputStream in=
				PropertiesDemo.class.getClassLoader()
				.getResourceAsStream("db.properties");//配置文件的加载方式
		cfg.load(in);
		System.out.println(cfg);
		System.out.println(cfg.size());
		
		//查找文件内容
		String driver=cfg.getProperty("jdbc.driver");
		System.out.println(driver);
		
		String url=cfg.getProperty("jdbc.url");
		String username=cfg.getProperty("jdbc.username");
		String password=cfg.getProperty("jdbc.password");
		
		
		
	}

}
