<!DOCTYPE html>
<html lang="pt-BR">
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UtopiaNerd</title>
    <link rel="stylesheet" href="../Css/Cliente/Login.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

</head>

<body>

<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="/cadastroServlet" method="post">

            <span>${requestScope.mensagemCad}</span>
            <input type="text" id="nome" name="nome" placeholder="Name" />
            <input type="email" id="email-criar" name="email-criar" placeholder="Email" />
            <input type="CPF" id="cpf" name="cpf" oninput="formatarCPF()" maxlength="14" placeholder="CPF" />

             <button type="submit">Cadastrar</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="/login-cliente" method="post">
            <h1>Entrar</h1>
            <span>${requestScope.mensagem}</span>
            <input type="email" id="email" name="email" placeholder="Email" />
            <input type="password" id="senha" name="senha" placeholder="Senha" />

            <button type="submit">Entre</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Bem vindo</h1>
                <p>Entre com seu login </p>
                <button class="ghost" id="signIn">Entrar
                </button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Ola, Bem vindo!</h1>
                <p>Para prosseguir, crie sua conta colocando suas informações nos campos ao lado</p>
                <button class="ghost" id="signUp">Cadastre-se</button>
            </div>
        </div>
    </div>
</div>

    <script>
        function formatarCPF() {
            let cpfInput = document.getElementById('cpf');
            let cpf = cpfInput.value;

            cpf = cpf.replace(/\D/g, '');

            cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');

            cpfInput.value = cpf;
        }
    </script>


<script src="../Javascript/Cliente/Login.js"></script>
</body>

</html>