function decrementar() {
    const inputQuantidade = document.querySelector('.input-quantidade');
    let quantidade = parseInt(inputQuantidade.value);
    if (quantidade > 1) {
        quantidade--;
        inputQuantidade.value = quantidade;
    }
}

function incrementar() {
    const inputQuantidade = document.querySelector('.input-quantidade');
    let quantidade = parseInt(inputQuantidade.value);
    quantidade++;
    inputQuantidade.value = quantidade;
}

