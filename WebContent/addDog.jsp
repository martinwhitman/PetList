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
<form action = "addDogServlet" method="post">
Type: <input type ="text" name = "type">
Name: <input type = "text" name = "name">
OwnerID:<input type ="text" name="ownerID">

<input type = "submit" value="Add Dog">
</form>
<a href ="index.html"> Back to start</a><br />
<a href = "viewAllDogsServlet">View complete roster</a>
</body>
</html>