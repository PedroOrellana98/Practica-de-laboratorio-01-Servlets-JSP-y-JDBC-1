<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
	<c:set var="p1" value="${ requestScope['usuario'] }" />
	<c:set var="p2" value="${ requestScope['idc'] }" />
</body>
<div class="header">
	<h1>Modificar</h1>

</div>
<div class="topnav">
	<a href="/Practica-1/JSPs/Inicio.jsp">Home</a> <a
		href="/Practica-1/controladorSesiones?id=2&ced=${p1.cedula}">Mi
		Cuenta</a> <a href=""></a> <a href="" style="float: right">Sing out</a>
</div>
<div class="info">
	<a>Aqui deberia estar</a>
	<h1 id="title">${p1.cedula}</h1>
	<h1>${p1.correo}</h1>
</div>
<div class="formulario">
	<form action="/Practica-1/AgregarNumero?ced=${p2 }" method="POST">

		<h1>Ingrese el numero para agregar:</h1>
		
		<label for="numero">Numero: </label> 
		<input type="text" name="numero" placeholder="numero"> 
		
		<label for="operadora">Operadora: </label> 
		<input type="text"name="operadora" placeholder="operadora">
		
		 <label for="tipo">Tipo:</label>
		 <input type="text" name="tipo" placeholder="tipo">
		 
		<button type="submit" name="agregar" value="ingresar">ingresar</button>
	</form>
</div>
</html>