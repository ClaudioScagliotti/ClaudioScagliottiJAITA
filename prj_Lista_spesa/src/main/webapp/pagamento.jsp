<%@ include file="header.jsp"
%>

<h1>Pagamento</h1>


<br>
<form action="pagamento" method="get">
<label for="pagamento_id"> Inserisci pagamento:</label>
<input type="text" name="importo" id="pagamento_id">
<input type="submit" name="paga" id="paga_id">
</form>

<%

Boolean s= (Boolean)request.getAttribute("pagata");
//double i= (double)request.getAttribute("importo");
//double t= (double)request.getAttribute("totale");
//double r= i-t;


if(s){
	//double resto= (s.getImporto())-(s.getTotale());
	out.print("La spesa e' stata pagata correttamente");
}else{
	out.print("Spesa non pagata, errore nel pagamento");
}

%>

<%@ include file="footer.jsp"
%>