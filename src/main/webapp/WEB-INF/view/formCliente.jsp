<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Css/cadastro.css">
<title>Insert title here</title>
</head>
<body>
<form action="">
        <fieldset class="login">
            <h1 class="h1">Login</h1>

            <label for="nome" class="labNome">Nome:</label>
            <input type="text" id="nome" value="Digite seu nome">
            
            <br>
            <label for="sobrenome" class="labSnome">Sobrenome:</label>
            <input type="text" id="sobrenome" value="Digite seu sobrenome">
            <br>
            <label for="">Idade:</label>
            <input type="number" id="idade" class="inIdade">
            <br>
            <label for="endereco" class="labEndereco">Endereço:</label>
            <input type="text" id="endereco" value="Digite seu endereço">
            <br>
            <label for="contato" class="labContato">Telefone ou celular:</label>
            <input type="text" id="contato" name="contato" value="Digite seu meio de contato">
            <br>
            <label for="email" class="labEmail">E-mail:</label>
            <input type="text" id="email" value="Digite" class="InEmail">
            <br>
            <label for="pt_interesse" class="labProduto">Produto de interesse:</label>
            <select name="SelectProdutos" id="tprodutos" class="slt_produtos">
                <option value="pt_selecione">Selecione</option>
                <option value="pt_domestico">Produto domesticos</option>
                <option value="pt_eletronico">Produto eletronico</option>
                

            </select>
            <br>
            <label for="">Gênero:</label>
            <select name="SelectGen" id="genero" class="">
                <option value="gen_selecione">Selecione</option>
                <option value="gen_MA">Masculino</option>
                <option value="gen_FE">Feminino</option>

            </select>
            <br>
            
            <button type="submit" class="btCadastrar">Cadastrar</button>

        </fieldset>
    </form>

</body>
</html>