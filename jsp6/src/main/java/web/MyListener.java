package web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener,ServletRequestAttributeListener {

	public void requestDestroyed(ServletRequestEvent e) {
		//request销毁前的那一刻自动调用此方法
		System.out.println("销毁request");

	}

	public void requestInitialized(ServletRequestEvent e) {
		//tomcat创建request时自动调用此方法
	    System.out.println("创建request");
		System.out.println(
		        e.getServletRequest());

	}

	public void attributeAdded(
			ServletRequestAttributeEvent e) {
		
	System.out.println("向request内添加一个值");	
	}

	public void attributeRemoved(
			ServletRequestAttributeEvent e) {
		
		
	}

	public void attributeReplaced(
			ServletRequestAttributeEvent e) {
		
		
	}

}
