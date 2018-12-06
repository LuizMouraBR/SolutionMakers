<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout_header.jsp"%>
<br>

<div style="margin-left: 3%; max-width: 700px;">

<h1>Funções operador</h1>

<form method="get" action="/SolutionMakers/controller?">
	<button type="submit" class="btn btn-info" name="acao" value="AdicionarCliente">Adicionar clientes</button>
	<button type="submit" class="btn btn-info" name="acao" value="ListarCliente">Listar clientes</button>
</form>

</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>