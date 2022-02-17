<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<form action="salvarClinete" method="post">
		<fieldset class="login">
			<h1 class="h1">Login</h1>

			<label for="input_nome" class="labNome">Nome:</label> <input type="text"
				name="nome" id="input_nome" value="Digite seu nome" ${Cliente.nome }> <br> <label
				for="endereco" class="labEndereco">Endereço:</label> <input
				type="text" name="endereco" value="Digite seu endereço"> <br>
			<label for="contato" class="labContato">Telefone ou celular:</label>
			<input type="number"  name="contato"
				value="Digite seu meio de contato"> <br> <label
				for="email" class="labEmail">E-mail:</label> <input type="text"
				name="email" value="Digite" class="InEmail"> <br> <label
				for="pt_interesse" class="labProduto">Produto de interesse:</label>
			<select name="tprodutos" class="slt_produtos">
					<c:forEach items="${tipos}" var="t">
						<option value="${t }">${t.toString() }</option>
					</c:forEach>
			</select>
			</select> <br> <label for="">Gênero:</label> <select name="genero"
				class="gen_produtos">
			<c:forEach items="${genero}" var="t">
						<option value="${g }">${t.toString() }</option>
					</c:forEach>
			

			</select> <br> <label for="">Faixa etária:</label> <select name="Fetaria"
				class="ft_etaria">
				<c:forEach items="${faixa}" var="t">
						<option value="${f }">${t.toString() }</option>
					</c:forEach>


			</select> <br>

			<button type="submit" value="salvar" class="btCadastrar">Cadastrar</button>

		</fieldset>
	</form>

</body>
</html>