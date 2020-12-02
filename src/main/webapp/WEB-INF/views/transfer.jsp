<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
    rel="stylesheet">
</head>
<body>
<h3>Welcome</h3>
	<form:form action="transfer" method="post" modelAttribute="transferBean">
		<table>
			<tr>
				<td>Enter from account number:</td>
				<td><form:input path="fromAccountId"/><form:errors path="fromAccountId" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td>Enter to account number:</td>
				<td><form:input path="toAccountId"/><form:errors path="toAccountId" class="error"></form:errors> </td>
			</tr>
			
			<tr>
				<td>Enter amount to be transferred:</td>
				<td><input type="text" name="amount"><form:errors path="amount" class="error"></form:errors> </td>
			</tr>
			
			<tr>
				<td><input type="submit" value="transfer amount"></td>
			</tr>
			
		
		</table>
	
	</form:form>

</body>
</html>