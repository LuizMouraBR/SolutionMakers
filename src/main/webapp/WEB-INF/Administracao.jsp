<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout_header.jsp"%>
<br>

<div style="margin-left: 3%; max-width: 700px;">

<h1>Bem vindo à Administração</h1>

<form method="get" action="/SolutionMakers/controller?">
	<button type="submit" class="btn btn-info" name="acao" value="GerenciarOperadores">Gerenciar operadores</button>
	<button type="submit" class="btn btn-info" name="acao" value="LogAcesso">Log de acesso</button>
	<button type="submit" class="btn btn-info" name="acao" value="LogAcoes">Log de ações</button>
	<button type="submit" class="btn btn-info" name="acao" value="UsuariosBloqueados">Usuários bloqueados</button>
</form>

</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>