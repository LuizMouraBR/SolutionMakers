<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/layout_header.jsp"%>

<div style="margin-left: 3%; margin-right: 3%; max-width: 700px;">
	<br>
	<h1>Deixar uma sugestão</h1>
	
	<p>Ficamos felizes que você esteja disposto(a) a nos ajudar com seu importante feedback :)</p>
	
	<form method="post" class="form-group">
	
		<label for="nome">Digite um título a sua sugestão:</label>
		<input type="text" name="nome" class="form-control" placeholder="Ex: Implementar um sistema de identificação por voz"/>
		<br>
		
		<label for="nome">Digite a sugestão (ou sugestões) por extenso:</label>
		<textarea class="form-control" placeholder="Explique de forma clara todos os pontos de sua sugestão." name="descricao"></textarea>
		<br>
		
		<small>Agradecemos seu feedback!</small> <br>
		<input type="submit" class="btn btn-success" value="Enviar sugestão"/>
	</form>
</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>