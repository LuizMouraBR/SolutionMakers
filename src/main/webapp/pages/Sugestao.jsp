<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/layout_header.jsp"%>

<div style="margin-left: 3%; margin-right: 3%; max-width: 700px;">
	<br>
	<h1>Deixar uma sugest�o</h1>
	
	<p>Ficamos felizes que voc� esteja disposto(a) a nos ajudar com seu importante feedback :)</p>
	
	<form method="post" class="form-group">
	
		<label for="nome">Digite um t�tulo a sua sugest�o:</label>
		<input type="text" name="nome" class="form-control" placeholder="Ex: Implementar um sistema de identifica��o por voz"/>
		<br>
		
		<label for="nome">Digite a sugest�o (ou sugest�es) por extenso:</label>
		<textarea class="form-control" placeholder="Explique de forma clara todos os pontos de sua sugest�o." name="descricao"></textarea>
		<br>
		
		<small>Agradecemos seu feedback!</small> <br>
		<input type="submit" class="btn btn-success" value="Enviar sugest�o"/>
	</form>
</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>