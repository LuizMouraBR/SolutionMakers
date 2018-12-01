<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/layout_header.jsp"%>
<head>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<style>
.pChave {
	display: flex;
	color: white;
}
</style>
<title><c:out value="${usuario.nickname}"></c:out> -
	SolutionMakers</title>
</head>

<div style="margin-left: 3%; margin-right: 3%; max-width: 700px;">
	<br>

	<c:if test="${usuario.nickname != null}">
	<i class="material-icons">
account_circle
</i>
		<img style="float: left; padding: 5px 5px;"
			src="https://image.freepik.com/free-icon/user-image-with-black-background_318-34564.jpg"
			alt="Foto do Usuário" width="100px" />

		<h2>
			<c:out value="${usuario.nickname}"></c:out>
		</h2> (Administrador)
		<br>
		<br>
		<h3>Bio:</h3>
		<p>
			<c:out value="${usuario.bio}"></c:out>
		</p>
	</c:if>



	<c:if test="${usuario.nickname == null}">
		<div class="alert alert-danger">
			<h2>Usuário não encontrado. :/</h2>
		</div>
	</c:if>


</div>

<%@include file="/WEB-INF/layout_footer.jsp"%>
