<!DOCTYPE html>
<html lang="pt-BR">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="Css/Cadastro.css">

</head>
<body>
    <c:if test="${sessionScope.loggedUser != null || sessionScope.loggedUserEstoque != null}">
        <span>${sessionScope.loggedUser}</span>
        <span>${sessionScope.loggedUserEstoque}</span>
        <a href="/logout"><button>Sair</button></a>
        <a href="/PaginaInicial.jsp"><button>Menu</button></a>
    </c:if>

    <c:if test="${sessionScope.loggedUser != null}">

        <form action="/cadastrar-produto" method="post" enctype="multipart/form-data">
            <h1>Adicionar Produto</h1>
            <section>

                <div>
                    <label for="Prod-Nome">Item</label>
                    <input type="text" value="${param.nome}" name="Prod-Nome" id="Prod-Nome" placeholder="Produto" required minlength="2" maxlength="99"
                           pattern="^[a-zA-Z][a-zA-Z\s]*$" title="Name should not contain any numbers or special characters." />
                </div>

                <div>
                    <label for="Prod-Quantidade">Quantidade</label>
                    <input name="Prod-Quantidade"  value="${param.estoque}" id="Prod-Quantidade" required/>
                </div>

                <div>
                    <label for="Prod-Avaliacao">Avaliação</label>
                    <input type="number" value="${param.avaliacao}" name="Prod-Avaliacao" id="Prod-Avaliacao" min="1" max="5" step="0.5" required />
                </div>

                <div id="descricao">
                    <label for="Prod-Descricao">Descrição</label>
                    <textarea name="Prod-Descricao" id="Prod-Descricao" required maxlength="2000" oninput="updateCharacterCount()" >${param.descricao}</textarea>
                    <div id="characterCount"></div>
                </div>

                <div>
                    <label for="Prod-Preco">Preço</label>
                    <span>R$</span>
                    <input type="text" value="${param.preco}" name="Prod-Preco" id="Prod-Preco" inputmode="decimal" min="0" oninput="formatPrice(this)" readonly/>
                </div>

                <div><input type="hidden" value="${param.imagem}" name="image" id="image"/></div>
                <div><input type="hidden" value="${param.imagem2}" name="image2" id="image2"/></div>
                <div><input type="hidden" value="${param.imagem3}" name="image3" id="image3"/></div>
                <div><input type="hidden" value="${param.imagem4}" name="image4" id="image4"/></div>

                <div><input type="hidden" value="${param.id}" name="id" id="id"></div>

                <button type="submit">Ok</button>
            </section>
        </form>
    </c:if>

    <c:if test="${sessionScope.loggedUserEstoque !=null}">
        <form action="/cadastrar-produto" method="post" enctype="multipart/form-data">
            <h1>Adicionar Produto</h1>
            <section>

                <div>
                    <label for="Prod-Nome-Alt">Item</label>
                    <input type="text" value="${param.nome}" name="Prod-Nome-Alt" id="Prod-Nome-Alt" placeholder="Produto" required minlength="2" maxlength="99"
                           pattern="^[a-zA-Z][a-zA-Z\s]*$" title="Name should not contain any numbers or special characters." readonly/>
                </div>

                <div>
                    <label for="Prod-Quantidade-Alt">Quantidade</label>
                    <input name="Prod-Quantidade-Alt"  value="${param.estoque}" id="Prod-Quantidade-Alt" required/>
                </div>

                <div>
                    <label for="Prod-Avaliacao-Alt">Avaliação</label>
                    <input type="number" value="${param.avaliacao}" name="Prod-Avaliacao-Alt" id="Prod-Avaliacao-Alt" min="1" max="5" step="0.5" required readonly/>
                </div>

                <div id="descricao">
                    <label for="Prod-Descricao-Alt">Descrição</label>
                    <textarea name="Prod-Descricao-Alt" id="Prod-Descricao-Alt" required maxlength="2000" oninput="updateCharacterCount()" readonly>${param.descricao}</textarea>
                    <div id="characterCount"></div>
                </div>

                <div>
                    <label for="Prod-Preco-Alt">Preço</label>
                    <span>R$</span>
                    <input type="text" value="${param.preco}" name="Prod-Preco-Alt" id="Prod-Preco-Alt" inputmode="decimal" min="0" oninput="formatPrice(this)" readonly/>
                </div>

                    <div><input type="hidden" value="${param.id}" name="id-Alt" id="id-Alt"></div>
                    <div><input type="hidden" value="${param.imagem}" name="image-Alt" id="image-Alt"/></div>
                    <div><input type="hidden" value="${param.imagem2}" name="image2-Alt" id="image2-Alt"/></div>
                    <div><input type="hidden" value="${param.imagem3}" name="image3-Alt" id="image3-Alt"/></div>
                    <div><input type="hidden" value="${param.imagem4}" name="image4-Alt" id="image4-Alt"/></div>
                    <button type="submit">Ok</button>
            </section>
        </form>
    </c:if>

    <a href="/achar-todos-produtos"><button>Cancelar</button></a>


    <script>
        function previewImage(event) {
          var input = event.target;
          var preview = document.getElementById("preview");

          if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
              preview.src = e.target.result;
              preview.style.display = "block";
            };

            reader.readAsDataURL(input.files[0]);
          } else {
            preview.src = "#";
            preview.style.display = "none";
          }
        }
    </script>


    <script>
        var select = document.getElementById("Prod-Quantidade");

        for (var i = 1; i <= 50; i++) {
          var option = document.createElement("option");
          option.value = i;
          option.text = i;
          select.appendChild(option);
        }

        function formatPrice(input) {
          var value = input.value;
          value = value.replace(/\D/g, '');
          value = value.replace(/^0+/, '');

          if (value.length > 2) {
            var cents = value.slice(-2);
            var dollars = value.slice(0, -2);
            value = dollars + ',' + cents;
          } else if (value.length === 2) {
            value = '0,' + value;
          } else if (value.length === 1) {
            value = '0,0' + value;
          }

          input.value = value;
        }
    </script>

</form>
</body>
</html>