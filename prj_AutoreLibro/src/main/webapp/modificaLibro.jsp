<%@page import="model.Libro"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
<div class="container">
  <h2>Modifica libro</h2> 
<a href="listaLibri"> Indietro </a>
	<form method="post" action="modificaLibro">
		Id: <input type="number" name="id" hidden value="<%=request.getAttribute("id")%>"><br>
		Titolo: <input type="text" name="titolo" value="<%=request.getAttribute("titolo")%>"><br>
		Prezzo:<input type="text" name="prezzo" value="<%=request.getAttribute("prezzo")%>"><br>
		Pagine:<input type="text" name="pagine" value="<%=request.getAttribute("pagine")%>"><br>
		
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