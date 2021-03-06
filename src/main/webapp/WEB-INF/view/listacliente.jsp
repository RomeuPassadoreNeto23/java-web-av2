<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="icom1.png" type="image/x-icon">
<link rel="stylesheet" href="tabela2.css">
<title>Tabela de clientes</title>
</head>
<body>
 <h1 class="h1">Tabela de clientes</h1>
    <table class="tbClientes" style="border-color: black;"  border="1">
        <tr style="border-color: black;">
          <th class="id">id</th>
          <th class="Nome">Nome</th>
          <th class="Sobrenome">Endere?o</th>
          <th class="Endereco">telefone</th>
          <th class="Contato">tipo celualar ou  telefone</th>
          <th class="Email">E-mail</th>
          <th class="PdInteresse">Produto de interesse</th>
          <th class="Genero" style="background-color: white;">Genero</th>
          <th class="FaixaEtaria">idade</th>
          <th  class="FaixaEtaria"> Data do Cadastro </th>
          <th class="FaixaEtaria"> Hora do cadastro</th>
          <th class="FaixaEtaria"> alterar cliente</th>
          <th class="FaixaEtaria"> excluir </th>
        </tr class="principal">
       
        <c:forEach  items="${cliente}" var="c">
         <tr >
            <td>${c.id }</td>
            <td>${c.nome }</td>
            <td>${c.endereco }</td>
            <td>${c.contato }</td>
            <td>${c.tptelefone.toString() }</td>
            <td>${c.email }</td>
            <td>${c.tprodutos.toString() }</td>
            <td>${c.sex.toString() }</td>
            <td>${c.idade}</td>
            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${c.eatacadastro.time }" /></td>
             <td><fmt:formatDate pattern=" HH:mm:ss" value="${c.eatacadastro.time }" /></td>
             <td><a  href="alterarCliente?idcliente=${c.id }" style="color: white; text-decoration: none;">Alterar</a></td>
             <td  class="principal"><a href="excluirCliente?idcliente=${c.id }" style="color: white; text-decoration: none;" onclick="return confirm('Deseja excluir?')">Excluir</a></td>
         </tr>
         </c:forEach>   
      </table>
      <br>
      <ul>
      <li style="list-style: none;"><a style="color: white; text-decoration: none;" href="tabelaestajsp">Tabela de Estat?sticas</a></li>
      </ul>
</body>
</html>