<%-- 
    Document   : listaMercadorias
    Created on : 03/05/2017, 18:40:22
    Author     : Leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head> 
    <body>
        <table width="300px" border="1px" bordercolor="#000000">
            <tr>
                <td>Nome:</td>
                <td>Telefone:</td>
                <td>Tipo negócio:</td>
                <td>Mercadoria:</td>
                <td>Tipo da Mercadoria:</td>
                <td>Preço unidade:</td>
                <td>Quantidade disponível:</td>
            </tr>

            <c:forEach var="mercadoria" items="${mercadorias}"><c:forEach var="negocio" items="${negocios}">
                    <tr>
                        <td>${negocio.getNome()}</td>
                        <td>${negocio.getTelefone()}</td>
                        <td>${negocio.getTipo()}</td>
                        <td>${mercadoria.getNome()}</td>
                        <td>${mercadoria.getTipo()}</td>
                        <td>${mercadoria.getPreco()}</td>
                        <td>${mercadoria.getQuantidade()}</td>
                    </tr>
                </c:forEach></c:forEach>

        </table>
    </body>
</html>
