<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> Autentifica-te </title>
    
    <link rel="stylesheet" href="">
    
    <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
    <![endif]-->
</head>

<body>

	<a href="?lang=ro">ro</a> | <a href="?lang=en">en</a>

	<form method="post" id="login" action="j_spring_security_check" >
		${error}
		<br>
        <label for="username"> <fmt:message key="label.username"/> </label>
        <input type="text" name="j_username" id="username" />
		<br>
        <label for="password"> <fmt:message key="label.password"/> </label>
        <input type="password" name="j_password" id="password" />
		<br>
      <input type="submit" value="<fmt:message key="button.login"/>" />
    </form>
	
</body>
</html>