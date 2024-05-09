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
                    <h2>Registro de cliente</h2>
                </div>
                <div class="row clearfix">
                    <div class="FORMS1">
                        <div class="">
                            <form action="/cadastroServlet" method="post">
                                <div class="JaInformado">
                                    <input type="hidden" id="email-criar" name="email-criar" value=${requestScope.emailCliente}>
                                    <input type="hidden" id="cpf" name="cpf" value=${requestScope.cpfCliente}>
                                    <input type="hidden" id="nome" name="nome" value=${requestScope.nomeCliente} >
                                </div>

                                <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
                                    <input type="password" name="password" placeholder="Senha" required />
                                </div>
                                <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
                                    <input type="password" name="confirmPassword" placeholder="Confirme sua senha" required />
                                </div>
                                <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
                                    <input type="date" name="Data de nascimento" placeholder="Data de nascimento"
                                        required />
                                </div>
                                <div>
                                    Endereço de faturamento:
                                </div>
                                <div class="input_field"> <span><i aria-hidden="true" class="fa fa-envelope"></i></span>
                                    <input type="text" name="CEP" maxlength="8" placeholder="CEP" required />
                                </div>
                                <div class="col_half">
                                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                                        <input type="text" name="Logradouro" placeholder="Logradouro" />
                                    </div>
                                </div>
                                <div class="col_half">
                                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                                        <input type="number" name="Numero" maxlength="5" placeholder="Numero" required />
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
                                    <select name="Genero">
                                        <option selected disabled>Selecione</option>
                                        <option value="masculino">Masculino</option>
                                        <option value="feminino">Feminino</option>
                                        <option value="outro">Outro</option>
                                        <option value="nao-informar">Prefiro não informar</option>
                                    </select>
                                    <div class="select_arrow"></div>
                                </div>
                                <div class="input_field checkbox_option">
                                    <input type="checkbox" id="cb1">
                                    <label for="cb1">Eu concordo com os termos e condições</label>
                                </div>
                                </div>
                                <div class="input_field radio_option">
                                    <div>Selecione caso queira usar outro endereço para entrega</div>

                                    <input type="checkbox" name="radiogroup1" id="rd2">
                                    <label for="rd2"></label>
                                </div>

                                <div class="Form2 hidden">
                                    <div>Endereço de entrega:</div>
                                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-envelope"></i></span>
                                        <input type="text" name="cep2" maxlength="8" placeholder="CEP" />
                                    </div>
                                    <div class="col_half">
                                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                                            <input type="text" name="Logradouro2" placeholder="Logradouro" />
                                        </div>
                                    </div>
                                    <div class="col_half">
                                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                                            <input type="number" name="Numero2" maxlength="5" placeholder="Numero" />
                                        </div>
                                    </div>
                                    <div class="col_half">
                                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                                            <input type="text" name="Complemento2" placeholder="Complemento" />
                                        </div>
                                    </div>
                                    <div class="col_half">
                                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                                            <input type="text" name="Bairro2" placeholder="Bairro" />
                                        </div>
                                    </div>
                                    <div class="col_half">
                                        <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                                            <input type="text" name="Cidade2" placeholder="Cidade" />
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
                                </div>
                                <button class="button" type="submit">Cadastrar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="../Javascript/Cliente/Cadastro"></script>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var checkbox = document.getElementById('rd2');
        var form2 = document.querySelector('.Form2');

        checkbox.addEventListener('change', function() {
            if (this.checked) {
                form2.classList.remove('hidden');
            } else {
                form2.classList.add('hidden');
            }
        });
    });
</script>


</body>

</html>