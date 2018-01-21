package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor {

	public void afterCompletion(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object obj, 
			Exception error)
			throws Exception {
		System.out.println("afterCompletion()");

	}

	public void postHandle(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object obj, 
			ModelAndView mav)
			throws Exception {
		System.out.println("postHandle()");

	}

	public boolean preHandle(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object obj) throws Exception {
		System.out.println("preHandle()");
		return true;
	}

}
