<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> <fmt:message key="title.user_page" /> </title>
    
    <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
    <![endif]-->
</head>

<body>
 	<p>
 		${user.userName} <br> ${user.email} 
 	</p>
 	<br>
 	
 	<h2> <fmt:message key="label.posts" /> </h2>
 	<table border="1">
      <c:forEach var="post" items="${user_posts}">
        <tr>
          <td>${post.content}</td>
          <td>${post.eventDateTime}</td>
          <td><a href="/cefacem/posts/${post.postId}/comments"> <fmt:message key="label.comments" /> </a></td>
          <td>
          	<a href="/cefacem/posts/${post.postId}/edit"> <fmt:message key="label.edit" /> </a>
          </td>
        </tr>
      </c:forEach>
    </table>
 	
 	<h2> <fmt:message key="label.comments" /> </h2> <br>
 	<table border="1">
      <c:forEach var="comment" items="${user_comments}">
        <tr>
          <td> ${comment.content}</td>
          <td> <a href="/cefacem/posts/${comment.post.postId}/comments/${comment.commentId}/edit"> 
				<fmt:message key="label.edit" /> </a> </td>
        </tr>
      </c:forEach>
    </table>
 	
</body>
</html>