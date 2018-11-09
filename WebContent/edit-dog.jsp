<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT DOG</title>
</head>
<body>
<form action = "editDogServlet" method="post">
Type: <input type="text" name = "type" value="${dogToEdit.type}">
Name: <input type="text" name = "name" value="${dogToEdit.name}">
Owner ID: <input type="text" name = "ownerID" value="${dogToEdit.owner.ownerID}">
<input type="hidden" name = "ID" value="${dogToEdit.ID}">
<input type="submit" value="Save Edited Dog">
</form>
</body>
</html>