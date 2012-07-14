<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<a id="login" href="login">Autentifica-te</a> |
	<a id="signup" href="signup">Inregistreaza-te</a> |
	<p>${logged_user} | <a id="logout" href="j_spring_security_logout">logout</a> </p>
	<br>
	<table>
      <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.userId}</td>
          <td>${user.userName}</td>
          <td>${user.email}</td>
          <td>${user.creationDate}</td>
          <td>${user.password}</td>
        </tr>
      </c:forEach>
    </table>
    
</body>
</html>
