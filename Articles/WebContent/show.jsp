<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示</title>
</head>
<body>
<form action="showArticle" method="post">
  <table align="center">
   <tr>
   <th>编  号 </th>
   <th>标  题 </th>
   <th>   内               容       </th>
   <th> 操     作 </th>
   </tr>

   <c:forEach var="li" items="${list}">
   <tr>
   <td>${li.id} </td>
   <td> ${li.title} </td>
   <td> ${li.content} </td>
   <td><a href="deleteArticle?id=${li.id}">删除</a>|<a href="updateArticle?id=${li.id}">修改</a></td>
   </tr> 
   </c:forEach>

   <tr>
   <td align="center"><a href="add.jsp"> 添  加 </a></td>
   </tr>
  </table>
</form>
</body>
</html>