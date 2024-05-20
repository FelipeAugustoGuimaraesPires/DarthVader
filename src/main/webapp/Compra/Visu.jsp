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


    <title>Compras passadas</title>
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
    <!-- Adicionar imagem de fundo no CSS -->
</header>

<main class="main-section">



            <input id="tela" name="tela" type="hidden" value="Carrinho">Carrinho</input>
            <table class="cart-table">
                <tr>
                    <th class="table-head-item first-col">Venda</th>
                    <th class="table-head-item first-col">Produto</th>
                    <th class="table-head-item second-col">Endereço de entrega</th>
                    <th class="table-head-item third-col">Valor total</th>
                </tr>

                    <tr>
                        <td>1</td>
                        <td>Action Figure DarthVader(2), Funko pop DarthVader</td>
                        <td>PR Osasco Rochdale Avenida Cruzeiro 3777 ap2091</td>
                        <td>R$10.310,00</td>
                    </tr>
                </tbody>

            </table>

            <a id="enderecoA" href="/achar-todos-produtos-cliente">
                <button type="button" class="purchase-button">Voltar</button>
            </a>
</main>

<script>

const addEndereco = () =>{
const enderecoFinal = document.getElementById("EnderecoFinal").value
document.getElementById("enderecoA").addAtribute("href", enderecoFinal)
}
    function formatarCEP(input) {
      var cep = input.value;

      // Remover todos os caracteres não numéricos
      cep = cep.replace(/\D/g, '');

      // Adicionar o caractere "-" após os primeiros 5 dígitos
      cep = cep.replace(/^(\d{5})(\d)/, '$1-$2');

      // Atualizar o valor do campo de entrada
      input.value = cep;
    }
</script>

<script>
        // Função para formatar o valor
        function formatarValor(valor) {
            return valor.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
        }

        // Função para calcular o valor total
        function calcularTotal(valorProduto, valorFrete) {
            return valorProduto + valorFrete;
        }

        // Seleciona o elemento span pelo id
        var elementoTotal = document.getElementById('totalGeral');

        // Define uma variável para armazenar o valor do produto (você pode ajustar isso conforme necessário)
        var valorProduto = 10300;

        // Adiciona um evento de clique a todos os botões de rádio
        var botoesRadio = document.querySelectorAll('input[name="frete"]');
        botoesRadio.forEach(function(botao) {
            botao.addEventListener('click', function() {
                // Obtém o valor do frete do botão de rádio selecionado
                var valorFrete = parseInt(this.value);

                // Calcula o novo valor total
                var novoTotal = calcularTotal(valorProduto, valorFrete);

                // Atualiza o conteúdo do elemento span com o novo valor total formatado
                elementoTotal.textContent = formatarValor(novoTotal);
            });
        });
    </script>
</body>
</html>