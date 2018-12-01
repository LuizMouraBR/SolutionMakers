<!DOCTYPE html>
<html>
<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
	
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<meta charset="UTF-8">

<title>SolutionMakers - Login</title>

<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

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
.LoginForm{
	border-radius: 10px;
	box-shadow: 0 0px 0px 0 rgba(0, 0, 0, 0.9), 0 0px 50px 0 rgba(0, 0, 0, 0.59);
	background-color: #EEEEEE;
	max-width:500px;
	padding: 16px 16px;
	margin: auto;
	margin-top: 10%;
}
</style>

</head>
<body>

	<c:if test="${not empty erro}">
		<div class="alert alert-danger">
			<strong>Erro.</strong>
			<c:out value="${erro}"></c:out>
		</div>
	</c:if>

<div class="LoginForm">
	<form action="/SolutionMakers/login" method="post" style="max-width:500px;margin:auto">
	  <h2>Efetuar login</h2>
	  <p>Para continuar, por favor <strong>preencha todos os campos</strong> abaixo.</p>
	
	  <div class="input-container">
	    <i class="fa fa-envelope icon"></i>
	    <input class="input-field" type="email" placeholder="Digite seu e-mail" name="email">
	  </div>
	  
	  <div class="input-container">
	    <i class="fa fa-key icon"></i>
	    <input class="input-field" type="password" placeholder="Digite sua senha" name="senha">
	  </div>
	
	  <button type="submit" class="btn">Entrar</button>
	  <br>
	  <a href="#" style="color: blue;">Esqueci minha senha</a>
	  <br>
	  <a href="/SolutionMakers/controller?acao=index" style="color: blue">Voltar para a home page</a>
	</form>
</div>


</body>
</html>
