<!-- "/aggiungiLibro" -->
<%@page import="model.Libro"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
<div class="container">
  <h2>Aggiungi libro</h2> 
  <a href="listaLibri"> Indietro </a>
	<form method="post" action="aggiungiLibro">
		Titolo:<input type="text" name="titolo" ><br>
		Prezzo:<input type="text" name="prezzo" ><br>
		Pagine:<input type="text" name="pagine" ><br>
		
		<input type="submit" value="Salva">
	</form>
	</div>
		<% 
	String msg=(String)request.getAttribute("avvisoMessaggio");
	if(msg!=null){
		out.print("<script>alert(\""+msg+"\");</script>");
	}
	%>
	</body>
</html>