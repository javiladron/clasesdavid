<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Clase de JSTL</title>

  </head>

  <body>
	<%-- crear una variable en jstl --%>
	<c:set var="edad" value="36" />
	
	<%-- destruir una variable en jstl <c:remove var="edad"/>  --%>
	
	
	<%-- imprimir una variable en jstl --%>
	<p>Primera forma: <c:out value="${edad }" /></p>
	<p>Segunda forma: ${edad }</p>
	
	
	<%-- intruccion de control if unica --%>
	<c:if test="${not empty(edad) }">
		<p>La variable <strong>edad</strong> no es nula y su valor es <strong>${edad }</strong></p>
	</c:if>
	
	<%-- instruccion de control choose when otherwise if else if else if ... else --%>
	<fmt:parseNumber var="edadnum" type="number" value="${edad }"/>
	<c:choose>
		<c:when test="${edadnum < 26 }">
			<p>Eres un crio y no puedes entrar a la discoteca</p>
		</c:when>
		<c:when test="${edadnum == 26 }">
			<p>Entras a la discoteca por los pelos</p>
		</c:when>
		<c:otherwise>
			<p>Superas los 26 años y no tienes problema para entrar a la discoteca</p>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${edad eq '26' }">
			<p>Entras a la discoteca por los pelos DE UNA SEGUNDA FORMA</p>
		</c:when>
		<c:otherwise>
			<p>NO ENTRAS A LA DISCOTECA PORQUE HOY HA FIESTA DE LOS 26 AÑOS</p>
		</c:otherwise>
	</c:choose>
	
	<%-- instrucction de control for (la lista me viene ya del controlador de spring) --%>
	<fmt:parseNumber var="cont" type="number" value="1"/>
	<c:forEach var="jugador" items="${lista }">
		<c:if test="${cont % 2 == 0 }">
			<p>Jugador -> ${jugador }</p>
		</c:if>
		<fmt:parseNumber var="cont" type="number" value="${cont+1 }"/>
	</c:forEach>
	
	
	<%-- instruccion para capturar posibles trozos de codigo que produzcan excepciones --%>
	<c:catch var="exception">
		<fmt:parseNumber var="cont" type="number" value="${60/0 }"/>
	</c:catch>
	<c:if test="${not empty(exception) }">
		<p>Se ha producido una excepcion: ${exception }</p>
	</c:if>
	
	
	
	
	
	
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
  </body>
</html>
