<%@page import="model.AutoreLibro"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
 <div class="container">
  <h2>Autori Libri</h2> 
	<table class="table table-striped">
	<thead>
	<tr> 
	<th>Id autore</th>
	<th>Id libro</th>
	<th>Cognome autore</th>
	<th>Titolo libro</th>
	<th>Prezzo libro</th>
	<th>Elimina</th>
	</tr>
    </thead>
 	<tbody>
 	<%
 	List<AutoreLibro> lista=(List<AutoreLibro>) request.getAttribute("listaAutoriLibri");
 			if(lista!=null){
 				for(AutoreLibro p : lista){
 					out.print("<tr>");
 					out.print("<td>" + p.getAlAutoreId() + 	 "</td>");
 					out.print("<td>" + p.getAlLibroId() + "</td>");
 					out.print("<td>" + p.getaCognome() + "</td>");
 					out.print("<td>" + p.getlTitolo() + "</td>");
 					out.print("<td>" + p.getlPrezzo() + "</td>");
					
					
					out.print("<td>" + 
							"<form method = \"post\" action=\"delAutoreLibro?autore_id=" + p.getAlAutoreId() + "\">" +
							"<input type=\"submit\"></input>" +
							"</form> </td>");
					out.print("</tr>");
 				}
 			}else{
 				out.print("<br> Lista vuota <br>");
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