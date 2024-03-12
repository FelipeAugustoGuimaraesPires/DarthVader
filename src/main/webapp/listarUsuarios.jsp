<!DOCTYPE html>
<html lang="pt-BR">
<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <script src="../Javascript/Pesuisa.js"></script>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Usuário</title>
    </head>
    <body>
        <c:if test="${sessionScope.loggedUser !=null}">
            <span>${sessionScope.loggedUser}</span>
            <a href="/logout">Sair</a>
        </c:if>

        <h1>Lista de Usuário</h1>

        <a href="CriarUsuario.jsp"><button style="font-size:24px" >+</button></a>

        <input type="text" id="mySearch" onkeyup="myFunction()" placeholder="procurar..">

        <table id="myTable">
            <tr class="header">
                <th>Nome</th>
                <th>Email</th>
                <th>Status</th>
                <th>Grupo</th>
                <c:if test="${sessionScope.loggedUser !=null}">
                    <th>Ações</th>
                </c:if>
            </tr>
            <c:forEach var="usuarios" items="${usuarios}">
                <tr>
                    <td>${usuarios.nome}</td>
                    <td>${usuarios.email}</td>
                    <td>${usuarios.estatus}</td>
                    <td>${usuarios.grupo}</td>
                    <td>
                        <c:if test="${sessionScope.loggedUser !=null}">
                            <div id="acao">
                                

                                <input type="hidden" id="id" name="id" value=${usuarios.ID}>
                                <input type="hidden" id="senha" name="senha" value=${usuarios.senha}>
                                <input type="hidden" id="cpf" name="cpf" value=${usuarios.CPF}>
                                <a id="Atualizar" href="alterarUsuario.jsp?id=${usuarios.ID}&nome=${usuarios.nome}&Grupo=${usuarios.grupo}&senha=${usuarios.senha}&cpf=${usuarios.CPF}"><button>Atualizar</button></a>

                                <form action="/habilitar-desabilitar" method="post">
                                    <input type="hidden" id="id" name="id" value=${usuarios.ID}>
                                    <button type="submit">Alterar estatus</button>
                                </form>
                            </div>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>