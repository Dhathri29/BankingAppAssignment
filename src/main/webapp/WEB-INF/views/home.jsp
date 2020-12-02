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
 Add new role to employees  <a href="adduser"> Add User </a> <br>
  Transfer amount	<a href="transfer"> Transfer </a> <br>
  Withdraw amount	<a href="withdraw"> Withdraw </a> <br>
  Deposit amount	<a href="deposit"> Deposit </a> <br>
	<a href="logout"> Logout </a>
	
</c:if>

<c:if test="${sessionScope.user.userType == 'Mgr'}">
  Update the user details  <a href="updateuser"> Update User </a> <br>
  Transfer amount	<a href="transfer"> Transfer </a> <br>
  Withdraw amount	<a href="withdraw"> Withdraw </a> <br>
  Deposit amount	<a href="deposit"> Deposit </a> <br>
	<a href="logout"> Logout </a>
</c:if>

<c:if test="${sessionScope.user.userType == 'Clerk'}">

	<a href="deposit"> Deposit </a> <br>
	<a href="logout"> Logout </a>
</c:if>

</body>
</html>