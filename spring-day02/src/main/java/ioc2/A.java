package ioc2;

//测试构造器注入
public class A {

	//若是A想调用B类方法
	//构造器注入
	private B b;
	
	//A类的有参构造器
	//传入B对象，在xml文件中配置就可以成功注入
	

	public A() {
		System.out.println("A()");
	}

	public A(B b) {
		System.out.println("A(B)");
		this.b = b;
	}
	
	public void exe(){
		System.out.println("exe()");
		b.f1();
	}
}
