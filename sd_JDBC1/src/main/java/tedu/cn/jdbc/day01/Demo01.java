package tedu.cn.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Demo01 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
        System.out.println("ok!");
        
        //连接到数据库
        String url="jdbc:oracle:thin:"
        		+ "@localhost:1521:xe";
        String username="system";
        String password="294823013";
        /*
         * getConnection方法去查找并尝试去连接到数据库
         * 若不成功则会报异常
         */
        
        Connection conn=
        		DriverManager.getConnection(
        				url,username,password);
        //输出conn引用对象的实际类型
        //用于证明驱动程序提供了Connection接口的实现类
        System.out.println(conn.getClass());
        
        //创建语句对象,statement是一个接口
        Statement st=conn.createStatement();
        
        //执行SQL语句
        String ddl="drop table robin_demo2";
        boolean ft=st.execute(ddl);
        //返回true：表示有结果集，false表没有结果集
        //创建失败则会抛出异常,所以说true不是返回创建成功
        //false和true只是代表有无结果集
        //如果没有异常则创建成功！
        //创建出的表在sqldeveloper中可以查得到
        System.out.println(ft);
        
        conn.close();
	}

}
