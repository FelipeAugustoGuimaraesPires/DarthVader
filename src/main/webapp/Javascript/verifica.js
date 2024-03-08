function validarFormulario() {
            var senha = document.getElementById("senha").value;
            var confirmarSenha = document.getElementById("confirmarSenha").value;
            var mensagemErro = document.getElementById("mensagemErro");

            if (senha !== confirmarSenha) {
                mensagemErro.innerText = "Senhas divergentes";
                mensagemErro.style.display = "block";
                return false;
            } else {
                mensagemErro.style.display = "none";
                return true;
            }
        }

