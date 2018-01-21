package tedu.cn.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tedu.cn.jdbc.DBUtils;
import tedu.cn.jdbc.day01.DbUtils;

/**
 * 模拟事务
 * 用JDBC来执行数据库事务
 * 但是底层还是由数据库来是实现的
 * 
 * 事务运行标准模式
 * 经典的事务编程式写法
 * @author Administrator
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DBUtils.getConnection();
			//取消自动提交，后续手动提交
			conn.setAutoCommit(false);
			
			//我们在固定的事务编程模板中编写代码
			//将具体的事务代码写在中间的sql语句中
			//sql...
			
			//执行的一堆sql操作...
			/*
			 * 若是在sql操作时发生异常，例如余额不足
			 * 抛出异常 throw e；
			 * 就会被catch到然后rollback
			 * 就是说我们如果在某一环节出错
			 * 只要抛出异常即可
			 */
			
			//sql...
			
			//待全部sql处理完后，再一起提交commit
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			//避免空指针异常还要做一个非空判断才完整
			
				/*
				 * 将rollback写在异常中
				 * 那么发生异常时就会执行rollback
				 * 将之前的所有sql操作回退取消
				 * 这样避免了系统因为外部异常情况
				 * 比如断电或者服务器信号中断而导致的数据丢失
				 * 一旦发生异常而catch掉
				 * 回退所有操作
				 * 
				 * rollback方法封装
				 * 在DBUtils中
				 * 
				 */
			DBUtils.rollback(conn);	 
		} finally{
			DbUtils.close(conn);
		}

	}
	
	
	
}
