package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Emp;



@Repository("empDAO")
public class EmpDAO {
	
	//注解注入JdbcTemplate，然后就可以使用里面的方法了
	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	
	//添加数据进数据库
	public void save(Emp emp){
		//sql语句
		String sql="insert into emplist "
				+ "values(emplist_seq.nextval,?,?)";
		//声明一个Object对象数组，目的是给sql语句中的问号赋值
		//将参数Emp的值给这个object数组
		Object[] params=
				new Object[]{
						emp.getName(),emp.getAge()};
		//将sql和这个Object数组传进去即可
		template.update(sql,params);
	}
	
	//查询全部内容
	public List<Emp> findAll(){
		//新建集合，将取得的数据存入这个集合返回
		List<Emp> emps=
				new ArrayList<Emp>();
		String sql="select * from emplist";
		emps=
			template.query(sql, new EmpRowMapper());
		return emps;
		
	}
	
	//告诉JdbcTemplate如何将ResultSet中的一条记录
	//转换为对应的entity实体对象
	//这个类形容一种具体的行为方式
	
	//RowMapper的泛型就是那个实体对象
	class EmpRowMapper implements RowMapper<Emp>{

		//重写一个RowMapper方法mapRow，其返回值就是那个实体类型
		//第一个参数是ResultSet结果集
		//而第二个int参数则是下标,一般用不上这个参数
		//这个下标是记录的下标指向某一条记录
		//因为结果集中有多条记录，从0开始
		public Emp mapRow(
				ResultSet rs, 
				int index) throws SQLException {
			Emp emp=new Emp();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			return emp;
		}
		
	}
	
	
	
	//条件查询
	public Emp findById(int id){
		Emp emp=new Emp();
		String sql="select * from emplist "
				+ "where id=? ";
		//即便是只有一个参数也要用数组传数据
		Object[] args=
				new Object[]{id};
		try{
		emp=
             template.queryForObject(
            		 sql, args, new EmpRowMapper());
		}catch(Exception e){
			e.printStackTrace();
			//这里因为会找不到对应的数据
			//所以这里返回null
			return null;
		}
		return emp;
		
	}
	
	//条件查询2
		public Emp findById2(int id){
			Emp emp=new Emp();
			String sql="select * from emplist "
					+ "where id=? ";
			//即便是只有一个参数也要用数组传数据
			Object[] args=
					new Object[]{id};
			//因为template的queryForObject找不到数据会报异常
			//而query()方法即使取不到也不会报异常
			//这里用一个List来接收参数，再取参数的第一条记录便可
			//这样也可以避免异常
			List<Emp> emps=
					template.query(sql, args,new EmpRowMapper());
			if(emps!=null && emps.size()>0){
				emp=emps.get(0);
			}
			return emp;
			
		}
		
	//修改数据
	public void modify(Emp emp){
		String sql="update emplist set "
				+ "name=?,age=? where id=? ";
		Object[] args=
				new Object[]{
						emp.getName(),
						emp.getAge(),
						emp.getId()};
		//更改数据update方法
		template.update(sql,args);
	}
	
	//删除某条数据
	public void delete(int id){
		//根据id来删除
		String sql="delete from emplist "
				+ "where id=?";
		Object[] args=
				new Object[]{id};
		//删除还是用update
		template.update(sql,args);
	}
}
