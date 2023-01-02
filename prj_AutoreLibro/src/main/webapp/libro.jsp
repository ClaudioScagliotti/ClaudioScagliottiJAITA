<%@page import="model.Libro"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
 <div class="container">

  <h2>Libri</h2> 
	<table class="table table-striped">
	<thead>
	<tr> 
		<th>ID</th>	
		<th>Titolo</th>
		<th>Prezzo</th>
		<th>Pagine</th>	
		<th>Elimina</th>	
		<th>Modifica</th>	
	</tr>
 	</thead>
 	<tbody>
	<%
 		List<Libro> lista = (List<Libro>) request.getAttribute("listaLibro");
		if(lista!=null){
			for(Libro p : lista){
				out.print("<tr>");
				out.print("<td>" + p.getId() + 	 "</td>");
				out.print("<td>" + p.getTitolo() + "</td>");
				out.print("<td>" + p.getPrezzo() + "</td>");
				out.print("<td>" + p.getPagine() + "</td>");
 
				out.print("<td>" + 
							"<form method = \"post\" action=\"delLibro?idLibro=" + p.getId() + "\">" +
							"<input type=\"submit\"></input>" +
							"</form> </td>");
				out.print("<td>" + 
						"<form method = \"get\" action=\"modificaLibro\">"+
						"<input type=\"text\" hidden name=\"modificaId\" value=\""+p.getId()+ "\" >" +
						"<input type=\"submit\"></input>" +
						"</form> </td>");
				out.print("</tr>");
			}
		}else{
			out.print("<br> Non ci sono libri in lista <br>");
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