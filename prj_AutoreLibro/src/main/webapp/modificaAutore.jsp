<%@page import="model.Autore"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
<div class="container">
  <h2>Modifica autore</h2> 
<a href="listaAutori"> Indietro </a>
	<form method="post" action="modificaAutore">
		Id: <input type="number" name="id" hidden value="<%=request.getAttribute("id")%>"><br>
		Nome: <input type="text" name="nome" value="<%=request.getAttribute("nome")%>"><br>
		Cognome:<input type="text" name="cognome" value="<%=request.getAttribute("cognome")%>"><br>
		Nazionalita:<input type="text" name="nazionalita" value="<%=request.getAttribute("nazionalita")%>"><br>
		
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