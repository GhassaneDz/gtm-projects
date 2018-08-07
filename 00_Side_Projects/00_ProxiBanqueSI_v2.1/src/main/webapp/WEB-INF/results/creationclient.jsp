<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProxiBanque - client ajout�</title>
<jsp:include page="/WEB-INF/parts/header.html"></jsp:include>
</head>
<body>
	<h3>Le client ${client.prenom} ${client.nom} a �t� ajout� � la
		base de donn�es ProxiBanque</h3>

	<form>
		<fieldset>
			<legend>
				<b>R�capitulatif du client</b>
			</legend>
			<table>
				<tr>
					<td>Nom :</td>
					<td>${client.nom}</td>
				</tr>
				<tr>
					<td>Pr�nom :</td>
					<td>${client.prenom}</td>
				</tr>
				<tr>
					<td>Adresse :</td>
					<td>${client.adresse}</td>
				</tr>
				<tr>
					<td>Code Postal :</td>
					<td>${client.codePostal}</td>
				</tr>
				<tr>
					<td>Ville :</td>
					<td>${client.ville}</td>
				</tr>
				<tr>
					<td>T�l�phone :</td>
					<td>${client.telephone}
					<td>
				</tr>
			</table>
		</fieldset>
	</form>
	<a href="creerclient.html">Retour au menu de cr�ation client</a>
	<br>
	<a href="ListerClients"> Retour � la liste des clients</a>
	<jsp:include page="/WEB-INF/parts/footer.html"></jsp:include>
</body>
</html>