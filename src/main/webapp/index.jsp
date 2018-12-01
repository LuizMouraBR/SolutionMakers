<%@include file="/WEB-INF/layout_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>SolutionMakers - Bem vindo(a)</title>
<style>
.pageContent{
	margin-left: 3%;
	margin-right: 3%;
	border-radius: 3px;
}
.cardPrincipal{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	background-color: white;
	padding: 12px 12px;
	border-radius: 4px;"
}
.cardRelacionado{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	background-color: white;
	padding: 20x 20px;
	border-radius: 4px;"
}
</style>
</head>

<div class="conteudoPrincipal" style="text-align: center; margin: auto; padding: 25px 25px;">
<div class="pageContent">
	<div class="row">
	
	<!-- Conteúdo em destaque -->
	  <div class="col-sm-9">
	  
		<h1>Soluções para você...</h1>
		<br>
		  
		<div class="cardPrincipal">
		<h3>Conteúdo principal</h3>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque
			tincidunt fermentum dolor, at vulputate purus rhoncus quis. Curabitur
			venenatis ullamcorper urna ac dapibus. Fusce hendrerit faucibus sapien,
			non tristique ipsum posuere in. Integer viverra odio at libero dapibus
			facilisis. Proin nec lorem maximus, finibus erat mattis, convallis
			nisi. Nulla facilisi. Etiam vehicula sapien nec interdum consectetur.
			Cras consequat est odio, sit amet tempor urna tempor et. Nunc augue
			purus, pharetra eget mauris a, volutpat dapibus arcu. Fusce a est id
			est cursus laoreet. Integer malesuada velit sit amet tempor elementum.
			Sed ut luctus ex. Etiam luctus libero vitae libero posuere posuere in
			non neque.
		
		</p>
		<form action="#">
			<input type="submit" value="Ver mais" class="btn btn-info">
		</form>	
		</div>
		<br>
		
		<div class="cardPrincipal">
		<h3>Conteúdo principal</h3>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque
			tincidunt fermentum dolor, at vulputate purus rhoncus quis. Curabitur
			venenatis ullamcorper urna ac dapibus. Fusce hendrerit faucibus sapien,
			non tristique ipsum posuere in. Integer viverra odio at libero dapibus
			facilisis. Proin nec lorem maximus, finibus erat mattis, convallis
			nisi. Nulla facilisi. Etiam vehicula sapien nec interdum consectetur.
			Cras consequat est odio, sit amet tempor urna tempor et. Nunc augue
			purus, pharetra eget mauris a, volutpat dapibus arcu. Fusce a est id
			est cursus laoreet. Integer malesuada velit sit amet tempor elementum.
			Sed ut luctus ex. Etiam luctus libero vitae libero posuere posuere in
			non neque.
		
		</p>
		<form action="#">
			<input type="submit" value="Ver mais" class="btn btn-info">
		</form>	
		</div>
		<br>
		
	</div>
	
	<!-- Tickets recentes -->
	  <div class="col-sm-3" style="background-color: #EEEEEF; border-radius: 10px;">
		  <h1>Tickets Recentes</h1>
		  <br>
		
		<c:if test="${not empty topicos}">
		
			<c:forEach var="topico" items="${topicos}">
				<div class="cardRelacionado" >
					<div class="col-sm-12" >
						<form method="get">
							<a href="/SolutionMakers/controllerTopico?acao=ViewTopico&topicoID=${topico.id}" style="color: dodgerblue;" href="#" ><c:out value="${topico.titulo}"></c:out></a>  
							<p><c:out value="${topico.descricao}"></c:out></p>
						</form>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${empty topicos}">
		
			<div class="alert alert-danger">
				<b>Erro de conexão com a base de dados.</b>
				<p><small>Ou nenhum ticket foi inserido.</small></p>
			</div>
		</c:if>
		
	  </div>
	</div>
</div>

</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>