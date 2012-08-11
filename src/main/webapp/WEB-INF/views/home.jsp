<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> <fmt:message key="title.home" /> </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" type="text/css" href="/cefacem/resources/css/bootstrap.css" />
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>
    <link rel="stylesheet" type="text/css" href="/cefacem/resources/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="/cefacem/resources/css/main.css" />
    
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<body>
	<!-- Navbar
    ================================================== -->
	<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
  <div class="container">
 		<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </a>
    <a class="brand" href="#"> <fmt:message key="title.home" /> </a>
  	<div class="btn-group pull-right">
  		<c:if test="${not empty logged_user}">
      <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
        <i class="icon-user"></i> ${logged_user}
        <span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
      	<li><a href="/cefacem/user/${logged_user}"> <fmt:message key="label.profile"/> </a></li>
        <li class="divider"></li>
        <li><a id="logout" href="/cefacem/j_spring_security_logout"> 
							<fmt:message key="label.logout"/> </a></li>
      </ul>
      </c:if>
    </div>
    <div class="nav-collapse">
      <ul class="nav">
	      <li class="active"> <a id="post" href="/cefacem/post"> <fmt:message key="label.post"/> </a> </li>
	      <c:if test="${empty logged_user}">
	        <li><a id="login" href="/cefacem/login"> <fmt:message key="label.login"/> </a></li>
	        <li><a id="signup" href="/cefacem/signup"> <fmt:message key="label.signup"/> </a></li>
	      </c:if>  
      </ul>
      <ul class="nav pull-right">
      	<li><span><a href="/cefacem/change_language?lang=ro">ro</a>
      						 <a href="/cefacem/change_language?lang=en">en</a>
      			</span></li> 
      </ul>
    </div><!--/.nav-collapse -->	
  </div>
  </div>
	</div>
	
	<!-- 
	<c:if test="${empty logged_user}">
		<a id="login" href="/cefacem/login"> <fmt:message key="label.login"/> </a> |
		<a id="signup" href="/cefacem/signup"> <fmt:message key="label.signup"/> </a> |
	</c:if>
	<c:if test="${not empty logged_user}">
		<a href="/cefacem/user/${logged_user}"> ${logged_user} </a>| 
		<a id="logout" href="/cefacem/j_spring_security_logout"> 
			<fmt:message key="label.logout"/> </a> |
	</c:if>
	<a id="post" href="/cefacem/post"> <fmt:message key="label.post"/> </a> 
	<br><br><br>
	-->
	
	<div class="container-fluid">
		<c:forEach var="post" items="${posts}">
				
			<div class="row-fluid">
				<div class="span3 offset3"></div>
				<div class="span6">
				<table>
					<tbody>
						<tr>
							<td>
								<div class="vote-buttons">
									<a class="vote up" id="up_${post.postId}" href="" title="Vote Up"></a>
									<div class="post-score" id="score_${post.postId}">${post.simpleScore}</div>
									<a class="vote down" id="down_${post.postId}" href="" title="Vote Down"></a>
								</div>
							</td>
							
							<td>
								<time datetime="${post.eventDateTime}">
									<fmt:formatDate value="${post.eventDateTime}" type="both" dateStyle="long" timeStyle="short" />
								</time>
								
								<br>
								${post.content} 
							</td>
						</tr>
					</tbody>
				</table>
				<br>	
				</div>
				<div class="span3 offset3"></div>
			</div>
		</c:forEach>
	</div><!--/.fluid-container-->
	
	<!-- 
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
   --> 
    
    <c:if test="${prev == 'y'}" >
    	<a href="/cefacem/page?start=${prev_end - page_length}&end=${prev_end}"> 
    		<fmt:message key="label.previous" /> </a>
    </c:if> |
    <c:if test="${next == 'y'}" >
    	<a href="/cefacem/page?start=${next_start}&end=${next_start + page_length}"> 
    		<fmt:message key="label.next" /> </a>
    </c:if>
    
    
    <!-- JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="/cefacem/resources/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/cefacem/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/cefacem/resources/js/main.js"></script>
</body>
</html>
