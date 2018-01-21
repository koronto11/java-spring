<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="js/jquery-1.11.1.js"></script>
 <script>
    //发送异步请求取得数据并显示在对应选择节点上
	//用jquery框架来处理
	$(function(){
		//单击事件
		$('#a1').click(showNumber);
	});
    function showNumber(){
    	//把服务器返回的数据直接显示到对应的节点上
    	$('#d1').load('luck.do');
    }
 </script>
</head>
<body style="font-size:30px">
  <a id="a1">你的幸运数字是:</a>
  <div id="d1"></div>
</body>
</html>