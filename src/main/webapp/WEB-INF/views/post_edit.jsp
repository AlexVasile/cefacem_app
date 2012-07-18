<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>  </title>
    
    <link rel="stylesheet" type="text/css" href="/cefacem/resources/css/smoothness/jquery-ui-1.8.20.custom.css" />
    <link rel="stylesheet" type="text/css" href="/cefacem/resources/css/jquery-ui-timepicker-addon.css" />
    
    <script type="text/javascript" src="/cefacem/resources/js/jquery-1.7.2.min.js"></script>
  	<script type="text/javascript" src="/cefacem/resources/js/jquery-ui-1.8.20.custom.min.js"></script>
  	<script type="text/javascript" src="/cefacem/resources/js/jquery-ui-timepicker-addon.js"></script>
    
    <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
    <![endif]-->
    
    <script type="text/javascript">
    	$(document).ready(function () {
    		$("#date_time").datetimepicker({ dateFormat: "dd/mm/yy" });
    	});
    </script>
</head>

<body>

	<a href="?lang=ro">ro</a> | <a href="?lang=en">en</a>

	<form:form method="post" commandName="post">
		<label for="date"> <fmt:message key="label.dateTime" /> </label>
		<form:input path="eventDateTime" type="text" id="date_time" />
		<form:errors path="eventDateTime"/>
		<br>
		<label for="content"> <fmt:message key="label.content" /> </label>
		<br>
		<form:textarea path="content" id="content" style="height: 160px; width: 400px;" />
		<br>
		<form:errors path="content"/>
		<br>
		
		<input type="submit" value="<fmt:message key="button.post" />" />
	</form:form>
</body>
</html>