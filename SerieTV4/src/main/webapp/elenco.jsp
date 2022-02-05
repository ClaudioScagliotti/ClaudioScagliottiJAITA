<%@ include file="header.jsp"%>
<%@page import="java.util.List" %>
<%@page import="model.Serie" %>
<h1>Elenco serie tv</h1>
<form action="elenco" method="post">
<label for="genere_id"> Filtra per genere</label>
<input type="text" name="genere" id="genere_id">
<input type="submit">
</form>
<!-- String titolo, String genere, int stagioni, int anno_inizio, int episodi, Boolean finita) -->
<table>
<tr>
<th>Titolo</th>
<th>Genere</th>
<th>Stagioni</th>
<th>Anno inizio</th>
<th>Episodi</th>
<th>Terminata</th>

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
<td><%= s1.getStagioni() %> </td>
<td><%= s1.getAnno_inizio() %> </td>
<td><%= s1.getEpisodi() %> </td>
<td><%= s1.getFinita() %> </td>
<%
}
%>
</tr>
</table>
<%@ include file="footer.jsp"%>
