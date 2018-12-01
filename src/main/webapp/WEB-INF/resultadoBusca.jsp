<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/layout_header.jsp"%>

<head>
<title>Você buscou por: <c:out value="${busca}"></c:out> -
	SolutionMakers
</title>
</head>

<div style="margin-left: 3%;">

	<h3 id="minhaBusca">
		Você buscou por
		<c:out value="${busca}"></c:out>
		:
	</h3>


	<c:if test="${empty topicos}">
		<h2 class="alert alert-danger">Sua busca não retornou nenhum
			resultado. =/</h2>
	</c:if>

	<c:forEach var="topico" items="${topicos}">
		<div class="card"
			style="margin: auto; box-shadow: 0px 4px 8px #888888; max-width: 700px;">
			<div class="card-body">
				<form action="/SolutionMakers/controllerTopico?" method="get">
					<input type="submit" class="btn btn-info" style="color: white;"
						value="<c:out value="${topico.titulo}"></c:out>"> <input
						type="hidden" name="topicoID" value="${topico.id}"> <input
						type="hidden" name="acao" value="ViewTopico">
				</form>
				<c:if test="${topico.resolvido == true}">
					<p
						style="border-radius: 5px; float: right; background-color: #00cc00; padding: 5px 5px;">Resolvido</p>
				</c:if>

				<c:if test="${topico.resolvido == false}">
					<p
						style="border-radius: 5px; float: right; background-color: #ff1a1a; padding: 5px 5px;">Não
						resolvido</p>
				</c:if>

				<form action="/SolutionMakers/controller?" method="get">
					<div style="padding: 5px 5px;">
						<i>por 
						<input class="btn btn-light" type="submit" value="${topico.autor_nickname}">
						</i>
					</div>
					<input type="hidden" value="${topico.autor_nickname}" name="userNick">
					<input type="hidden" name="acao" value="conta">
				</form>
				<hr>
				<p class="card-text">
					<c:out value="${topico.descricao}"></c:out>
				</p>
				<h6>
					<c:out value="${topico.respostas}"></c:out>
					respostas
				</h6>

			</div>
		</div>
		<br>
	</c:forEach>

</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>