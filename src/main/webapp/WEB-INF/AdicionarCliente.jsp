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

<h1>Adicionar cliente</h1>

<form action="/SolutionMakers/controller?">

	<div class="form-group">
		<div class="CadastroForm">
		<h2>Digite os dados de usuário do cliente: </h2>
		
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
			
			<hr>
			
			<h2>Digite os dados de cliente: </h2>
	
			<label for="nomeCompleto">Digite o nome completo do cliente:</label> 
			<input type="text" name="nomeCompleto" class="form-control" maxlength="80" required /> 
			
			<label for="rg">Digite o RG do cliente:</label> 
			<input type="text" name="rg" class="form-control" maxlength="20" required /> 
			
			<label for="cpf">Digite o CPF do cliente:</label> 
			<input type="text" name="cpf" class="form-control" maxlength="25" required /> 
			
			<label for="pis">Digite o PIS do cliente:</label> 
			<input type="text" name="pis" class="form-control" maxlength="25" required /> 
			
			<label for="empresaId">Selecione a empresa em que o cliente trabalha:</label> 
			<select class="form-control" name="empresaId">
				<c:forEach var="empresa" items="${empresas}">
					<option value="${empresa.id}"><c:out value="${empresa.nomeFantasia}"></c:out> </option>
				</c:forEach>
			</select>
			
			
			<button class="btn btn-success" type="submit">Adicionar cliente</button>
			
			<input type="hidden" name="acao" value="adicionarClienteConfirm">
		</div>
	</div>
</form>

</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>