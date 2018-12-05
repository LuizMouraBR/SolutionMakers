<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/layout_header.jsp"%>

<div style="margin-left: 3%; margin-right: 3%; max-width: 700px;">
	<br>
	<h1>Criar novo ticket</h1>
	
	<form class="form-group" action="/SolutionMakers/controllerTopico?">
	
		<label for="titulo">Digite o nome do ticket:</label>
		<input type="text" name="titulo" class="form-control" placeholder="Ex: Como apagar todos os campos de um vetor"/>
		<br>
		
		<label for="">Digite uma, duas ou três palavras chave:</label>
		<div style="width: 30%;"><input type="text" name="pChave1" class="form-control" placeholder="Ex: .net framework"/></div>
		<div style="width: 30%;"><input type="text" name="pChave2" class="form-control" placeholder="Ex: Segurança"/></div>
		<div style="width: 30%;"><input type="text" name="pChave3" class="form-control" placeholder="Ex: Minecraft"/></div>
		<br>
		
		<label for="descricao">Digite a descrição do ticket:</label>
		<textarea class="form-control" placeholder="Digite a descrição e detalhes do seu ticket para que sua dúvida seja melhor identificada e esclarecida." name="descricao"></textarea>
		<br>
		
		<input type="submit" class="btn btn-success" value="Criar ticket"/>
		
		<input type="hidden" value="${usuarioEmSessao.nickname}" name="usuarioNick"/>
		<input type="hidden" value="${usuarioEmSessao.nivelAcesso}" name="usuarioNivelAcesso"/>
		<input type="hidden" name="acao" value="criarTopico">
	</form>
</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>