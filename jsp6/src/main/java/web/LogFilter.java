package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Filter过滤器
 * 专门用于处理公共请求
 * 
 * doFilter一定要写
 * init和destroy方法一般不写
 * @author Administrator
 *
 */
public class LogFilter implements Filter {

	public void destroy() {
		//销毁LogFilter
		System.out.println("销毁LogFilter");
	}

	//该方法是处理公共业务的方法
	public void doFilter(
			ServletRequest req, 
			ServletResponse res, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("在前面记日记");
		chain.doFilter(req, res);
		System.out.println("在后面记日记");
	}

	//参数FilterConfig和servletConfig作用一样
	//servletConfig用于为servlet提供数据
	//FilterConfig用于为Filter提供数据
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化LogFilter");

	}

}
