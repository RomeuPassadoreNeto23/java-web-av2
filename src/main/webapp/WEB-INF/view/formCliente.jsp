<%@page import="br.senai.sp.lojaquiosque.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.senai.sp.lojaquiosque.model.Cliente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="cadastro.css">
<title>Cadastro</title>
</head>
<style>
*
body {
	width: 399px;
	margin: auto;
	padding-top: 100px;
	background-image: linear-gradient(to right, rgb(255, 217, 0), blue);
}

.login {
	width: 400px;
	padding-left: 20px;
	height: 600px;
	border: none;
	background-color: rgb(163, 148, 148);
}

.h1 {
	color: aliceblue;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

label {
	color: aliceblue;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	font-size: 1em;
}

.labNome {
	padding-right: 157px;
}

.labSnome {
	padding-right: 115px;
}

.labEndereco {
	padding-right: 131px;
}

.labContato {
	padding-right: 54px;
}

.labEmail {
	padding-right: 125px;
	width: 1000px;
}

.labProduto {
	padding-right: 44px;
}

.InEmail {
	width: 200px;
}

.btCadastrar {
	border: none;
	background-color: antiquewhite;
	padding: 10px;
}
</style>
<body>
	<form action="salvarClinete" method="get">
	<input type="hidden" name="id" value="${cliente.id }" />
			<h1 class="h1">cadastro de  cliente</h1>
		
			<label for="input_nome" class="labNome">Nome:</label> <input type="text"
				name="nome" id="input_nome"  value="Digite seu Nome:  ${cliente.nome }"> <br> <label
				for="endereco" class="labEndereco">Endereço:</label> <input
				type="text" name="endereco" value="Digite seu Endereço:  ${cliente.endereco }"> <br>
			<label for="contato" class="labContato">Telefon:</label>
			<input type="tel"  name="contato" value="Digite seu Telefone: ${cliente.contato }">
			<br>
			     <label  for="tptelefone">telefone ou celular: </label>
				<select name="tptelefone" class="slt_produtos"> 
					<c:forEach items="${tptelefone}" var="t">
					 <option <c:if test="${cliente.tptelefone == t }">selected</c:if> value="${t }">${t.toString() }</option>
					</c:forEach>
			</select>
			
				 <br> <label
				for="email" class="labEmail">E-mail:</label> <input type="email"
				name="email" placeholder="Digite seu Email" value="Digite seu Email: ${ cliente.email }" class="InEmail"> <br> 
				<label for="tprodutos"  class="labProduto">Produto de interesse:</label>
			    <select name="tprodutos" >
					<c:forEach items="${tipos}" var="t">
						 <option <c:if test="${cliente.tprodutos == t }">selected</c:if> value="${t }">${t.toString() }</option>
					</c:forEach>
			     </select>
		    <br>
		  <label for="sex" class="labProduto">Genero:</label>
			    <select name="sex" >
					<c:forEach items="${genero}" var="t">
					 <option <c:if test="${cliente.sex == t }">selected</c:if> value="${t }">${t.toString() }</option>
					</c:forEach>
			     </select>
			 <br> 
			  <label for="idade" class="labProduto">Idade:</label>
			  <input type="text"  name="idade" value="Digite sua Idade:  ${cliente.idade }"> 
			  <br>

			<button type="submit" value="salvar" class="btCadastrar">Cadastrar</button>

		
	</form>

</body>
</html>