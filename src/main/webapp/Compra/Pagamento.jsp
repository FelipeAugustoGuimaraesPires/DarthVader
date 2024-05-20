<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <link rel="stylesheet" href="../Css/Compra/Pagamento.css">
    <style>
        .botao {
            border-radius: 12px;
            padding: 10px;
            margin: 5px;
            cursor: pointer;
        }
        .verde {
            background-color: green;
            color: white;
        }
        .cinza {
            background-color: gray;
            color: white;
        }
        .cartaoCredito {
            display: none;
            animation: slideDown 2s forwards;
        }
        @keyframes slideDown {
            100% { transform: translateY(0); display: block; }
        }
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
    </style>
    <script>
        function selecionarPagamento(tipo) {
            var divCartao = document.querySelector('.cartaoCredito');
            var divCartaoNovo = document.querySelector('.container');
            var formaPagamentoInput = document.getElementById('formaPagamento');
            formaPagamentoInput.value = tipo;

            if (tipo == 'cartao') {
                divCartao.style.display = 'none';
                divCartaoNovo.style.display = 'block';
            } else {
                divCartaoNovo.style.display = 'none';
                divCartao.style.display = 'none';
            }
        }

        function finalizarPedido() {
            var pagamento = document.querySelector('input[name="pagamento"]:checked').value;
            var divCartao = document.querySelector('.cartaoCredito');
            if (pagamento == 'cartao') {
                var inputs = divCartao.querySelectorAll('input');
                for (var i = 0; i < inputs.length; i++) {
                    if (inputs[i].value == '') {
                        alert('Preencha todos os campos do cartão de crédito.');
                        return;
                    }
                }
                alert('O pedido foi finalizado com cartão de crédito.');
            } else {
                alert('O pedido foi finalizado com boleto.');
            }
        }
    </script>
</head>
<body>
    <input type="hidden" value=${param.valor}></input>
    <h2>Finalização de Compra</h2>
    <p>Selecione a forma de pagamento:</p>
    <input type="radio" id="boleto" name="pagamento" value="boleto" onclick="selecionarPagamento('boleto')">
    <label for="boleto">Boleto</label><br>
    <input type="radio" id="cartao" name="pagamento" value="cartao" onclick="selecionarPagamento('cartao')">
    <label for="cartao">Cartão de Crédito</label><br>
    <div class="cartaoCredito"></div>

    <div class="container preload" style="display: none;">
        <div class="tips"></div>
        <div id="card-success" class="hidden"></div>
        <div id="form-errors" class="hidden"></div>
        <div id="form-container">
            <div id="card-front">
                <div id="shadow"></div>
                <div id="image-container">
                    <span id="amount"></span>
                    <span id="card-image"></span>
                </div>
                <label for="card-number">Numero do Cartão</label>
                <input type="text" id="card-number" placeholder="1234 5678 9101 1112" maxlength="16">
                <div id="cardholder-container">
                    <label for="card-holder">Nome no cartão</label>
                    <input type="text" id="card-holder" placeholder="e.g. John Doe" maxlength="30">
                </div>
                <div id="exp-container">
                    <label for="card-exp">Validade</label>
                    <input id="card-month" type="text" placeholder="MM" maxlength="2">
                    <input id="card-year" type="text" placeholder="YY" maxlength="2">
                </div>
                <div id="cvc-container">
                    <label for="card-cvc">CVC/CVV</label>
                    <input id="card-cvc" placeholder="XXXX" type="text" maxlength="4">
                </div>
            </div>
            <div id="card-back">
                <div id="card-stripe"></div>
            </div>
            <input type="text" id="card-token">
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript" src="https://js.stripe.com/v2/"></script>
        <script src="https://use.fontawesome.com/f1e0bf0cbc.js"></script>
        <div class="card">
            <label for="parcelas">Deseja parcelar em quantas vezes:</label>
            <select id="parcelas" name="parcelas">
                <option value="1">1x</option>
                <option value="2">2x</option>
                <option value="3">3x</option>
                <option value="4">4x</option>
                <option value="5">5x</option>
                <option value="6">6x</option>
                <option value="7">7x</option>
                <option value="8">8x</option>
                <option value="9">9x</option>
                <option value="10">10x</option>
                <option value="11">11x</option>
                <option value="12">12x</option>
            </select>
        </div>
    </div>

    <form action="/deletar-produto-carrinho" method="post">
        <input type="hidden" id="formaPagamento" name="formaPagamento" value="">
    </form>
    <a href="../Compra/Nf.jsp"> <button class="botao verde" onclick="finalizarPedido()">Próximo</button> </a>
    <a href="/ver-carrinho?email=felipe%40email" class="botao cinza">Voltar</a>
    <script src="Javascript/Compra/Pagamento.js"></script>
</body>
</html>
