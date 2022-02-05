<%@ include file="header.jsp"%>
<%@page import="java.util.List" %>
<%@page import="model.Serie" %>
<h1>Aggiungi serie</h1>
<!-- String titolo, String genere, int stagioni, int anno_inizio, int episodi, Boolean finita) -->
<form action="addSerie" method="post">
<label for="titolo_id"> Inserisci titolo</label>
<input type="text" name="titolo" id="titolo_id">
<label for="genere_id"> Inserisci genere</label>
<input type="text" name="genere" id="genere_id">
<label for="genere_id"> Inserisci numero di stagioni</label>
<input type="number" name="stagioni" id="stagioni_id">
<label for="genere_id"> Inserisci anno di inizio</label>
<input type="number" name="anno" id="anno_id">
<label for="genere_id"> Inserisci numero di episodi</label>
<input type="number" name="episodi" id="episodi_id">
<label for="genere_id"> Finita?</label>
        <label for="true_ID">SI</label>
<input type="radio" name="finita" id="true_id" value="true">
        <label for="false_ID">NO</label>
<input type="radio" name="finita" id="false_id" value="false">


<input type="submit">
</form>

<%@ include file="footer.jsp"%>