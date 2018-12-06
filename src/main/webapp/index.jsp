<%@include file="/WEB-INF/layout_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  
		<h1>Acontecendo atualmente... <c:out value="${data}"></c:out> </h1>
		<br>
		  
		<div class="cardPrincipal">
		<h3>Bancos digitais são seguros? Veja o que dizem os especialistas</h3>
		<hr>
		<p>
			O mundo das empresas de tecnologia financeira, as fintechs, sofreu um susto na sexta-feira (4), diante das notícias de que o Banco Central determinou a liquidação extrajudicial do banco comercial Neon, parceiro da fintech de mesmo...
		</p>
		<form action="https://economia.uol.com.br/noticias/redacao/2018/05/05/bancos-digitais-sao-seguros-veja-o-que-dizem-os-especialistas.htm" target="_blank">
			<input type="submit" value="Ver mais" class="btn btn-info">
		</form>	
		</div>
		<br>
		
		<div class="cardPrincipal">
		<h3>Tudo o que você precisa saber sobre as novas placas de vídeo NVidia</h3>
		<hr>
		<p>
			Faz bastante tempo, mas depois de anunciar a arquitetura Pascal em 2014 e lançar as GTX 1070 e 1080 em maio de 2016, a Nvidia finalmente lançou uma nova placa gráfica de topo de linha para gamers. Diga oi para as novas GeForce RTX 2070, 2080 e 2080 Ti. Logo de cara, o nome das novas GPU da empresa indicam algumas grandes mudanças. A 2080 Ti traz a nova ger...
		</p>
		<form action="https://gizmodo.uol.com.br/placas-video-nvidia-rtx/" target="_blank">
			<input type="submit" value="Ver mais" class="btn btn-info">
		</form>	
		</div>
		<br>
		
		<div class="cardPrincipal">
		<h3>SpaceX lança 64 satélites de uma vez</h3>
		<hr>
		<p>
			     Washington, 3 dez 2018 (AFP) - A SpaceX lançou seu foguete Falcon 9 nesta segunda-feira (3), enviando uma carga incomum ao espaço - 64 satélites ao mesmo tempo, um recorde dos EUA. A empresa chefiada pelo bilionário americano Elon Musk registrou mais um marco em sua tentativa de tornar os foguetes mais reutilizáveis, como os aviões: o lançamento usou um propulsor reciclado pela tercei...
		</p>
		<form action="https://noticias.uol.com.br/ciencia/ultimas-noticias/afp/2018/12/03/spacex-lanca-64-satelites-de-uma-vez.htm" target="_blank">
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