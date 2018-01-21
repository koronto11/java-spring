<!-- pageEncoding声明文档编码
     contentType声明输出的内容的格式
     import导入相关的包 -->
<%@page pageEncoding="utf-8" 
contentType="text/html" 
import="java.text.*,java.util.*"%>
<!-- 直接输出脚本 -->
<!-- 此JSP脚本可以被其他网页调用，是其他网页的一部分
所以不必写出完整结构，别的网页在指定位置调用它即可 -->
<%
 Date date=new Date();
 SimpleDateFormat sdf=
		 new SimpleDateFormat("HH:mm:ss");
 String now=sdf.format(date);
%>
<p><%=now %></p>
