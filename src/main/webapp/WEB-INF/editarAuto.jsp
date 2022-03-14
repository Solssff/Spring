<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class=container>
		<form:form action="/auto/actualizar/${auto.id}" method="post"
			modelAttribute="auto">
			<form:label path="marca">Marca</form:label>
			<form:errors path="marca" class="text-danger"></form:errors>
			<form:input path="marca" class="form-control" />
			<br>
			<br>
			<form:label path="motor">Motor</form:label>
			<form:errors path="motor"></form:errors>
			<form:input path="motor" class="form-control" />
			<br>
			<br>
			<form:label path="color">Color</form:label>
			<form:errors path="color"></form:errors>
			<form:input path="color" class="form-control" />
			<br>
			<br>
			<form:label path="velocidad">Velocidad</form:label>
			<form:errors path="velocidad" class="text-danger"></form:errors>
			<form:input path="velocidad" class="form-control" />
			<br>
			<br>
			<input type="submit" class="btn btn-primary" value="Editar auto">
		</form:form>



	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>