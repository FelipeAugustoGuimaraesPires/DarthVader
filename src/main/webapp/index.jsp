<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <title>Pagina de Login(Usuário)</title>

    <link rel="stylesheet" href="style.css">
</head>

<body>
    <form action="/criar-usuario" method="post">
        <section>
            <p>Login de Usuário</p>
            <div>Usário: <input type=”email” name="User-Email" id="User-Email"> </div>
            <div>Senha: <input type="password" id="pass" name="password" minlength="8" required /></div>
            <input type="button">    Ok </input>
            <button>Cancelar</button>
        </section>
    </form>


</body>

</html>
