<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

.input-container {
	display: -ms-flexbox;
	display: flex;
	width: 100%;
	margin-bottom: 15px;
}

.icon {
	padding: 10px;
	background: #009933;
	color: white;
	min-width: 50px;
	text-align: center;
}

.input-field {
	width: 100%;
	padding: 10px;
	outline: none;
	border: 2px solid #009933;
}

.input-field:focus {
	border: 2px solid #009933;
}

.btn {
	background-color: #009933;
	color: white;
	padding: 15px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.btn:hover {
	opacity: 1;
}

.LoginForm {
	border-radius: 10px;
	box-shadow: 0 0px 0px 0 rgba(0, 0, 0, 0.9), 0 0px 50px 0
		rgba(0, 0, 0, 0.59);
	background-color: #EEEEEE;
	max-width: 500px;
	padding: 16px 16px;
	margin: auto;
	margin-top: 10%;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<meta charset="ISO-8859-1">
<title>Trocar de senha</title>
</head>
<body>

	<c:if test="${not empty erro}">
		<div class="alert alert-danger">
			<strong>Senhas não coincidem</strong>
			<c:out value="${erro}"></c:out>
		</div>
	</c:if>

	<div class="LoginForm">
		<form action="TrocaSenha" method="post"
			style="max-width: 500px; margin: auto">
			<h2>
				Olá
				<c:out value="${email}"></c:out>
			</h2>
			<p>
				Este é o primeiro acesso que você faz a sua <b>conta</b>. Por favor,
				insira uma nova <b>senha</b>.
			</p>

			<div class="input-container">
				<i class="fa fa-key icon"></i> <input class="input-field"
					type="password" placeholder="Digite sua senha" name="senha1"
					id="senha1">
			</div>

			<div class="input-container">
				<i class="fa fa-key icon"></i> <input class="input-field"
					type="password" placeholder="Repita sua senha" name="senha2"
					id="senha2">
			</div>

			<button type="submit" class="btn">Continuar</button>
			<input type="hidden" name="email"
				value="<c:out value="${email}"></c:out>">
		</form>
	</div>

</body>
</html>