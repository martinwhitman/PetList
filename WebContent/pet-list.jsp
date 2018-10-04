<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "editPetListServlet">
<table>
<c:forEach items="${requestScope.allDogs}" var="currentdog">
<tr>
	<td><input type="radio" name="ID" value="${currentdog.ID}"></td>
	<td>${currentdog.type}</td>
	<td>${currentdog.name}</td>
	<td>${currentdog.owner}</td>
	</tr>
</c:forEach>
</table>
<input type = "submit" value = "Edit Selected Dog" name = "doThisToDog">
<input type = "submit" value = "Delete Selected Dog" name = "doThisToDog">
<input type = "submit" value = "Add New Dog" name = "doThisToDog">
</form>
</body>
</html>