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
            <li class="active"><a href="${pageContext.request.contextPath }/operation/">Operation</a></li>
            <li><a href="#">Result</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h1>Operación matemática</h1>
        		<p class="lead">Elige una operación matemática básica e introduce los dos operandos que intervendrán en ella. <br/>Pulsa el botón calcular y obtendrás el resultado.</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form action="${pageContext.request.contextPath }/operation/calcular/" method="POST">
		      		<p><strong>Primer operador: </strong><input type="text" name="primerop" value="" class="form-control operador" /></p>
		      		<p><strong>Segundo operador: </strong><input type="text" name="segundoop" value="" class="form-control operador" /></p>
		      		<p><select name="operacion" class="form-control operador">
		      			<option value="-1">Elige operación</option>
		      			<option value="1">Sumar</option>
		      			<option value="2">Restar</option>
		      			<option value="3">Multiplicar</option>
		      			<option value="4">Dividir</option>
		      		</select></p>
		      		<p><input type="submit" class="btn btn-success" name="boton" value="Calcular" /></p>
      			</form>
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
