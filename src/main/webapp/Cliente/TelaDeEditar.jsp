<!DOCTYPE html>
<html lang="pt-BR">
<%@ page contentType="text/html; charset=UTF-8" %>


<head>
    <meta charset="UTF-8">
    <title>Registro de cliente</title>
    <link rel="stylesheet" href="../Css/Cliente/Cadastro.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
</head>

<body>

<div class="form_wrapper">
    <div class="form_container">
        <div class="title_container">
            <h2>Editar Cliente</h2>
        </div>
        <div class="row clearfix">
            <div class="">
                <form action="/edita-cliente" method="post">
                    <input type="hidden" name="id" value="${sessionScope.id}" required />
                    <input type="hidden" name="tela" value="Editar" required />
                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
                        <input type="text" name="nome" placeholder="Nome" required />
                    </div>

                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
                        <input type="password" name="password" placeholder="Senha" required />
                    </div>
                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
                        <input type="password" name="passwordConfirma" placeholder="Confirme sua senha" required />
                    </div>
                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
                        <input type="date" name="Data de nascimento" placeholder="Data de nascimento" required />
                    </div>
                    <div>
                        Novo Endereço de entrega:
                    </div>
                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-envelope"></i></span>
                        <input type="text" name="CEP" placeholder="CEP" required />
                    </div>
                    <div class="col_half">
                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                            <input type="text" name="Logradouro" placeholder="Logradouro" />
                        </div>
                    </div>
                    <div class="col_half">
                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                            <input type="number" name="Numero" placeholder="Numero" required />
                        </div>
                    </div>
                    <div class="col_half">
                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                            <input type="text" name="Complemento" placeholder="Complemento" />
                        </div>
                    </div>
                    <div class="col_half">
                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                            <input type="text" name="Bairro" placeholder="Bairro" />
                        </div>
                    </div>
                    <div class="col_half">
                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                            <input type="text" name="Cidade" placeholder="Cidade" />
                        </div>
                    </div>


                    <div class="input_field select_option">
                        <div>UF:</div>
                        <select name="Uf">
                            <option selected disabled>Selecione</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                        <div class="select_arrow"></div>
                    </div>

                    <div class="input_field select_option">
                        <div>Gênero:</div>
                        <select name="genero">
                            <option selected disabled>Selecione</option>
                            <option value="masculino">Masculino</option>
                            <option value="feminino">Feminino</option>
                            <option value="outro">Outro</option>
                            <option value="nao-informar">Prefiro não informar</option>
                        </select>
                        <div class="select_arrow"></div>
                    </div>

                    <button class="button" type="submit">Salvar</button>
                    <input class="button" type="submit" value="Cancelar" />


                </form>
            </div>
        </div>
    </div>
</div>



<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<script>
    var senha = document.querySelector('input[name="password"]').value;
    var confirmaSenha = document.querySelector('input[name="passwordConfirma"]').value;
    if(senha !== confirmaSenha) {
        alert('A senha e a confirmação de senha não são iguais!');
        return;
    }

</script>


</body>

</html>