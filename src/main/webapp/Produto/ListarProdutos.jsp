<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="../Javascript/Produto/Pesquisa.js"></script>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../Css/Produto/ListarProdutos.css">
        <title>Listagem de Produtos</title>
    </head>
    <body>

        <c:if test="${sessionScope.loggedUser != null || sessionScope.loggedUserEstoque != null}">
            <span>${sessionScope.loggedUser}</span>
            <span>${sessionScope.loggedUserEstoque}</span>
            <a href="/logout"><button>Sair</button></a>
            <a href="/PaginaInicial.jsp"><button>Menu</button></a>
        </c:if>

        <h1>Listagem de Produtos</h1>

        <div id="searchBar">
        <input type="text" id="searchInput" onkeyup="myFunction()" placeholder="Pesquisar...">
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
                <th>Preço</th>
                <th>Quantidade em Estoque</th>
                <th>Status</th>
                    <th>Ações</th>
            </tr>

                <c:forEach var="produtos" items="${produtos}">
                    <tr>
                        <td>${produtos.id}</td>
                        <td>${produtos.nome}</td>
                        <td>${produtos.avaliacao}</td>
                        <td>${produtos.preco}</td>
                        <td>${produtos.qtdEstoque}</td>
                        <td>${produtos.estatus}</td>
                        <td>
                            <a id="Atualizar" href="./Produto/AlteracaoDeProduto.jsp?id=${produtos.id}&nome=${produtos.nome}&avaliacao=${produtos.avaliacao}&descricao=${produtos.descricao}&preco=${produtos.preco}&estoque=${produtos.qtdEstoque}&estatus=${produtos.estatus}&imagem=${produtos.imagem}&imagem2=${produtos.imagem2}&imagem3=${produtos.imagem3}&imagem4=${produtos.imagem4}"><button>Atualizar</button></a>

                            <c:if test="${sessionScope.loggedUser !=null}">
                                <a id="Alterar" href="./Produto/AlterarImagem.jsp?id=${produtos.id}&nome=${produtos.nome}&avaliacao=${produtos.avaliacao}&descricao=${produtos.descricao}&preco=${produtos.preco}&estoque=${produtos.qtdEstoque}&estatus=${produtos.estatus}&imagem=${produtos.imagem}&imagem2=${produtos.imagem2}&imagem3=${produtos.imagem3}&imagem4=${produtos.imagem4}"><button>Alterar imagem</button></a>
                            </c:if>

                            <a id="Visualizar" href="./Produto/VisualizacaoDeProdutos.jsp?id=${produtos.id}&nome=${produtos.nome}&avaliacao=${produtos.avaliacao}&descricao=${produtos.descricao}&preco=${produtos.preco}&estoque=${produtos.qtdEstoque}&estatus=${produtos.estatus}&imagem=${produtos.imagem}&imagem2=${produtos.imagem2}&imagem3=${produtos.imagem3}&imagem4=${produtos.imagem4}"><button>Visualizar</button></a>
                            <c:if test="${sessionScope.loggedUser != null}">
                                <form id= "formularioStatus" action="/habilitar-desabilitar-produto" method="post">
                                    <input type="hidden" id="id" name="id" value=${produtos.id}>
                                    <button id="botaoStatus" type="submit">Inativar/Reativar</button>
                                </form>
                            </c:if>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <script src="../Javascript/Produto/popupConfirmation.js"></script>
        <script>
          // Adicione um evento de clique ao botão "Inativar/Reativar"
          document.getElementById("botaoStatus").addEventListener("click", function(event) {
            // Impedir o comportamento padrão do botão
            event.preventDefault();

            // Chamar a função showConfirmationPopup() ao clicar no botão "Inativar/Reativar"
            showConfirmationPopup();
          });
        </script>

    </body>
</html>