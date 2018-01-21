package entity;

public class Emp2 {

	private Integer empNo;
	private String ename;
	private Integer age;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp2 [empNo=" + empNo + ", ename=" + ename + ", age=" + age + "]";
	}
}
