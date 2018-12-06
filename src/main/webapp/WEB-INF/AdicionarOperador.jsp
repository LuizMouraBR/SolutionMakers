<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout_header.jsp"%>
<br>
<style>
.CadastroForm {
	border-radius: 10px;
	box-shadow: 0 0px 0px 0 rgba(0, 0, 0, 0.9), 0 0px 50px 0
		rgba(0, 0, 0, 0.59);
	background-color: #EEEEEE;
	max-width: 500px;
	padding: 16px 16px;
	margin: auto;
}
</style>
<div style="margin-left: 3%; max-width: 700px;">

<h1>Adicionar operador</h1>

<form action="/SolutionMakers/controller?">

	<div class="form-group">
		<div class="CadastroForm">
		<h2>Digite os dados de usuário: </h2>
		
			<h6>
				Para efetuar o cadastro, você deve preencher <b>todos os campos</b>
				abaixo.
			</h6>

			<label for="nickname">Digite o nickname:</label> 
			<input type="text" name="nickname" class="form-control" maxlength="50" required /> 
			
			<label for="email">Digite o email:</label> 
			<input type="text" name="email" class="form-control" maxlength="60" required /> 

			<label for="bio">Digite a bio (Um breve resumo):</label> 
			<input type="text" name="bio" class="form-control" /> 
			
			<button class="btn btn-success" type="submit">Adicionar operador</button>
			
			<input type="hidden" name="acao" value="adicionarOperadorConfirm">
		</div>
	</div>
</form>

</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>