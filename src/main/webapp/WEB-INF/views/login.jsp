<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<form method="post" id="login" action="j_spring_security_check" >
      <table>
      	<tr>
      		<td>${error}</td>
      	</tr>
        <tr>
          <td>
            <label for="username">Username: </label>
          </td>
          <td>
            <input type="text" name="j_username" id="username" required="required"/>
          </td>
        </tr>

        <tr>
          <td>
            <label for="password">Parola: </label>
          </td>
          <td>
            <input type="password" name="j_password" id="password" required="required" />
          </td>
          <td>
          	
          </td>
        </tr>
      </table>
      <input type="submit" value="Autentifica-te" />
    </form>
	
</body>
</html>