package tedu.cn.jdbc.day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DbUtils.getConnection();
			Statement sta=conn.createStatement();
			String sql="SELECT * FROM emp";
			ResultSet rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("empno");
				String name=rs.getString("ename");
				String job=rs.getString("job");
				int mgr=rs.getInt("mgr");
				double salary=rs.getDouble("sal");
				double comm=rs.getDouble("comm");
				int deptno=rs.getInt("deptno");
				String hiredate=rs.getString("hiredate");
				//输出结果
				System.out.println(id+","+name+","+job
						+","+mgr+","+salary+","+comm+","+deptno+","+hiredate);
			}
			
			//这两个close可以不调用，但是如果不释放，内存压力大
			//结果集用完后建议立即释放
			//conn释放后这两个close也会自动释放
			rs.close();//释放查询结果
			sta.close();//释放语句对象
		} catch (Exception e) {
			e.printStackTrace();
		} finally{   //在finally中关闭最可靠，因为是必须执行
			/*try {
				if(conn!=null){  //if判断用于空指针异常抛出
				conn.close();    //双重try-catch来进行抛异常
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
			//上面那一坨双重try-catch抛可以用另一种方法代替
			//用DbUtils的close方法来封装刚刚的繁琐步骤
			//这样整体就很严谨的代码，标准结构
			DbUtils.close(conn);
		}
	}

}
