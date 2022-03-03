<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="tbEstatisticas.css">
<title>Insert title here</title>
</head>
<body>
  <div class="divPrincipal">
        <div class="divEstatistica">
            <h1 class="h1Genero" id="h1Titulo">Estatísticas de clientes por gênero</h1>
            <table class="tbGenero">
                <tr>
                    <th> </th>
                    <th >Masculino</th>
                    <th >Feminino</th>
                </tr>
                <tr> 
                    <th id="th">Qtde de clientes</th>
                   
                    <td>${generoh}</td>
                   
                    <td>${mulher}</td>
                </tr>   
               
            </table>
        </div>
        <div class="divEstatistica">
            <h1 class="h1fxetaria" id="h1Titulo">Estatísticas de clientes por faixa etária</h1>
            <table class="tbGenero">
                <tr>
                    <th></th>
                    <th>Jovem</th>
                    <th>Adulto</th>
                    <th>Idoso</th>
                </tr>
                <tr> 
                    <th id="th">Qtde de clientes</th>
                    <td>${jovem}</td>
                    <td>${adulto}</td>
                    <td>${idoso}</td>
                </tr>   
               
            </table>
        </div>
        <div class="divEstatistica">
            <h1 h1="h1Periodo">Estatísticas de clientes por semana</h1>
            <table class="tbGenero">
                <tr>
                    <th> </th>
                    <th>SEG</th>
                    <th>TER</th>
                    <th>QUA</th>
                    <th>QUI</th>
                    <th>SEX</th>
                    <th>SAB</th>
                    <th>DOM</th>
                    
                </tr>
                <tr> 
                    <th id="th">Qtde de clientes</th>
                    <td>${Segunda }</td>
                    <td>${Terca }</td>
                    <td>${Quarta }</td>
                    <td>${Quinta }</td>
                    <td>${Sexta }</td>
                    <td>${Sabado }</td>
                    <td>${domingo }</td>
                    
                </tr>
                
                
            </table>
        </div>
        <div class="divEstatistica">
            <h1 h1="h1Semana">Estatísticas de clientes por periodo</h1>
            <table class="tbSemanal">
                <tr>
                    <th id="thPeriodo">Manhã</th>
                    <td id="tdPeriodo">${manha }</td>
                    
                </tr>
                <tr>
                    <th id="thPeriodo">Tarde</th>
                    <td id="tdPeriodo">${tarde }</td>
                    
                </tr>
                <tr>
                    <th id="thPeriodo">Noite</th>
                    <td id="tdPeriodo">${noite }</td>
                    
                </tr>
               
                
                
            </table>
        </div>
    </div>

</body>
</html>