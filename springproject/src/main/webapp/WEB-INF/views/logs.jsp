<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



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

    <title>Spring project</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/estaticos/css/bootstrap.min.css" />" rel="stylesheet">
    
    <link href="<c:url value="/estaticos/css/custom.css" />" rel="stylesheet">

  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Spring Project</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath }/operation/">Operation</a></li>
            <li><a href="#">Result</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/operation/logs/?mode=${modologs}">Logs</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h1>Logs</h1>
        		<p class="lead">Vista donde mostramos el conjunto de operaciones llevadas a cabo en el sistema</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<p><a href="${pageContext.request.contextPath }/operation/logs/?mode=${modologs}&op=1">Logs suma</a></p>
				<p><a href="${pageContext.request.contextPath }/operation/logs/?mode=${modologs}&op=2">Logs resta</a></p>
				<p><a href="${pageContext.request.contextPath }/operation/logs/?mode=${modologs}&op=3">Logs multiplicacion</a></p>
				<p><a href="${pageContext.request.contextPath }/operation/logs/?mode=${modologs}&op=4">Logs division</a></p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<table class="table table-condensed">
				    <thead>
				      <tr>
				        <th>Operation</th>
				      </tr>
				    </thead>
				    <tbody>
				    <c:forEach var="coaux" items="${lista }"> 
				      <tr>
				      		<td>Operacion ${coaux.operacion } -> ${coaux.primerop } | ${coaux.segundoop } </td>
				      </tr>
				    </c:forEach>
				      
				    </tbody>
				 </table>
      			
      			
			</div>
		</div>
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="<c:url value="/estaticos/js/bootstrap.min.js" />"></script>
  </body>
</html>
