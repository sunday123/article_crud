<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添 加</title>
</head>
<body>
<form action="addArticle" method="post">
  <table align="center">
        <tr>
           <td colspan="2"><center><h4>添加</h4></center></td> 
        </tr>
        <tr>
           <td>标 题：</td><td><input type="text" name="title"/></td>
        </tr>
                <tr>
           <td>内 容：</td><td><input type="text" name="content"/></td>
        </tr>
        <tr>
          <td><input type="submit" value="提  交"/></td><td><input type="reset" value="重 置"/></td>
        </tr>
  </table>
</form>
</body>
</html>