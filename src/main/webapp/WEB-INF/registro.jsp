<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>

<body>
<!-- Navbar -->
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> 
				<c:out value="${titulo}"></c:out>
				</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/">Home</a></li>
					<li><a href="usuario/registro">Registro</a></li>
					<li><a href="showLogin">Login</a></li>
					<li><a href="autos">Autos</a></li>
					<li><a href="direccion">Direcciones</a></li>
					<li><a href="recuperarCookie">Cookie</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${msgError != null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msgError}"></c:out>
			</div>
		</c:if>
	<div class="container">
		<!--method GET: muestra en a URL los parametros y sus valores-->
		<!--method POST: envia los parametros ocultos-->
		<br>
		<h1>Formulario de Registro</h1>
		<br>
		<form:form action="/usuario/formulario" method="post" modelAttribute="usuario">
		
			<form:label path="nombre">Nombre</form:label>
			<br>
			<form:errors path="nombre" class="text-danger"></form:errors>
			<form:input path="nombre" class="form-control"/>
			<br>
			<br>
			<form:label path="apellido">Apellido</form:label>
			<form:errors path="apellido"></form:errors>
			<form:input path="apellido" class="form-control"/>
			<br>
			<br>
			<form:label path="correo">Correo</form:label>
			<form:errors path="correo"></form:errors>
			<form:input path="correo" class="form-control"/>
			<br>
			<br>
			<form:label path="password">Password</form:label>
			<br>
			<form:errors path="password" class="text-danger"></form:errors>
			<form:input path="password" class="form-control"/>
			<br>
			<br>
			<form:label path="genero">Genero</form:label>
			<form:errors path="genero"></form:errors>
			<form:select path="genero" class="form-control">
			<form:option value="1">Femenino</form:option>
			<form:option value="2">Masculino</form:option>
			<form:option value="3">Prefiero no deir</form:option>
			<br>
			<br>
			</form:select>
			<br>
			<br>
			<!--botones-->
			<input type="submit" class="btn btn-primary" value="Enviar">
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</html>