<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProxiBanque - gestion client</title>
<jsp:include page="/WEB-INF/parts/header.html"></jsp:include>
</head>
<body>
	<ul>
		<li><a href="AssocierCompteCourant?idClient=${param['idClient']}">Associer
				un compte courant au client</a></li>
		<li><a href="AssocierCompteEpargne?idClient=${param['idClient']}">Associer
				un compte �pargne au client</a></li>
		<li><a href="DecrireClient?idClient=${param['idClient']}">D�crire
				le client</a></li>
		<li><a href="ObtenirClient?idClient=${param['idClient']}">Modifier
				les param�tres du client (nom, pr�nom, adresse...)</a></li>
		<li><a href="SupprimerClient?idClient=${param['idClient']}">Supprimer
				ce client</a></li>
	</ul>
	<br>
	<a href="ListerClients">Retour � la gestion clients</a>
	<br>
	<a href="index.jsp">Retour au menu principal conseillers</a>

	<jsp:include page="/WEB-INF/parts/footer.html"></jsp:include>
</body>
</html>