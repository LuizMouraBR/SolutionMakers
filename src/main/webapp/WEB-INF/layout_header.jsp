<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="UTF-8">
</head>
<body>

	<h1 style="margin-left: 3%;">SolutionMakers</h1>

	<p style="margin-left: 3%;">Grandes projetos também começam de uma página em branco.</p>
		<div id="MenuBar" style="box-shadow: 0px 2px 8px #888888;">
			<div class="w3container">
				<div class="w3-bar w3-green">
				<a href="/SolutionMakers/controller?acao=index"	class="w3-bar-item w3-button w3-mobile">Home page</a>
				
				<c:if test="${usuarioEmSessao != null}">
					<form style="float: left;" action="/SolutionMakers/controller?" method="get">
						<input class="w3-bar-item w3-button w3-mobile w3-gray" type="submit" value="${usuarioEmSessao.nickname}">							
						<input type="hidden" value="${usuarioEmSessao.nickname}" name="userNick">
						<input type="hidden" name="acao" value="conta">
					</form>
					<c:if test="${usuarioEmSessao.nivelAcesso == 1}">
						<a href="/SolutionMakers/controller?acao=Administracao" class="w3-bar-item w3-button w3-mobile">Adminstração</a> 
					</c:if>
					<c:if test="${usuarioEmSessao.nivelAcesso == 1 || usuarioEmSessao.nivelAcesso == 2}">
						<form style="float: left;" action="/SolutionMakers/controllerEmpresa?" method="get">
							<input class="w3-bar-item w3-button w3-mobile" type="submit" value="Gerenciar empresas">							
							<input type="hidden" value="${usuarioEmSessao.nickname}" name="userNick">
							<input type="hidden" name="acao" value="criarEmpresa">
						</form>
						
						<form style="float: left;" action="/SolutionMakers/controllerUsuario?" method="get">
							<input class="w3-bar-item w3-button w3-mobile" type="submit" value="Cadastrar usuários">							
							<input type="hidden" value="${usuarioEmSessao.nickname}" name="userNick">
							<input type="hidden" name="acao" value="cadastrarUsuarios">
						</form>
						
						
					</c:if>
					<c:if test="${usuarioEmSessao.nivelAcesso == 3}">
						<form style="float: left;" action="/SolutionMakers/controllerTopico?" method="get">
							<input class="w3-bar-item w3-button w3-mobile" type="submit" value="Criar Ticket">							
							<input type="hidden" value="${usuarioEmSessao.nickname}" name="userNick">
							<input type="hidden" name="acao" value="telaTopico">
						</form>
					</c:if>
					<form style="float: left;" action="/SolutionMakers/controllerDiscussao?" method="get">
						<input class="w3-bar-item w3-button w3-mobile" type="submit" value="Criar Discussão">							
						<input type="hidden" value="${usuarioEmSessao.nickname}" name="userNick">
						<input type="hidden" name="acao" value="telaDiscussao">
					</form>
				</c:if>
				
				<c:if test="${usuarioEmSessao == null}">
					<a href="/SolutionMakers/controller?acao=loginPage"	class="w3-bar-item w3-button w3-mobile">Login</a> 
				</c:if>
				
				<a href="/SolutionMakers/controller?acao=listarTopicos" class="w3-bar-item w3-button w3-mobile">Tickets</a> 
				<a href="/SolutionMakers/controller?acao=listarDiscussoes"	class="w3-bar-item w3-button w3-mobile">Discussões</a> 
				<a href="/SolutionMakers/pages/Sobre.jsp"	class="w3-bar-item w3-button w3-mobile">Sobre nós</a>
					
					<form action="/SolutionMakers/controller" method="get">
						<input type="submit" style="float:right" value="Buscar" class="w3-bar-item w3-button w3-mobile w3-light-grey">
						<input type='text' name="busca" style="float:right" class='w3-bar-item w3-mobile' placeholder='O que gostaria de buscar?'>
						<input type="hidden" name="acao" value="resultadoBusca"/> 
					</form>
					
				</div>
			</div>
		</div>
</body>
</html>