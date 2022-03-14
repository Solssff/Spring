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
<title>Registro Direccion</title>
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
		<h1>Registro Direccion</h1>
		<br>
		<form:form action="/direccion/crear" method="post"
			modelAttribute="direccion">

			<form:label path="nombre">Nombre</form:label>
			<form:errors path="nombre" class="text-danger"></form:errors>
			<form:input path="nombre" class="form-control" />
			<br>
			<br>
			<form:label path="numero">Numero</form:label>
			<form:errors path="numero" class="text-danger"></form:errors>
			<form:input path="numero" class="form-control" />
			<br>
			<br>
			<form:label path="sector">Sector</form:label>
			<form:errors path="sector" class="text-danger"></form:errors>
			<form:input path="sector" class="form-control" />
			<br>
			<br>
			<form:label path="ciudad">Ciudad</form:label>
			<form:errors path="ciudad" class="text-danger"></form:errors>
			<form:input path="ciudad" class="form-control" />
			<br>
			<br>
			<form:label path="region">Region</form:label>
			<form:errors path="region" class="text-danger"></form:errors>
			<form:input path="region" class="form-control" />
			<br>
			<br>
			<form:label path="cliente" class="form-control" />
			<br>
			<form:select path="cliente" class="form-select">
				<c:forEach items="${listaClientes}" var="cliente">
					<form:option value="${cliente.id}">
						<c:out value="${cliente.nombre}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>


			<input type="submit" class="btn btn-primary" value="Enviar">
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>