package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SysdateTag extends SimpleTagSupport {

//声明私有变量，方便用户修改
private String format="yyyy/MM/dd HH:mm:ss";
 
 
public String getFormat() {
	return format;
}


public void setFormat(String format) {
	this.format = format;
}


	@Override
	public void doTag() throws JspException, IOException {
		//创建系统时间
		Date date=new Date();
		SimpleDateFormat sdf=
				new SimpleDateFormat(format);
		String now=sdf.format(date);
		
		//将时间输出给浏览器
		//以前的做法是通过response的getWriter
		//但是这里没有request和response参数
		//这里获取输出流的方法是继承父类的getJspContext
		//该方法声明返回的是JspContext
		//但实际返回的是pageContext
		//pageContext继承于JspContext
		//需要强转为子类型,大转小要强转
		//pageContext是JSP隐含对象中的管理者
		//可以获取其他8个对象
		
		//这是一个JSP的doTag()输出的模板套路
		PageContext context=
				(PageContext) getJspContext();
		JspWriter out=context.getOut();
		out.println(now);
		//这里的流不要关闭,
		//因为JSP上还有标签要使用这个流
	}

}
