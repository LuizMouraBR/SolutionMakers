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
				</i>
			</div>
			<input type="hidden" value="${resposta.usuarioNick }" name="userNick">
			<input type="hidden" name="acao" value="conta">
		</form>
		<i style="float: right;">
			<c:out value="${resposta.dataPostagem}"></c:out>
		</i>
		
		</div>
		<br>
	</c:forEach>
<hr>
Envie sua resposta:
<br><br>
	<form action="/SolutionMakers/controllerTopico?">
		<textarea placeholder="Digite sua resposta aqui" class="form-control" name="conteudo"></textarea><br>
		<button type="submit" class="btn btn-success">Enviar resposta</button>
		<input type="hidden" value="luizmourabr" name="usuarioNick"/>
		<input type="hidden" value="${topico.id}" name="topicoId"/>
		<input type="hidden" value="2" name="usuarioId"/>
		<input type="hidden" name="acao" value="resposta">
	</form>
	<br>
</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>
