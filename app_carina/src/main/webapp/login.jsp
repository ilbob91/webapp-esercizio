<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello!</title>
</head>
<body>
	<form action="login" method="post">
		<p>Inserisci le tue credenziali</p>

		<p>
			<label>Nome</label><br> <input type="text" name="nome"
				class="nome" placeholder="Nome" required="required">
		</p>
		<p>
			<label>Cognome</label><br> <input type="text" name="cognome"
				class="cognome" placeholder="Cognome" required="required">
		</p>
		<p>
			<label>Numero</label><br> <input type="text" name="numero"
				class="numero" placeholder="Numero" required="required">
		</p>
		<input type="submit" value="Registra">
	</form>

	<table>
		<tr>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Numero</th>
		</tr>

		<c:forEach items="${listaPersone}" var="persona">

			<tr>
				<td><c:out value="${persona.getNome()}" /></td>
				<td><c:out value="${persona.getCognome()}" /></td>
				<td><c:out value="${persona.getNumero()}" /></td>

			</tr>

		</c:forEach>

	</table>
</body>
</html>