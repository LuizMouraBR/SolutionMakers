<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/layout_header.jsp"%>
<head>
<style>
.pChave {
	display: flex;
	color: white;
}
.cardResposta{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	background-color: white;
	padding: 30px 20px;
	border-radius: 4px;"
	margin: 12px;
}
</style>
<title><c:out value="${topico.titulo}"></c:out> - SolutionMakers</title>
</head>

<div style="margin-left: 3%; max-width: 700px;">
<br>
	<h2>
		<c:out value="${topico.titulo}"></c:out>
	</h2>
	<div>
		<form action="/SolutionMakers/controller?" method="get" >
			<div style="padding: 5px 5px;">
				<i>por 
					<input class="btn btn-dark" type="submit" value="${topico.autor_nickname}">
					
					<c:if test="${topico.autor_nivelAcesso == 2}">
						<span class="btn btn-success">Operador</span>
					</c:if>
					
					<c:if test="${topico.autor_nivelAcesso == 3}">
						<span class="btn btn-primary">Cliente</span>
					</c:if>
					
					<c:if test="${topico.autor_nivelAcesso == 4}">
						<span class="btn btn-warning">Usuário</span>
					</c:if>
					
				</i>
			</div>
			<input type="hidden" value="${topico.autor_nickname}" name="userNick">
			<input type="hidden" name="acao" value="conta">
		</form>
	</div>
	<hr>
	<p>
		<c:out value="${topico.descricao}"></c:out>
	</p>
	<br>

	<p>Palavras chave:</p>

	<div class="pChave">
		<c:if test="${topico.pChave1 != NULL}">
			<form method="get" action="/SolutionMakers/controller">
				<!-- <input type="hidden" value="buscaPalavraChave" name="acao"> -->
				<button name="pChave" class="btn btn-info" type="submit" value="${topico.pChave1}">
					<c:out value="${topico.pChave1}"></c:out>
				</button>
			</form>
		</c:if>
		-
		<c:if test="${topico.pChave2 != NULL}">
			<form method="get">
				<input type="hidden" value="buscaPalavraChave" name="acao">
				<button name="pChave" class="btn btn-info" value="${topico.pChave2}">
					<c:out value="${topico.pChave2}"></c:out>
				</button>
			</form>
		</c:if>
		-
		<c:if test="${topico.pChave3 != NULL}">
			<form method="get">
				<input type="hidden" value="buscaPalavraChave" name="acao">
				<button name="pChave" class="btn btn-info" value="${topico.pChave3}">
					<c:out value="${topico.pChave3}"></c:out>
				</button>
			</form>
		</c:if>
	</div>

<hr>
	<h2>Respostas:</h2>
	
	<c:if test="${empty topico.respostas}">
		<div class="alert alert-danger">
			<p> Não há respostas ainda...			</p>
			Seja o primeiro :)
		</div>
	</c:if>
	
	<c:forEach var="resposta" items="${topico.respostas}">
		<div class="cardResposta">
		<p style="color: black;">
		<span class="glyphicon glyphicon-pencil"></span>
			<c:out value="${resposta.conteudo}"></c:out>
		</p>
		<form action="/SolutionMakers/controller?" method="get">
			<div style="padding: 5px 5px;">
				<i>por 
					<input class="btn btn-dark" type="submit" value="${resposta.usuarioNick }">
				
				<c:if test="${resposta.usuarioNivelAcesso == 2}">
					<span class="btn btn-success">OP</span>
				</c:if>
				
				<c:if test="${resposta.usuarioNivelAcesso == 3}">
					<span class="btn btn-primary">CL</span>
				</c:if>
				
				<c:if test="${resposta.usuarioNivelAcesso == 4}">
					<span class="btn btn-warning">US</span>
				</c:if>
				
				</i>
			</div>
			<input type="hidden" value="${resposta.usuarioNick }" name="userNick">
			<input type="hidden" name="acao" value="conta">
		</form>
		<c:if test="${usuarioEmSessao.nivelAcesso == 1 && resposta.usuarioNivelAcesso == 2}">
			<form action="/SolutionMakers/controller?" method="get">
			<div style="padding: 5px 5px;">
				<input class="btn btn-warning" type="submit" value="Editar resposta">
			</div>
			<input type="hidden" value="${resposta.id}" name="respostaId">
			<input type="hidden" name="acao" value="editarResposta">
		</form>
		</c:if>
		
		<i style="float: right;">
			<c:out value="${resposta.dataPostagem}"></c:out>
		</i>
		</div>
		<br>
	</c:forEach>
<hr>

Envie sua resposta:
<br><br>

<c:if test="${usuarioEmSessao != null}">
		<form action="/SolutionMakers/controllerTopico?">
			<textarea placeholder="Digite sua resposta aqui" class="form-control" name="conteudo"></textarea><br>
			<button type="submit" class="btn btn-success">Enviar resposta</button>
			<input type="hidden" value="${usuarioEmSessao.nickname}" name="usuarioNick"/>
			<input type="hidden" value="${topico.id}" name="topicoId"/>
			<input type="hidden" value="${usuarioEmSessao.id}" name="usuarioId"/>
			<input type="hidden" name="acao" value="resposta">
		</form>
	<br>
</c:if>


<c:if test="${usuarioEmSessao == null}">
	<div class="alert alert-warning">
		Você precisa <a href="/SolutionMakers/pages/login.jsp" style="color: blue;">fazer login</a> para poder responder a este ticket.<br>
	</div>

</c:if>
<br>

</div>
<%@include file="/WEB-INF/layout_footer.jsp"%>
