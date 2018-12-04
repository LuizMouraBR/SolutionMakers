<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/layout_header.jsp"%>

<div style="margin-left: 3%; margin-right: 3%; max-width: 700px;">
	<br>
	<h1>Criar novo ticket</h1>
	
	<form method="post" class="form-group">
	
		<label for="nome">Digite o nome do ticket:</label>
		<input type="text" name="nome" class="form-control" placeholder="Digite o título do seu ticket"/>
		<br>
		<label for="nome">Digite a descrição do ticket:</label>
		<textarea class="form-control" placeholder="Digite a descrição e detalhes do seu ticket para que sua dúvida seja melhor identificada e esclarecida." name="descricao"></textarea>
		<br>
		<input type="submit" class="btn btn-success" value="Criar ticket"/>
	</form>
</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>