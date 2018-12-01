<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">

<title>Tópicos - SolutionMakers</title>
</head>
<body>

	<%@include file="/WEB-INF/layout_header.jsp"%>

	<h2 style="margin-left: 3%;margin-right: 3%; max-width: 700px;">Tópicos:</h2>
	<br>

	<c:forEach var="topico" items="${topicos}">
		<div class="card"
			style="margin: auto; box-shadow: 0px 4px 8px #888888; max-width: 700px;">
			<div class="card-body">
				<form action="/SolutionMakers/controllerTopico?" method="get">
					<input type="submit" class="btn btn-info" style="color: white;"
						value="<c:out value="${topico.titulo}"></c:out>"> <input
						type="hidden" name="topicoID" value="${topico.id}"> <input
						type="hidden" name="acao" value="ViewTopico">
				</form>
				<c:if test="${topico.resolvido == true}">
					<p
						style="border-radius: 5px; float: right; background-color: #00cc00; padding: 5px 5px;">Resolvido</p>
				</c:if>

				<c:if test="${topico.resolvido == false}">
					<p
						style="border-radius: 5px; float: right; background-color: #ff1a1a; padding: 5px 5px;">Não
						resolvido</p>
				</c:if>

				<form action="/SolutionMakers/controller?" method="get">
					<div style="padding: 5px 5px;">
						<i>por 
						<input class="btn btn-light" type="submit" value="${topico.autor_nickname}">
						</i>
					</div>
					<input type="hidden" value="${topico.autor_nickname}" name="userNick">
					<input type="hidden" name="acao" value="conta">
				</form>
				<hr>
				<p class="card-text">
					<c:out value="${topico.descricao}"></c:out>
				</p>
				<h6>
					<c:out value="${topico.respostas}"></c:out>
					respostas
				</h6>

			</div>
		</div>
		<br>
	</c:forEach>

	<%@include file="/WEB-INF/layout_footer.jsp"%>
</body>
</html>