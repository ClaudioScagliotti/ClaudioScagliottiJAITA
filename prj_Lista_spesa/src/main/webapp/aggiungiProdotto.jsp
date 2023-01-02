
<%@ include file="header.jsp"%>
<h1>Inserimento nuovo prodotto</h1>
<form action="aggiungiProdotto" method="post">
<label for="nome_id"> Inserisci nome:</label>
<input type="text" name="nome" id="nome_id">
<label for="prezzo_id"> Inserisci prezzo:</label>
<input type="number" name="prezzo" id="prezzo_id">
<label for="reparto_id"> Inserisci reparto:</label>
<input type="text" name="reparto" id="reparto_id">
<input type="submit" name="Aggiungi" id="aggiungi_id">
</form>
<%@ include file="footer.jsp"%>