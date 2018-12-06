<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			<input type="email"  name="email" id="email" onkeyup="validarEmail(this.value)" class="form-control" maxlength="70" required /> 
			
			<label for="nickname">Digite uma breve descrição sobre o usuário:</label> 
			<textarea class="form-control" name="bio" id="bio" rows="4" cols="50"></textarea>

			<input type="submit" class="btn btn-success" value="Cadastrar"/>

			<input type="hidden" value="${usuarioEmSessao.nickname}" name="usuarioNick"/>
			<input type="hidden" value="${usuarioEmSessao.nivelAcesso}" name="usuarioNivelAcesso"/>
			<input type="hidden" name="acao" value="cadastraUsuario">
				
			
		</div>
	</div>


</form>

<br>
<br>


<script>

	
    function validarEmail(email) {

        var email = document.getElementById("email");
        document.getElementById('email').style.color="#000000";

        if(email != null && email.length > 0){
            var usuario = email.substring(0, email.indexOf("@"));
            var dominio = email.substring(email.indexOf("@")+ 1, email.length);
            if ((usuario.length >=1) &&
                (dominio.length >=3) &&
                (usuario.search("@")==-1) &&
                (dominio.search("@")==-1) &&
                (usuario.search(" ")==-1) &&
                (dominio.search(" ")==-1) &&
                (dominio.search(".")!=-1) &&
                (dominio.indexOf(".") >=1)&&
                (dominio.lastIndexOf(".") < dominio.length - 1)) {
            	email.style.borderColor = "green";
            }
            else{
            	email.style.borderColor = "red";
            }
        }

    }
	

</script>

<%@include file="/WEB-INF/layout_footer.jsp"%>