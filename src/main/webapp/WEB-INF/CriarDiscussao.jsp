<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout_header.jsp"%>

<div style="margin-left: 3%; margin-right: 3%; max-width: 700px;">
	<br>
	<h1>Criar nova discussão!</h1>
	
	 
	<form class="form-group" action="/SolutionMakers/controllerDiscussao?">
	
		<label for="titulo">Digite o título da discussão:</label>
		<input type="text" name="titulo" class="form-control" placeholder="Você acha certo o vetor começar no 0?"/>
		<br>

		
		<label for="descricao">Digite a descrição da discussão:</label>
		<textarea class="form-control" placeholder="Digite a descrição e detalhes da sua discussão." name="descricao"></textarea>
		<br>
		
		<input type="submit" class="btn btn-success" value="Criar discussão"/>
		
		<input type="hidden" value="${usuarioEmSessao.nickname}" name="usuarioNick"/>
		<input type="hidden" value="${usuarioEmSessao.nivelAcesso}" name="usuarioNivelAcesso"/>
		<input type="hidden" name="acao" value="criarDiscussao">
	</form>
	
</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>