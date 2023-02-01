<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Crud Animales</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Animales</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		

		<div class="container">
			<h3 class="text-center">Listar Animales</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar un animal</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>NombreCientifico</th>
						<th>Habitad</th>
						<th>Especie</th>
                                                <th>Peso</th>
                                                <th>Dieta</th>
                                                <th>PeligroExtincion</th>
                                                
                                                
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="animales" items="${listarAnimales}">

						<tr>
							<td><c:out value="${animales.id}" /></td>
							<td><c:out value="${animales.nombre}" /></td>
							<td><c:out value="${animales.nombreCientifico}" /></td>
							<td><c:out value="${animales.habitad}" /></td>
                                                        <td><c:out value="${animales.especie}" /></td>
                                                        <td><c:out value="${animales.peso}" /></td>
                                                        <td><c:out value="${animales.dieta}" /></td>
                                                         <td><c:out value="${animales.peligroExtincion}" /></td>
							<td><a href="edit?id=<c:out value='${animales.id}' />">editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${animales.id}' />">eliminar</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
