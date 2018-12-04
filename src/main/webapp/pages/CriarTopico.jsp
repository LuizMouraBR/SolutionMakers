<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/layout_header.jsp"%>

<div style="margin-left: 3%; margin-right: 3%; max-width: 700px;">
	<br>
	<h1>Criar novo ticket</h1>
	
	<form method="post" class="form-group">
	
		<label for="nome">Digite o nome do ticket:</label>
		<input type="text" name="nome" class="form-control" placeholder="Ex: Como apagar todos os campos de um vetor"/>
		<br>
		
		<label for="nome">Digite uma, duas ou três palavras chave:</label>
		
		<div style="width: 30%;"><input type="text" name="p1Chave" class="form-control" placeholder="Ex: .net framework"/></div>
		<div style="width: 30%;"><input type="text" name="p2Chave" class="form-control" placeholder="Ex: Segurança"/></div>
		<div style="width: 30%;"><input type="text" name="p3Chave" class="form-control" placeholder="Ex: Minecraft"/></div>
		<br>
		
		<label for="nome">Digite a descrição do ticket:</label>
		<textarea class="form-control" placeholder="Digite a descrição e detalhes do seu ticket para que sua dúvida seja melhor identificada e esclarecida." name="descricao"></textarea>
		<br>
		
		<input type="submit" class="btn btn-success" value="Criar ticket"/>
	</form>
</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>