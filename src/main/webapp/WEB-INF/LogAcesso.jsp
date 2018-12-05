<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/layout_header.jsp"%>
<br>
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

<div style="margin-left: 3%; max-width: 700px;">

<h1>Log de acesso</h1>

<table>
  <tr>
    <th>ID</th>
    <th>Email do usu�rio</th>
    <th>A��o</th>
    <th>Data e hora</th>
  </tr>

  <c:forEach var="log" items="${logsAcesso}">
	  <tr>
	    <td><c:out value="${log.id}"></c:out></td>
	    <td><c:out value="${log.emailUser}"></c:out></td>
	    <td><c:out value="${log.acao}"></c:out></td>
	    <td><c:out value="${log.data}"></c:out></td>
	  </tr>
  </c:forEach>
  
</table>

</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>