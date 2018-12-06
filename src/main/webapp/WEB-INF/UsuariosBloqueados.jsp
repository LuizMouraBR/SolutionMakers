<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/layout_header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<h1>Usu�rios bloqueados</h1>


<table>
  <tr>
    <th>ID</th>
    <th>Email do usu�rio</th>
  </tr>

  <c:forEach var="user" items="${listUsuariosBloq}">
	  <tr>
	    <td><c:out value="${user.id}"></c:out></td>
	    <td><c:out value="${user.email}"></c:out></td>
	  </tr>
  </c:forEach>
  
</table>

</div>

<br>
<%@include file="/WEB-INF/layout_footer.jsp"%>