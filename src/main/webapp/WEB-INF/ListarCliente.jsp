<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h1>Listar clientes</h1>

<table>
  <tr>
    <th>ID</th>
    <th>Nome Completo</th>
    <th>RG</th>
    <th>CPF</th>
    <th>PIS</th>
    <th>Empresa</th>
    <th>Ações</th>
  </tr>

  <c:forEach var="cliente" items="${listCliente}">
	  <tr>
	    <td><c:out value="${cliente.id}"></c:out></td>
	    <td><c:out value="${cliente.nomeCompleto}"></c:out></td>
	    <td><c:out value="${cliente.rg}"></c:out></td>
	    <td><c:out value="${cliente.cpf}"></c:out></td>
	    <td><c:out value="${cliente.pis}"></c:out></td>
	    <td><c:out value="${cliente.empresaNome}"></c:out></td>
	    
	    <td><form action="/SolutionMakers/controller?"><button type="submit" name="acao" value="ExcluirCliente" class="btn btn-danger">Excluir</button><input type="hidden" name="usuarioId" value="${cliente.usuarioId }"/></form></td>
	    
	  </tr>
  </c:forEach>
  
</table>


</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>