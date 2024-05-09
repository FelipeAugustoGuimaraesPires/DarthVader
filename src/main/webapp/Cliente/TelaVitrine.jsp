<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UtopiaNerd</title>
    <link rel="stylesheet" href="../Css/Cliente/Vitrine.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

</head>
<header>
    <c:if test="${sessionScope.loggedUser != null || sessionScope.loggedUserEstoque != null}">
        <div class="header-container">
            <div class="logo">
                <img src="../img/LOGO.webp" alt="Logo">
                <span>${sessionScope.loggedUser}</span>
                <a href="/logout"><button>Sair</button></a>
                <form action="/edita-cliente" method="post">
                    <input type="hidden" id="email" name="email" value="${sessionScope.email}">
                    <input type="hidden" id="tela" name="tela" value="Vitrine">
                    <button type="submit">Editar meus dados</button>
                </form>
                <form action="/lista-endereco" method="post">
                    <input type="hidden" id="email" name="email" value="${sessionScope.email}">
                    <button type="submit">Visualizar meus endereços</button>
                </form>
            </div>
            <div class="buttons">
                <i class="bi bi-cart-fill"></i>
            </div>
        </div>
    </c:if>

    <c:if test="${sessionScope.loggedUser == null && sessionScope.loggedUserEstoque == null}">
        <div class="header-container">
            <div class="logo">
                <img src="../img/LOGO.webp" alt="Logo">
            </div>
            <div class="buttons">
                <a href="../Cliente/TelaDeLogin.jsp"> <button class="btn1">Login/Cadastro</button> </a>
                <i class="bi bi-cart-fill"></i>
            </div>
        </div>
    </c:if>
</header>

<body>
<div>
    <div class="pag-inner-content">
        <h3 class="section-title"> Produtos Selecionados</h3>
        <div class="subtitle-underline"></div>
        <div class="cols cols-5">
            <c:forEach var="produtos" items="${produtos}" varStatus="loop">
                <div class="product">
                    <a href="./Produto/VisualizacaoDeProdutos.jsp?id=${produtos.id}&nome=${produtos.nome}&avaliacao=${produtos.avaliacao}&descricao=${produtos.descricao}&preco=${produtos.preco}&estoque=${produtos.qtdEstoque}&estatus=${produtos.estatus}&imagem=${produtos.imagem}&imagem2=${produtos.imagem2}&imagem3=${produtos.imagem3}&imagem4=${produtos.imagem4}">
                        <img src="/img/${produtos.imagem}" alt="Imagem Item">
                    </a>
                    <p class="product-name">${produtos.nome}</p>
                    <p class="product-name">${produtos.descricao}</p>
                    <p class="rate">&#9733;&#9733;&#9733;&#9733;&#9733;</p>
                    <p class="product-price">${produtos.preco}</p>
                    <div class="product-actions">
                        <button class="btn add-to-cart">Adicionar</button>
                        <div class="quantity-control" style="display: none;">
                            <input type="hidden" id="Estoque_${loop.index}" value="${produtos.qtdEstoque}">
                            <button class="btn decrement">-</button>
                            <span class="quantity">1</span>
                            <button class="btn increment">+</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</main>



<script src="../Javascript/Cliente/Cliente.js"></script>
</body>

</html>