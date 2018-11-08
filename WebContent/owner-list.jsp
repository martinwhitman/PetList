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
<form method = "post" action = "editOwnerListServlet">
<table>
<c:forEach items="${requestScope.allOwners}" var="currentowner">
<tr>
	<td><input type="radio" name="ownerID" value="${currentowner.ownerID}"></td>
	<td>${currentowner.name}</td>
	<td>${currentowner.address}</td>
	<td>${currentowner.state}</td>
	</tr>
</c:forEach>
</table>
<input type = "submit" value = "Edit Selected Owner" name = "doThisToOwner">
<input type = "submit" value = "Delete Selected Owner" name = "doThisToOwner">
<input type = "submit" value = "Add New Owner" name = "doThisToOwner">
</form>
</body>
</html>