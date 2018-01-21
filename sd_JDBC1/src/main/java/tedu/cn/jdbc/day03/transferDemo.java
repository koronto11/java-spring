package tedu.cn.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tedu.cn.jdbc.DBUtils;

public class transferDemo {

	public static void main(String[] args) {
		try{
			//运行前要保证数据库是commit状态
			//若是中间状态则会锁定数据
			transfer(2,1,5000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 编写一段代码，用于封装一段汇款的SQL语句方法
	 * 
	 * 利用事务的标准模板来编写
	 * 
	 * 安全性好
	 * 能够人为控制抛异常机制
	 * 统一提交
	 * 及时回退操作
	 * 
	 */
   public static void transfer(
		   int id1,int id2,double money)throws Exception{
	   /*
	    * 用一个UPDATE语句调用两次就可以实现转账功能
	    */
	   String sql1="update account "
	   		+"set balance=balance+? "
	   		+"where id=? ";
	   String sql2="select balance from account "
	   		+ "where id=? ";
	   Connection conn=null;
	   try {
		 conn=DBUtils.getConnection();
		 conn.setAutoCommit(false);
		 
		 /*
		  *检查源账户是否发生透支
	     */
		 PreparedStatement ps=
					conn.prepareStatement(sql2);
		 ps.setInt(1, id1);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 double m=rs.getDouble(1);
			 if(m<money){
				 throw new Exception("余额不足！");
			 }
		 }
		 ps.close();
		 /*
		  * 这里有个小技巧
		  * ps这个引用在上面已经引用过了
		  * 这里用close将其关闭
		  * 然后在下面再用PreparedStatement时就可以重用了
		  * 省去一个建立引用的步骤
		  * 重用引用
		  * 节省资源，提高资源利用率
		  * 
		  * 相当于之前的执行计划关闭掉
		  * 再次重用就是新的执行计划
		  */
		 
		 ps=conn.prepareStatement(sql1);
		 //扣款
		 ps.setDouble(1, -money);
		 ps.setInt(2, id1);
	     int n=ps.executeUpdate();
		 if(n!=1){
			 //若是返回结果不是1，则表示在数据库中没有更新数据
			 //给一个if判断，当用户谁错用户名时
			 throw new Exception("扣错了！");
		 }
		 
		 //转款
		 ps.setDouble(1, money);
		 ps.setInt(2, id2);
		 n=ps.executeUpdate();
		 if(n!=1){
			 throw new Exception("转账账户错了");
		 }
		 
		
		conn.commit();
		
		System.out.println(sql1);
		System.out.println("转账成功！");
	} catch (Exception e) {
		e.printStackTrace();
		DBUtils.rollback(conn);
	} finally{
		DBUtils.close(conn);
	}
   }
}
