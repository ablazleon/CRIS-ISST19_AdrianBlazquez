<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista de Profesor</title>
</head>
<body>
Click <a href="LogoutServlet">here</a> to logout.
<hr>

<h2>Datos de ${professor.name}</h2>
Nombre: ${professor.name} <br>
Correo: ${professor.email} <br>

<h3>Lista de TFGs guiados</h3>

<table border="1">
			<tr>
				<th>Título</th>
				<th>Email alumno</th>
				<th>Nombre del alumno</th>
				<th>Estado del TFG</th>
				<th>Memoria</th>
				<th>Decisión</th>
			</tr>
			<c:forEach items="${professor.advisedTFGs}" var="tfgi">
				<tr>
					<td>${tfgi.title }</td>
					<td>${tfgi.email }</td>
					<td>${tfgi.name }</td>
					<td>${tfgi.status }</td>
					<td><c:if test="${tfgi.status > 3}">
							<form action="ServeFileServlet">
								<input type="hidden" name="email" value="${tfgi.email}" />
								<button type="submit">Descargar</button>
							</form>
						</c:if></td>
					<td><c:if test="${tfgi.status == 1}">
							<form action="Form2ProfessorServlet", method="post">
								<input type="hidden" name="emailAlumno" value="${tfgi.email}" />
								<input type="hidden" name="email" value="${professor.email}" />
								<button type="submit">Aceptar ser tutor</button>
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>

</body>
</html>