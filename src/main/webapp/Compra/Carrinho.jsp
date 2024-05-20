<!DOCTYPE html>
<html lang="pt-BR">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="../Css/Compra/Carrinho.css">
    <link rel="shortcut icon" href="images/favicon.png" type="image/png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <title>Carrinho</title>
</head>
<body>
<header class="main-header">
    <nav class="main-nav container">
        <ul class="header-list-container list-container">
            <li class="nav-item">
                <a href="/achar-todos-produtos-cliente">Home</a>
            </li>
        </ul>
    </nav>
    <hr>
</header>

<main class="main-section">
    <section class="container normal-section">
        <h2 class="section-title">Carrinho</h2>

        <table class="cart-table">
            <tr>
                <th class="table-head-item first-col">#</th>
                <th class="table-head-item first-col">CodItem</th>
                <th class="table-head-item first-col">Produto</th>
                <th class="table-head-item second-col">Preço Uni</th>
                <th class="table-head-item second-col">Quantidade</th>
                <th class="table-head-item second-col">Total do produto</th>
                <th class="table-head-item third-col">Remover</th>
            </tr>

            <c:forEach var="carrinho" items="${carrinho}">
                <tr>
                    <td>${carrinho.id}</td>
                    <td>${carrinho.prodId}</td>
                    <td id="prodNome" name="prodNome">${carrinho.prodNome}</td>
                    <td class="prodPreco unit-price">${carrinho.prodPrecoInt}</td>
                    <td class="prodPreco">
                        <input type="number" id="qntProd" name="qntProd" value="1" min="1" class="product-qtd-input" name="quantity">
                    </td>
                    <td class="prodPreco">
                        <input type="text" class="total-price" value="${carrinho.prodPrecoInt}" readonly>
                    </td>

                    <form action="/deletar-produto-carrinho" method="get">
                        <input type="hidden" name="id" value="${carrinho.id}" />
                        <input type="hidden" id="email" name="email" value="${sessionScope.email}">
                        <td><button type="submit" class="">remover</button></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
        <tfoot>
            <tr>
                <td colspan="3" class="cart-total-container">
                    <c:set var="valor" value="0" />
                    <c:forEach var="carrinho" items="${carrinho}">
                        <c:set var="valor" value="${valor + carrinho.prodPrecoInt}" />
                    </c:forEach>
                </td>
            </tr>
        </tfoot>

        <form action="/ver-carrinho" method="get">
            <strong>Total itens </strong>
            <input type="text" id="totalGeral" name="totalGeral" value="R$${valor}" readonly>

            <h2 class="section-title">Frete</h2>

            <div class="FreteEscolher">
                <i class="bi bi-truck" style="font-style: normal;">  Entrega:</i>
                <div class="EndereçoEntregaPedido">
                    <label for="Endereço">Selecione um Endereço ja existente</label>
                    <select id="endereco" name="endereco">
                        <c:forEach var="endereco" items="${endereco}">
                            <option id="EnderecoFinal" name="EnderecoFinal" value="${endereco.enderecoCompleto}">
                                ${endereco.enderecoCompleto}
                            </option>
                        </c:forEach>
                        <c:set var="enderecoTela" value="${param.EnderecoFinal}" />
                    </select>
                </div>

                <h2>Selecione o tipo de frete:</h2>
                <select id="entrega" name="entrega">
                    <option id="expressa" name="expressa" value="15">Entrega Expressa - R$ 15,00</option>
                    <option id="padrao" name="padrao" value="10">Entrega Padrão - R$ 10,00</option>
                    <option id="economica" name="economica" value="5">Entrega Econômica R$ 5,00</option>
                </select>
            </div>
            <input type="hidden" id="email" name="email" value="${sessionScope.email}">
            <input type="hidden" id="valorItens" name="valorItens" value="${valor}">

            <input type="hidden" id="email" name="email" value="${sessionScope.email}">
            <input id="tela" name="tela" type="hidden" value="Carrinho">
            <strong>Total com frete </strong>
            <input type="text" id="TotalFinal" name="TotalFinal" value="R$${valor}" readonly>
            <button type="submit" class="purchase-button">Pagamento</button>
        </form>
    </section>
</main>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const quantityInputs = document.querySelectorAll('.product-qtd-input');
        const totalFooter = document.getElementById('totalGeral');
        const freteSelect = document.getElementById('entrega');
        const totalFinalInput = document.getElementById('TotalFinal');

        function updateProductTotal(input) {
            const row = input.closest('tr');
            const unitPrice = parseFloat(row.querySelector('.unit-price').textContent);
            let quantity = parseInt(input.value);

            // Verificar se a quantidade é menor que 1 ou nula e ajustar para 1
            if (isNaN(quantity) || quantity < 1) {
                quantity = 1;
                input.value = 1;
            }

            const totalPriceElement = row.querySelector('.total-price');
            const totalPrice = unitPrice * quantity;
            totalPriceElement.value = totalPrice.toFixed(2);
        }

        function updateCartTotal() {
            let total = 0;
            document.querySelectorAll('.total-price').forEach(function (element) {
                total += parseFloat(element.value);
            });
            totalFooter.value = 'R$' + total.toFixed(2);
            updateTotalFinal();
        }

        function updateTotalFinal() {
            const totalItens = parseFloat(totalFooter.value.replace('R$', ''));
            const freteValue = parseFloat(freteSelect.value);
            const totalFinal = totalItens + freteValue;
            totalFinalInput.value = 'R$' + totalFinal.toFixed(2);
        }

        quantityInputs.forEach(function (input) {
            input.addEventListener('change', function () {
                updateProductTotal(input);
                updateCartTotal();
            });

            input.addEventListener('input', function () {
                updateProductTotal(input);
                updateCartTotal();
            });
        });

        freteSelect.addEventListener('change', updateTotalFinal);

        // Initial calculation to ensure totals are correct on page load
        quantityInputs.forEach(function (input) {
            updateProductTotal(input);
        });
        updateCartTotal();
    });
</script>
</body>
</html>
