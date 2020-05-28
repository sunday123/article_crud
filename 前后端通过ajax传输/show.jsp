<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.min.js" type="text/javascript"></script>
<title>显示</title>
    <style>
        .hide{
            display: none;
        }
        .c1{
            position: fixed;
            top:0;
            bottom: 0;
            left:0;
            right: 0;
            background: rgba(0,0,0,.5);
            z-index: 2;
        }
        .c2{
            background-color: white;
            position: fixed;
            width: 400px;
            height: 250px;
            top:50%;
            left: 50%;
            z-index: 3;
            margin-top: -150px;
            margin-left: -200px;
        }
		#modal p {
			margin-left:80px;
		}
    </style>
</head>
<body>
<div action="showArticle" method="post">
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
   <td>${li}</td>
    <td> <button>增加</button>|<button onclick="updateA( ${li})" >修改</button></td>
   </tr> 
   </c:forEach>

   <tr>
   <td align="center"><a href="add.jsp"> 添  加 </a></td>
   </tr>
  </table>
</div>

<div id="shade" class="c1 hide"></div>

<div id="modal" class="c2 hide">
    <h5 align="center">修改</h5>
    <p>序号:<input  id="upate_ID" type="number" disabled="disabled"/></p>
    <p>标题:<input id="upate_title" type="text"/></p>
    <p>内容:<input id="upate_content" type="text"/></p>
<p>  
    
    <input type="button" value="确定" onclick="doit();">
    <input type="button" value="取消" onclick="Hide();">
</p>
</div>


<script type="text/javascript">
function updateA(article) {
 	var li = eval(article);  
    console.log(li);  
/* 	alert(li.id+'|'+li.title+'|'+li.content); */
	
	
	
    document.getElementById('shade').classList.remove('hide');
    document.getElementById('modal').classList.remove('hide');
    document.getElementById("upate_ID").value=li.id;
    document.getElementById("upate_title").value=li.title;
    document.getElementById("upate_content").value=li.content;
	
	
/* 	var cc =  escape(article);
    console.log(cc); 
	alert(cc); */
}


 function Hide(){
    document.getElementById('shade').classList.add('hide');
    document.getElementById('modal').classList.add('hide');
}
 
 
function doit(){
	var id = parseInt(document.getElementById("upate_ID").value);
    var title =document.getElementById("upate_title").value;
    var content=document.getElementById("upate_content").value;
    console.log(id+'|'+title+'|'+content);
    Hide();

    $.ajax({
        type : "POST",
        url : "updateArticle",
        contentType : 'application/json;charset=utf-8', /* //必须有 */
        data : JSON.stringify({"id": id, "title": title, "content":content}),      /* //"{"id": id, "title": title, "content":content}, */
        dataType : "json",
  /*       traditional: true, */
        success : function (s) {
             console.log("返回成功收到:");
             console.log(s);
             alert("成功后台收到："+s.id+"|"+s.title+"|"+s.content);

        },
        error : function (e) {
         console.log("返回失败:");
         console.log(e);
         alert("后台返回失败："+e);
    }});
    
    
    
} 



</script>

</body>
</html>