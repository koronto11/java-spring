package ioc;

public class A {
    //添加一个属性，成员变量
	private IB b;
	
    //若是A想调用多个类的方法
	//那统一创建一个接口IB，然后调用的类去实现这个接口
	//在set方法的参数列表里就可以传入接口类型
	public void setB(IB b) {
    	System.out.println("setB()");
    	this.b = b;
	}

	public A() {
		System.out.println("A()");
	}

	//A类的execute()方法需要去调用B的f1()方法
	public void execute(){
		
		System.out.println("execute()");
		b.f1();
	}
}
