<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bienvenido</title>
<link rel="stylesheet"  href="/Practica-1/CONFIG/Style/styleLoggedOn.css" type="text/css">
</head>
<body>
<h1>Login con exito</h1>
<form>
	<c:set var="lista" scope="request" value="${requestScope['telefono']}"/>
	<table class="container">
	<thead>
		<tr>
			<th><h1>Codigo</h1></th>
			<th><h1>Numero</h1></th>
			<th><h1>Tipo</h1></th>
			<th><h1>Operadora</h1></th>
		</tr>
	</thead>
	<tbody>
	<%/*
	
		<c:forEach var="telf" item="${lista}">
			<tr>	
				<td>${u.codigo}</td>
				<td>${u.numero}</td>
				<td>${u.tipo}</td>
				<td>${u.operadora}</td>
			</tr>
		</c:forEach>
		*/%>
	</tbody>
</table>
</form>

</body>
</html>