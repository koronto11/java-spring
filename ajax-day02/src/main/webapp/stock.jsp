<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <style>
  #d1{
    width:450px;
    height:350px;
    background-color:black;
    margin-top:20px;
  }
  #d2{
    height:40px;
    background-color:red;
    color:yellow;
    
  }
  table{
    color:white;
    font-style:italic;
    font-size:24px;
  }
 </style>
 <!-- 利用jQuery框架来完成对节点的操控 -->
 <script type="text/javascript" 
         src="js/jquery-1.11.1.js"></script>
 <script type="text/javascript">
  //定时器实现实时更新数据
  //相当于window.onload(function(){});页面加载完毕时执行代码
  $(function(){
	  //周期性定时器,以时间参数作为循环执行quoto函数
	  var SID=setInterval(quoto,3000);
  });
  /*
   该函数通过调用ajax对象(XMLHttpRequest)
   向服务器发送异步请求，然后服务器返回一个JSON字符串
   通过解析字符串获得信息然后更新页面信息
  */
  function quoto(){
	  //利用jQuery提供的方法来向服务器发送请求
	  $.ajax({
		  //url发送请求，然后服务器就会返回数据
		  "url":"quoto.do",
		  "type":"post",
		  "dataType":"json",
		  "success":function(stocks){
			  //事件处理函数
			  //dataType会自动将json字符串转换为js对象
			  //success指定的这个匿名函数中的参数
			  //就是经过jquery转换的那个javascript对象
			  
			  //追加数据之前要先清空之前的表格内容tbody
			  //不是remove而是empty。数据清空
			  $('#tb1').empty();
			  //因为服务器传来的数据是一个数组
			  //所以需要遍历输出
			  for(i=0;i<stocks.length;i++){
				  //注意js中没有int类型，统统都用var
				  //所以用for循环的时候要注意
				  var s=stocks[i];
				  //更新表格
				  //往tbody标签中插入数据,循环插入
				  $('#tb1').append(
						  '<tr><td>' + s.code +
						  '</td><td>' + s.name + 
						  '</td><td>' + s.price + 
						  '</td></tr>');
			  }
		  }
	  });
  }
 </script>
</head>
<body style="font-size:30px">
  <div id="d1">
    <div id="d2">股票行情</div>
    <div id="d3">
      <table width="100%">
        <thead>
          <tr>
             <td>代码</td>
             <td>名称</td>
             <td>价格</td>
          </tr>
        </thead>
        <tbody id="tb1">
          <!-- 将服务端数据放在这个表格主体 -->
          
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>