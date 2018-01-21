package first;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {

	public static void main(String[] args) {
		//启动Spring容器
		ApplicationContext ac=
				new ClassPathXmlApplicationContext(
						"applicationContext.xml");
        //System.out.println(ac);
        //获得对象
		//getBean方法返回值类型是Object
		//大转小需要强转成所返回的类型
		//强转还可以在getBean参数列表中加一个Student.class
		//跟(Student)作用是一样的
		//这样就可以省去了new的过程
		//交由Spring来帮我们创建对象
		//根据id来寻找所对应的类中的无参构造器方法
        Student stu=ac.getBean("stu1",Student.class);
        //会输出无参构造器中的内容还有一些对象信息
        System.out.println(stu);
        
        //调用java自带的类Date，里面有无参构造器
        //输出系统时间
        //用getBean取代new，Spring容器帮我们new
        Date date=ac.getBean("date",Date.class);
        System.out.println(date);
	}

}
