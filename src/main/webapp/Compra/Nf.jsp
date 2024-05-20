<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
  <meta charset="UTF-8">
  <title>Resumo do Pedido</title>
  <link rel="stylesheet" href="../Css/Compra/Nf.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2>Resumo do Pedido</h2>
            <table>
                <tr>
                    <td>
                        <p>Valor Produtos: <span id="total-price">R$10.300,00</span></p>
                    </td>
                </tr>
            </table>
            <p>Frete: <span id="shipping">R$10,00</span></p>
            <p>Total Geral: <span id="grand-total">R$10.310,00</span></p>
            <p>Endereço de Entrega: <span id="delivery-address">PR Osasco Rochdale Avenida Cruzeiro 3777 ap2091</span></p>
            <a href="/achar-todos-produtos-cliente"><button id="complete-purchase">Concluir Compra</button></a>
            <a href="/ver-carrinho?email=felipe%40email"><button id="go-back" class="ghost">Voltar</button></a>
        </div>
    </div>
    


</body>
</html>