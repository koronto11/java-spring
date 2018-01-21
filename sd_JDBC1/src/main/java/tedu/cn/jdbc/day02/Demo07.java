package tedu.cn.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import tedu.cn.jdbc.DBUtils;


/**
 * SQL注入攻击 演示
 * @author Administrator
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		//获取用户数据输入
		Scanner scan=new Scanner(System.in);
		System.out.print("请用户输入username:");
		String name=scan.nextLine();
		System.out.print("请用户输入password:");
		String pwd=scan.nextLine();
		//检查登陆情况
		boolean pass=login(name,pwd);
		
		//当pass为true时登陆成功
		if(pass){
			System.out.println("登陆成功！");
		}else{
			System.out.println("登陆不成功！");
		}
		
		/*
		 * 请用户输入username:tom
         * 请用户输入password:1' or '1'='1
         * SELECT COUNT(*) AS C 
         * FROM robin_user WHERE NAME='tom' 
         * AND PWD='1' or '1'='1' 
         * 登陆成功！
         * 
         * 这样子的程序漏洞太多
         * SQL注入攻击
         * 用万能密码也可以登陆成功
         * 这就是属于数据库层面上的安全防护不够
         * 
         * 原因是因为用户输入了含有SQL指令的参数
         * PWD='1' or '1'='1'
         * 这样不管用户名是什么
         * 都根据后面那个
         * or '1'='1'
         * or是同为假时才为假(一个为真就为真)
         * 这样就直接影响数据库
         * 参数在拼接SQL时候，造成SQL语句的语义更改
         * 因为我们是在JAVA中写SQL语句交给数据库进行识别
         * 只要将源代码中的SQL更改就可以影响数据库的查询结果
         * 改变SQL语句的执行计划
         * 最终的结果就会改变
         * 黑客通常会用这种方法对数据库进行攻击
         * 
         * 避免方法(如何规避SQL注入攻击)：
         * 1.避免用户输入SQL成分，拦截用户输入的SQL成分，立即拒绝服务(太不灵活)
         * 2.固定执行计划，避免改变执行逻辑(较灵活)
         *   --其实就是PreparedStatement
         *   --带参数的SQL，将执行计划固定然后发送给数据库
         *   --然后用户将参数带入，这样可以有效规避SQL注入攻击
		 */

	}
    //该boolean方法用于检测用户是否能够登陆
	public static boolean login(String name,String pwd){
    	//在这里,加号表示字符串相加,用字符串常量和变量合并成一个完整的SQL语句.
    	//因为name和pwd是灵活的，由用户输入
		//count方法用于反馈记录数
    	String sql="SELECT COUNT(*) AS C "+
    			"FROM robin_user "+
    			"WHERE NAME=\'"+name+
    			"\' AND PWD=\'"+pwd+"\' ";
    	
    	Connection conn=null;
    	System.out.println(sql);
    	try {
			conn=DBUtils.getConnection();
			Statement sta=conn.createStatement();
			ResultSet rs=sta.executeQuery(sql);
			while(rs.next()){
				int n=rs.getInt("c");
				if(n>=1){
					return true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
		}
    	//只要是boolean返回值方法，都要设置一个除正确其他情况下的返回结果
    	return false;
    }
}
 