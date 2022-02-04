<%@ include file="header.jsp"%>
<%@page import="java.util.List" %>
<%@page import="model.Serie" %>
<h1>Elenco serie tv</h1>
<table>
<tr>
<th>Titolo</th>
<th>Genere</th>
</tr>
<%
List<Serie> l= (List<Serie>) request.getAttribute("elencoSerie");
%>
<%
for(Serie s1: l){
%>
<tr>
<td><%= s1.getTitolo( ) %> </td>
<td><%= s1.getGenere( ) %> </td>
<%
}
%>
</tr>
</table>
<%@ include file="footer.jsp"%>
