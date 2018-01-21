package json;

import bean.Stock;
import net.sf.json.JSONObject;

public class JsonTest {

	//将java对象转换为Json字符串
	public static void test1(){
		Stock s=new Stock();
		s.setCode("800877");
		s.setName("中国嘉陵");
		s.setPrice(100);
		//使用json-lib来转换
		JSONObject jsonObj=
				JSONObject.fromObject(s);
		String jsonStr=jsonObj.toString();
		System.out.println(jsonStr);
	}
	
	public static void main(String[] args){
		test1();
	}
}
