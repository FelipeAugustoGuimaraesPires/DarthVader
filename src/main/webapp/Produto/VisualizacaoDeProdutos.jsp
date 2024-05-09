<!DOCTYPE html>
<html lang="pt-BR">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>Visualização de item</title>
    <link rel="stylesheet" href="../Css/Produto/VisualizacaoProdutos.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
</head>
<body>
    <h1>TELA PRODUTO</h1>
    <div class="container">
        <div class="lado-esquerdo">
            <div class="imagem-selecionada">
                <div class="swiper mySwiper">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <img src="/img/${param.imagem}" alt="Imagem a ser adicionada">
                        </div>
                        <div class="swiper-slide">
                            <img src="/img/${param.imagem2}" alt="Imagem a ser adicionada">
                        </div>
                        <div class="swiper-slide">
                            <img src="/img/${param.imagem3}" alt="Imagem a ser adicionada">
                        </div>
                        <div class="swiper-slide">
                            <img src="/img/${param.imagem4}" alt="Imagem a ser adicionada">
                        </div>
                    </div>
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>
            </div>
        </div>
        <div class="lado-direito">
            <h1>${param.nome}</h1>
            <p>${param.descricao}</p>
            <div>
                <label>Avaliação: ${param.avaliacao}</label>
                <span id="avaliacao"></span>
            </div>
            <h2>Preço: R$ ${param.preco}</h2>
            <div class="contador">
                <button class="btn-quantidade" onclick="decrementar()">-</button>
                <input type="text" class="input-quantidade" value="1" min="1" max="5">
                <button class="btn-quantidade" onclick="incrementar(${param.estoque})">+</button>
            </div>
            <button class="comprar-btn" disabled>
                <i class="fa fa-shopping-cart"></i>
                Comprar
            </button>
        </div>
    </div>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="../Javascript/Produto/Visualizar.js"></script>
</body>
</html>