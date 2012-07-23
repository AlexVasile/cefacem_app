<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> Ce facem azi? </title>
    
    <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
    <![endif]-->
</head>

<body>
	 <a href="?lang=ro">ro</a> | <a href="?lang=en">en</a>
	<h3> <fmt:message key="label.welcome"/> </h3>
	
	<c:if test="${empty logged_user}">
		<a id="login" href="login"> <fmt:message key="label.login"/> </a> |
		<a id="signup" href="signup"> <fmt:message key="label.signup"/> </a> |
	</c:if>
	<c:if test="${not empty logged_user}">
		${logged_user} | <a id="logout" href="j_spring_security_logout"> 
			<fmt:message key="label.logout"/> </a> |
	</c:if>
	
	<a id="post" href="post"> <fmt:message key="label.post"/> </a> 
	<br><br><br>
	
	<table border="1">
      <c:forEach var="post" items="${posts}">
        <tr>
          <td> <form method="POST" action="/cefacem/vote/${post.postId}/up"><input type="submit" value="up"/></form></td>
          <td>${post.simpleScore}</td>
          <td> <form method="POST" action="/cefacem/vote/${post.postId}/down"><input type="submit" value="down"/></form></td>	
          <td>${post.content}</td>
          <td>${post.eventDateTime}</td>
          <td>${post.user.userName}</td>
          <td><a href="/cefacem/posts/${post.postId}/comments"> <fmt:message key="label.comments" /> </a></td>
          <td>
          	<c:if test="${post.user.userName == logged_user}">
          		<a href="/cefacem/posts/${post.postId}/edit"> <fmt:message key="label.edit" /> </a>
          	</c:if>
          </td>
        </tr>
      </c:forEach>
    </table>
    
</body>
</html>
