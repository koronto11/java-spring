package tedu.cn.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import tedu.cn.jdbc.DBUtils;

/**
 * 用PreparedStatement来规避SQL注入攻击
 * 同样测试用户输入
 * @author Administrator
 *
 */
public class Demo08 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
        System.out.print("请用户输入用户名：");
        String name=scan.nextLine();
        System.out.print("请用户输入用户密码：");
        String pwd=scan.nextLine();
        
        boolean pass=login(name,pwd);
        if(pass){
        	System.out.println("登陆成功！");
        }else{
        	System.out.println("用户名和密码不匹配！");
        }
	}
public static boolean login(String name,String pwd){
	String sql="select count(*) as c "
			+ "from robin_user "
			+ "where name=? and pwd=? ";
	Connection conn=null;
	try {
		conn=DBUtils.getConnection();
		PreparedStatement ps=
				conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int n=rs.getInt("c");
			if(n==1){
				return true;
			}
		}
		System.out.println(sql);
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		DBUtils.close(conn);
	}
	return false;
	/*
	 * 请用户输入用户名：tom
     * 请用户输入用户密码：1' or '1'='1
     * select count(*) as c from robin_user where name=? and pwd=? 
     * 用户名和密码不匹配！
     * 
     * 这样就避免了SQL注入攻击
     * 规定了SQL的模式
     * 传进来的参数但当做字符串进行处理
     * 这样黑客传入的SQL语句就被当成规定的字符串
     * 就无法对数据库的SQL进行干预了
	 */
}
}
