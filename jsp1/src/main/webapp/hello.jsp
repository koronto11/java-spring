<%@page pageEncoding="utf-8"%>
<!-- 1.先写标签 -->
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>第一个JSP</title>
  </head>
  <body>
    <!-- JSP声明 声名一种方法然后在后面调用 -->
    <%!
     public double hundred(double b){
    	return b*100;
    }
    %>
    <ul>
      <!-- jsp小脚本 纯java代码-->
      <% 
        for(int i=0;i<10;i++){
      %>
        <!-- 若想在java中写标签，那么就用jsp脚本标签分隔开 -->
        <!-- li标签中要输出值了，要写JSP表达式 随机输出一个值-->
        <li><%=hundred(Math.random()) %></li>
      <%  	
        }
      %>
    </ul>
    
    <!-- 引入一个JSP，相当于将此JSP内容引导此处而已 -->
    <%@include file="time.jsp" %>
  </body>
</html> 