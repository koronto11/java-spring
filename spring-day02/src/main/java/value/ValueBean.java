package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 演示参数值注入
 * @author Administrator
 *
 */
public class ValueBean {

	//先创建两个属性
	private String name;
	private int age;
	
	//创建List集合属性
	private List<String> city;
	
	public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> city) {
		this.city = city;
	}
	
	
	//创建Set集合类型
	private Set<String> interest;
	
	
	public Set<String> getInterest() {
		return interest;
	}
	public void setInterest(Set<String> interest) {
		this.interest = interest;
	}
	
	//创建Map集合类型
	private Map<String,Double> score;
	public Map<String, Double> getScore() {
		return score;
	}
	public void setScore(Map<String, Double> score) {
	    this.score = score;
	}
	
	//创建Properties类型
	private Properties db;
	public Properties getDb() {
		return db;
	}
	public void setDb(Properties db) {
		this.db = db;
	}
	@Override
	public String toString() {
		return "ValueBean [name=" + name + ", age=" + age + ", city=" + city + ", interest=" + interest + ", score="
				+ score + ", db=" + db + "]";
	}
	//要想通过容器帮我们给属性赋值
	//还是通过setter方法或者构造器方法
	//因为SpringIOC是根据属性名找到这个对应属性
	//而属性名就是get/set方法去掉get/set首字母小写的方法
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public ValueBean() {
		System.out.println("ValueBean()");
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	
}
