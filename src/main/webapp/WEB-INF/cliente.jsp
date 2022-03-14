<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Datos Cliente</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<!--method GET: muestra en a URL los parametros y sus valores-->
		<!--method POST: envia los parametros ocultos-->
		<br>
		<h1>Registro Clientes</h1>
		<br>
		<form:form action="/cliente/crear" method="post"
			modelAttribute="cliente">

			<form:label path="nombre">Nombre</form:label>
			<form:errors path="nombre" class="text-danger"></form:errors>
			<form:input path="nombre" class="form-control" />
			<br>
			<br>
			<form:label path="apellido">Apellido</form:label>
			<form:errors path="apellido" class="text-danger"></form:errors>
			<form:input path="apellido" class="form-control" />
			<br>
			<br>
			<form:label path="correo">Correo</form:label>
			<form:errors path="correo" class="text-danger"></form:errors>
			<form:input path="correo" class="form-control" />
			<br>
			<br>
			<input type="submit" class="btn btn-primary" value="Enviar">
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>