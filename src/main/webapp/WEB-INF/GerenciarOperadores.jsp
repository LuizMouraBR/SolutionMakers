<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout_header.jsp"%>
<br>

<div style="margin-left: 3%; max-width: 700px;">

<h1>Gerenciar operadores</h1>

<form method="get" action="/SolutionMakers/controller?">
	<button type="submit" class="btn btn-info" name="acao" value="AdicionarOperador">Adicionar operador</button>
	<button type="submit" class="btn btn-info" name="acao" value="ListarOperador">Listar operadores</button>
	<button type="submit" class="btn btn-info" name="acao" value="FuncoesOperador">Funções de operador</button>
</form>


</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>