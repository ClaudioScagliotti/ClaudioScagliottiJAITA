<%@ include file="header.jsp"
%>

<h1>Totale spesa</h1>
<%
double tot= (double) request.getAttribute("totale");
out.print("Il totale della tua spesa e':"+tot+" euro");
%>

<br>
<form action="get">
<button type="submit" formaction="pagamento">Pagamento</button>
</form>

<%@ include file="footer.jsp"
%>