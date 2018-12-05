<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/layout_header.jsp"%>
<style>

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

</style>

<br>

<div style="margin-left: 3%; max-width: 700px;">

<h1>Listar operadores</h1>

<table>
  <tr>
    <th>ID</th>
    <th>Operador</th>
    <th>Tickets Resolvidos</th>
    <th>Ações</th>
  </tr>

  <c:forEach var="operador" items="${listOperador}">
	  <tr>
	    <td><c:out value="${operador.id}"></c:out></td>
	    <td><c:out value="${operador.usuarioNickname}"></c:out></td>
	    <td><c:out value="${operador.ticketsResolvidos}"></c:out></td>
	    
	    <td><form action="/SolutionMakers/controller?"><button type="submit" name="acao" value="ExcluirOperador" class="btn btn-danger">Excluir</button><input type="hidden" name="usuarioId" value="${operador.usuarioId }"/></form></td>
	    
	  </tr>
  </c:forEach>
  
</table>


</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>