<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	
	<form:form method="post" action="signup" commandName="user">
      <table>
        <tr>
          <td>
          <label for="username">UserName:</label>
          </td>	
          <td>
            <form:input path="userName" id="username" autofocus="autofocus" required="required" />
          </td>
          <td>
            <form:errors path="userName" />
            ${userErrMessage}
          </td>
        </tr>
      
        <tr>
          <td>
          	<label for="email">Email:</label>
          </td>		
          <td>
            <form:input path="email" id="email" type="email" required="required" />
          </td>
          <td>
            <form:errors path="email" />
          </td>
        </tr>

        <tr>
          <td>
          	<label for="password">Parola:</label>
          </td>	
          <td>
            <form:input path="password" id="password" required="required" />
          </td>
          <td>
            <form:errors path="password" />
          </td>
        </tr>
    
      </table>
 
      <input type="submit" value="Inregistreaza-te">
    </form:form>
	
</body>
</html>