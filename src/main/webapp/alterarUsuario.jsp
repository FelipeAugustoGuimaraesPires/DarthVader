<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

        <link rel="stylesheet" href="style.css">
    </head>
        <c:if test="${sessionScope.loggedUser !=null}">
            <span>${sessionScope.loggedUser}</span>
            <a href="/logout">Logout</a>
        </c:if>
        <body>
            <title>Alterar Usuário</title>
            <form action="/criar-usuario" method="post">
                <section>
                    <p> Alterar Usuário </p>

                    <div>Nome: <input type="text" name="User-Nome" id="User-Nome" value="${param.nome}"></div>
                    <div>CPF: <input type="text" name="User-CPF" id="User-CPF" value="${param.cpf}"></div>
                    <div>Senha: <input type="text"></div>
                    <div>Confirmar Senha: <input type="text" name="User-Senha" id="User-Senha"></div>
                    <div>Grupo: <input type=text name="User-Grupo" id="User-Grupo" value="${param.Grupo}"></div>
                    <button type="submit">Ok</button>
                    <button>Cancelar</button>
                    <div><input type="hidden" name="id" id="id" value="${param.id}"></div>
                </section>
            </form>


        </body>

</html>