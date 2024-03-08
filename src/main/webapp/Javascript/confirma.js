  function exibirConfirmacao() {
        var span = document.createElement("span");
        span.innerText = "Deseja mesmo Alterar Status do usuário?";

        var botaoSim = document.createElement("button");
        botaoSim.innerText = "Sim";
        botaoSim.addEventListener("click", alterarStatus);

        var botaoNao = document.createElement("button");
        botaoNao.innerText = "Não";
        botaoNao.addEventListener("click", fecharSpan);

        span.appendChild(botaoSim);
        span.appendChild(botaoNao);

        document.body.appendChild(span);
    }

    function alterarStatus() {

        fecharSpan();
    }

    function fecharSpan() {
        var span = document.querySelector("span");
        if (span) {
            span.parentNode.removeChild(span);
        }
    }