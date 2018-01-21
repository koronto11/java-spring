package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import entity.Emp;
import entity.Emp2;

/**
 * 这个接口就叫Mapper映射器
 * @author Administrator
 *
 */
@Repository("eDAO")
public interface EmpDAO {

  //Mapper映射器中的方法的方法名，参数列表，返回类型
  //要与映射文件中的sql的id，parameterType，resultType保持一致
  public void save(Emp emp);
  public List<Emp> findAll();
  public Emp findById(int id);
  public void modify(Emp emp);
  public void delete(int id);
  public Map findById2(int id);
  public Emp2 findById3(int id);
}
