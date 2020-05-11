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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form action="/Practica-1/src/ec/ups/edu/controlador/controladorSesiones?id=3" method="GET">
<c:set var="t1" value="${requestScope['telefonos']}"/>

<%/* <h1>Login con exito</h1> */%>
	
	<div class="header">
  		<h1>Lista de telefonos</h1>

	<div class="topnav">
		<a href="/Practica-1/JSPs/Inicio.jsp">Home</a>
		<a href="/Practica-1/JSPs/Busquedas.jsp">Busqueda</a>
		<a href="" style="float:right">Sing out</a>
	</div>
	
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
		<c:forEach var="telf" items="${t1}">
			<tr>	
				<td>${telf.codigo}</td>
				<td>${telf.numero}</td>
				<td>${telf.tipo}</td>
				<td>${telf.operadora}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</form>
</body>
</html>
