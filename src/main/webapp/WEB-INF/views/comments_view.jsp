<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>  </title>
    
    <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
    <![endif]-->
</head>

<body>

	${post.eventDateTime} <br>
	${post.content} <br>
	${post.user.userName} <br>
	<c:if test="${post.user.userName == logged_user}">
		<a href="/cefacem/posts/${post.postId}/edit"> <fmt:message key="label.edit" /> </a>
	</c:if>
	<br> <br>
	
	<!-- all comments -->
	<c:forEach var="comment" items="${comments}" >
		${comment.content} | ${comment.user.userName} |
		<c:if test="${comment.user.userName == logged_user}">
			<a href="/cefacem/posts/${post.postId}/comments/${comment.commentId}/edit"><fmt:message key="label.edit" /></a>
		</c:if> <br>	
	</c:forEach>
	<br><br>
	
	<!-- new comment form -->
	<form:form method="post" commandName="comment">
		<label for="comment_content"> <fmt:message key="label.comment_content" /> </label> <br>
		<form:textarea path="content" id="comment_content" style="height: 100px; width: 400px;" /> 
		<br>
		<form:errors path="content" /> <br>
		
		<input type="submit" value="<fmt:message key="button.comment" />" />
	</form:form>
	
</body>
</html>