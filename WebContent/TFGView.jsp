<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista de Alumno</title>
</head>
<body>
Click <a href="LogoutServlet">here</a> to logout.
<hr>

<h2>Información sobre TFG de ${tfg.name}</h2>
Título: ${tfg.title} <br>
Alumno: ${tfg.name} <br>
Correo alumno: ${tfg.email} <br>
Tutor: ${tfg.advisor.name} <br>
Correo tutor: ${tfg.advisor.email} <br>
Estado:  ${tfg.status} <br><br>

<c:if test="${tfg.status == 3}">
	Subida de memoria: <br>
	<form action="Form4TFGServlet" method="post" enctype="multipart/form-data">
	    <input type="file" name="file" />
	    <input type="hidden" name="email" value="${tfg.email}"/>
		<button type="submit">Subir memoria</button>
	</form>
</c:if>


</body>
</html>