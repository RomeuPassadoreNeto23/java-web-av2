<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="tbclientes.css">
<title>Insert title here</title>
</head>
<body>
 <h1 class="h1">Tabela de clientes</h1>
    <table class="tbClientes" style="border-color: black;"  border="1">
        <tr style="border-color: black;">
          <th class="id">id</th>
          <th class="Nome">Nome</th>
          <th class="Sobrenome">Endereço</th>
          <th class="Endereco">telefone</th>
          <th class="Contato">tipo celualar ou  telefone</th>
          <th class="Email">E-mail</th>
          <th class="PdInteresse">Produto de interesse</th>
          <th class="Genero">Genero</th>
          <th class="FaixaEtaria">Faixa etária</th>
          <th> Data do Cadastro </th>
          <th> Hora do cadastro</th>
        </tr>
       
        <c:forEach  items="${cliente}" var="c">
         <tr>
            <td>${c.id }</td>
            <td>${c.nome }</td>
            <td>${c.endereco }</td>
            <td>${c.contato }</td>
            <td>${c.tptelefone.toString() }</td>
            <td>${c.email }</td>
            <td>${c.tprodutos.toString() }</td>
            <td>${c.sex.toString() }</td>
            <td>${c.faixa_etaria.toString() }</td>
            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${c.eatacadastro.time }" /></td>
             <td><fmt:formatDate pattern=" HH:mm:ss" value="${c.eatacadastro.time }" /></td>
         </tr>
         </c:forEach>   
       
      </table>
</body>
</html>