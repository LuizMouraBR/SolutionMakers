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

			<label for="nickname">Digite seu apelido:</label> 
			<input type="text" name="nickname" class="form-control" maxlength="16" required /> 
			
			<label for="email">Digite seu e-mail:</label> 
			<input type="email"  name="email" class="form-control" maxlength="70" required /> 
			
			<label for="senha">Digite sua senha:</label> 
			<input type="password" name="senha" class="form-control" maxlength="16" onblur="verificaSenhas()" id="campo1" required /> 
			
			<label for="RepSenha">Repita sua senha:</label> 
			<input type="password" name="RepSenha" class="form-control" maxlength="255" onblur="verificaSenhas()" id="campo2" required /> 
			
			<div id="senhas" style="display: none; color: red;" >
				<b>Erro</b> As senhas devem coincidir.
			</div>
			
			<label for="nickname">Digite uma breve descrição sobre o usuário:</label> 
			<textarea class="form-control" rows="4" cols="50"></textarea>
			
			<label for="email">Digite seu e-mail:</label> 
			<input type="email"  name="email" class="form-control" maxlength="70" required /> 
			
			
		</div>
	</div>


</form>

<br>
<br>


<script>

	function verificaSenhas(){
		var campo1 = document.getElementById("campo1");
		var campo2 = document.getElementById("campo2");
		var divSenhas = document.getElementById("senhas");
		
		if(!campo1.value.localeCompare(campo2.value)){
			divSenhas.style.display = "none";
			campo1.style.borderColor = "#ced4da";
			campo2.style.borderColor = "#ced4da";
		}
		else{
			divSenhas.style.display = "block";
			campo1.style.borderColor = "red";
			campo2.style.borderColor = "red";
		}
		
	}

</script>

<%@include file="/WEB-INF/layout_footer.jsp"%>