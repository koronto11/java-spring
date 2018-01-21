package entity;

import java.io.Serializable;

/**
 * 实体类course，满足javaBean规范
 * 有包，默认构造器，序列化接口
 * @author Administrator
 *
 */
public class Course implements Serializable {

	//声明内部参数
	private Integer courseId;//课程id
	private String name;//课程名字
	private Integer days;//课程天数
	public Integer getId() {
		return courseId;
	}
	public void setId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
}
