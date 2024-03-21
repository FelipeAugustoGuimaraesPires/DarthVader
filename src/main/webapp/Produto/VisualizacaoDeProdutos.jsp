<!DOCTYPE html>
<html lang="pt-BR">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>Visualização de item</title>
    <link rel="stylesheet" href="Css/VisualizacaoProdutos.css">
</head>
<body>

<h1> TELA PRODUTO</h1>

<main>
    <section>
        <div class="container">
            <div class="Lado-esquerdo">
                <div class="itens">
                    <div class="imagem-selecionada">
                        <!--AQUI È ADICIONADO A IMAGEM SELECIONADA COMO PRINCIPAL-->
                        <img src="MARQUITO/DrwrcryWkAEf5fB.jpg" alt="Imagem principal a ser adicionada">
                    </div>
                    <div class="imagens-carrossel">
                        <!--AQUI DEVEM SER ADICIONADAS AS IMAGENS DO BANCO DO ITEM EM ESPECIFICO-->

                        <div class="imagem">
                            <img src="MARQUITO/DrwrcryWkAEf5fB.jpg" alt="Imagem a ser adicionada">
                        </div>
                        <div class="imagem">
                            <img src="MARQUITO/DrwrcryWkAEf5fB.jpg" alt="Imagem a ser adicionada">
                        </div>
                        <div class="imagem">
                            <img src="/img/${param.imagem}" alt="Imagem a ser adicionada">
                        </div>
                        <div class="imagem">
                            <img src="MARQUITO/DrwrcryWkAEf5fB.jpg" alt="Imagem a ser adicionada">
                        </div>

                    </div>
                </div>
            </div>

            <!-- PEGAR INFORMAÇOES E SUBSTITUIR OS CAMPOS POR VALORES DO BANCO-->
            <div class="lado-direito">
                <h6>MEU HERÓI</h6>
                <h1>COMPRAR O PRÓPRIO MARQUITO</h1>
                <p>ESSE CARA È INCRIVEL</p>
                <span class="preco">R$ 1000000000000000,00</span>
                <div class="options">
                    <div class="quantidade">
                        <div class="menos">
                            -
                        </div>
                        <!--ADICIONAR A QUANTIDADE DO BANCO -->
                        <span>0</span>
                        <div class="mais">
                            +
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
</main>


</body>
</html>