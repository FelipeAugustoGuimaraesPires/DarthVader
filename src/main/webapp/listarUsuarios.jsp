<!DOCTYPE html>
<html lang="pt-BR">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Usuário</title>
    </head>
    <body>

        <h1>Lista de Usuário</h1>

        <button style="font-size:24px">+</button>

        <input type="text" id="mySearch" onkeyup="myFunction()" placeholder="procurar..">
        <button type="submit">Procurar</button>

        <table id="myTable">
            <tr class="header">
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Status</th>
                <th>Deletar</th>
                <th>Alterar</th>
                <th>Hab/Des</th>
            </tr>
            <c:forEach var="usuarios" items="${usuarios}">
                <tr>
                    <td>${usuarios.ID}</td>
                    <td>${usuarios.nome}</td>
                    <td>${usuarios.email}</td>
                    <td>${usuarios.estatus}</td>
                    <td>
                        <form action="/deletar-usuario" method="post">
                            <input type="hidden" id="ID" name="ID" value=${usuarios.ID}>
                            <button type="submit">Deletar</button>
                        </form>
                    </td>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" id="ID" name="ID" value=${usuarios.ID}>
                            <button type="submit">Deletar</button>
                        </form>
                    </td>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" id="ID" name="ID" value=${usuarios.ID}>
                            <button type="submit">Deletar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>