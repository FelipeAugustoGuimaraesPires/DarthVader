<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../Css/Produto/">
    <title>Lista de endereços</title>
</head>
<body>

<c:if test="${sessionScope.loggedUser != null || sessionScope.loggedUserEstoque != null}">
    <span>${sessionScope.loggedUser}</span>
    <a href="/logout"><button>Sair</button></a>
</c:if>

<h1>Seus endereços:</h1>

<div id="searchBar">
    <input type="text" id="searchInput" onkeyup="myFunction()" placeholder="Pesquisar...">
    <button>Buscar</button>
</div>

<c:if test="${sessionScope.loggedUser !=null}">
    <a href="./Produto/CadastrodeProduto.jsp"><button style="font-size:24px" >+</button></a>
</c:if>

<table>
    <tr class="header">
        <th>CEP</th>
        <th>Logradouro</th>
        <th>Número</th>
        <th>Complemento</th>
        <th>Bairro</th>
        <th>Cidade</th>
        <th>Tipo</th>
        <th>Status</th>
        <th>Ações</th>
    </tr>

    <c:forEach var="endereco" items="${endereco}">
        <tr>
            <td>${endereco.cep}</td>
            <td>${endereco.logradouro}</td>
            <td>${endereco.numero}</td>
            <td>${endereco.complemento}</td>
            <td>${endereco.bairro}</td>
            <td>${endereco.cidade}</td>
            <td>${endereco.tipo}</td>
            <td>${endereco.status}</td>
            <td>
                <c:if test="${sessionScope.loggedUser != null}">
                    <form id= "formularioStatus" action="/tornar-endereco-faturamento" method="post">
                        <input type="hidden" id="id" name="id" value=${endereco.id}>
                        <button id="botaoStatus" type="submit">Tornar Faturamento</button>
                    </form>

                    <form id= "formularioStatus" action="/desabilitar-endereco" method="post">
                        <input type="hidden" id="id" name="id" value=${endereco.id}>
                        <button id="botaoStatus" type="submit">Inativar</button>
                    </form>
                </c:if>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>