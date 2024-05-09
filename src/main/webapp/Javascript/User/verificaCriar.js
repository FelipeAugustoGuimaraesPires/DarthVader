function validarFormulario() {
    var nome = document.getElementById("User-Nome").value;
    var cpf = document.getElementById("User-CPF").value;
    var email = document.getElementById("User-Email").value;
    var senha = document.getElementById("senha").value;
    var confirmarSenha = document.getElementById("confirmarSenha").value;
    var grupo = document.getElementById("User-Grupo").value;
    var mensagemErro = document.getElementById("mensagemErro");

    if (nome === "" || cpf === "" || email === "" || senha === "" || confirmarSenha === "" || grupo === "") {
        mensagemErro.innerHTML = "Por favor, preencha todos os campos do formulário.";
        mensagemErro.style.display = "block";
        return false;
    }

    if (cpf.length !== 14 || !validarCPF(cpf)) {
        mensagemErro.innerHTML = "CPF inválido.";
        mensagemErro.style.display = "block";
        return false;
    }

    if (senha !== confirmarSenha) {
        mensagemErro.innerHTML = "Os campos de senha não estão iguais. Por favor, verifique.";
        mensagemErro.style.display = "block";
        return false;
    }

    return true;
}

function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g,'');
    if(cpf == '') return false;
    if (cpf.length != 11 ||
        cpf == "00000000000" ||
        cpf == "11111111111" ||
        cpf == "22222222222" ||
        cpf == "33333333333" ||
        cpf == "44444444444" ||
        cpf == "55555555555" ||
        cpf == "66666666666" ||
        cpf == "77777777777" ||
        cpf == "88888888888" ||
        cpf == "99999999999")
            return false;
    add = 0;
    for (i=0; i < 9; i ++)
        add += parseInt(cpf.charAt(i)) * (10 - i);
        rev = 11 - (add % 11);
        if (rev == 10 || rev == 11)
            rev = 0;
        if (rev != parseInt(cpf.charAt(9)))
            return false;
    add = 0;
    for (i = 0; i < 10; i ++)
        add += parseInt(cpf.charAt(i)) * (11 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(10)))
        return false;
    return true;
}
