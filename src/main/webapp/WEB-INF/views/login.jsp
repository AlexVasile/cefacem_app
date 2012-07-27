<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> <fmt:message key="title.login" /> </title>
    
    <link rel="stylesheet" href="">
    
    <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
    <![endif]-->
</head>

<body>

	<a href="/cefacem/change_language?lang=ro">ro</a> | <a href="/cefacem/change_language?lang=en">en</a>
	
	<p><fmt:message key="label.login" /></p>
	<form method="post" id="login" action="j_spring_security_check" >
		${error}
		<br>
        <label for="username"> <fmt:message key="label.username"/> </label>
        <input type="text" name="j_username" id="username" autofocus="autofocus" />
		<br>
        <label for="password"> <fmt:message key="label.password"/> </label>
        <input type="password" name="j_password" id="password" />
		<br>
      <input type="submit" value="<fmt:message key="button.login"/>" />
    </form>
	
	<h3> <fmt:message key="label.or" /> </h3>
	<p><fmt:message key="label.signup" /></p>
	
	<form:form method="post" action="/cefacem/signup" commandName="user">
      <table>
        <tr>
          <td>
          <label for="signup_username"> <fmt:message key="label.username"/> </label>
          </td>	
          <td>
            <form:input path="userName" id="signup_username" />
          </td>
          <td>
            <form:errors path="userName" />
            ${userErrMessage}
          </td>
        </tr>
      
        <tr>
          <td>
          	<label for="signup_email"> <fmt:message key="label.email"/> </label>
          </td>		
          <td>
            <form:input path="email" id="signup_email" type="email" />
          </td>
          <td>
            <form:errors path="email" />
          </td>
        </tr>

        <tr>
          <td>
          	<label for="signup_password"> <fmt:message key="label.password"/> </label>
          </td>	
          <td>
            <form:input path="password" type="password" id="signup_password" />
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