<%@page import="model.AutoreLibro"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
<div class="container">
  <h2>Aggiungi relazione autore-libro</h2> 
  <a href="listaAutoriLibri"> Indietro </a>
  <form method="post" action="aggiungiAutoreLibro">
  		ID Libro:<input type="text" name="libro_id" ><br>
		ID Autore:<input type="text" name="autore_id" ><br>
			<input type="submit" value="Salva">
	</form>
	</div>	
</body>
</html>