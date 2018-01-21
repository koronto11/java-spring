package annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 通过注解创建对象 
 * 
 * Component("sb")组件扫描，后面括号指定id
 * Scope指定作用域
 * @author Administrator
 *
 */
@Component("sb")
//@Scope("prototype")
public class SomeBean {

	//Spring容器帮我们创建对象的两大前提
	//类有无参构造器和配置对应的bean方法
	//利用组件扫描我们可以省略配置bean这个过程
	public SomeBean() {
		System.out.println("SomeBean()");
	}
	
	//初始化方法
	@PostConstruct
	public void init(){
		System.out.println("init()");
	}
	
	//销毁方法
	@PreDestroy
	public void destroy(){
		System.out.println("destroy()");
	}

}
