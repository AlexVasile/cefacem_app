<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> Inregistreaza-te </title>
    
    <link rel="stylesheet" href="">
    
    <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
    <![endif]-->
</head>

<body>

	<a href="?lang=ro">ro</a> | <a href="?lang=en">en</a>
		
	<form:form method="post" action="signup" commandName="user">
      <table>
        <tr>
          <td>
          <label for="username"> <fmt:message key="label.username"/> </label>
          </td>	
          <td>
            <form:input path="userName" id="username" autofocus="autofocus" />
          </td>
          <td>
            <form:errors path="userName" />
            ${userErrMessage}
          </td>
        </tr>
      
        <tr>
          <td>
          	<label for="email"> <fmt:message key="label.email"/> </label>
          </td>		
          <td>
            <form:input path="email" id="email" type="email" />
          </td>
          <td>
            <form:errors path="email" />
          </td>
        </tr>

        <tr>
          <td>
          	<label for="password"> <fmt:message key="label.password"/> </label>
          </td>	
          <td>
            <form:input path="password" type="password" id="password" />
          </td>
          <td>
            <form:errors path="password" />
          </td>
        </tr>
    
      </table>
 
      <input type="submit" value="<fmt:message key="button.signup"/>">
    </form:form>
	
</body>
</html>