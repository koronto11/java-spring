package tedu.cn.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tedu.cn.jdbc.DBUtils;
import tedu.cn.jdbc.day01.DbUtils;


/**
 * 双表关联
 * 提取主键
 * 
 * 模拟演示过程
 * 
 * @author Administrator
 *
 */
public class Demo06 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DbUtils.getConnection();
			conn.setAutoCommit(false);
			
			String sql="insert into keywords "
					+ "(id,word) values "
					+ "(k_seq.nextval,?) ";
			//new String[]{"id"}为自动生成序列的那个列名
			//为什么是String[]数组，因为主键也可能不只一个
			PreparedStatement ps=
					conn.prepareStatement(sql,new String[]{"id"});
			ps.setString(1,"pgone");
			int n=ps.executeUpdate();
			if(n!=1){
				throw new Exception("话题添加失败！");
			}
			//拿出自动生成的主键
			ResultSet rs=ps.getGeneratedKeys();
			int id=-1;//一定要将局部变量定义在外面，不然取不出来
			while(rs.next()){
				id=rs.getInt(1);
			}
			
			
			rs.close();
			ps.close();
			
			
			String sql1="insert into post"
					+ "(id,content,k_id) values"
					+ "(p_seq.nextval,?,?)";
			ps=conn.prepareStatement(sql1);
			ps.setString(1, "我超喜欢");
			ps.setInt(2, id);
			n=ps.executeUpdate();
			if(n!=1){
				throw new Exception("编写失败");
			}
			conn.commit();
			System.out.println("ok!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.rollback(conn);
		}

	}

}
