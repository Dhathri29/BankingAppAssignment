<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<br>
<h3>Welcome, ${sessionScope.user.userType}</h3>  <br>
<c:if test="${sessionScope.user.userType == 'Admin'}">
	<a href="adduser"> Add User </a> <br>
	<a href="logout"> Logout </a>
	
</c:if>

<c:if test="${sessionScope.user.userType == 'Mgr'}">
	<a href="transfer"> Transfer </a> <br>
	<a href="withdraw"> Withdraw </a> <br>
	<a href="deposit"> Deposit </a> <br>
	<a href="logout"> Logout </a>
</c:if>

</body>
</html>