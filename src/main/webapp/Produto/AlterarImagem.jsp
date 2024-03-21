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

    <form action="/cadastrar-produto" method="post" enctype="multipart/form-data">
        <h1>Adicionar Produto</h1>
        <section>

            <div><input type="hidden" value="${param.nome}" name="Prod-Nome" id="Prod-Nome"/></div>

            <div><input type="hidden" name="Prod-Quantidade"  value="${param.estoque}" id="Prod-Quantidade" required/></div>

            <div><input type="hidden" value="${param.avaliacao}" name="Prod-Avaliacao" id="Prod-Avaliacao"/></div>

            <div><input type="hidden" value="${param.descricao}" name="Prod-Descricao" id="Prod-Descricao"></input></div>

            <div><input type="hidden" value="${param.preco}" name="Prod-Preco" id="Prod-Preco"/></div>

            <div>
                <label for="image">Upload da primeira imagem</label>
                <input type="file" name="image" id="image" accept="image/png, image/jpeg" onchange="previewImage(event)" required/>
                <img id="preview" src="#" alt="Prévia da imagem" style="max-width: 300px; max-height: 200px; display: none;"/>
            </div>

            <div>
                <label for="image2">Upload da segunda imagem</label>
                <input type="file" name="image2" id="image2" accept="image/png, image/jpeg" onchange="previewImage(event)" required/>
                <img id="preview" src="#" alt="Prévia da imagem" style="max-width: 300px; max-height: 200px; display: none;"/>
            </div>

            <div>
                <label for="image3">Upload da terceira imagem</label>
                <input type="file" name="image3" id="image3" accept="image/png, image/jpeg" onchange="previewImage(event)" required/>
                <img id="preview" src="#" alt="Prévia da imagem" style="max-width: 300px; max-height: 200px; display: none;"/>
            </div>

            <div>
                <label for="image3">Upload da quarta imagem</label>
                <input type="file" name="image3" id="image3" accept="image/png, image/jpeg" onchange="previewImage(event)" required/>
                <img id="preview" src="#" alt="Prévia da imagem" style="max-width: 300px; max-height: 200px; display: none;"/>
            </div>

            <div><input type="hidden" value="${param.id}" name="id" id="id"></div>

            <button type="submit">Ok</button>
        </section>
    </form>

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

</form>
</body>
</html>