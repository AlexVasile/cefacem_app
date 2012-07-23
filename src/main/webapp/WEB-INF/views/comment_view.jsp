<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	${comment.content}
	<br>
	${comment.user.userName}
	<br>
	${comment.creationDate}
	<br>
	<c:if test="${comment.user.userName == logged_user}">
		<a href="/cefacem/posts/${comment.post.postId}/comments/${comment.commentId}/edit"> 
				<fmt:message key="label.edit" /> </a>
	</c:if>
	
</body>
</html>