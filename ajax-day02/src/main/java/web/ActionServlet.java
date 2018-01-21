package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Stock;
import net.sf.json.JSONArray;

public class ActionServlet extends HttpServlet{

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()");
		String uri=request.getRequestURI();
		System.out.println("uri"+uri);
		String action=uri.substring(uri.lastIndexOf("/"), 
				                          uri.lastIndexOf("."));
		//输出检测
		System.out.println("action:"+action);
		
		//针对不同的action(路径)进行不同的处理
		//先设置响应的字符集编码
		response.setContentType("text/html;charset=utf-8");
		//然后创建输出流
		PrintWriter out=response.getWriter();
		//判断路径
		if("/quoto".equals(action)){
			//模拟生成json字符串，几只股票信息
			List<Stock> stocks=
					new ArrayList<Stock>();
			Random r=new Random();
			//8条数据添加到集合中
			for(int i=0;i<8;i++){
				Stock s=new Stock();
				s.setCode("80087" + r.nextInt(10));
				s.setName("中国石化" + r.nextInt(10));
				s.setPrice(1000 + r.nextInt(1000));
				stocks.add(s);
			}
			//fromObject()方法的参数可以是数组也可以是集合
			//若是单一一个 实体类就用JSONObject对象
			JSONArray jsonArr=JSONArray.fromObject(stocks);
			String jsonStr=jsonArr.toString();
			System.out.println(jsonStr);
			//服务端将处理好的json字符串响应给浏览器进行处理
			out.println(jsonStr);
			
		}else if("/luck".equals(action)){
			//生成随机数然后发送给浏览器
			Random r=new Random();
			int num=
					r.nextInt(8888);
			System.out.println(num);
			out.println(num);
		}

	}
}
