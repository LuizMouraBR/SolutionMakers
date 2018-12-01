<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/layout_header.jsp"%>
<head>
<style>
.pChave {
	display: flex;
	color: white;
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
				<i>por <input class="btn btn-light" type="submit"
					value="${topico.autor_nickname}">
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


	<h2>Respostas:</h2>
</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>
