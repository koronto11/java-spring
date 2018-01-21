package tedu.cn.jdbc.day03;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import tedu.cn.jdbc.DBUtils;
import tedu.cn.jdbc.day01.DbUtils;

/**
 * 模拟批量更新操作
 * 
 * 执行一批DDL语句
 * @author Administrator
 *
 */
public class Demo04 {

	public static void main(String[] args) {
	    //按月分的表
		String sql1="create table log_01 "
				+ "(id number(8), "
				+ "msg varchar2(100))";
		String sql2="create table log_02 "
				+ "(id number(8), "
				+ "msg varchar2(100))";
		String sql3="create table log_03 "
				+ "(id number(8), "
				+ "msg varchar2(100))";
		//执行一批SQL
		Connection conn=null;
		try {
			conn=DbUtils.getConnection();
			conn.setAutoCommit(false);
			
	        Statement sta=conn.createStatement();
			//addbatch只是将SQL语句放入Statement的缓存区，不执行
	        sta.addBatch(sql1);
			sta.addBatch(sql2);
			sta.addBatch(sql3);
			/*
			 * 当调用了executeBatch才会批量发送给数据库
			 * Statement的executeBatch方法返回的是一个int数组
			 * 
			 * 将一批命令提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。返回数组的 int 元素的排序对应于批中的命令，批中的命令根据被添加到批中的顺序排序。方法 executeBatch 返回的数组中的元素可能为以下元素之一：
             *大于等于 0 的数 - 指示成功处理了命令，是给出执行命令所影响数据库中行数的更新计数
             *SUCCESS_NO_INFO 的值 - 指示成功执行了命令，但受影响的行数是未知的
             *如果批量更新中的命令之一无法正确执行，则此方法抛出 BatchUpdateException，并且 JDBC 驱动程序可能继续处理批处理中的剩余命令，也可能不执行。无论如何，驱动程序的行为必须与特定的 DBMS 一致，要么始终继续处理命令，要么永远不继续处理命令。如果驱动程序在某一次失败后继续进行处理，则 BatchUpdateException.getUpdateCounts 方法返回的数组将包含的元素与批中存在的命令一样多，并且其中至少有一个元素将为：

             *EXECUTE_FAILED 的值 - 指示未能成功执行命令，仅当命令失败后驱动程序继续处理命令时出现
			 */
		
			int[] ary=sta.executeBatch();
			System.out.println(Arrays.toString(ary));
			
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//注意DDL语句是不能回滚操作的
			
		}finally{
			DbUtils.close(conn);
		}

	}

}
