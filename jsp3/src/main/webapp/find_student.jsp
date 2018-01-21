<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/hs-tags" prefix="s" %>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>EL和JSTL技术</title>    
  </head>
  <body>
  <h1>JSTL</h1>
  <!-- JSTL开发技术 -->
  <!-- if标签 test为true时输出-->
  <p>
    <c:if test="${stu.sex=='M' }">男</c:if>
    <c:if test="${stu.sex=='F' }">女</c:if>
  </p>
  <!-- choose标签  相当于一个多重判断 test为true时输出-->
  <p>
    <c:choose>
      <c:when test="${stu.sex=='M' }">男</c:when>
      <c:otherwise>女</c:otherwise>
    </c:choose>
  </p>
  <!-- forEach标签 遍历集合或数组 items指定要遍历的集合 var给每个取出来的数据命个别名
  然后通过EL表达式显示出来，${var值即可}显示 -->
  <p>
    <c:forEach items="${stu.interests }" var="i">
      ${i }
    </c:forEach>
  </p>
  
  <!-- 自定义标签展示 -->
  <p>
    <s:sysdate/>
    <s:sysdate format="HH:mm:ss"></s:sysdate>
  </p>
  
  <!-- 展示数据 -->
    <h1>EL</h1>
    <!-- 1.如何获取Bean属性 -->
    <!-- ${stu.name}相当于request.setAttribute("stu").getName(); -->
    <p>姓名:${stu.name }</p>
    <p>年龄:${stu["age"] }</p>
    <p>性别:${stu.sex }</p>
    <!-- 等价于request.Attribute("stu").getCourse().getId(); -->
    <p>课程:${stu.course.id }</p>
    
    <!-- 2.EL表达式进行简单运算 -->
    <p>年龄+5:${stu.age+5 }</p>
    <p>年龄是否在20-30间:${stu.age>=20 && stu.age<=30 }</p>
    <p>判断是否为空：${empty stu }</p>
    
    <!-- 3.EL获取请求参数的值,如何获取浏览器表单提交的信息 -->
    <p>${param.name }</p>
    
    
    
  </body>
</html>