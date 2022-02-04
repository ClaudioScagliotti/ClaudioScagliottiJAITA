<%@ include file="header.jsp"%>
<%@page import="java.util.List" %>
<%@page import="model.Serie" %>
<form action="addSerie" method="post">
<label for="titolo_id"> Inserisci titolo</label>
<input type="text" nome="titolo" id="titolo_id">

<label for="genere_id"> Inserisci genere</label>
<input type="text" nome="genere" id="genere_id">
<input type="submit">
</form>

<%@ include file="footer.jsp"%>