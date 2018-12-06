<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/layout_header.jsp"%>
<br>

<div style="margin-left: 3%; max-width: 700px;">

<h1>Editando resposta de <c:out value="${resposta.usuarioNick}"></c:out> </h1>

<form action="/SolutionMakers/controllerTopico?">

	<textarea class="form-control" name="conteudo" placeholder="${resposta.conteudo}">${resposta.conteudo}</textarea>

	<button type="submit" class="btn btn-warning">Editar resposta</button>
	
	<input type="hidden" name="editorId" value="${usuarioEmSessao.id}"/>
	<input type="hidden" name="respostaId" value="${resposta.id}"/>
	<input type="hidden" name="acao" value="editarRespostaConfirm"/>
</form>

</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>