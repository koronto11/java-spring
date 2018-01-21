package scope;

public class MessageBean {

	public MessageBean() {
		System.out.println("MessageBean()");
	}

	//作为初始化回调方法
	public void init(){
		System.out.println("init()");
	}
	
	public void sendMsg(){
		System.out.println("sendMsg()");
	}
	
	public void destroy(){
		System.out.println("释放资源");
	}
}
