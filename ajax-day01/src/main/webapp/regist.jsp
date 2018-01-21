<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script type="text/javascript"
  src="js/ajax.js">
  </script>
  <script type="text/javascript">
     function check_adminCode(){
    	 //step1:先获得ajax对象
    	 //在ajax.js文件中，外部引入
    	 var xhr=getXhr();
         //弹出这个xhr对象信息,测试js代码是否正确
         //当触发事件的时候会调用这个函数
       //alert(xhr);
         //step2:发送请求
         //a.准备工作(请求方式,发送地址?数据,是否异步)
         //因为是get方式发送
         //所以路径后面是要传递的数据
         //$F是取得根据该节点id取得对应的值
         var uri='check_admin.do?adminCode=' + $F('adminCode');
         //encodeURI是javascript函数，
         xhr.open('get',encodeURI(uri),true);
         //b.绑定事件处理函数
         //用于处理服务器返回数据并用于展现
         //因为事件处理函数也需要xhr对象进行判断
         //所以这里的事件处理函数直接用匿名函数来写就好
         xhr.onreadystatechange=function(){
        	 //step3是编写服务器端的相关带代码
        	 //step4编写事件处理函数
        	 if(xhr.readyState==4 && xhr.status==200){
        		 //通信状态为4，表示其完全收到服务端传来的数据
        		 //status为200，即表示成功
        		 var res=xhr.responseText;//返回的是文本
        		 //并将数据进行展示
        		// alert(res);弹出警告的方式不友好
        		 //先找到要显示的位置span标签
        		 //innerHTML是输出文本信息
        		 $('adminCode_msg').innerHTML=res;
        	 }
         };
         //c.发送
         //get方式的参数是null，post则是数据
         xhr.send(null);
    	 
     }
     
    
  </script>
</head>
<body style="font-size:25px;">
   <form method="post" action="regist.do">
      <!-- onblur触发事件 
                     某元素失去活动焦点时产生该事件。
                     例如鼠标在文本框中点击后
                     又在文本框外点击时就会产生这个事件。
                     触发这个check_adminCode()方法 -->     
           账号<input type="text" id="adminCode" name="adminCode"
           onblur="check_adminCode();"/>
           <!-- 用行内元素标签来显示ajax交互结果 -->
           <span id="adminCode_msg"></span>
           <br>
           密码<input type="password" name="pwd"/><br>
         <input type="submit" value="确定"/>     
   </form>
</body>
</html>