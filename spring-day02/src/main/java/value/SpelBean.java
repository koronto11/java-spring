package value;

public class SpelBean {

	private String name;
	private String city;
	private Double score;
	private String pagesize;
	
	public SpelBean() {
		System.out.println("SpelBean()");
	}
	@Override
	public String toString() {
		return "SpelBean [name=" + name + ", city=" + city + ", score=" + score + ", pagesize=" + pagesize + "]";
	}
	//用Spring表达式来读取Bean对象数据
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public String getCity() {
		return city;
	}
	public Double getScore() {
		return score;
	}
	public String getPagesize() {
		return pagesize;
	}
}
