<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/layout_header.jsp"%>

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

<br>
<br>

<form>

	<div class="form-group">
		<div class="CadastroForm">


			<h2>Cadastro</h2>
			<h6>
				Para efetuar o cadastro, você deve preencher <b>todos os campos</b>
				abaixo.
			</h6>

			<label for="empresa">Digite o nome da Empresa:</label> 
			<input type="text" name="nomeEmpresa" class="form-control" maxlength="20" required /> 
		
			<label for="empresa">Digite a razão social da Empresa:</label> 
			<input type="text" name="razaoSocial" class="form-control" maxlength="20" required /> 
			
			<label for="empresa">Digite o CNPJ da Empresa:</label> 
			<input type="text" name="cnpj" class="form-control" maxlength="20" required /> 
		
			<label for="empresa">Digite o endereço da Empresa:</label> 
			<input type="text" name="endereco" class="form-control" maxlength="20" required /> 
			
			<input type="submit" class="btn btn-success" value="Criar Empresa"/>
		
			<input type="hidden" value="${usuarioEmSessao.nickname}" name="usuarioNick"/>
			<input type="hidden" value="${usuarioEmSessao.nivelAcesso}" name="usuarioNivelAcesso"/>
			<input type="hidden" name="acao" value="cadastraEmpresa">
			

		</div>
	</div>


</form>


<%@include file="/WEB-INF/layout_footer.jsp"%>