<%@page import="model.Autore"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
  <div class="container">
  <h2>Autori</h2> 
	<table class="table table-striped">
	<thead>
	<tr> 
		<th>ID</th>	
		<th>Nome</th>
		<th>Cognome</th>
		<th>NazionalitÓ</th>
		<th>Elimina</th>	
		<th>Modifica</th>		
	</tr>
    </thead>
 	<tbody>
	<%
 		List<Autore> lista = (List<Autore>) request.getAttribute("listaAutori");
		if(lista!=null){
			for(Autore p : lista){
				out.print("<tr>");
				out.print("<td>" + p.getId() + 	 "</td>");
				out.print("<td>" + p.getNome() + "</td>");
				out.print("<td>" + p.getCognome() + "</td>");
				out.print("<td>" + p.getNazionalita() + "</td>");
 
				out.print("<td>" + 
							"<form method = \"post\" action=\"delAutore?idAutore=" + p.getId() + "\">" +
							"<input type=\"submit\"></input>" +
							"</form> </td>");
				out.print("<td>" + 
						"<form method = \"get\" action=\"modificaAutore\">"+
						"<input type=\"text\" hidden name=\"modificaId\" value=\""+p.getId()+ "\" >" +
						"<input type=\"submit\"></input>" +
						"</form> </td>");
				out.print("</tr>");
			}
		}else{
			out.print("<br> Non ci sono autori in lista <br>");
		}
 
 
	%>
    </tbody>
	</table>
    </div>
	<% 
	String msg=(String)request.getAttribute("avvisoMessaggio");
	if(msg!=null){
		out.print("<script>alert(\""+msg+"\");</script>");
	}
	%>
 
</body>
</html>