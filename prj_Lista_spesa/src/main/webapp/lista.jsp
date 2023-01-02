
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><%@ include file="header.jsp"%>
<h1>Lista della spesa</h1>
<table>
	<tr>
		<th>ID</th>
		<th>Nome prodotto</th>
		<th>Prezzo</th>
		<th>Reparto</th>
		<th>azioni</th>
	</tr>
<%
List<Prodotto> lista= (List<Prodotto>) request.getAttribute("lista");

for(Prodotto p: lista){
	out.print("<tr>");
	out.print("<th>"+p.getId()+ "</th>");
	out.print("<th>"+p.getNome()+ "</th>");
	out.print("<th>"+p.getPrezzo()+ "</th>");
	out.print("<th>"+p.getCategoria()+ "</th>");
	out.print("<th>" + 
			"<form method = \"post\" action=\"removeProdotto?id=" + p.getId() + "\">" +
			"<input type=\"submit\"><i class=\" fa fa-trash \"></i></input>" +
			"</form>"
			+ "</th>");
	out.print("</tr>");
}
%>
</table>

<%@ include file="footer.jsp"
%>