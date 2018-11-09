<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT OWNER</title>
</head>
<body>
<form action = "editOwnerServlet" method="post">
Name: <input type="text" name = "name" value="${ownerToEdit.name}">
Address: <input type="text" name = "address" value="${ownerToEdit.address}">
State: <input type="text" name = "state" value="${ownerToEdit.state}">
<input type="hidden" name = "ownerID" value="${ownerToEdit.ownerID}">
<input type="submit" value="Save Edited Owner">
</form>
</body>
</html>