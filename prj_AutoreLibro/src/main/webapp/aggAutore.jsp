<%@page import="model.Autore"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
<div class="container">
  <h2>Aggiungi autore</h2> 
  <a href="listaAutori"> Indietro </a>
  	<form method="post" action="aggiungiAutore">
		Nome:<input type="text" name="nome" ><br>
		Cognome:<input type="text" name="cognome" ><br>
		Nazionalita:<input type="text" name="nazionalita" ><br>
		
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