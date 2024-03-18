<!DOCTYPE html>
<html lang="pt-BR">
    <%@ page contentType="text/html; charset=UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="Css/ListarProdutos.css">
        <title>Listagem de Produtos</title>
    </head>
    <body>

    <c:if test="${sessionScope.loggedUser != null || sessionScope.loggedUserEstoque != null}">
        <span>${sessionScope.loggedUser}</span>
        <a href="/logout"><button>Sair</button></a>
        <a href="/PaginaInicial.jsp"><button>Menu</button></a>
    </c:if>

        <h1>Listagem de Produtos</h1>

        <div id="searchBar">
        <input type="text" id="searchInput" placeholder="Pesquisar...">
        <button>Buscar</button>
        </div>

        <c:if test="${sessionScope.loggedUser !=null}">
        <a href="./Produto/CadastrodeProduto.jsp"><button style="font-size:24px" >+</button></a>
        </c:if>

        <table>
            <tr class="header">
                <th>ID</th>
                <th>Nome</th>
                <th>Avaliação</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Quantidade em Estoque</th>
                <th>Status</th>
                <c:if test="${sessionScope.loggedUser !=null}">
                    <th>Ações</th>
                </c:if>
            </tr>

                <c:forEach var="produtos" items="${produtos}">
                    <tr>
                        <td>${produtos.id}</td>
                        <td>${produtos.nome}</td>
                        <td>${produtos.avaliacao}</td>
                        <td>${produtos.descricao}</td>
                        <td>${produtos.preco}</td>
                        <td>${produtos.qtdEstoque}</td>
                        <td>${produtos.estatus}</td>
                        <td>
                            <c:if test="${sessionScope.loggedUser != null}">
                                <div id="acao">


                                    <a id="Atualizar" href="alterarUsuario.jsp?id=${usuarios.ID}&nome=${usuarios.nome}&Grupo=${usuarios.grupo}&senha=${usuarios.senha}&cpf=${usuarios.CPF}"><button>Atualizar</button></a>

                                    <form id= "formularioStatus" action="/habilitar-desabilitar-produto" method="post">
                                        <input type="hidden" id="id" name="id" value=${produtos.id}>
                                        <button id="botaoStatus" type="submit">Inativar/Reativar</button>
                                    </form>
                                </div>
                            </c:if>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>