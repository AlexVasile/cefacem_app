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
	
	<a id="login" href="login"> <fmt:message key="label.login"/> </a> |
	<a id="signup" href="signup"> <fmt:message key="label.signup"/> </a> |
	<a id="post" href="post"> <fmt:message key="label.post"/> </a>
	<p>${logged_user} | <a id="logout" href="j_spring_security_logout"> 
		<fmt:message key="label.logout"/> </a> </p>
	<br>
	<table>
      <c:forEach var="post" items="${posts}">
        <tr>
          <td>${post.content}</td>
          <td>| ${post.eventDateTime} |</td>
          <td>${post.user.userName}</td>
        </tr>
      </c:forEach>
    </table>
    
</body>
</html>
